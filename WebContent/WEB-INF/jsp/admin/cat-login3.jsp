<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="cn">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script src="/zhitong/js/jquery-1.9.1.min.js"></script>
<title>Mr.Cat</title>
</head>

<body>
	<video id="video" width="480" height="320" controls> </video>
	<div>
		<button id="capture">拍照</button>
		<button id="uploadbtn" onclick=test()>点点</button>
	</div>
	<div style="display: none">
		<canvas id="canvas" width="640" height="320"></canvas>

		<!-- 这两个表单是用来提交页面的，曲线救国，曲线的有点过分，没办法。。 -->
		<form action="./login.do" method="get" id="pageForm"></form>
		<form action="./catLoginSucess.do" method="get" id="pageForm2"></form>
	</div>

	<script>
    //访问用户媒体设备的兼容方法
    function getUserMedia(constraints, success, error) {
      if (navigator.mediaDevices.getUserMedia) {
        //最新的标准API
        navigator.mediaDevices.getUserMedia(constraints).then(success).catch(error);
      } else if (navigator.webkitGetUserMedia) {
        //webkit核心浏览器
        navigator.webkitGetUserMedia(constraints,success, error)
      } else if (navigator.mozGetUserMedia) {
        //firfox浏览器
        navigator.mozGetUserMedia(constraints, success, error);
      } else if (navigator.getUserMedia) {
        //旧版API
        navigator.getUserMedia(constraints, success, error);
      }
    }
 
    let video = document.getElementById('video');
    let canvas = document.getElementById('canvas');
    let context = canvas.getContext('2d');
 
    function success(stream) {
      //兼容webkit核心浏览器
      let CompatibleURL = window.URL || window.webkitURL;
      //将视频流设置为video元素的源
      console.log(stream);
 
      //video.src = CompatibleURL.createObjectURL(stream);
      video.srcObject = stream;
      video.play();
    }
 
    function error(error) {
      console.log(`访问用户媒体设备失败${error.name}, ${error.message}`);
    }
 
    if (navigator.mediaDevices.getUserMedia || navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia) {
      //调用用户媒体设备, 访问摄像头
      getUserMedia({video : {width: 480, height: 320}}, success, error);
    } else {
      alert('不支持访问用户媒体');
    }
 
    document.getElementById('capture').addEventListener('click', function () {
      context.drawImage(video, 0, 0, 480, 320);      
    })

	//append:下载图片方法
	//下面的代码是保存canvas标签里的图片并且将其按一定的规则重命名
	var type = 'png';
	
	var _fixType = function(type) {
    type = type.toLowerCase().replace(/jpg/i, 'jpeg');
    var r = type.match(/png|jpeg|bmp|gif/)[0];
    return 'image/' + r;
};
	

	// 这是一个转换base64的一个方法
    function convertBase64UrlToBlob(urlData){
        var bytes=window.atob(urlData.split(',')[1]);        //去掉url的头，并转换为byte
        //处理异常,将ascii码小于0的转换为大于0
        var ab = new ArrayBuffer(bytes.length);
        var ia = new Uint8Array(ab);
        for (var i = 0; i < bytes.length; i++) {
            ia[i] = bytes.charCodeAt(i);
        }
        return new Blob( [ab] , {type : 'image/jpeg'});
    }
	
    // 提交pageForm，pageForm.do用作两脚兽和其他跳转页面 
    function subPageForm(){
		document.getElementById("pageForm").submit();
	}

    // 提交pageForm，pageForm.do用作Mr.Cat跳转页面 
    function subPageForm2(){
		document.getElementById("pageForm2").submit();
	}
    
	//上传函数
	function test(){
		var formDate = new FormData();
		var type = 'png';
		var imgData = document.getElementById('canvas').toDataURL(type);
        formDate.append('image', convertBase64UrlToBlob(imgData));
        $.ajax({
            type: 'POST',
            url: './catLogin.do',
            data: formDate,
            contentType: false,
            processData: false,
            success: function(data){
                
                switch (data) {
				case '1':
					alert("Mr.Cat!");
					subPageForm2();
					break;
				case '0':
					alert("外星人！");
					subPageForm();
					break;
				case '2':
					alert("两脚兽！");
					subPageForm();
					break;
				default:
					break;
                }
            },
            error: function(data){
                alert('error');
            }
        })
	}
  </script>
</body>
</html>