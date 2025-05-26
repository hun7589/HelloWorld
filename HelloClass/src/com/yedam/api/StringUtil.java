package com.yedam.api;

import java.util.Scanner;

public class StringUtil {
public static void main(String[] args) {
}
	
	

	

public static String getGender(String ssn) {
    // 공백 및 특수문자 제거
    ssn = ssn.replace(" ", "").replace("-", "");
    if (ssn.length() < 7) return "알 수 없음";

    char sex = ssn.charAt(6);
    switch (sex) {
        case '1':
        case '3':
            return "남성";
        case '2':
        case '4':
            return "여성";
        default:
            return "알 수 없음";
    }
}

	public static Object getExtName(String file) {
		 int idx = file.lastIndexOf('.');
	        if (idx == -1 || idx == file.length() - 1) {
	            return "확장자 없음";
	        }
	        return file.substring(idx + 1).toLowerCase();
	    }
	}

