package com.practice;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class Testng {
 @Test(dependsOnMethods = "hey")
 public void hai() {
	 System.out.println(" hai");
 }
 @Test (priority = 1)
 public void hey() {
	 System.out.println("hey");
 }
 @Test(dependsOnMethods = "bye")
 public void bubyeee() {
	 System.out.println("bubyee");
 }
 @Test
 public void bye() {
	 System.out.println("bye");
 }
@Test(dependsOnMethods = "bye")
public void arrange() {
	System.out.println("arrange");
}
}
