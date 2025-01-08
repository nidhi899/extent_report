package tests;

import java.io.IOException;

import org.testng.annotations.Test;
import com.mappls.map.features.TC__025_RealViewFeature;
import com.mappls.map.utils.DriverManager;

public class TC__025_RealView extends DriverManager{

	private TC__025_RealViewFeature drf;

	//563
	@Test(priority = 1)
	public void RealView() throws IOException, InterruptedException {
		drf = new TC__025_RealViewFeature(driver);
		drf.RealViewIconDisplay();
	}
}
