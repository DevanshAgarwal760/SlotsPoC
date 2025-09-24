package Utilities;

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
	public static File imageFile = new File("src/main/resources/sample.png"); // your image
	public static File subImageFile = new File("src/main/resources/cropped.png");
	public static BufferedImage fullImage;
		
	public static void captureFullSS()
	{
		try {
		// Get screen size
		robot=new Robot();
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

        // Capture full screen
        fullImage = robot.createScreenCapture(screenRect);
        ImageIO.write(fullImage, "png", imageFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void captureSubSS(int x,int y,int width,int height) throws IOException
	{
		// Capture full screen
        BufferedImage croppedImage = fullImage.getSubimage(x, y, width, height);
        ImageIO.write(croppedImage, "png", subImageFile);
	}
}
