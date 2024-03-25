package org.testng;


import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test1 {
	
	
    private static String ZAP_PROXY_ADRESS ="localhost";
	private static int ZAP_PROXY_PORT =8080;
	private static String ZAP_API_KEY="ds89kg10p9n3ouabbsl9cmtc0";
	private ClientApi api;
	private static WebDriver driver;
	
	
	
	@BeforeClass
	private void beforemethod() {
		String ProxyServerUrl =ZAP_PROXY_ADRESS +":"+ZAP_PROXY_PORT;
		Proxy Proxy = new Proxy();
		Proxy.setHttpProxy(ProxyServerUrl);
		Proxy.setSslProxy(ProxyServerUrl);
		ChromeOptions co = new ChromeOptions();
		co.setProxy(Proxy);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		api = new ClientApi(ZAP_PROXY_ADRESS, ZAP_PROXY_PORT, ZAP_API_KEY);
	

	}
	
	@Test
	private void Amazon_Security_testing() {
		driver.get("https://www.amazon.in/");
	

	}
	
	@AfterClass
	private void afterclass() throws ClientApiException {
		String title = "Amazone Report";
		String template = "traditional-html";	
		
		api.reports.generate(title, template, null, null, null, null, null, null, null, null, null, null, null);
		//System.out.println(Response.toString());
		
	}
	
}



