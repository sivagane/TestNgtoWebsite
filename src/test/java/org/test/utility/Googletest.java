package org.test.utility;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Googletest {
WebDriver d;

@BeforeMethod
public void setUp() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jegan\\eclipse-workspace\\TestNgtoWebsite\\div\\chromedriver.exe");
	d=new ChromeDriver();
	d.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
	}
@DataProvider
public  Iterator<Object[]> getTestData() {
	ArrayList<Object[]> testdata = GetDatafromExcel.getdatafromexcel();
   return testdata.iterator();
}


@Test(dataProvider="getTestData")
public void Googlepagetest(String Firstname,String Lastname,String EmailAddress) {
	d.findElement(By.id("firstName")).clear();
	d.findElement(By.id("firstName")).sendKeys(Firstname);
	
	d.findElement(By.id("lastName")).clear();
	d.findElement(By.id("lastName")).sendKeys(Lastname);
	
	d.findElement(By.id("username")).clear();
	d.findElement(By.id("username")).sendKeys(EmailAddress);
	
	d.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
}


@AfterMethod
public void teardown() {
	d.quit();
}
}
