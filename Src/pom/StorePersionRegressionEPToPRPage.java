package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class StorePersionRegressionEPToPRPage extends WebBase{ 
	//EP stands for Expiry Product and PR stands for Purchase Return
	private String value ="Value.Value";
	
	@FindBy(name = "Expiry Products")
	private WebElement expiryProductsTab;

	@WindowsFindBy(accessibility = "tiexpriedId")
	private WebElement expiredProductTab;

	@WindowsFindBy(accessibility = "tiExpiryProductCurrentMonthId")
	private WebElement currentMonthExpiryProductTab;

	@WindowsFindBy(accessibility = "tiExpiryProductNextMonthId")
	private WebElement nextMonthExpiryProductTab;

	@WindowsFindBy(accessibility = "tiExpiryProductNext3MonthId")
	private WebElement next3MonthExpiryProductTab;

	@WindowsFindBy(accessibility = "tiExpiryProductNext6MonthId")
	private WebElement next6MonthExpiryProductTab;

	@WindowsFindBy(accessibility = "btnExpiryProductRefreshButtonId")
	private WebElement expiryProductRefreshButton;

	@WindowsFindBy(accessibility = "btnExpiryPriductDownloadButtonId")
	private WebElement expiryProductDownloadButton;
	
	
	public StorePersionRegressionEPToPRPage(WindowsDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickExpiryProductsTab() {
	    expiryProductsTab.click();
	}

	public boolean isExpiredProductTabDisplayed() {
	    return expiredProductTab.isDisplayed();
	}

	public boolean isCurrentMonthExpiryProductTabDisplayed() {
	    return currentMonthExpiryProductTab.isDisplayed();
	}

	public boolean isNextMonthExpiryProductTabDisplayed() {
	    return nextMonthExpiryProductTab.isDisplayed();
	}

	public boolean isNext3MonthExpiryProductTabDisplayed() {
	    return next3MonthExpiryProductTab.isDisplayed();
	}

	public boolean isNext6MonthExpiryProductTabDisplayed() {
	    return next6MonthExpiryProductTab.isDisplayed();
	}

	public boolean isExpiryProductRefreshButtonDisplayed() {
	    return expiryProductRefreshButton.isDisplayed();
	}

	public boolean isExpiryProductDownloadButtonDisplayed() {
	    return expiryProductDownloadButton.isDisplayed();
	}


	
	
	@FindBy(name = "Indent")
	private WebElement indentTab;

	@WindowsFindBy(accessibility = "tiIndentPlanId")
	private WebElement indentPlanTab;

	@WindowsFindBy(accessibility = "tiIndentViewIndentId")
	private WebElement viewIndentTab;

	@WindowsFindBy(accessibility = "txtIndentPlanPONumberId")
	private WebElement indentPONumber;

	@WindowsFindBy(accessibility = "txtIndentPlanPODateId")
	private WebElement indentPlanDate;

	@WindowsFindBy(accessibility = "rbIndentPlanReatilOrderId")
	private WebElement indentPlanReatilOrderRadioButton;

	@WindowsFindBy(accessibility = "rbIndentPlanWholesaleOrderId")
	private WebElement indentPlanWholesaleOrderRadioButton;

	@WindowsFindBy(accessibility = "BtnIndentPlanCreateId")
	private WebElement indentPlanCreateButton;

	@WindowsFindBy(accessibility = "btnIndentPlanAddProductCardId")
	private WebElement indentPlanAddProductButton;

	@WindowsFindBy(accessibility = "btnIndentPlanInvAddProductId")
	private WebElement addNewProductButton;

	@WindowsFindBy(accessibility = "BtnIndentPlanRefreshId")
	private WebElement indentPlanRefreshButton;

	@WindowsFindBy(accessibility = "cmbIndentPlanProductSearchListId")
	private WebElement indentPlanProductSearchList;

	@WindowsFindBy(accessibility = "txtIndentPlanSearchBrandId")
	private WebElement indentPlanSearchBrand;

	@WindowsFindBy(accessibility = "txtIndentPlanSubCategoryId")
	private WebElement indentPlanSubCategory;

	@WindowsFindBy(accessibility = "txtIndentPlanSearchSubUnitId")
	private WebElement indentPlanSearchSubUnit;

	@WindowsFindBy(accessibility = "txtIndentPlanQuantitytId")
	private WebElement indentPlanQuantity;

	@WindowsFindBy(accessibility = "btnIndentPlanInvRemoveProductId")
	private WebElement indentPlanRemoveProduct;

	@WindowsFindBy(accessibility = "btnIndentViewIndentIndentSearchId")
	private WebElement viewIndentSearchButton;

	@WindowsFindBy(accessibility = "btnIndentViewIndentRefreshId")
	private WebElement viewIndentRefreshButton;

	@WindowsFindBy(accessibility = "cmbIndentStoreSelectStoreId")
	private WebElement indentStoreDropdown;

	@WindowsFindBy(accessibility = "cmbIndentStoreSelectStatusId")
	private WebElement indentSelectStatusDropdown;

	@WindowsFindBy(accessibility = "dpIndentStoreStartingDateId")
	private WebElement indentStartingDate;

	@WindowsFindBy(accessibility = "dpIndentStoreEndingDateId")
	private WebElement indentEndingDate;

	@FindBy(name = "IndentListFlyout")
	private WebElement indentSearchFlyout;

	@WindowsFindBy(accessibility = "Calendar")
	private WebElement calendarPopUp;

	@WindowsFindBy(accessibility = "cbIndentStoreFullId")
	private WebElement fullpaymentMode;

	@WindowsFindBy(accessibility = "cbIndentStorePartialId")
	private WebElement partialPaymentMode;

	@WindowsFindBy(accessibility = "PART_BackButton")
	private WebElement flyoutBackButton;

	@WindowsFindBy(accessibility = "btnIndentStoreRefreshId")
	private WebElement indentStoreRefreshButton;

	@WindowsFindBy(accessibility = "btnIndentStoreSearchId")
	private WebElement flyoutSearchButton;

	public void clickIndentTab() {
	    indentTab.click();
	}

	public boolean isIndentPlanTabDisplayed() {
	    return indentPlanTab.isDisplayed();
	}

	public boolean isViewIndentTabDisplayed() {
	    return viewIndentTab.isDisplayed();
	}

	public boolean isIndentPONumberDisplayed() {
	    return indentPONumber.isDisplayed();
	}

	public boolean isIndentPlanDateDisplayed() {
	    return indentPlanDate.isDisplayed();
	}

	public boolean isIndentPlanReatilOrderRadioButtonDisplayed() {
	    return indentPlanReatilOrderRadioButton.isDisplayed();
	}

	public boolean isIndentPlanWholesaleOrderRadioButtonDisplayed() {
	    return indentPlanWholesaleOrderRadioButton.isDisplayed();
	}

	public boolean isIndentPlanCreateButtonDisplayed() {
	    return indentPlanCreateButton.isDisplayed();
	}

	public boolean isIndentPlanAddProductButtonDisplayed() {
	    return indentPlanAddProductButton.isDisplayed();
	}

	public boolean isAddNewProductButtonDisplayed() {
	    return addNewProductButton.isDisplayed();
	}

	public boolean isIndentPlanRefreshButtonDisplayed() {
	    return indentPlanRefreshButton.isDisplayed();
	}

	public void clickAddProductButton() {
	    indentPlanAddProductButton.click();
	}

	public boolean isIndentPlanSearchProductFieldDisplayed() {
	    return indentPlanProductSearchList.isDisplayed();
	}

	public boolean isIndentPlanSearchBrandDisplayed() {
	    return indentPlanSearchBrand.isDisplayed();
	}

	public boolean isIndentPlanSubCategoryDisplayed() {
	    return indentPlanSubCategory.isDisplayed();
	}

	public boolean isIndentPlanSearchSubUnitDisplayed() {
	    return indentPlanSearchSubUnit.isDisplayed();
	}

	public boolean isIndentPlanQuantityDisplayed() {
	    return indentPlanQuantity.isDisplayed();
	}

	public boolean isIndentPlanRemoveProductButtonDisplayed() {
	    return indentPlanRemoveProduct.isDisplayed();
	}

	public void sendProduct(String name) {
	    indentPlanProductSearchList.sendKeys(name);
	}

	public void clickSendProductDropdown() {
	    indentPlanProductSearchList.click();
	}

	public void clickAddNewProductButton() {
	    addNewProductButton.click();
	}

	public void clickViewIndentTab() {
	    viewIndentTab.click();
	}

	public boolean isViewIndentSearchButtonDisplayed() {
	    return viewIndentSearchButton.isDisplayed();
	}

	public boolean isViewIndentRefreshButtonDisplayed() {
	    return viewIndentRefreshButton.isDisplayed();
	}

	public void clickViewIndentSearchButton() {
	    viewIndentSearchButton.click();
	}

	public boolean isIndentStoreDropdownDisplayed() {
	    return indentStoreDropdown.isDisplayed();
	}

	public boolean isIndentSelectStatusDropdownDisplayed() {
	    return indentSelectStatusDropdown.isDisplayed();
	}

	public boolean isIndentStartingDateDisplayed() {
	    return indentStartingDate.isDisplayed();
	}

	public boolean isIndentEndingDateDisplayed() {
	    return indentEndingDate.isDisplayed();
	}

	public boolean isCalendarPopUpDisplayed() {
	    return calendarPopUp.isDisplayed();
	}

	public void isIndentSearchFlyoutDisplayed() {
	    indentSearchFlyout.isDisplayed();
	}

	public boolean isFullPaymentModeDisplayed() {
	    return fullpaymentMode.isDisplayed();
	}

	public boolean isPartialPaymentModeDisplayed() {
	    return partialPaymentMode.isDisplayed();
	}

	public boolean isFlyoutBackButtonDisplayed() {
	    return flyoutBackButton.isDisplayed();
	}

	public boolean isIndentStoreRefreshButtonDisplayed() {
	    return indentStoreRefreshButton.isDisplayed();
	}

	public boolean isFlyoutSearchButtonDisplayed() {
	    return flyoutSearchButton.isDisplayed();
	}

	public void clickIndentStoreDropdown() {
	    indentStoreDropdown.click();
	}

	public void clickIndentSelectStatusDropdown() {
	    indentSelectStatusDropdown.click();
	}

	public void clickIndentStartingDate() {
	    indentStartingDate.click();
	}

	public void clickIndentEndingDate() {
	    indentEndingDate.click();
	}

	public  void clickFlyoutSearchButton() {
	     flyoutSearchButton.click();
	}
	
	@WindowsFindBy(accessibility = "cmbIndentStoreSelectStatusId")
	private WebElement indentStatusDropDown;

	
	public void sendIndentStatusDropDown(String name) {
		indentStatusDropDown.sendKeys(name);
	}
	public void sendIndentStoreDropDown(String name) {
		indentStoreDropdown.sendKeys(name);
	}

	
	


	
	

	    // SKU Tab
	    @FindBy(name = "SKU")
	    private WebElement skuTab;

	    @WindowsFindBy(accessibility = "tiSKUCertificateId")
	    private WebElement skuCertificateTab;

	    @WindowsFindBy(accessibility = "cmbSKUCertificateSearchCategoryId")
	    private WebElement skuCategoryDropDown;

	    @WindowsFindBy(accessibility = "cmbSKUCertificateSearchSubCategoryId")
	    private WebElement skuSubCategoryDropDown;

	    @WindowsFindBy(accessibility = "cmbSKUCertificateSearchBrandId")
	    private WebElement skuSearchBrandDropDown;

	    @WindowsFindBy(accessibility = "btnSKUCertificateSearchId")
	    private WebElement skuSearchButton;

	    @WindowsFindBy(accessibility = "btnSKUCertificateRefreshId")
	    private WebElement skuRefreshButton;

	    @WindowsFindBy(accessibility = "cbSKUCertificateExpiredId")
	    private WebElement expiredTab;

	    @WindowsFindBy(accessibility = "cbSKUCertificateNoCertificateId")
	    private WebElement noCertificateTab;

	    @WindowsFindBy(accessibility = "cbSKUCertificateValidCertificateId")
	    private WebElement validCertificateTab;

	    @FindBy(name = "Our Store")
	    private WebElement ourStore;

	    @WindowsFindBy(accessibility = "PageDown")
	    private WebElement pageDown;

	    @WindowsFindBy(accessibility = "PageUp")
	    private WebElement pageUp;

	    // Purchase Return Tab Elements
	    @FindBy(name = "Purchase Return")
	    private WebElement purchaseReturnTab;

	    @WindowsFindBy(accessibility = "cmbAddPurchaseReturnSupplierNameId")
	    private WebElement purchaseReturnSupplierNames;

	    @WindowsFindBy(accessibility = "txtPurchaseReturnProductSKUId")
	    private WebElement purchaseReturnProductSKU;

	    @WindowsFindBy(accessibility = "cmbPurchaseReturnLotNumberId")
	    private WebElement purchaseReturnLotNumber;

	    @WindowsFindBy(accessibility = "btnPurchaseReturnSearchId")
	    private WebElement purchaseReturnSearchButton;

	    @WindowsFindBy(accessibility = "tbPurchaseReturnAmountId")
	    private WebElement purchaseReturnAmountField;

	    @WindowsFindBy(accessibility = "btnPurchaseReturnCreateRequestId")
	    private WebElement purchaseReturnCreateRequestButton;

	    @WindowsFindBy(accessibility = "tbPurchaseReturnViewRequestId")
	    private WebElement purchaseReturnViewRequestButton;

	    // Methods for SKU Tab
	    public void clickSKUTab() {
	        skuTab.click();
	    }

	    public void clickSkuCertificateTab() {
	        skuCertificateTab.click();
	    }

	    public boolean isSkuCategoryDropDownDisplayed() {
	        return skuCategoryDropDown.isDisplayed();
	    }

	    public boolean isSkuSubCategoryDropDownDisplayed() {
	        return skuSubCategoryDropDown.isDisplayed();
	    }

	    public boolean isSkuSearchBrandDropDownDisplayed() {
	        return skuSearchBrandDropDown.isDisplayed();
	    }

	    public boolean isSkuSearchButtonDisplayed() {
	        return skuSearchButton.isDisplayed();
	    }

	    public boolean isSkuRefreshButtonDisplayed() {
	        return skuRefreshButton.isDisplayed();
	    }

	    public boolean isExpiredTabDisplayed() {
	        return expiredTab.isDisplayed();
	    }

	    public boolean isNoCertificateTabDisplayed() {
	        return noCertificateTab.isDisplayed();
	    }

	    public boolean isValidCertificateTabDisplayed() {
	        return validCertificateTab.isDisplayed();
	    }

	    public void clickSkuCategoryDropDown() {
	        skuCategoryDropDown.click();
	    }

	    public void clickSkuSubCategoryDropDown() {
	        skuSubCategoryDropDown.click();
	    }

	    public void clickSkuSearchBrandDropDown() {
	        skuSearchBrandDropDown.click();
	    }

	    public void clickExpiredTab() {
	        expiredTab.click();
	    }

	    public void clickNoCertificateTab() {
	        noCertificateTab.click();
	    }

	    public void clickValidCertificateTab() {
	        validCertificateTab.click();
	    }

	    public void clickOurStore() {
	        ourStore.click();
	    }

	    // Methods for Purchase Return Tab
	    public void clickPurchaseReturnTab() {
	        purchaseReturnTab.click();
	    }

	    public boolean isPurchaseReturnSupplierNamesDisplayed() {
	        return purchaseReturnSupplierNames.isDisplayed();
	    }

	    public boolean isPurchaseReturnProductSKUDisplayed() {
	        return purchaseReturnProductSKU.isDisplayed();
	    }

	    public boolean isPurchaseReturnLotNumberDisplayed() {
	        return purchaseReturnLotNumber.isDisplayed();
	    }

	    public boolean isPurchaseReturnSearchButtonDisplayed() {
	        return purchaseReturnSearchButton.isDisplayed();
	    }

	    public boolean isPurchaseReturnAmountFieldDisplayed() {
	        return purchaseReturnAmountField.isDisplayed();
	    }

	    public boolean isPurchaseReturnCreateRequestButtonDisplayed() {
	        return purchaseReturnCreateRequestButton.isDisplayed();
	    }

	    public boolean isPurchaseReturnViewRequestButtonDisplayed() {
	        return purchaseReturnViewRequestButton.isDisplayed();
	    }

	    public void clickPurchaseReturnSupplierNamesDropdown() {
	        purchaseReturnSupplierNames.click();
	    }

	    public void sendProductSKU(String name) {
	        purchaseReturnProductSKU.sendKeys(name);
	    }

	    public void clickPurchaseReturnSearchButton() {
	        purchaseReturnSearchButton.click();
	    }

	  
	    
	   
		@WindowsFindBy(accessibility = "cmbOurStoreSelectStateId")
		private WebElement ourStoreStateDropDown;

		@WindowsFindBy(accessibility = "cmbOurStoreSelectDistrictId")
		private WebElement ourStoreDistrictDropDown;

		@WindowsFindBy(accessibility = "btnOurStoreSearchId")
		private WebElement ourStoreSearchButton;
	    
		@WindowsFindBy(accessibility = "btnOurStoreRefreshId")
		private WebElement ourStoreRefreshButton;
		
	    public void sendOurStoreStateDropDown(String name) {
	    	ourStoreStateDropDown.sendKeys(name);
	    }
	    
	    public void clickOurStoreStateDropDown() {
	    	ourStoreStateDropDown.click();
	    }

	   
	    public void clickOurStoreDistrictDropDown() {
	    	ourStoreDistrictDropDown.click();
	    }

	    public void clickOurStoreSearchButton() {
	    	ourStoreSearchButton.click();
	    }
	    
	    
	    public boolean isOurStoreStateDropDownDisplayed() {
	        return ourStoreStateDropDown.isDisplayed();
	    }

	    public boolean isOurStoreDistrictDropDownDisplayed() {
	        return ourStoreDistrictDropDown.isDisplayed();
	    }

	    public boolean isOurStoreSearchButtonDisplayed() {
	        return ourStoreSearchButton.isDisplayed();
	    }

	    public boolean isOurStoreRefreshButtonDisplayed() {
	        return ourStoreRefreshButton.isDisplayed();
	    }
	   
	    public void clickViewRequestButton() {
	        purchaseReturnViewRequestButton.click();
	    } 
	    
	    

	        // Additional elements for "View Request" section
	        @WindowsFindBy(accessibility = "cmbPurchaseReturnViewRequestSupplierNameId")
	        private WebElement viewRequestSupplierName;

	        @WindowsFindBy(accessibility = "cmbPurchaseReturnViewRequestReturnStatusId")
	        private WebElement viewReturnStatus;

	        @WindowsFindBy(accessibility = "btnPurchaseReturnViewRequestRefreshId")
	        private WebElement viewRequestRefreshButton;

	        @WindowsFindBy(accessibility = "tbPurchaseReturnViewRequestBackId")
	        private WebElement viewRequestBackButton;

	        @WindowsFindBy(accessibility = "btnPurchaseReturnViewRequestSerachId")
	        private WebElement viewRequestSearchButton;

	        // Additional methods for "View Request" section
	        public void clickViewRequestBackButton() {
	            viewRequestBackButton.click();
	        }

	        public boolean isViewRequestSupplierNameDisplayed() {
	            return viewRequestSupplierName.isDisplayed();
	        }

	        public boolean isViewReturnStatusDisplayed() {
	            return viewReturnStatus.isDisplayed();
	        }

	        public boolean isViewRequestRefreshButtonDisplayed() {
	            return viewRequestRefreshButton.isDisplayed();
	        }

	        public boolean isViewRequestBackButtonDisplayed() {
	            return viewRequestBackButton.isDisplayed();
	        }

	        public boolean isViewRequestSearchButtonDisplayed() {
	            return viewRequestSearchButton.isDisplayed();
	        }

	        public void clickViewRequestSupplierName() {
	            viewRequestSupplierName.click();
	        }

	        public void clickViewReturnStatus() {
	            viewReturnStatus.click();
	        }
	        
	        
	        public WebElement ViewRequestSupplierName() {
	           return viewRequestSupplierName;
	        }
	        
	        
	        
	        
	        
	 

	            // Additional elements and methods for "EOD (Cash Declaration)" section
	            @FindBy(name = "EOD (Cash Declaration)")
	            private WebElement eodCashDeclarationTab;

	            @WindowsFindBy(accessibility = "btnEODRefresh1Id")
	            private WebElement eodRefreshButton;

	            @WindowsFindBy(accessibility = "lblEODOpeningCashBalanceId")
	            private WebElement eodOpeningCashBalanceField;

	            @WindowsFindBy(accessibility = "lblEODTotalSalesForTheDayId")
	            private WebElement eodTotalSalesForTheDayField;

	            @WindowsFindBy(accessibility = "lblEODCashSalesId")
	            private WebElement eodCashSalesField;

	            @WindowsFindBy(accessibility = "lblEODUPISalesId")
	            private WebElement eodUpiSalesField;

	            @WindowsFindBy(accessibility = "lblEODCreditSalesId")
	            private WebElement eodCreditSalesField;

	            @WindowsFindBy(accessibility = "lblEODAvailableCashBalanceId")
	            private WebElement eodAvailableCashBalanceField;

	            @WindowsFindBy(accessibility = "lblEODBandDepositId")
	            private WebElement eodBankDepositField;

	            @WindowsFindBy(accessibility = "lblEODClosingCashBalanceId")
	            private WebElement eodClosingCashBalanceField; 

	            @WindowsFindBy(accessibility = "btnEODAddDepositId")
	            private WebElement eodAddDepositButton;

	            @WindowsFindBy(accessibility = "dpEODAddDepositDepositDateId")
	            private WebElement addDepositDateField;

	            @WindowsFindBy(accessibility = "txtEODAddDepositDepositAmountId")
	            private WebElement addDepositAmountField;

	            @WindowsFindBy(accessibility = "cmbEODAddDepositSelectBankId")
	            private WebElement addDepositSelectBankDropdown;

	            @WindowsFindBy(accessibility = "txtEODAddDepositAccountNoId")
	            private WebElement addDepositAccountNoField;

	            @WindowsFindBy(accessibility = "txtEODAddDepositIFSCCodeId")
	            private WebElement addDepositIFSCCodeField;

	            @WindowsFindBy(accessibility = "txtEODAddDepositBranchId")
	            private WebElement addDepositBranchField;

	            @WindowsFindBy(accessibility = "btnEODAddDepositAddAttachmentId")
	            private WebElement addDepositAddAttachmentField;

	            @WindowsFindBy(accessibility = "btnEODAddDepositAddDepositId")
	            private WebElement addDepositButton;

	            @WindowsFindBy(accessibility = "btnEODAddDepositRefreshId")
	            private WebElement addDepositRefreshRefreshButon;

	            @WindowsFindBy(accessibility = "btnEODAddDepositExitId")
	            private WebElement closeAddDepositButton;

	            @WindowsFindBy(accessibility = "btnEODAddDenominationId")
	            private WebElement EODAddDenominationButton;

	            @WindowsFindBy(accessibility = "btnEODFlyoutViewId")
	            private WebElement EODViewButton;

	            @WindowsFindBy(accessibility = "dpEODViewDenominationStartingDateId")
	            private WebElement viewDenominationStartingDate;

	            @WindowsFindBy(accessibility = "dpEODViewDenominationEndingDateId")
	            private WebElement viewDenominationEndingDate;

	            @WindowsFindBy(accessibility = "btnEODViewDenominationSearchId")
	            private WebElement viewDenominationSearchButton;

	            @WindowsFindBy(accessibility = "btnEODViewDenominationRefreshId")
	            private WebElement viewDenominationRefreshId;

	            @WindowsFindBy(accessibility = "btnEODViewDenominationDownloadId")
	            private WebElement viewDenominationDownload;

	            @WindowsFindBy(accessibility = "btnEODFlyoutBackId")
	            private WebElement viewDenominationBackButton;

	            @WindowsFindBy(accessibility = "rbEODDenominationId")
	            private WebElement denominationRedioButton;

	            @WindowsFindBy(accessibility = "rbEODDepositId")
	            private WebElement depositRedioButton;

	            // Additional methods for "EOD (Cash Declaration)" section
	            public void clickEODCashDeclarationTab() {
	                eodCashDeclarationTab.click();
	            }

	            public boolean isEODRefreshButtonDisplayed() {
	                return eodRefreshButton.isDisplayed();
	            }

	            public boolean isEODOpeningCashBalanceFieldDisplayed() {
	                return eodOpeningCashBalanceField.isDisplayed();
	            }

	            public boolean isEODTotalSalesForTheDayFieldDisplayed() {
	                return eodTotalSalesForTheDayField.isDisplayed();
	            }

	            public boolean isEODCashSalesFieldDisplayed() {
	                return eodCashSalesField.isDisplayed();
	            }

	            public boolean isEODUpiSalesFieldDisplayed() {
	                return eodUpiSalesField.isDisplayed();
	            }

	            public boolean isEODCreditSalesFieldDisplayed() {
	                return eodCreditSalesField.isDisplayed();
	            }

	            public boolean isEODAvailableCashBalanceFieldDisplayed() {
	                return eodAvailableCashBalanceField.isDisplayed();
	            }

	            public boolean isEODBankDepositFieldDisplayed() {
	                return eodBankDepositField.isDisplayed();
	            }

	            public boolean isEODClosingCashBalanceFieldDisplayed() {
	                return eodClosingCashBalanceField.isDisplayed();
	            }

	            public boolean isEODAddDepositButtonDisplayed() {
	                return eodAddDepositButton.isDisplayed();
	            }

	            public void clickEODAddDepositButton() {
	                eodAddDepositButton.click();
	            }

	            public boolean isAddDepositDateFieldDisplayed() {
	                return addDepositDateField.isDisplayed();
	            }

	            public boolean isAddDepositAmountFieldDisplayed() {
	                return addDepositAmountField.isDisplayed();
	            }

	            public boolean isAddDepositSelectBankDropdownDisplayed() {
	                return addDepositSelectBankDropdown.isDisplayed();
	            }

	            public boolean isAddDepositAccountNoFieldDisplayed() {
	                return addDepositAccountNoField.isDisplayed();
	            }
	            
	            
	            public String getDepositAccountNo() {
	                return addDepositAccountNoField.getAttribute(value);
	            }

	            public boolean isAddDepositIFSCCodeFieldDisplayed() {
	                return addDepositIFSCCodeField.isDisplayed();
	            }

	            public String getDepositIFSCCode() {
	                return addDepositIFSCCodeField.getAttribute(value);
	            }

	            public String getDepositBranchName() {
	                return addDepositBranchField.getAttribute(value);
	            }

	            public boolean isAddDepositBranchFieldDisplayed() {
	                return addDepositBranchField.isDisplayed();
	            }

	            public boolean isAddDepositAddAttachmentFieldDisplayed() {
	                return addDepositAddAttachmentField.isDisplayed();
	            }

	            public boolean isAddDepositButtonDisplayed() {
	                return addDepositButton.isDisplayed();
	            }

	            public boolean isAddDepositRefreshRefreshButonDisplayed() {
	                return addDepositRefreshRefreshButon.isDisplayed();
	            }

	            public boolean isCloseAddDepositButtonDisplayed() {
	                return closeAddDepositButton.isDisplayed();
	            }

	            public void clickAddDepositSelectBankDropdown() {
	                addDepositSelectBankDropdown.click();
	            }

	            public void sendBankName(String name) {
	                addDepositSelectBankDropdown.sendKeys(name);
	            }

	            public boolean isEODAddDenominationButtonDisplayed() {
	                return EODAddDenominationButton.isDisplayed();
	            }

	            public boolean isEODViewButtonDisplayed() {
	                return EODViewButton.isDisplayed();
	            }

	            public void clickEODViewButton() {
	                EODViewButton.click();
	            }

	            public boolean isViewDenominationStartingDateDisplayed() {
	                return viewDenominationStartingDate.isDisplayed();
	            }

	            public void sendViewDenominationStartingDate(String name) {
	                viewDenominationStartingDate.sendKeys(name);
	            }

	            public boolean isViewDenominationEndingDateDisplayed() {
	                return viewDenominationEndingDate.isDisplayed();
	            }

	            public void sendViewDenominationEndingDate(String name) {
	                viewDenominationEndingDate.sendKeys(name);
	            }

	            public boolean isViewDenominationSearchButtonDisplayed() {
	                return viewDenominationSearchButton.isDisplayed();
	            }

	            public void clickViewDenominationSearchButton() {
	                viewDenominationSearchButton.click();
	            }

	            public boolean isViewDenominationRefreshIdDisplayed() {
	                return viewDenominationRefreshId.isDisplayed();
	            }

	            public boolean isViewDenominationDownloadDisplayed() {
	                return viewDenominationDownload.isDisplayed();
	            }

	            public boolean isViewDenominationBackButtonDisplayed() {
	                return viewDenominationBackButton.isDisplayed();
	            }

	            public boolean isDenominationRedioButtonDisplayed() {
	                return denominationRedioButton.isDisplayed();
	            }

	            public boolean isDepositRedioButtonDisplayed() {
	                return depositRedioButton.isDisplayed();
	            }

	            public void clickCloseAddDepositButton() {
	                closeAddDepositButton.click();
	            }
	        }

	    

	    
	


