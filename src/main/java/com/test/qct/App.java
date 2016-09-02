package com.test.qct;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.google.zxing.WriterException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("D:/aa.png");
			QRCodeUtil.genGR("http://www.baidu.com", os);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
