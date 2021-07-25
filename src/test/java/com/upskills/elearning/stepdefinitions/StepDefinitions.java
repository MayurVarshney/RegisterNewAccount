package com.upskills.elearning.stepdefinitions;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepDefinitions {
	
	WebDriver driver;
	
	Random randomNo = new Random();
	int randomNumber = randomNo.nextInt(1000000);
	String emailId = "mayur" + randomNumber + "@gmail.com";
	String userName = "Mayur" + randomNumber;
	
	@Given("User opens URL in a browser to open Application")
	public void user_opens_url_in_a_browser_to_open_application() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();	   
	}
	
	@Given("User clicks on SignUp Link")
	public void user_clicks_on_sign_up_link() {
		
		driver.findElement(By.xpath("(//a[contains(@href,'http://elearningm1.upskills.in/main/auth')])[1]")).click();
	}
	
	@Then("User validates that Registration page should be opened")
	public void user_validates_that_registration_page_should_be_opened() {
		
		String ActualRegistrationText = driver.findElement(By.xpath("//*[@class='active']")).getText().trim();
		String ExpectedRegistrationText = "Registration";
		Assert.assertEquals(ExpectedRegistrationText, ActualRegistrationText);
	   
	}
	@Given("User enters first Name as {string}")
	public void user_enters_first_name_as(String firstName) {
		driver.findElement(By.xpath("//input[@id='registration_firstname']")).sendKeys(firstName);
	}
	
	@Given("User enters last Name as {string}")
	public void user_enters_last_name_as(String lastName) {
		driver.findElement(By.xpath("//input[@id='registration_lastname']")).sendKeys(lastName);
	   
	}
	@Given("User enters unique EmailId")
	public void user_enters_unique_EmailId() {
	
		driver.findElement(By.xpath("//input[@id='registration_email']")).sendKeys(emailId);
		
	}
	
	@Given("User enters unique Username")
	public void user_enters_unique_username() {
	
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
		
	}
	
	@Given("User enters valid password and confirm Password")
	public void user_enters_valid_password_and_confirm_password() {
		
		driver.findElement(By.xpath("//input[@id='pass1']")).sendKeys("Mayur1234");
		driver.findElement(By.xpath("//input[@id='pass2']")).sendKeys("Mayur1234");
	}
	@Given("User enters Phone number as {string}")
	public void user_enters_phone_number_as(String phoneNumber) {
		driver.findElement(By.xpath("//input[@id='registration_phone']")).sendKeys(phoneNumber);
	   
	}
	@Given("User enter code")
	public void user_enter_code() {
	  driver.findElement(By.xpath("//input[@id='registration_official_code']")).sendKeys("1234");
	}
	@Given("User clicks on Register button")
	public void user_clicks_on_register_button() {
		driver.findElement(By.xpath("//button[@id='registration_submit']")).click();
	    
	}
	@Then("verify Registration should be completed Successfully")
	public void verify_registration_should_be_completed_successfully() {
		
		String actualSignedUpUser = driver.findElement(By.xpath("//div[@class= 'col-xs-12 col-md-12']")).getText().substring(0, 19).trim();
		String actualRegisteredMessage = driver.findElement(By.xpath("//div[@class= 'col-xs-12 col-md-12']")).getText().substring(22, 67).trim();

		String expectedSignedUpUser = "Dear Mayur Varshney";
		String expectedRegisteredMessage ="Your personal settings have been registered.";
		
		Assert.assertEquals(expectedSignedUpUser, actualSignedUpUser);
		Assert.assertEquals(expectedRegisteredMessage, actualRegisteredMessage);
		
	}

	@When("User Clicks on top right corner to open drop-down")
	public void user_clicks_on_top_right_corner_to_open_drop_down() {
		
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
	   
	}
	@Then("User Validates the email which is entered")
	public void user_validates_the_email_which_is_entered() {
	   String actualEmail=  driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[2]/ul/li[1]/div/p")).getText().trim();
	   Assert.assertEquals(emailId, actualEmail);
	   
	}
	
	@When("User click on Inbox")
	public void user_click_on_inbox() {
		driver.findElement(By.xpath("//a[contains(@href,'inbox')][@title='Inbox']")).click();
	 
	}

	@When("user click on Compose Message Button")
	public void user_click_on_compose_message_button() {
		driver.findElement(By.xpath("//img[@alt='Compose message']")).click();
	    
	}
	@When("user enters email of recipient")
	public void user_enters_email_of_recipient() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Mayur");
		Thread.sleep(1000);
		
		List<WebElement> list = driver.findElements(By.xpath("//li[@role='treeitem']"));
		
		for(int i = 0 ;i< list.size();i++)
		{
		if(list.get(i).getText().equals("Mayur Varshney (mayur)"))
			{
				list.get(i).click();
				break;
			}
		}
	}
		
	@When("user enters subject as {string}")
	public void user_enters_subject_as(String subject) {
		
		driver.findElement(By.xpath("//input[@id='compose_message_title']")).sendKeys(subject);
	   
	}
	@When("User enters message body")
	public void user_enters_message_body() {
	    
	}
	@When("user clicks on Send message button")
	public void user_clicks_on_send_message_button() {
		
		driver.findElement(By.xpath("//*[@id='compose_message_compose']")).click();
	    
	}
	@Then("user verify the email acknowlegement")
	public void user_verify_the_email_acknowlegement() {
	String actaulAcknowledgeMesage=	driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]")).getText().trim();
	String expectedAcknowledgeMesage = "The message has been sent to Mayur Varshney (mayur)";
	
	Assert.assertEquals(expectedAcknowledgeMesage, actaulAcknowledgeMesage);
	}

}
