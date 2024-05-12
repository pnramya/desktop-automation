package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class FinanceRegressionPage extends WebBase{
	
	    // Additional elements and methods for "Sales" section
	    @FindBy(name = "Sales")
	    private WebElement salesTab;

	    @WindowsFindBy(accessibility = "tiSalesMisId")
	    private WebElement misTab;

	    @WindowsFindBy(accessibility = "tiSalesCreditSalesId")
	    private WebElement creditSalesTab;

	    @WindowsFindBy(accessibility = "dpSalesMISStartDateId")
	    private WebElement fromDate;

	    @WindowsFindBy(accessibility = "dpSalesMISEndDateId")
	    private WebElement toDate;

	    @WindowsFindBy(accessibility = "cmbSalesMISSelectStoreId")
	    private WebElement storeNameDropDown;

	    @WindowsFindBy(accessibility = "btnSalesMISRefreshId")
	    private WebElement refreshBtn;

	    @WindowsFindBy(className = "Popup")
	    private WebElement popUp;

	    @WindowsFindBy(accessibility = "btnSalesMISSearchId")
	    private WebElement searchBtn;

	    public FinanceRegressionPage(WindowsDriver<WebElement> driver) {
			this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	  
		// Additional methods for "Sales" section
	    public void salesTabClick() {
	        salesTab.click();
	    }

	    public boolean isMisTabDisplayed() {
	        return misTab.isDisplayed();
	    }

	    public void misTabClick() {
	        misTab.click();
	    }

	    public boolean isCreditSalesTabDisplayed() {
	        return creditSalesTab.isDisplayed();
	    }

	    public boolean isFromDateDisplayed() {
	        return fromDate.isDisplayed();
	    }

	    public boolean isToDateDisplayed() {
	        return toDate.isDisplayed();
	    }

	    public boolean isStoreNameDropDownDisplayed() {
	        return storeNameDropDown.isDisplayed();
	    }

	    public boolean isRefreshBtnDisplayed() {
	        return refreshBtn.isDisplayed();
	    }

	    public boolean isDropDownPopupElementsDisplayed() {
	        return popUp.isDisplayed();
	    }

	    public boolean isSearchBtnDisplayed() {
	        return searchBtn.isDisplayed();
	    }

	    public void clickSearchBtn() {
	        searchBtn.click();
	    }

	    public void clickStoreDropDown() {
	        storeNameDropDown.click();
	    }

	    public void sendStoreDropDown(String name) {
	        storeNameDropDown.sendKeys(name);
	    }

	    public void sendMisFromDate(String name) {
	        fromDate.sendKeys(name);
	    }

	    public void sendMisToDate(String name) {
	        toDate.sendKeys(name);
	    }

	    public void clickCreditSalesTab() {
	        creditSalesTab.click();
	    }
	    
	    
	    
	    
	    
	     
	        @WindowsFindBy(xpath = "//Custom[2]/Custom/Tab/TabItem[2]/Custom/Text/Text")
	        private WebElement creditSalestotalCount;

	        @WindowsFindBy(accessibility = "dpSalesCreditSalesStartDateId")
	        private WebElement creditSalesrealizeFromDate;

	        @WindowsFindBy(accessibility = "dpSalesCreditSalesEndDateId")
	        private WebElement creditSalesrealizeToDate;

	        @WindowsFindBy(accessibility = "btnSalesCreditSalesRefreshId")
	        private WebElement creditSalesRefreshButton;

	        @WindowsFindBy(accessibility = "btnSalesCreditSalesDownloadId")
	        private WebElement creditSalesDownloadButton;

	        @WindowsFindBy(accessibility = "btnSalesCreditSalesSearchId")
	        private WebElement creditSalesSearchButton;

	        // Additional methods for "Credit Sales" section
	        public boolean isCreditSalesTotalCountsFieldDisplayed() {
	            return creditSalestotalCount.isDisplayed();
	        }

	        public boolean isCreditSalesFromDateFieldDisplayed() {
	            return creditSalesrealizeFromDate.isDisplayed();
	        }

	        public boolean isCreditSalesToDateFieldDisplayed() {
	            return creditSalesrealizeToDate.isDisplayed();
	        }

	        public boolean isCreditSalesRefreshButtonDisplayed() {
	            return creditSalesRefreshButton.isDisplayed();
	        }

	        public boolean isCreditSalesDownloadButtonDisplayed() {
	            return creditSalesDownloadButton.isDisplayed();
	        }

	        public boolean isCreditSalesSearchButtonDisplayed() {
	            return creditSalesSearchButton.isDisplayed();
	        }

	        // Additional elements and methods for "Purchase and Returns" section
	        @FindBy(name = "Purchase and Returns")
	        private WebElement purchaseReturnsTab;

	        @WindowsFindBy(accessibility = "tiPurchaseAndReturnPurchaseInvoiceId")
	        private WebElement purchaseInvoiceTab;

	        @WindowsFindBy(accessibility = "cbPurchaseAndReturnPurchaseInvoiceShowOnId")
	        private WebElement showOnCheckBox;

	        @WindowsFindBy(accessibility = "dpPurchaseAndReturnPurchaseInvoiceStartDateId")
	        private WebElement purchaseInvoiceFromDate;

	        @WindowsFindBy(accessibility = "dpPurchaseAndReturnPurchaseInvoiceEndDateId")
	        private WebElement purchaseInvoiceToDate;

	        @WindowsFindBy(accessibility = "cmbPurchaseAndReturnPurchaseInvoiceSelectStoreNameId")
	        private WebElement purchaseInvoiceStoreDropdown;

	        @WindowsFindBy(accessibility = "btnPurchaseAndReturnPurchaseInvoiceSearchId")
	        private WebElement purchaseInvoiceRefreshButton;

	        @WindowsFindBy(accessibility = "btnPurchaseAndReturnPurchaseInvoiceRefreshId")
	        private WebElement purchaseInvoiceSearchButton;

	        // Additional methods for "Purchase and Returns" section
	        public void clickPurchaseReturnsTab() {
	            purchaseReturnsTab.click();
	        }

	        public void clickPurchaseInvoiceTab() {
	            purchaseInvoiceTab.click();
	        }

	        public boolean isPurchaseInvoiceTabDisplayed() {
	            return purchaseInvoiceTab.isDisplayed();
	        }

	        public boolean isShowOnCheckBoxDisplayed() {
	            return showOnCheckBox.isDisplayed();
	        }

	        public boolean isPurchaseInvoiceFromDateDisplayed() {
	            return purchaseInvoiceFromDate.isDisplayed();
	        }

	        public boolean isPurchaseInvoiceToDateDisplayed() {
	            return purchaseInvoiceToDate.isDisplayed();
	        }

	        public boolean isPurchaseInvoiceStoreDropdownDisplayed() {
	            return purchaseInvoiceStoreDropdown.isDisplayed();
	        }

	        public boolean isPurchaseInvoiceRefreshButtonDisplayed() {
	            return purchaseInvoiceRefreshButton.isDisplayed();
	        }

	        public boolean isPurchaseInvoiceSearchButtonDisplayed() {
	            return purchaseInvoiceSearchButton.isDisplayed();
	        }
	        
	        
	        
	        
	     

	            // Additional elements and methods for "Credit Note View" section
	            @WindowsFindBy(accessibility = "tiPurchaseAndReturnCreditNoteViewId")
	            private WebElement creditNoteViewTab;

	            @WindowsFindBy(accessibility = "tiPurchaseAndReturnCreditNoteSummaryId")
	            private WebElement creditNoteSummary;

	            @WindowsFindBy(accessibility = "cmbPurchaseAndReturnCreditNoteViewSupplierNameId")
	            private WebElement creditNoteSupplierNameDropdown;

	            @WindowsFindBy(accessibility = "cmbPurchaseAndReturnCreditNoteViewStoreNameId")
	            private WebElement creditNoteStoreNameDropdown;

	            @WindowsFindBy(accessibility = "cmbPurchaseAndReturnCreditNoteViewSalesReturnStatusId")
	            private WebElement creditNoteReturnStutusDropdown;

	            @WindowsFindBy(accessibility = "btnPurchaseAndReturnCreditNoteViewRefreshId")
	            private WebElement creditNoteRefreshButton;

	            @WindowsFindBy(accessibility = "btnPurchaseAndReturnCreditNoteViewSearchId")
	            private WebElement creditNoteSearchButton;

	            // Additional methods for "Credit Note View" section
	            public void clickCreditNoteViewTab() {
	                creditNoteViewTab.click();
	            }

	            public void clickCreditNoteSummaryTab() {
	                creditNoteSummary.click();
	            }

	            public boolean isCreditNoteViewTabDisplayed() {
	                return creditNoteViewTab.isDisplayed();
	            }

	            public boolean isCreditNoteSummaryTabDisplayed() {
	                return creditNoteSummary.isDisplayed();
	            }

	            public boolean isCreditNoteSupplierNameDropdownDisplayed() {
	                return creditNoteSupplierNameDropdown.isDisplayed();
	            }

	            public boolean isCreditNoteStoreNameDropdownDisplayed() {
	                return creditNoteStoreNameDropdown.isDisplayed();
	            }

	            public boolean isCreditNoteReturnStatusDropdownDisplayed() {
	                return creditNoteReturnStutusDropdown.isDisplayed();
	            }

	            public boolean isCreditNoteRefreshButtonDisplayed() {
	                return creditNoteRefreshButton.isDisplayed();
	            }

	            public boolean isCreditNoteSearchButtonDisplayed() {
	                return creditNoteSearchButton.isDisplayed();
	            }

	            public void clickCreditNoteSupplierNameDropdown() {
	                creditNoteSupplierNameDropdown.click();
	            }

	            public void clickCreditNoteStoreNameDropdown() {
	                creditNoteStoreNameDropdown.click();
	            }

	            public void clickCreditNoteReturnStatusDropdown() {
	                creditNoteReturnStutusDropdown.click();
	            }

	            // Additional elements and methods for "Credit Note Summary" section
	            @WindowsFindBy(accessibility = "cmbPurchaseAndReturnCreditNoteSummaryStoreId")
	            private WebElement cnSummaryStoreNameDropdown;

	            @WindowsFindBy(accessibility = "cmbPurchaseAndReturnCreditNoteSummarySupplierId")
	            private WebElement cnSummarySuppliersDropdown;

	            @WindowsFindBy(accessibility = "dpPurchaseAndReturnCreditNoteSummaryStartDateId")
	            private WebElement cnSummaryFromDate;

	            @WindowsFindBy(accessibility = "dpPurchaseAndReturnCreditNoteSummaryEndDateId")
	            private WebElement cnSummaryToDate;

	            @WindowsFindBy(accessibility = "btnPurchaseAndReturnCreditNoteSummaryRefreshId")
	            private WebElement cnSummaryRefreshButton;

	            @WindowsFindBy(accessibility = "btnPurchaseAndReturnCreditNoteSummaryDownloadId")
	            private WebElement cnSummaryDownloadButton;

	            @WindowsFindBy(accessibility = "btnPurchaseAndReturnCreditNoteSummarySearchId")
	            private WebElement cnSummarySearchButton;

	            // Additional methods for "Credit Note Summary" section
	            public boolean isCnSummaryStoreNameDropdownDisplayed() {
	                return cnSummaryStoreNameDropdown.isDisplayed();
	            }

	            public boolean isCnSummarySuppliersDropdownDisplayed() {
	                return cnSummarySuppliersDropdown.isDisplayed();
	            }

	            public boolean isCnSummaryFromDateDisplayed() {
	                return cnSummaryFromDate.isDisplayed();
	            }

	            public boolean isCnSummaryToDateDisplayed() {
	                return cnSummaryToDate.isDisplayed();
	            }

	            public boolean isCnSummaryRefreshButtonDisplayed() {
	                return cnSummaryRefreshButton.isDisplayed();
	            }

	            public boolean isCnSummaryDownloadButtonDisplayed() {
	                return cnSummaryDownloadButton.isDisplayed();
	            }

	            public boolean isCnSummarySearchButtonDisplayed() {
	                return cnSummarySearchButton.isDisplayed();
	            }

	            public void clickCnSummaryStoreNameDropdown() {
	                cnSummaryStoreNameDropdown.click();
	            }

	            public void clickCnSummarySuppliersDropdown() {
	                cnSummarySuppliersDropdown.click();
	            }

	            public void sendCnSummarySuppliersDropdown(String name) {
	                cnSummarySuppliersDropdown.sendKeys(name);
	            }

	            public void sendCnSummaryStoreNameDropdown(String name) {
	                cnSummaryStoreNameDropdown.sendKeys(name);
	            }

	            public void sendCnSummaryFromDate(String name) {
	                cnSummaryFromDate.sendKeys(name);
	            }

	            public void sendCnSummaryToDate(String name) {
	                cnSummaryToDate.sendKeys(name);
	            }

	            public void clickCnSummarySearchButton() {
	                cnSummarySearchButton.click();
	            }
	        }

	    

	


