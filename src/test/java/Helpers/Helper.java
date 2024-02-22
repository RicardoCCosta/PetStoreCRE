package Helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static void takeScreenshot(WebDriver driver) {
		// Verifica se o WebDriver suporta captura de tela
		if (driver instanceof TakesScreenshot) {
			TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

			// Captura um screenshot como um ficheiro
			File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);

			// Especifique o caminho onde você deseja salvar o screenshot
			String screenshotDirectory = "screenshots/";
			
			// Gera um nome para o screenshot unico e com timestamp
			LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
	        String fileName= now.format(formatter);
			
			Path screenshotPath = Paths.get(screenshotDirectory, fileName + ".png");

			try {
				// Mova o arquivo de screenshot para o diretório especificado
				Files.move(screenshot.toPath(), screenshotPath);
				System.out.println("Screenshot salvo em: " + screenshotPath.toString());
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		} else {
			System.out.println("WebDriver não suporta captura de tela.");
		}
	}
	
	public static String getUniqueEmail() {
		// Get current timeStamp
		LocalDateTime now = LocalDateTime.now();
		// Format timeStamp into a readable number 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String formattedDateTime = now.format(formatter);
        // Return in an email format
        return "user_" + formattedDateTime + "@gmail.com";
	}
	
	public static String getUniqueUsername() {
		// Get current timeStamp
		LocalDateTime now = LocalDateTime.now();
		// Format timeStamp into a readable number 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String formattedDateTime = now.format(formatter);
        // Return as a userName
        return "user_" + formattedDateTime;
	}
	
	// Used for instances where the test need the browser to load properly
	public static void waitLoad() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}