package com.hrm.GenericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;

public class FileUtility {
	/**
	 * @author Koushik MN
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String readdatafromproperty(String key) throws IOException {
FileInputStream fis=new FileInputStream(IpthConstants.Filepath);
Properties p=new Properties();
p.load(fis);
String value = p.getProperty(key);
return value;
}
/**
 * this method is used to upload file r document
 * @return
 */
public void fileupload(WebElement element)
{
	File f=new File(IpthConstants.docpath);
	String path = f.getAbsolutePath();
	element.sendKeys(path);
	
}
/**
 * this method is used to upload image
 * @return
 */
public void imageupload(WebElement element)
{
	File f=new File(IpthConstants.imagepath);
	String path = f.getAbsolutePath();
	element.sendKeys(path);
}
}
