package com.niit.scart.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

public static String upload(String path,MultipartFile file,String filename){
	if(!file.isEmpty()){
	try{
		byte[] bytes=file.getBytes();
		File dir=new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		File serverFile=new File(dir.getAbsolutePath()+File.separator+filename);
		BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();
		return "true";
	}catch(Exception e){
		e.printStackTrace();
		return "execption";
	}
	}else{
		return "cant create";
	}
	}
}

