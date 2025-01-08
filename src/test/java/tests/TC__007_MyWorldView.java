package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mappls.map.features.TC__007_MyWorldViewFeature;
import com.mappls.map.utils.DriverManager;



public class TC__007_MyWorldView extends DriverManager {

	private TC__007_MyWorldViewFeature mwvf;

//99-118
	@Test(priority = 1)
	public void myWorldViewUI() throws IOException, InterruptedException {
		mwvf = new TC__007_MyWorldViewFeature(driver);
		mwvf.myWorldViewUI();
	}
	
	@Test(priority = 2)
	public void myWorldViewBackButton() throws IOException, InterruptedException {
		mwvf = new TC__007_MyWorldViewFeature(driver);
		mwvf.myWorldViewBackButton();
		
	}
	
	@Test(priority = 3)
	public void myWorldViewcontactsync() throws IOException, InterruptedException {
		mwvf = new TC__007_MyWorldViewFeature(driver);
		mwvf.myWorldViewcontactsync();
	}
	
	@Test(priority = 4)
	public void myWorldViewSearchContact() throws IOException, InterruptedException {
		mwvf = new TC__007_MyWorldViewFeature(driver);
		mwvf.myWorldViewSearchContact();
	}
	
	@Test(priority = 5)
	public void myWorldViewContactPermission() throws IOException, InterruptedException {
		mwvf = new TC__007_MyWorldViewFeature(driver);
		mwvf.myWorldViewContactPermission();
	}
	
	@Test(priority = 6)
	public void myWorldViewMapplsNotification() throws IOException, InterruptedException {
		mwvf = new TC__007_MyWorldViewFeature(driver);
		mwvf.myWorldViewMapplsNotification();
	}
	
	@Test(priority = 7)
	public void myWorldViewMMIMap() throws IOException, InterruptedException {
		mwvf = new TC__007_MyWorldViewFeature(driver);
		mwvf.myWorldViewMMIMap();
	}
	
	@Test(priority = 8)
	public void myWorldViewHybridSatellite() throws IOException, InterruptedException {
		mwvf = new TC__007_MyWorldViewFeature(driver);
		mwvf.myWorldViewHybridSatellite();
	}
	@Test(priority = 9)
	public void myWorldView3DMAp() throws IOException, InterruptedException {
		mwvf = new TC__007_MyWorldViewFeature(driver);
		mwvf.myWorldView3DMAp();
	}
	
	@Test(priority = 10)
	public void myWorldViewReviewDetailPage() throws IOException, InterruptedException {
		mwvf = new TC__007_MyWorldViewFeature(driver);
		mwvf.myWorldViewReviewDetailPage();
	}
	
//	@Test(priority = 11)
//	public void myWorldViewLike() throws IOException, InterruptedException {
//		mwvf = new TC__007_MyWorldViewFeature(driver);
//		mwvf.myWorldViewLike();
//	}
//	
//	@Test(priority = 12)
//	public void myWorldViewUnlike() throws IOException, InterruptedException {
//		mwvf = new TC__007_MyWorldViewFeature(driver);
//		mwvf.myWorldViewUnlike();
//	}
	
	@Test(priority = 13)
	public void myWorldViewFlag() throws IOException, InterruptedException {
		mwvf = new TC__007_MyWorldViewFeature(driver);
		mwvf.myWorldViewFlag();
	}
//	///hold
//	@Test(priority = 14)
//	public void myWorldViewFollow() throws IOException, InterruptedException {
//		mwvf = new TC__007_MyWorldViewFeature(driver);
//		mwvf.myWorldViewFollow();
//	}
//	
//	@Test(priority = 15)
//	public void myWorldViewUnfollow() throws IOException, InterruptedException {
//		mwvf = new TC__007_MyWorldViewFeature(driver);
//		mwvf.myWorldViewUnfollow();
//	}
	
}
