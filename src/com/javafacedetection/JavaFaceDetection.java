package com.javafacedetection;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class JavaFaceDetection {

	public static void main(String[] args) {
		// Open lib OpenCV
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		// Load and return img
		String imgfile = "images/pessoa1.jpg";
		Mat src = Imgcodecs.imread(imgfile);
		// Load xml and lock face.
		String xmlFile = "xml/lbpcascade_frontalface.xml";
		CascadeClassifier cc = new CascadeClassifier(xmlFile);
		// detection face.
		MatOfRect faceDetection = new MatOfRect();
		cc.detectMultiScale(src, faceDetection);
		System.out.println(String.format("Face Detection: %d", faceDetection.toArray().length));
		// Draws a simple, thick, or filled up-right rectangle.
		for (Rect rect : faceDetection.toArray()) {
			Imgproc.rectangle(src, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 3);

		}
		
		Imgcodecs.imwrite("images/pessoa1_out.jpg", src);
		System.out.println("Detection Finished");
		
	}

}
