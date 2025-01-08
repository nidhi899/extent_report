package tests;


import org.testng.annotations.Test;

import com.mappls.map.features.TC__014_HomeScreenFeature;
import com.mappls.map.utils.DriverManager;

public class TC__014_HomeScreen extends DriverManager{
//301-305
	TC__014_HomeScreenFeature hm;
	
//	Verify that the UI is proper and visible in Home Screen	
//	UI of the Home screen should be properly visible and the functions should work properly
	@Test(priority = 1) 
	public void homeScreenUI () {
		hm = new TC__014_HomeScreenFeature(driver);
		hm.uiVerification();
	}
	
	
//	TC - 2
//	Verify all the elements at the top of the Home Screen	"On the top of the Screen there should be the Search bar,
//	To the left of the search bar, Hamburger should be displayed
//	To the right of search bar, navigation button and what & where search button should be displayed"
    @Test(priority = 2)
    public void verifyAllElementsTopScreen() {
    	hm = new TC__014_HomeScreenFeature(driver);
    	hm.topScreen();
    }


//    Check the Elements in Home Screen	
//    Verify the elements at the center of the Home Screen	
//    "By default MapmyIndia map should be displayed,
//    Current location of the user should be displayed with the dialogue box ""You are Here""
//    The Map Layer, compass event icon,Mappls camera, Mappls pin button should also be displayed to the right side of the screen"
    
//    @Test(priority = 3) 
//     public void verifyElementsCenterScreen() throws InterruptedException, IOException, FindFailed {
//    	 hm = new TC__014_HomeScreenFeature(driver);
//    	 hm.centerScreen();
//     }
     
     
//     TC - 4
//     Verify the elements at the lower side of the screen	
//     The Current location button and the Quick Access menu should be diplayed at the lower part of the screen
       @Test(priority = 3)
       public void lowerSideElements() {
    	   hm = new TC__014_HomeScreenFeature(driver);
    	   hm.lowerSideElementsVerification();
       }
    
       
//       Verify the elements at the left side of the screen
//       360 degree button should be displayed at the top left side of the screen
         @Test(priority = 4)
         public void leftSideElements() {
        	 hm = new TC__014_HomeScreenFeature(driver);
        	 hm.leftElementsVerification();
         }
       
    
    
//       Check the Elements in Home Screen	
//       Verify the elements at the center of the Home Screen	
//       "By default MapmyIndia map should be displayed,
//       Current location of the user should be displayed with the dialogue box ""You are Here""
//       The Map Layer, compass event icon,Mappls camera, Mappls pin button should also be displayed to the right side of the screen"
       
//       @Test(priority = 5) //WIP 
//       public void verifyElementsCenterScreen() throws InterruptedException, IOException, FindFailed {
//      	 hm = new TC__014_HomeScreenFeature(driver);
//      	 hm.centerScreen();
//       }
    
    
    
    
    
    

}
