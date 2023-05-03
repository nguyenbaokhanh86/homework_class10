package flow_01;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import commons.commonFuncs;

public class signUp_guru99 {
	
	
	public void TC001() {
		String url = "https://demo.guru99.com/insurance/v1/register.php";
		WebDriver driver_local;
		
		commonFuncs funcs = new commonFuncs();
		driver_local = funcs.initDriver("chrome",url);
		
		Random ran = new Random();
		String str_name = "khanh" + ran.nextInt();
		String str_email = "baokhanh" + ran.nextInt() + "@gmail.com";
		
		WebElement name = driver_local.findElement(By.xpath("//input[@id='user_firstname']"));
		name.sendKeys(str_name);
		
		WebElement sur_name = driver_local.findElement(By.xpath("//input[@id='user_surname']"));
		sur_name.sendKeys(str_name);
		
		WebElement phone = driver_local.findElement(By.xpath("//input[@id='user_phone']"));
		phone.sendKeys("123456789");
		
		WebElement street = driver_local.findElement(By.xpath("//input[@id='user_address_attributes_street']"));
		street.sendKeys("123 street");
		
		WebElement city = driver_local.findElement(By.xpath("//input[@id='user_address_attributes_city']"));
		city.sendKeys("123 city");
		
		WebElement county = driver_local.findElement(By.xpath("//input[@id='user_address_attributes_county']"));
		county.sendKeys("123 county");
		
		WebElement postcode = driver_local.findElement(By.xpath("//input[@id='user_address_attributes_postcode']"));
		postcode.sendKeys("123 postcode");
		
		WebElement email = driver_local.findElement(By.xpath("//input[@id='user_user_detail_attributes_email']"));
		email.sendKeys(str_email);
		
		WebElement pass = driver_local.findElement(By.xpath("//input[@id='user_user_detail_attributes_password']"));
		pass.sendKeys("123456789");
		
		WebElement confirm_pass = driver_local.findElement(By.xpath("//input[@id='user_user_detail_attributes_password_confirmation']"));
		confirm_pass.sendKeys("123456789");
		
		WebElement createbtn = driver_local.findElement(By.xpath("//input[@name='submit']"));
		createbtn.click();
		
		String url_login = "https://demo.guru99.com/insurance/v1/index.php";
		driver_local = funcs.initDriver("chrome",url_login);
		
		WebElement email_login = driver_local.findElement(By.xpath("//input[@id='email']"));
		email_login.sendKeys(str_email);
		
		WebElement pass_login = driver_local.findElement(By.xpath("//input[@id='password']"));
		pass_login.sendKeys("123456789");
		
		WebElement loginbtn = driver_local.findElement(By.xpath("//input[@name='submit']"));
		loginbtn.click();
		
		String url_expect = "https://demo.guru99.com/insurance/v1/header.php";
		String url_actual = driver_local.getCurrentUrl();
		
		if (url_expect.equalsIgnoreCase(url_actual)) {
			System.out.println("Passed " + url_actual);
		} else {
			System.out.println("Failed");
		} 
		
		driver_local.quit();
	}

}
