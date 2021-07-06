package seleniumSample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/table.html");
		
		driver.manage().window().maximize();
		
		List<WebElement> tablerows =driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		System.out.println(tablerows.size());

		ArrayList<String> table1 = new ArrayList<String>();
		for(int i=2;i<6;i++)//search starts from second row.
		{
		String text=driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
		
		table1.add(text);
		
		}
       // System.out.println(table1);//();
    Collections.sort(table1);
	/*
	 * String tab= table1.get(2); System.out.println(tab.replace("%", " "));
	 */
	System.out.println(table1);	
    
	}

}


/*
 * List<WebElement>
 * table=driver.findElements(By.xpath("//table[@id='table_id']"));
 * ArrayList<String> table1 = new ArrayList<String>(); for(WebElement tab:
 * table) { table1.add(tab.getText()); } Collections.sort(table1);
 * System.out.println(table1);
 */
