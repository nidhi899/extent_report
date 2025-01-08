package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mappls.map.features.TC__016_PlaceDetailFeature;
import com.mappls.map.utils.DriverManager;

public class TC__016_PlaceDetail extends DriverManager {
//317-417

	private TC__016_PlaceDetailFeature pdpf;

	// 317
	@Test(priority = 1)
	public void PlaceDetailUI() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.placeDetailUI();
	}

	// 318
	@Test(priority = 2)
	public void placeDetailShareViaMapplsPin() throws InterruptedException, IOException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.placeDetailShareViaPin();
	}

	// 319
	@Test(priority = 3)
	public void placeDirectionEta() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.placeDirectionEta();
	}

//		320
	@Test(priority = 4)
	public void verifyStartLocAddresswithLocDeny() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.placeDetailDirectionWithDeniedLoc();
	}

//		321
	@Test(priority = 5)
	public void verifyDirectionBtnoClickOfStartPoint() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.verifyDirectionBtnOnClickOfStartPoint();
	}

	// 322
	@Test(priority = 6)
	public void CameraNotAvailableAndSettingOption() throws InterruptedException, IOException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.checkCameraNotAvailableAndSettingOption();
	}

	// 323
	@Test(priority = 7)
	public void clickBackSettingAndcameraAccessPermission() throws InterruptedException, IOException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.checkclickBackSettingAndcameraAccessPermission();
	}

	// 324
	@Test(priority = 8)
	public void clickCancelandsettingOption() throws InterruptedException, IOException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.checkclickCancelandsettingOption();
	}

	// 325
	@Test(priority = 9)
	public void SettingsPage() throws InterruptedException, IOException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.checkSettingsPage();
	}

	// 326
	@Test(priority = 10)
	public void permissionDeniedtoAccessPhotoLibrary() throws InterruptedException, IOException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.checkpermissionDeniedtoAccessPhotoLibrary();
	}

	// 327
	@Test(priority = 11)
	public void clickcancelandDisplayOfPlaceDetailPage() throws InterruptedException, IOException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.checkclickcancelandDisplayOfPlaceDetailPage();
	}

	// 328
	@Test(priority = 12)
	public void clickOKandDisplaySettingpage() throws InterruptedException, IOException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.checkclickOKandDisplaySettingpage();
	}

	// 329
	@Test(priority = 13)
	public void clickonCameraopentoaddNewImages() throws InterruptedException, IOException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.checkclickonCameraopentoaddNewImages();
	}

	// 331
	@Test(priority = 14)
	public void verifyBackBtnDirection() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.verifyBackBtnOndirection();
	}

	// 332
	@Test(priority = 15)
	public void placeSetAsHome() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.placeSetAsHome();
	}

	// 333
	@Test(priority = 16)
	public void placeSetAsWork() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.placeSetAsWork();
	}

	// 334
	@Test(priority = 17)
	public void placeDetailNearby() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.placeDetailNearby();
	}

	// 335
	@Test(priority = 18)
	public void verifyselectedNearbyCategory() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.verifynearbyUI();
	}

	// 336
	@Test(priority = 19)
	public void verifybackBtnonReviewPage() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.verifyBackBtnOnReviewPage();
	}

	// 337
	@Test(priority = 20)
	public void verifymissedRatingInReview() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.verifyMissedRating();
	}

	// 338
	@Test(priority = 21)
	public void RatingPlace() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.placeDetailReviewRatingWithoutComment();
	}

	// 339
	@Test(priority = 22)
	public void ReviewRating() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.placeDetailReview();
	}

	// 340
	@Test(priority = 23)
	public void ReviewRatingImage() throws InterruptedException, IOException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.ratingReviewImage();
	}

	// 341
	@Test(priority = 24)
	public void placeDetailShare() throws InterruptedException, IOException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.placeDetailShare();
	}

	// 342 
	@Test(priority = 25)
	public void placeDetailSave() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.placeDetailSave();
	}

	// 343
	@Test(priority = 26)
	public void verifyExistingListName() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.listNameAlreadyExists();
	}

	// 344
	@Test(priority = 27)
	public void savePlaceAsFavourite() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.savePlaceFavourites();
	}

	// 345
	@Test(priority = 28)
	public void openPlaceAsFavourite() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.openFavouritesList();
	}

	// 346
	@Test(priority = 29)
	public void verifyListPrivately() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.saveListPrivately();
	}

	// 347
	@Test(priority = 30)
	public void openPlaceAsPublic() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.openPublicList();
	}

	// 348 
	@Test(priority = 31)
	public void placeDetailSavePublic() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.placeDetailSave();
	}

	// 349
	@Test(priority = 32)
	public void openPlaceAsPrivate() throws IOException, InterruptedException {
		pdpf = new TC__016_PlaceDetailFeature(driver);
		pdpf.openPrivateList();
	}

	//350
		@Test(priority = 33)
		public void ReportElementDisplayCheck() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.reportCategoryoption();
		}

		// 351
		@Test(priority = 34)
		public void verifyReportSubCategoryUnicefSchool() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.reportCategoryUnicefSchool();
		}

		// 352
		@Test(priority = 35)
		public void verifyReportSubCategoryPollutingActivity() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.reportCategoryPollutingActivity();
		}

		// 353
		@Test(priority = 36)
		public void verifyReportSubCategorySwachhBharat() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.reportCategorySwachhBharat();
		}

		// 354
		@Test(priority = 37)
		public void verifyReportSubCategoryMapIssue() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.reportCategoryMapIssue();
		}

		// 355
		@Test(priority = 38)
		public void verifyReportSubCategoryTrafficIssue() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.reportCategoryTrafficIssue();
		}

		// 356
		@Test(priority = 39)
		public void verifyReportSubCategoryCommunityIssue() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.reportCategoryCommunityIssue();
		}

		// 357
		@Test(priority = 40)
		public void verifyReportSubCategorySafetyIssue() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.reportCategorySafetyIssue();
		}

		// 358
		@Test(priority = 41)
		public void verifyReportSubCategoryRoadConditionIssue() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.reportCategoryRoadCondition();
		}


	// 359
		@Test(priority = 42)
		public void addedPostShare() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.AddedPostShare();
		}

	//360
		@Test(priority = 43)
		public void verifySuccessfulAdditionofPost() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.placeDetailPost();
		}
		// 361 Check for Description
		@Test(priority = 44)
		public void placeDetailDescription() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.placeDetailDescription();
		}


		// 366
		@Test(priority = 45)
		public void informationLocationClick() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkInformationLocation();
		}
		
		// 367
		@Test(priority = 46)
		public void infoLocationEditSubmit() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkInfoLocationEditSubmitMessage();
		}

		// 368
		@Test(priority = 47)
		public void informationCallingClick() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkCallingClick();
		}

		// 369
		@Test(priority = 48)
		public void infoCallingEditSubmit() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkCallingEditSubmit();
		}

		// 370
		@Test(priority = 49)
		public void informationEmailClick() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkEmailClick();
		}

		// 371
		@Test(priority = 50)
		public void infoEmailEditSubmit() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkEmailEditSubmit();
		} 

		// 372
		@Test(priority = 51)
		public void informationWebsiteClick() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkWebsiteClick();
		}

		// 373
		@Test(priority = 52)
		public void infoWebsiteEditClick() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkWebsiteEditSubmit();
		}

		// 374
		@Test(priority = 53)
		public void ClickSuggestAnEdit() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkSuggestAnEditClick();
		}

		// 375
		@Test(priority = 54)
		public void suggestANEditUI() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkSuggestAnEditUI();
		}

		// 376
		@Test(priority = 55)
		public void categoryAndAddressSuggestEdit() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.categoryAndAddressSuggestEdit();
		}

		// 377
		@Test(priority = 56)
		public void opeaningHours() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkopeaningHours();
		}

		// 378
		@Test(priority = 57)
		public void AdditionalInformation() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkAdditionalInformation();
		}

		// 379
		@Test(priority = 58)
		public void AddImageUI() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkAddImageUI();
		}
		// 380
		@Test(priority = 59)
		public void AddImageCameraText() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkAddImagefunctionality();
		}

		// 381
		@Test(priority = 60)
		public void AddImageUploadFunctionality() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkAddImageupload();
		}
			
		// 382
		@Test(priority = 61)
		public void SimilarPlacesNearbyUI() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checksimilarPlacesNearbyUI();
		}

		// 383
		@Test(priority = 62)
		public void SimilarPlacesNearbyDisplayedClick() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checksimilarPlacesNearbyclick();
		}

		// 384
		@Test(priority = 63)
		public void SimilarPlacesNearbyVerify() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checksimilarPlacesNearbyVerify();
		}

		// 386
		@Test(priority = 64)
		public void RateAndReviewExperienceCard() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkRateAndReviewExperienceCard();
		}

		// 388
		@Test(priority = 65)
		public void EditAndLikeCurrentUserReview() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkEditAndLikeCurrentUserReview();
		}

		// 389
		@Test(priority = 66)
		public void OpenUserReview() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkopenOwnreview();
		}

		// 390
		@Test(priority = 67)
		public void BackBtnFromReviewDetailPage() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkbackBtnReviewdetailpage();
		}

		// 391
		@Test(priority = 68)
		public void ShareReviewDetailPage() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkshareReviewdetailpage();
		}

		// 392
		@Test(priority = 69)
		public void TextleftToCancel() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checktexttoLeftCancel();
		}

		// 393
		@Test(priority = 70)
		public void otherUserFlag() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkotherUserFlag();
		}

		// 394
		@Test(priority = 71)
		public void otherUserFlagReviewOption() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkotherUserFlagReviewOption();
		}

		// 395
		@Test(priority = 72)
		public void otherUserFlagFunction() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkotherUserFlagfunction();
		}

		// 396
		@Test(priority = 73)
		public void DoneBtnFlag() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkDoneBtFlag();
		}

		// 397
		@Test(priority = 74)
		public void openOtherUSerReview() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkopenOtherUSerReview();
		}

		// 398
		@Test(priority = 75)
		public void backBtnFromotherUserReviewPage() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkbackBtnFromotherUserReviewPage();
		}

		// 399
		@Test(priority = 76)
		public void otherUserReviewShare() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkOtherUserReviewShare();
		}

		// 401
		@Test(priority = 77)
		public void ViewAllClickReviewPage() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkviewAllBtnClickUserReviewPage();
		}

		// 404
		@Test(priority = 78)
		public void EditUserOwnReport() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkEditUserOwnReport();
		}

		// 405
		@Test(priority = 79)
		public void OpenUserOwnReport() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkOpenUserOwnReport();
		}

		// 406
		@Test(priority = 80)
		public void BackBtnFromreportDetailPage() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkbackBTNReportDetailPage();
		}

		// 407
		@Test(priority = 81)
		public void ShareUserOwnReport() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkshareUserOwnReport();
		}

		// 408
		@Test(priority = 82)
		public void VerifyShareTextReport() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkShareReportText();
		}

		// 409
		@Test(priority = 83)
		public void openOtherUserReport() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkopenOtherUserReport();
		}

		// 410
		@Test(priority = 84)
		public void BackBtnFromOtherUserreportPage() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkBackBtnFromOtherUserReportPage();
		}

		// 411
		@Test(priority = 85)
		public void ShareOtherUserReport() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkshareotheruserReport();
		}

		// 412
		@Test(priority = 86)
		public void ViewAllButtonClickReportPage() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.checkviewAllBtnClickUserReportPage();
		}

		// 413
		@Test(priority = 87)
		public void getORCodeOption() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.getClickQRCodeOption();
		}

		// 414
		@Test(priority = 88)
		public void QRCodeUI() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.QRCodeUI();
		}
		// 415
				@Test(priority = 89)
				public void verifyQRPinDetailShare() throws IOException, InterruptedException {
					pdpf = new TC__016_PlaceDetailFeature(driver);
					pdpf.placeDetailQRPinDetailShare();
				}

		// 416
		@Test(priority = 90)
		public void verifyShareOptionQRPage() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.placeDetailQRShareOption();
		}

		// 417
		@Test(priority = 91)
		public void verifyQRPinDetailDownload() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.placeDetailQRPinDetailDownload();
		}

		@Test(priority = 92)
		public void placeDetailclaim() throws IOException, InterruptedException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.placeDetailclaim();
		}	
		@Test(priority = 93)
		public void addedPostContinue() throws InterruptedException, IOException {
			pdpf = new TC__016_PlaceDetailFeature(driver);
			pdpf.AddedPostContinue();
		}


//	@Test(priority = 1)
//	public void placeName() throws IOException, InterruptedException {
//		pdpf = new TC__016_PlaceDetailFeature(driver);
//		pdpf.placeDetailName();
//	}
//
//	@Test(priority = 2)
//	public void placeAddress() throws IOException, InterruptedException {
//		pdpf = new TC__016_PlaceDetailFeature(driver);
//		pdpf.placeDetailAdd();
//	}
//
//	@Test(priority = 3)
//	public void placeFeedback() throws IOException, InterruptedException {
//		pdpf = new TC__016_PlaceDetailFeature(driver);
//		pdpf.placeDetailFeedback();
//	}
//
//	@Test(priority = 4)
//	public void placeDistanceAndDuration() throws IOException, InterruptedException {
//		pdpf = new TC__016_PlaceDetailFeature(driver);
//		pdpf.DistanceAndDuration();
//	}
//
//	@Test(priority = 9)
//	public void placeDetailMapplsPin() throws IOException, InterruptedException {
//		pdpf = new TC__016_PlaceDetailFeature(driver);
//		pdpf.placeMapplsPin();
//	}
//




//	// Having application end issue in creating new list and saving the place
//	@Test(priority = 13)
//	public void placeDetailSaveWL() throws IOException, InterruptedException {
//		pdpf = new TC__016_PlaceDetailFeature(driver);
//		pdpf.placeDetailSaveWL();
//	}
	

//	@Test(priority = 15)
//	public void verifySuccessfulAdditionofPostWL() throws InterruptedException, IOException {
//		pdpf = new TC__016_PlaceDetailFeature(driver);
//		pdpf.placeDetailPostWL();
//	}

//	@Test(priority = 19)
//	public void placeDetailClaimWithoutLogin() throws IOException, InterruptedException {
//		pdpf = new TC__016_PlaceDetailFeature(driver);
//		pdpf.placeDetailclaimWL();
//	}

//	@Test(priority = 24)
//	public void placeSetAsHomeWL() throws IOException, InterruptedException {
//		pdpf = new TC__016_PlaceDetailFeature(driver);
//		pdpf.placeSetAsHomeWL();
//	}
//
//	@Test(priority = 25)
//	public void placeSetAsWorkWL() throws IOException, InterruptedException {
//		pdpf = new TC__016_PlaceDetailFeature(driver);
//		pdpf.placeSetAsWorkWL();
//	}

	/////

	




}
