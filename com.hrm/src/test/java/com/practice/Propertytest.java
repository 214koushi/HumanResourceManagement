package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertytest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Test.properties");
Properties p=new Properties();
p.load(fis);
String u = p.getProperty("url");
String u1 = p.getProperty("username");
String pa = p.getProperty("password");
String b = p.getProperty("browser");
System.out.println(u);
System.out.println(u1);
System.out.println(pa);
System.out.println(b);
	}

}
