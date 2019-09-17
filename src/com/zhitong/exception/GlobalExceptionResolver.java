package com.zhitong.exception;

import java.io.IOException;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionResolver{
	
	//空指针异常
    @ExceptionHandler(NullPointerException.class)  
    public String nullPointerExceptionHandler(NullPointerException ex,Model model) {  
        ex.printStackTrace();
        model.addAttribute("errorCode", "");
        model.addAttribute("msg", "空指针异常");
        return "/common/error";
    }
    
    //两种写法：使用@ResponseStatus或不使用
	//1.运行时异常
//    @ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR,reason="运行时异常")
//    @ExceptionHandler(RuntimeException.class)  
//    public String runtimeExceptionHandler(RuntimeException ex,Model model) {  
//        ex.printStackTrace();
//        model.addAttribute("errorCode", "");
//        model.addAttribute("msg", "运行时异常");
//        return "/common/error";
//    }  
    //2.运行时异常
    @ExceptionHandler(RuntimeException.class)  
    public String runtimeExceptionHandler(RuntimeException ex,Model model) {  
        ex.printStackTrace();
        model.addAttribute("errorCode", "");
        model.addAttribute("msg", "运行时异常");
        return "/common/error"; 
    }  
    
    //类型转换异常
    @ExceptionHandler(ClassCastException.class)  
    public String classCastExceptionHandler(ClassCastException ex,Model model) {  
        ex.printStackTrace();
        model.addAttribute("errorCode", "");
        model.addAttribute("msg", "类型转换异常");
        return "/common/error"; 
    }  

    //IO异常
    @ExceptionHandler(IOException.class)  
    public String iOExceptionHandler(IOException ex,Model model) {  
        ex.printStackTrace();
        model.addAttribute("errorCode", "");
        model.addAttribute("msg", "IO异常");
        return "/common/error"; 
    }  
    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)  
    public String noSuchMethodExceptionHandler(NoSuchMethodException ex,Model model) {  
        ex.printStackTrace();
        model.addAttribute("errorCode", "");
        model.addAttribute("msg", "未知方法异常");
        return "/common/error"; 
    }  
    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)  
    public String indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex,Model model) {  
        ex.printStackTrace();
        model.addAttribute("errorCode", "");
        model.addAttribute("msg", "数组越界异常");
        return "/common/error"; 
    }
	//非法参数异常
    @ExceptionHandler(IllegalArgumentException.class)
    public String IllegalArgumentExceptionR(IllegalArgumentException ex,Model model){
    	 model.addAttribute("errorCode", "");
         model.addAttribute("msg", "异常参数");
         return "/common/error"; 
    }
    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public String requestNotReadable(HttpMessageNotReadableException ex,Model model){
        ex.printStackTrace();
        model.addAttribute("errorCode", "400");
        model.addAttribute("msg", "400错误");
        return "/common/error"; 
    }
    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public String requestTypeMismatch(TypeMismatchException ex,Model model){
        ex.printStackTrace();
        model.addAttribute("errorCode", "400");
        model.addAttribute("msg", "400错误");
        return "/common/error"; 
    }
    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public String requestMissingServletRequest(MissingServletRequestParameterException ex,Model model){
        ex.printStackTrace();
        model.addAttribute("errorCode", "400");
        model.addAttribute("msg", "400错误");
        return "/common/error"; 
    }
    //404错误
    @ExceptionHandler({NoHandlerFoundException.class})
    public String noHandlerFoundExceptionR(NoHandlerFoundException ex,Model model){
        ex.printStackTrace();
        model.addAttribute("errorCode", "404");
        model.addAttribute("msg", "404错误");
        return "/common/error"; 
    }
    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public String request405(Model model,HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException){
    	 model.addAttribute("errorCode", "405");
         model.addAttribute("msg", "405错误");
         return "/common/error"; 
    }
    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public String request406(Model model,HttpMediaTypeNotAcceptableException httpMediaTypeNotAcceptableException){
    	 model.addAttribute("errorCode", "406");
         model.addAttribute("msg", "406错误");
         return "/common/error"; 
    }
    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class,HttpMessageNotWritableException.class})
    public String server500(RuntimeException runtimeException,Model model){
    	 model.addAttribute("errorCode", "500");
         model.addAttribute("msg", "500错误");
         return "/common/error"; 
    }
	//其他异常统一出口
    @ExceptionHandler(Exception.class)
    public String handleOtherException(Exception ex,Model model){
    	 model.addAttribute("errorCode", "");
         model.addAttribute("msg", "未知错误");
         return "/common/unknown"; 
    }
	
	
	
}
