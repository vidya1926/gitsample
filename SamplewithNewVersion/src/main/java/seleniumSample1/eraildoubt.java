package seleniumSample1;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class eraildoubt {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL
		
		driver.get("https://erail.in/");
		
		//Maximize screen
		
		driver.manage().window().maximize();

		driver.findElement(By.id("txtStationFrom")).clear();
		
		driver.findElement(By.id("txtStationFrom")).sendKeys("ms");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[text() = 'Chennai Egmore']")).click();
		
		driver.findElement(By.id("txtStationTo")).clear();
		
		driver.findElement(By.id("txtStationTo")).sendKeys("mdu");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[text() = 'Madurai Jn']")).click();
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		//DataTable TrainList TrainListHeader
		
		WebElement Web_table = driver.findElement(By.className("DataTable DataTableHeader TrainList TrainListHeader"));
		 
		java.util.List<WebElement> Table_rows = Web_table.findElements(By.tagName("tr"));
		
		Thread.sleep(2000);
						
		String all_train_number = Table_rows.get(1).getText();
		
		System.out.println(all_train_number);

	}

}
