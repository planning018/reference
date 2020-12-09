package com.bookshop.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * Dom4j的工具类
 * @author yxc
 *
 */
public class XmlUtils {
	
	private static String path;

	public static Document getDocument(){
		SAXReader reader = new SAXReader();
		try {
			return reader.read(path);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void setPath(String path){
		XmlUtils.path = path;
	}

	public static void saveDocument(Document document) throws IOException {
		XMLWriter writer = new XMLWriter(new FileOutputStream(path));
		writer.write(document);
		writer.close();
	}
	
}
