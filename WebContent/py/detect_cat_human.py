# -*- coding=utf-8 -*-
import cv2
def detect_cat_human_face():
    cat_path = "I:\\python3.5.2\\Lib\\site-packages\\cv2\\data\\haarcascade_frontalcatface.xml"
    human_path = "I:\\python3.5.2\\Lib\\site-packages\\cv2\\data\\haarcascade_frontalface_default.xml"
    # 打开result.txt，在其中写入识别结果
    f = open("H:\\workspace3\\zhitong\\WebContent\\py\\result.txt", "w")
    cat_face__cascade = cv2.CascadeClassifier(cat_path)
    human_face_cascade = cv2.CascadeClassifier(human_path)
    img = cv2.imread("H:\\pic\\blob.jpg")
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    # 猫脸识别结果
    cat_faces = cat_face__cascade.detectMultiScale(
        gray,
        scaleFactor=1.02,
        minNeighbors=3,
        minSize=(150, 150),
        flags=cv2.CASCADE_SCALE_IMAGE
    )
    if len(cat_faces) != 0:
        # 表示是猫脸，1代表猫脸
        f.write("1")
        return 1
    # 不是猫脸，进行人脸识别
    else:
        human_faces = human_face_cascade.detectMultiScale(
            gray,
            scaleFactor=1.15,
            minNeighbors=5,
            minSize=(5, 5),
        )
        if len(human_faces) != 0:
            # 表示是人脸，2代表人脸
            f.write("2")
            return 2
        else:
            # 表示不是人脸，0代表不是猫脸也不是人脸
            f.write("0")
            return 0

# 1代表猫脸，2代表人脸，0不是猫脸也不是人脸
print(detect_cat_human_face())









