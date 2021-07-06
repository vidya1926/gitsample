package seleniumSample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erailflights {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		// ChromeDriver driver=new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.linkText("FLIGHTS")).click();

		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		String Title = driver.getTitle();
		System.out.println(Title);
		String flightsirctccoin = driver.findElement(By.xpath("//a[@class='d-block font-weight-bold']")).getText();
		System.out.println(flightsirctccoin);
		driver.close();
		List<String> allhandles1 = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles1.get(0));
		String Title1 = driver.getTitle();
		System.out.println(Title1);

	}

}
