
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.google.common.io.Files;
   


public class ChromeProject {


		public static void main(String[] args) {
			
	WebDriver driver = new ChromeDriver ();

	driver.get("http://demoqa.com/");
	WebElement w = driver.findElement(By.id("menu-item-374"));	
	driver.findElement(By.partialLinkText("Registration")).click(); // other way to find same element
	
	if(driver.getCurrentUrl().contains("registration")) {
		
		System.out.println("Hey we made it");
	}
	
	

	//First name text field
	driver.findElement(By.id("name_3_firstname")).sendKeys("Nadya");
	
	//Last name text field
	driver.findElement(By.id("name_3_lastname")).sendKeys("Ilinskiy");
		
	//Country - dropdown 
		Select country = new Select (driver.findElement(By.id("dropdown_7")));
		country.selectByValue("United States");
		
	// Marital Status radio button	
		List<WebElement> status = driver.findElements(By.name("radio_4[]"));
		
			for(WebElement w1 : status) {
				if(w1.getAttribute("value").equals("married")){
					w1.click();
				}
				
			}
			
	//Hobby checkboxes checkbox_5[]
			List<WebElement> hobbey = driver.findElements(By.name("checkbox_5[]"));
			for(WebElement w1 : hobbey) {
				if(w1.getAttribute("value").equals("reading")||w1.getAttribute("value").equals("dance")){
					w1.click();
				}
				
			}
			
		// Date of Birth 
			//Month dropdown
			Select birthMonth = new Select (driver.findElement(By.id("mm_date_8")));
			birthMonth.selectByValue("7");
			
			//Day dropdown
			Select birthDay = new Select (driver.findElement(By.id("dd_date_8")));
			birthDay.selectByValue("11");
			
			//Year dropdown 
			Select birthYear = new Select (driver.findElement(By.id("yy_date_8")));
			birthYear.selectByValue("1979");
			
			
			
		//Phone Number 
			driver.findElement(By.id("phone_9")).sendKeys("7535555555");
			
		//Username
			driver.findElement(By.id("username")).sendKeys("Animag79");
			
		//E-mail
			driver.findElement(By.id("email_1")).sendKeys("Animag79@mail.ru");
			
		//Your Profile Picture
			driver.findElement(By.id("profile_pic_10")).sendKeys("/Users/nadya.ilinskaya/Desktop/hptree.jpg");
			
		//About Yourself
			driver.findElement(By.id("description")).sendKeys("I'm QAE at LP");
			
		//Password
			driver.findElement(By.id("password_2")).sendKeys("pass1234");
			
			
		//Confirm Password
			driver.findElement(By.id("confirm_password_password_2")).sendKeys("pass1234");
			
			
		// taking webpage screenshot
			
			String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";
			System.out.println(fileName);
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				Files.copy(scrFile, new File("/Users/nadya.ilinskaya/Desktop/ScreenShots/"+fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			driver.quit();
		}
}
	
	
	

