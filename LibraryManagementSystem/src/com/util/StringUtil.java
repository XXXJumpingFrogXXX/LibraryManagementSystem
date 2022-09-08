package com.util;

import java.util.Random;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if(str==null||"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getRandomCode() {
		String captcha = "";
		int [] code = new int[3];
		Random random = new Random();
		int numcase = random.nextInt(10) + 48;
		int uppercase = random.nextInt(26) + 65;
		int lowercase = random.nextInt(26) + 97;
		code[0] = numcase;
		code[1] = uppercase;
		code[2] = lowercase;
		
		for (int i = 0; i < 4; i++) {
			captcha+=(char)code[random.nextInt(3)];
		}
		
		return captcha;
	}

}