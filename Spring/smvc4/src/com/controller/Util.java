package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Util {

	
	public static void saveFile(MultipartFile mf) {
		String dir="C:\\spring\\smvc4\\web\\img\\";
		byte [] data;
		String imgname=mf.getOriginalFilename();
		
		try {
			data=mf.getBytes();
			FileOutputStream fo = new FileOutputStream(dir+imgname);
			fo.write(data);
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
