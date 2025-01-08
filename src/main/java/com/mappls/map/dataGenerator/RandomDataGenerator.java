package com.mappls.map.dataGenerator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomDataGenerator {

	public static String generateRandomDistrictInJharkhand() {
		String[] jharkhandDistricts = { "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", 
				"Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", 
				"Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", 
				"Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", 
				"Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", 
				"Uttar Pradesh", "Uttarakhand", "West Bengal", "Delhi"
		};
		return getRandomElement(jharkhandDistricts);
	}

	public static String getRandomElement(String[] array) {
		Random rand = new Random();
		return array[rand.nextInt(array.length)];
	}

	public static String generateRandomTestName() {
		Random random = new Random();
		String[] names = { "restaurant1", "hotel1", "park1", "myhome1", "sweet home1", "garden1" };
		int index = random.nextInt(names.length);
		return names[index];
	}
	
	public static String generateRandomTestName1() {
        Random random = new Random();
        String[] names = { "restaurant1", "hotel1", "park1", "myhome1", "sweet home1", "garden1" };
        int index = random.nextInt(names.length);
        long timestamp = System.currentTimeMillis();  // Get current timestamp
        return names[index] + "_" + timestamp;
    }

	// ====================for new user registration

	// random email generator
	public static String generateRandomEmail() {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder email = new StringBuilder();
		Random random = new Random();
		// Generate a random string of length 8 for the local part of the email
		for (int i = 0; i < 8; i++) {
			email.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
		}
		email.append("@example.com");
		return email.toString();
	}

	// invalid mail generator
	public static String generateRandomInvalidEmail() {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder email = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			email.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
		}
		email.append("@example.com.cp.mn.xsj.nm.d.e.er");
		return email.toString();
	}

	// random password generate
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=";
	private static final int PASSWORD_LENGTH = 8;

	public static String generateRandomPassword() {
		StringBuilder password = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			int index = random.nextInt(CHARACTERS.length());
			password.append(CHARACTERS.charAt(index));
		}
		return password.toString();
	}

	// random mobile number
	public static String generateRandomMobileNumber() {
		Random random = new Random();
		StringBuilder mobileNumber = new StringBuilder("9"); // Start with 9
		for (int i = 1; i < 10; i++) { // Generate 9 more digits
			mobileNumber.append(random.nextInt(10)); // Append a random digit between 0 and 9
		}
		return mobileNumber.toString();
	}

	// random name generator
	public static String generateRandomName() {
		String[] firstNames = { "John", "Jane", "David", "Emily", "Michael", "Sophia", "Daniel", "Olivia" };
		String[] lastNames = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore" };
		Random random = new Random();
		String firstName = firstNames[random.nextInt(firstNames.length)];
		String lastName = lastNames[random.nextInt(lastNames.length)];
		return firstName + " " + lastName;
	}

	// for near by places
	public static String generateRandomPlace() {
		String[] places = { "Bar", "Restaurant", "Disco", "Temple", "Park", "Cinema", "Museum", "Library", "Café",
				"Zoo" };
		return getRandomElement(places);
	}

	// for random place
	private static final List<String> PLACE_NAMES_LIST = Arrays.asList("Ujjain", "Bengaluru", "Shimla", "Ayodhya", "Jaipur", "Noida", "Lucknow","Varanasi", "Konark", "Ranchi");
	private static List<String> shuffledPlaceNames = new ArrayList<>(PLACE_NAMES_LIST);
	private static int currentIndex = 0;

	public static String generateRandomPlaceName() {
	    // Shuffle the list if it's the first call or all places have been generated
	    if (currentIndex == 0 || currentIndex >= shuffledPlaceNames.size()) {
	        Collections.shuffle(shuffledPlaceNames);
	        currentIndex = 0;
	    }
	    String randomPlace = shuffledPlaceNames.get(currentIndex);
	    currentIndex++;
	    return randomPlace;
	}


	// for random user names
	private static final String[] NAMES = { "Aarav", "Aditya", "Vihaan", "Arjun", "Ayaan", "Krishna", "Ishaan",
			"Ananya", "Siya", "Myra", "Aarohi", "Riya", "Anika" };
	private static Set<String> generatedNames = new HashSet<>();

	public static String generateRandomUserName() {
		String randomName;
		do {
			int randomIndex = ThreadLocalRandom.current().nextInt(0, NAMES.length);
			randomName = NAMES[randomIndex];
		} while (generatedNames.contains(randomName));
		generatedNames.add(randomName);
		return randomName;
	}

	// for random user about
	private static final String[] ABOUTS = { "Rich cultural heritage.", "Vibrant nightlife.",
			"Modern and traditional mix.", "Historical landmarks.", "Scenic landscapes.", "City of energy.",
			"Art and music hub.", "Adventure destination.", "Peaceful retreat.", "Emerging tech hub.",
			"Good place to visit on." };
	private static Set<String> generatedAbout = new HashSet<>();

	public static String generateRandomAbout() {
		String randomAbout;
		do {
			int randomIndex = ThreadLocalRandom.current().nextInt(0, ABOUTS.length);
			randomAbout = ABOUTS[randomIndex];
		} while (generatedAbout.contains(randomAbout));
		generatedAbout.add(randomAbout);
		return randomAbout;
	}

	// for random user id
	private static Set<String> generatedUserIds = new HashSet<>();

	public static String generateRandomUserId() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder userId;
		do {
			userId = new StringBuilder();
			for (int i = 0; i < 8; i++) { // Generating a random user ID of length 8
				int randomIndex = ThreadLocalRandom.current().nextInt(0, characters.length());
				userId.append(characters.charAt(randomIndex));
			}
		} while (generatedUserIds.contains(userId.toString()));
		generatedUserIds.add(userId.toString());
		return userId.toString();
	}

	// for random emergency contact
	private static final int MOBILE_NUMBER_LENGTH = 10;
	private static final Set<String> generatedMobileNumbers = new HashSet<>();

	public static String generateRandomContactNumber() {
		String randomMobileNumber;
		do {
			randomMobileNumber = generateRandomMobileNumberString();
		} while (generatedMobileNumbers.contains(randomMobileNumber));
		generatedMobileNumbers.add(randomMobileNumber);
		return randomMobileNumber;
	}

	private static String generateRandomMobileNumberString() {
		StringBuilder sb = new StringBuilder();
		// First digit: 6-9
		int firstDigit = ThreadLocalRandom.current().nextInt(6, 10);
		sb.append(firstDigit);
		// Remaining digits: 0-9
		for (int i = 1; i < MOBILE_NUMBER_LENGTH; i++) {
			int nextDigit = ThreadLocalRandom.current().nextInt(0, 10);
			sb.append(nextDigit);
		}
		return sb.toString();
	}

	// for random search category near me
	private static final String[] Category = { "atm", "coffee", "school", "toilet", "pharmacy", "parking",
			"transportation", "hotel", "entertainment", "shopping", "hospitals", "police", "bank", "cng" };
	private static Set<String> generatedCategory = new HashSet<>();

	public static String generateRandomCategory() {
		String randomCat;
		do {
			int randomIndex = ThreadLocalRandom.current().nextInt(0, NAMES.length);
			randomCat = Category[randomIndex];
		} while (generatedCategory.contains(randomCat));
		generatedCategory.add(randomCat);
		return randomCat;
	}

	// for random experience
	private static final String[] EXPERIENCES = { "Delicious local cuisine.", "Exciting festivals.",
			"Beautiful hiking trails.", "Relaxing beaches.", "Engaging tours.", "Unique shopping experiences.",
			"Breathtaking viewpoints.", "Interactive museums.", "Friendly locals.", "Lively street markets." };

	private static Set<String> generatedExperience = new HashSet<>();

	public static String generateRandomExperience() {
		String randomExperience;
		do {
			int randomIndex = ThreadLocalRandom.current().nextInt(0, EXPERIENCES.length);
			randomExperience = EXPERIENCES[randomIndex];
		} while (generatedExperience.contains(randomExperience));
		generatedExperience.add(randomExperience);
		return randomExperience;
	}

	// for random list names
	private static final String[] LIST_NAMES = { "Favorite Destinations", "Hidden Gems", "Must-Visit Spots",
			"Dream Vacation Spots", "Local Wonders", "Travel Treasures", "Top Rated Places", "Bucket List Locations",
			"Explorer's Picks", "Adventurous Escapes" };

	private static Set<String> generatedListNames = new HashSet<>();
	public static String generateRandomListName() {
		String randomListName;
		do {
			int randomIndex = ThreadLocalRandom.current().nextInt(0, LIST_NAMES.length);
			randomListName = LIST_NAMES[randomIndex];
		} while (generatedListNames.contains(randomListName));
		generatedListNames.add(randomListName);
		return randomListName;
	}
	
	 // For random route names
    private static final String[] ROUTE_DESTINATIONS = { "Home", "Office", "School", "Park", "Mall",
            "Airport", "Hospital", "Restaurant", "Gym", "Beach", "Stadium" };
    private static Set<String> generatedRouteNames = new HashSet<>();

    public static String generateRandomRouteName() {
        String randomRouteName;
        do {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, ROUTE_DESTINATIONS.length);
            randomRouteName = "Route to " + ROUTE_DESTINATIONS[randomIndex];
        } while (generatedRouteNames.contains(randomRouteName));
        generatedRouteNames.add(randomRouteName);
        return randomRouteName;
    }
    
    // For random traffic reports
    private static final String[] TRAFFIC_REPORTS = { "Construction work.", "Moderate  flow of traffic.", "Light traffic.",
            "Road construction ahead.", "Clear roads.", "Traffic jam.", "Slow moving traffic.",
            "Congestion at junction.", "Smooth flow of traffic." };
    private static Set<String> generatedTrafficReports = new HashSet<>();

    public static String generateRandomTrafficReport() {
        String randomTrafficReport;
        do {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, TRAFFIC_REPORTS.length);
            randomTrafficReport = TRAFFIC_REPORTS[randomIndex];
        } while (generatedTrafficReports.contains(randomTrafficReport));
        generatedTrafficReports.add(randomTrafficReport);
        return randomTrafficReport;
    }
	//=================================
    //For random pin
    private static final String[] RANDOM_PINS = { "3lglk2", "227c5a", "123b91", "518nsv", "ra4932", "3lgjuv" };
    private static Set<String> generatedPINS = new HashSet<>();

    public static String generateRandomPins() {
        String randompins;
        do {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, RANDOM_PINS.length);
            randompins = RANDOM_PINS[randomIndex];
        } while (generatedPINS.contains(randompins));
        generatedPINS.add(randompins);
        return randompins;
    }
    //for random building
    private static final String[] RANDOM_Building = { "India Gate", "Lotus Temple", 
    	    "Rashtrapati Bhavan", "Humayun's Tomb", "Jama Masjid", 
    	    "Connaught Place", "Akshardham Temple", "Jantar Mantar" };
    private static Set<String> generatedbuildingName = new HashSet<>();

    public static String generateRandomBuildingName() {
        String buildingName;
        do {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, RANDOM_Building.length);
            buildingName = RANDOM_Building[randomIndex];
        } while (generatedbuildingName.contains(buildingName));
        generatedbuildingName.add(buildingName);
        return buildingName;
    }
    //for random road
    private static final String[] Random_Road = {"Outer Ring Road","Kasturba Gandhi Marg Area"};
    private static Set<String> generatedRandomRoad = new HashSet<>();
    public static String generateRandomRoadName() {
        String roadName;
        do {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, Random_Road.length);
            roadName = Random_Road[randomIndex];
        } while (generatedRandomRoad.contains(roadName));
        generatedRandomRoad.add(roadName);
        return roadName;
    }
    //for random locality
    private static final String[] Random_Locality = {"Saket", "Greater Kailash", "Lajpat Nagar", 
    	   "Dwarka", "Karol Bagh", "Vasant Vihar", "Rohini", "Pitampura", };
    private static Set<String> generatedRandomLocality = new HashSet<>();
    public static String generateRandomLocality() {
        String localityName;
        do {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, Random_Locality.length);
            localityName = Random_Locality[randomIndex];
        } while (generatedRandomLocality.contains(localityName));
        generatedRandomLocality.add(localityName);
        return localityName;
    }
    //for random village
    private static final String[] Random_Village = {"Ghitorni", "Jonapur", "Mehrauli", 
    	    "Chattarpur", "Bijwasan", "Najafgarh", "Mundka", "Badarpur"};
    private static Set<String> generatedRandomVillage = new HashSet<>();
    public static String generateRandomVillage() {
        String villageName;
        do {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, Random_Village.length);
            villageName = Random_Village[randomIndex];
        } while (generatedRandomVillage.contains(villageName));
        generatedRandomVillage.add(villageName);
        return villageName;
    }
}
