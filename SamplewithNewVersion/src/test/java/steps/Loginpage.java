package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginpage {
	public ChromeDriver driver;
	@Given ("Initialize the Webdeivermanager")
	public void webDrivermanager() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@Given ("Open the Url")
     public void openUrl() {
		driver.get("http://leaftaps.com/opentaps/control/main");
	}
	@And ("Enter the username")
	public void enterUsername() {
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	}
	
	
	
	
	@Given("Enter the password")
	public void enterThePasswordAsCrmsfa() {
	    
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	}
	
	@Then("Click the Login button")
		
	public void clickLogin() {
	    
		driver.findElement(By.className("decorativeSubmit")).click();
		
	}
	@And("Verify the Title of the navigated page")
	public void verifyTitle() {
		String Title=driver.getTitle();
		if(Title.equals("LeafTaps-TestLeaf Automation Platform"))
		{
			System.out.println("You atre in the right page :" +Title);
		}else {
			System.out.println("You are in a different Page" );
		}
	}

	
	
	
}
