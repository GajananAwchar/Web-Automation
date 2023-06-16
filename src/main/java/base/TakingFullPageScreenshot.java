package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakingFullPageScreenshot {
	public static  void takescreenshot(WebDriver driver, String tname) throws IOException{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
			String imageName=tname+"_"+timeStamp+".png";
			TakesScreenshot screenshot= (TakesScreenshot)driver;
			File source= screenshot.getScreenshotAs(OutputType.FILE);
			File target= new File(System.getProperty("user.dir")+ "/Screenshot/"+imageName);
			FileUtils.copyFile(source, target); 
			System.out.println("Screenshot taken");  
		} 
	public static String  getMethodName() {
		 String nameofCurrMethod = new Throwable()
                 .getStackTrace()[0]
                 .getMethodName();
		return nameofCurrMethod;  
	}
	}

