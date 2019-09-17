# -*- coding=utf-8 -*-
import cv2
def detect_cat_face():
    # 特征检测器位置
    catPath = "I:\\python3.5.2\\Lib\\site-packages\\cv2\\data\\haarcascade_frontalcatface.xml"
    # 加载正面猫脸haar特征检测器
    faceCascade = cv2.CascadeClassifier(catPath)
    # 读取图片,imread()为__init__.py提供
    img = cv2.imread("cat.jpg")
    # 灰度化图片
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    # 猫脸检测,detectMultiScale:Detects objects of different sizes in the input image
    faces = faceCascade.detectMultiScale(
        gray,
        scaleFactor=1.02,
        minNeighbors=3,
        minSize=(150, 150),
        flags=cv2.CASCADE_SCALE_IMAGE
    )
    if len(faces) == 0:
        # 输出0表示不是猫

        print("0000")
    else:

        print("0000")

print(detect_cat_face())










