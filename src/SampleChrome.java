import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
public class SampleChrome {

	public static void main(String[] args) throws AddressException, MessagingException, Throwable, IOException {
	
		WebDriver driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		driver.get("https://www.gmail.com/");
		driver.manage().window().maximize();
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		monitoringMail mail = new monitoringMail();
		
		try {
			WebElement block=driver.findElement(By.xpath("/html/body/div[11]/div[3]"));
			List<WebElement> links=block.findElements(By.tagName("aaaa"));
			System.out.println(links.size());
		 
	
		}
		 
		catch (Throwable t)
		 {
			FileUtils.copyFile(src, new File("C:/selenium/error.png"));
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
		 }
		 }
	}


