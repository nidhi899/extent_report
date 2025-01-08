package tests;

import java.io.IOException;

import org.testng.annotations.Test;
import com.mappls.map.features.TC__006_CameraOffFeature;
import com.mappls.map.utils.DriverManager;

public class TC__006_CameraOff extends DriverManager {
//98
	private TC__006_CameraOffFeature cf;
	
	@Test(priority = 1)
	public void cameraOff() throws IOException, InterruptedException {
		cf = new TC__006_CameraOffFeature(driver);
		cf.cameraOffFeature();
	}

}
