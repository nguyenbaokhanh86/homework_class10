package flow_01;

import static org.testng.AssertJUnit.assertEquals;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import commons.commonFuncs;
import dev.failsafe.internal.util.Assert;

public class signUp {
	
	@Test
	public void TC001_signup() {
		String url = "https://www.demoblaze.com/index.html";
		WebDriver driver_local;
		
		commonFuncs funcs = new commonFuncs();
		driver_local = funcs.initDriver("chrome",url);
		
		Random ran = new Random();
		String str_name = "khanh" + ran.nextInt();
		
		WebElement signupbtn = driver_local.findElement(By.xpath("//a[@id='signin2']"));
		signupbtn.click();
		
		WebElement name = driver_local.findElement(By.xpath("//input[@id='sign-username']"));
		name.sendKeys(str_name);
		
		WebElement pass = driver_local.findElement(By.xpath("//input[@id='sign-password']"));
		pass.sendKeys("123456");
			
		funcs.sleepXtimes(5);
		
		WebElement createbtn = driver_local.findElement(By.xpath("//button[@onclick='register()']"));
		createbtn.click();
		
		funcs.sleepXtimes(5);
		
		Alert alert = driver_local.switchTo().alert();
		String actualText = alert.getText();
		
		funcs.sleepXtimes(5);
		
		System.out.println(actualText);
		alert.accept();
		
		driver_local.quit();
	}
	
	@Test
	public void TC002_login() {
		String url = "https://www.demoblaze.com/index.html";
		WebDriver driver_local;
		
		commonFuncs funcs = new commonFuncs();
		driver_local = funcs.initDriver("chrome",url);
		
		WebElement username = driver_local.findElement(By.xpath("//input[@id='loginusername']"));
		username.sendKeys("khanh123");
		
		WebElement passw = driver_local.findElement(By.xpath("//input[@id='loginpassword']"));
		passw.sendKeys("123456");
		
		WebElement loginbtn = driver_local.findElement(By.xpath("//button[@onclick='logIn()']"));
		loginbtn.click();
				
		funcs.sleepXtimes(5);
			
		driver_local.quit();
	}

}
