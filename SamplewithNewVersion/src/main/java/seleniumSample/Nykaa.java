package seleniumSample;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		public static void main(String[] args) throws InterruptedException, IOException {
			WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver=new ChromeDriver();
			ChromeOptions Options=new ChromeOptions();
			Options.addArguments("--disable-notification");
			
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("https://www.nykaa.com");
			driver.manage().window().maximize();		
			driver.findElement(By.name("search-suggestions-nykaa")).sendKeys("Perfumes",Keys.ENTER);
		
			 List<WebElement> Perfumes = driver.findElements(By.xpath("//div[@class='m-content__product-list__title']"));
		        System.out.println(Perfumes.size());
		        for (WebElement webElement : Perfumes) {
		            String name = webElement.getText();
		            String pdtname=name.replaceAll("a-z","");	            
		            System.out.println("The Available perfume Product Names are    "+pdtname);
		     }
		        List<WebElement> Perfumeprice = driver.findElements(By.xpath("//span[@class='post-card__content-price-offer']"));

		        for (WebElement webElement1 : Perfumeprice) {
		            String Mrpname = webElement1.getText();
		            String pdtmrp=Mrpname.replaceAll("0-9","");	            
		            System.out.println("The Available perfume Product cost are  : "+pdtmrp);        
		     }
		        Actions builder=new Actions(driver);
		       WebElement sortby=driver.findElement(By.xpath("//span[@class='pull-right']//i[1]"));
		       builder.click(sortby).perform();
		       WebElement highp=driver.findElement(By.xpath("//input[@id='5']/following-sibling::div[1]"));       
		       builder.click(highp).perform();
		       driver.findElement(By.xpath("//div[contains(@class,'product-list-box card')]")).click();
		        WebElement fper=   driver.findElement(By.xpath("//img[@class='listing-img']"));
		        builder.moveToElement(fper).perform();	        
		        WebDriverWait wait=new WebDriverWait(driver,15);
		        driver.findElement(By.xpath("//button[text()='ADD TO BAG']")).click();
		        WebElement c = driver.findElement(By.xpath("//button[text()='Added To Bag']"));
		        String cmsg=  wait.until(ExpectedConditions.visibilityOf(c)).getText();
		    	 System.out.println(cmsg);  
		    	 Set<String> winshow= driver.getWindowHandles();   
			 		System.out.println(winshow.size());	 		
			 		List <String>firstwin=new ArrayList<String>(winshow);
			 		driver.switchTo().window(firstwin.get(1));
			 		Thread.sleep(2000);
			 		driver.close();
			 		driver.switchTo().window(firstwin.get(0));

			 		  File source = driver.getScreenshotAs(OutputType.FILE);
					  File file = new  File("./snaps/c.jpg"); 
					  FileUtils.copyFile(source, file);
			 		
			 		driver.findElement(By.className("AddBagIcon")).click();	
			 		String grandTotal = driver.findElement(By.xpath("//div[text()='Grand Total:']")).getText();		 	
			 		System.out.println("The grandtotal of the product is   "  +grandTotal);	
			 		
			 		
			 		
						/*
						 * driver.findElement(By.xpath("//span[text()='Proceed']")).click();
						 * driver.findElement(By.xpath("(//button[contains(@class,'btn full')])[2]")).
						 * click(); driver.findElement(By.name("name")).sendKeys("Sanjay",Keys.TAB);
						 * driver.findElement(By.name("email")).sendKeys("aksan@gmail.com",Keys.TAB);
						 * driver.findElement(By.name("phoneNumber")).sendKeys("8648923645",Keys.TAB);
						 * driver.findElement(By.name("pinCode")).sendKeys("600077",Keys.TAB);
						 * driver.findElement(By.xpath("//textarea[@class='textarea-control prl10']")).
						 * sendKeys("RSA Nagar,Chennai");
						 * driver.findElement(By.xpath("//button[contains(@class,'btn full')]")).click()
						 * ; Thread.sleep(1000);
						 * driver.findElement(By.xpath("//button[@type='submit']")).click(); String
						 * thisFieldIs =
						 * driver.findElement(By.xpath("//span[@class='field-error']")).getText();
						 * System.out.println("CardNumber " +thisFieldIs); String Expiry=
						 * driver.findElement(By.xpath("//span[text()='Required']")).getText();
						 * System.out.println("Expirydate  "+Expiry); String required =
						 * driver.findElement(By.xpath("(//span[text()='Required'])[2]")).getText();
						 * System.out.println("CCV" +required);
						 * 
						 * 
						 * 
						 * 
						 * 
						 * driver.close();
						 */
			
			
				}

}
