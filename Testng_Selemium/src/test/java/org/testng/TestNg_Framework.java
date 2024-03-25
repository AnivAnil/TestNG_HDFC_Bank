package org.testng;

import static org.testng.Assert.assertEquals;

import java.security.KeyStore.Entry.Attribute;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.eventbus.AllowConcurrentEvents;

public class TestNg_Framework extends BaseMethod{
	
	 static public Loginpage l;
	
@BeforeClass
private void beforeclass() {
	browserlaunch("chrome");
	implicitlyWait(20);
}
@BeforeMethod
private void BeforeMethod() {
System.out.println("date"+new Date());
}



@Test(dataProvider="logi")
private void test(String user ,String pass) {
	geturl("https://adactinhotelapp.com/");
	SoftAssert s=new SoftAssert();
    s.assertTrue(currenturl().contains("adactinhotelapp"),"verify url");
	

	sendkeys(l.user(),user);
	s.assertEquals("user",getattribute(l.user()),"verify user");
	
	sendkeys(l.pass(),pass);
	s.assertEquals("pass",getattribute(l.pass()),"verify pass");
	
     click(l.login());
    
     
    
     
    
} 
   
   @DataProvider(name="login")
   private Object [][] data() {
	   Object [][] a=new Object[][] {
		   {"Anil","Anil"} ,
		   {"Anil256","Anil589"} ,
		   {"Anil8445","Anil54646"} ,
		   {"Anil6536","Anil6536"} 
	   };
	return a;
}
   @Test
   private void test1() {
		geturl("https://adactinhotelapp.com/");
		SoftAssert s=new SoftAssert();
	    s.assertTrue(currenturl().contains("adactinhotelapp"),"verify url");
		
		
		sendkeys(l.user(),"Anil");
		s.assertEquals("user",getattribute(l.user()),"verify user");
		
		sendkeys(l.pass(),"anil123");
		s.assertEquals("pass",getattribute(l.pass()),"verify pass");
		
	     click(l.login());
	    
	     
	    
	     
	    
	} 
    
	@AfterClass
    private void afterClass() {
		quit();

	}
//    
    
     
     
     
     
     
     
     






































}
