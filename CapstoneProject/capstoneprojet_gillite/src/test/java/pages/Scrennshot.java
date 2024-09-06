package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Scrennshot {
	public Scrennshot(WebDriver driver) {
	}



		public String getScreenshot(String scrShotName, WebDriver driver) {

			Date date = new Date();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");

			String dataTime = sdf.format(date);

			String fileName = scrShotName + " _ " + dataTime + ".png";

			TakesScreenshot scrShot = (TakesScreenshot) driver;

			File scrFile = scrShot.getScreenshotAs(OutputType.FILE);

			File destFile = new File(".\\screenshots\\" + fileName);

			try {

				FileUtils.copyFile(scrFile, destFile);

			} catch (IOException e) {

				e.printStackTrace();

			}
			return fileName;

		}
	}