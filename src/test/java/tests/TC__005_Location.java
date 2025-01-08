package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mappls.map.features.TC__005_LocationFeature;
import com.mappls.map.utils.DriverManager;

public class TC__005_Location extends DriverManager {

	private TC__005_LocationFeature lf;
	
	//96
	@Test(priority = 1)
	public void LocationOffPerMissionUI() throws IOException, InterruptedException {
		lf = new TC__005_LocationFeature(driver);
		lf.locationOff();
	}
   //97
	@Test(priority = 2)
	public void LocationPermissionUI() throws IOException, InterruptedException {
		lf = new TC__005_LocationFeature(driver);
		lf.location();
	}
}
