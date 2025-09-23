package Utilities;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenshotCapture 
{
	static Robot robot;
	static File imageFile = new File("src/main/resources/sample.png"); // your image
	static File subImageFile = new File("src/main/resources/cropped.png");
	static BufferedImage fullImage;
	public ScreenshotCapture() throws AWTException 
	{
		robot=new Robot();
	}
	
	
	public static void captureFullSS() throws IOException 
	{
		
		// Get screen size
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

        // Capture full screen
        fullImage = robot.createScreenCapture(screenRect);
        ImageIO.write(fullImage, "png", imageFile);
	}
	
	public static void captureSubSS() throws IOException 
	{
		// Capture full screen
        BufferedImage croppedImage = fullImage.getSubimage(460, 880, 142, 34);
        ImageIO.write(croppedImage, "png", subImageFile);
	}
}
