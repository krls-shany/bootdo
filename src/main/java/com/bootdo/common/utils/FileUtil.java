package com.bootdo.common.utils;

import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

public class FileUtil {

	private static Logger log= LoggerFactory.getLogger(FileUtil.class);
	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath + fileName);
		out.write(file);
		out.flush();
		out.close();
	}

	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	// extend by shany 2018-01-02
		public static void download(String fileName, HttpServletResponse response) {
			if (fileName != null) {
				File file = new File(fileName);
//				log.debug("[OUT]downloadFileName={"+file.getName()+"}");
				response.setHeader("content-type", "application/octet-stream");
				// response.setContentType("application/octet-stream");//设置强制下载后打开
				response.setContentType("application/force-download");// 设置强制下载不打开  
				response.setHeader("Content-Disposition", "attachment;filename="
						+ file.getName());

				if (file.exists()) {
					byte[] buffer = new byte[1024];
					FileInputStream fis = null;
					BufferedInputStream bis = null;
					try {
						fis = new FileInputStream(file);
						bis = new BufferedInputStream(fis);
						OutputStream os = response.getOutputStream();
						int i = bis.read(buffer);
						while (i != -1) {
							os.write(buffer, 0, i);
							i = bis.read(buffer);
						}
						// System.out.println("success");
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (bis != null) {
							try {
								bis.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (fis != null) {
							try {
								fis.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
			// return null;
		}

	
	public static String renameToUUID(String fileName) {
		return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
	}
}
