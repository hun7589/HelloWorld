package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamExe {
	public static void main(String[] args) {
		// 입력 -> 출력.
		try {
			// 입력스트림(original.png)
			InputStream is = new FileInputStream("c:/temp/original.png");
			// 출력스트림(copy.png)
			OutputStream os = new FileOutputStream("c:/temp/copy.png");

			while (true) {
				int data = is.read();//읽기.
				if(data == -1) {
					break;
				}
				os.write(data);//쓰기.
			}
			os.close();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void read() {
		// 입력(파일) = 바이트 기반.

		try {
			InputStream is = new FileInputStream("c:/temp/os1.db");
			// read()1바이트씩 읽기 -1반환
			while (true) {
				int data = is.read();
				if (data == -1) {
					break;
				}

				System.out.println(data);
			}
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void write() {

		// 출력(파일) = 바이트 기반.
		try {
			OutputStream os = new FileOutputStream("c:/temp/os1.db");
			byte b1 = 10;
			byte b2 = 20;
			byte b3 = 30;
			os.write(b1);
			os.write(b2);
			os.write(b3);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
