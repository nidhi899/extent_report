package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mappls.map.features.TC__017_NavigationFeature;
import com.mappls.map.utils.DriverManager;



public class TC__017_Navigation extends DriverManager {
//418-430
	
	private TC__017_NavigationFeature drf;

	@Test(priority = 1)
	public void ChooseOnMapLocStart() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.ChooseOnMapLocStart();
	}

	@Test(priority = 2)
	public void ChooseOnMapLocEnd() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.ChooseOnMapLocEnd();
	}
	
	@Test(priority = 3)
	public void CurrentLocStart() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.CurrentLocStart();
	}
	@Test(priority = 4)
	public void CurrentLocFinal() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.CurrentLocFinal();
	}

	@Test(priority = 5)
	public void StartandFinalLoc() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.StartandFinalLoc();
	}

	@Test(priority = 6)
	public void reverseLoc() throws IOException, InterruptedException {

		drf = new TC__017_NavigationFeature(driver);
		drf.interchangeStartAndFinal();
	}

	@Test(priority = 7)
	public void DirectionRoutePreview() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.PreviewRoute();
	}

	@Test(priority = 8)
	public void DirectionRouteStart() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.StartRoute();
	}

	@Test(priority = 9)
	public void btmShtShowOnMap() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.directionBtmshtShowOnMap();
	}

	@Test(priority = 10)
	public void ModeCar() throws IOException, InterruptedException {

		drf = new TC__017_NavigationFeature(driver);
		drf.modeCar();
	}

	@Test(priority = 11)
	public void ModeBike() throws IOException, InterruptedException {

		drf = new TC__017_NavigationFeature(driver);
		drf.modeBike();
	}

	@Test(priority = 12)
	public void ModeTruck() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.modeTruck();
	}

	@Test(priority = 13)
	public void ModeWalk() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.modeWalk();
	}

	@Test(priority = 14)
	public void StartnewRoute() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.searchStartNewRoute();
	}

	@Test(priority = 15)
	public void addWaypoint() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.searchAddWayPoint();
	}

	@Test(priority = 16)
	public void postReport() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.postonmap();
	}

	@Test(priority = 17)
	public void SaveRoute() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.saveRoute();
	}

	@Test(priority = 18)
	public void directionList() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.DirectionList();
	}
	
	@Test(priority = 19)
	public void directionRouteHome() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.directionToHome();
	}
	
	@Test(priority = 20)
	public void directionRouteWork() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
		drf.directionToWork();
	}
	
//	418	Check UI for Navigation Page -  Verify the UI is proper in Navigation	UI for all screen should be properly visible and function should work properly  wip
	@Test(priority = 21)
	public void NavigationPageUI() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
        drf.NavigationPageui();
	}
//	419	Verify Navigation without via points - Search for a route without Via Point	Route should get draw by providing starting and destination point(without get route button)	Automation	WIP
	
	@Test(priority = 22)
	public void NavigationWithoutGetRoute() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
        drf.NavigationWithoutgetroute();
	}
//	420	Verify Navigation with via points  -  Route should get draw after clicking on 'Get Route' button by providing starting, destination and via point(s)	Automation	WIP
	@Test(priority = 23)
	public void NavigationWithGetRoute() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
        drf.NavigationWithgetroute();
	}
//	423	Verify Navigation in MapmyIndia layer mode - Search for a route in MapmyIndia Map layer	MapmyIndia map layer should be display while navigating wip
	@Test(priority = 24)
	public void NavigationMMILayer() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
        drf.NavigationMmiLayer();
	}
//	424	Verify the Start button in Direction card ===Start button should be available on direction card	===Automation ==	Done
	@Test(priority = 25)
	public void NavigationStartButtonAvailability() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
        drf.NavigationStartbtnavailability();
	}
//	425	Verify the Start button in Direction card =====Checking the start is clicklable	Start button should be clickable and open the navigation page====Automation	==Done
	@Test(priority = 26)
	public void NavigationClickStartButton() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
        drf.NavigationClickStartbtn();
	}
//	428	Verify for Route summary UI =========Check that all the texts and icons are proper and correct	All the texts and icons should be clearly visible and correct =done
	@Test(priority = 27)
	public void NavigationRouteSummaryUI() throws IOException, InterruptedException {
		drf = new TC__017_NavigationFeature(driver);
        drf.NavigationRouteSummaryui();
	}
}
