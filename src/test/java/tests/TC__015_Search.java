package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mappls.map.features.TC__015_SearchFeature;
import com.mappls.map.utils.DriverManager;




public class TC__015_Search  extends DriverManager {
//306-316
	private TC__015_SearchFeature spf;

	@Test(priority = 1)
	public void SearchUI() throws InterruptedException, IOException {
		spf = new TC__015_SearchFeature(driver);
		spf.SearchUI();
	}

	@Test(priority = 2)
	public void SearchTextEnter() throws InterruptedException, IOException {
		spf = new TC__015_SearchFeature(driver);
		spf.searchTextEnter();
	}

	@Test(priority = 3)
	public void SearchAutoSuggest() throws IOException, InterruptedException {
		spf = new TC__015_SearchFeature(driver);
		spf.searchAutoSuggest();
	}
	
	@Test(priority = 4)
	public void SearchCategoryList() throws IOException {
		spf = new TC__015_SearchFeature(driver);
		spf.searchCatList();
		}
	
	@Test(priority = 5)
	public void SearchRoad() throws IOException, InterruptedException {
		spf = new TC__015_SearchFeature(driver);
		spf.searchRoad();
		}
	
	@Test(priority = 6)
	public void SearchBuilding() throws IOException, InterruptedException {
		spf = new TC__015_SearchFeature(driver);
		spf.searchBuilding();
		}
	
	@Test(priority = 7)
	public void SearchViaPin() throws IOException, InterruptedException {
		spf = new TC__015_SearchFeature(driver);
		spf.searchPin();
		}
	
	@Test(priority = 8)
	public void SearchLocality() throws IOException, InterruptedException {
		spf = new TC__015_SearchFeature(driver);
		spf.searchLocality();
		}
	
	@Test(priority = 9)
	public void SearchVillage() throws IOException, InterruptedException {
		spf = new TC__015_SearchFeature(driver);
		spf.searchVillage();
		}
	
	@Test(priority = 10)
	public void SearchNearbyCategories() throws InterruptedException, IOException {
		spf = new TC__015_SearchFeature(driver);
		spf.searchNearbyCategory();
	}
	
//	@Test(priority = 11)
//	public void SearchUserAddedPlace() throws InterruptedException, IOException {
//		spf = new TC__015_SearchFeature(driver);
//		spf.userAddedPlaceSearch();
//	}

}
