package com.hrm.GenericUtility;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * @author Koushik MN
	 * @return
	 */
public int getRandomno() {
	Random ran=new Random();
	int random=ran.nextInt(400);
	return random;
}
/**
 * @author Koushik MN
 * @return
 */
 public String getSystemDate() {
	Date d=new Date();
	String date = d.toString();
	return date;
}
 /**
  * @author Koushik MN
  * @return
  */
 public String getSystemdateInformat() {
	 SimpleDateFormat dateformat=new SimpleDateFormat("dd/mm/yyy hh-MM-ss");
	 Date d=new Date();
	String systemdate = dateformat.format(d);
	 return systemdate;
 }
}
