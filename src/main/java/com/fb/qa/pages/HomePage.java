package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class HomePage extends TestBase {

	public WebDriver driver;
	// page factory
	@FindBy(xpath = "//a[contains(@href, \"material-requisition\")]")
	WebElement materialReq;

	@FindBy(xpath = "//a[@href='/outward']//div[@class='icon']//img[@alt='icon']")
	WebElement outward;

	@FindBy(xpath = "//a[@href='/inward']//div[@class='icon']//img[@alt='icon']")
	WebElement inward;

	@FindBy(xpath = "//a[@href='/material-issuance']//div[@class='icon']//img[@alt='icon']")
	WebElement materialIssuance;

	@FindBy(xpath = "//*[@id=\"kt_content_container\"]/section/div/div/div/div/div/div/div[5]/a")
	WebElement purchaseOrders;

	@FindBy(xpath = "//*[@id=\"kt_content_container\"]/section/div/div/div/div/div/div/div[6]/a")
	WebElement materialInspection;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[7]/a[1]")
	WebElement goodsReceiveNote;

	@FindBy(xpath = "//a[@href=\"/product-categories\"]")
	WebElement productCategory;

	@FindBy(xpath = "//a[@href='/products']")
	WebElement products;

	@FindBy(xpath = "//a[@href='/locations']")
	WebElement locations;

	@FindBy(xpath = "//a[@href='/departments']")
	WebElement departments;

	@FindBy(xpath = "//a[@href='/budgets']")
	WebElement budgets;

	@FindBy(xpath = "//a[@href='/budgets/report']")
	WebElement budgetsReport;

	@FindBy(xpath = "//a[@href='/assets']")
	WebElement assets;

	@FindBy(xpath = "//a[@href='/inventory']")
	WebElement inventory;

	@FindBy(xpath = "//a[@href='/suppliers']")
	WebElement suppliers;

	@FindBy(xpath = "//a[@href='/supplier-bills']")
	WebElement suppliersBills;

	@FindBy(xpath = "//a[@href='/material-return']")
	WebElement materialReturn;

	@FindBy(xpath = "//a[@href='/purchase-order-returns']")
	WebElement purchaseOrderReturn;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	public MaterialRequisitionPage clickOnMaterialRequisition() {
		materialReq.click();
		return new MaterialRequisitionPage(driver);
	}
	public MaterialIssuancePage clickOnMaterialIssuance() {
		materialIssuance.click();
		// this.driver = driver;
		return new MaterialIssuancePage(driver);
	}
	
	public OutwardPage clickOnOutward() {
		return new OutwardPage(driver);
	}

	public InwardPage clickOnInward() {
		return new InwardPage(driver);
	}

	public PurchaseOrders clickOnPurchaseOrders() {
		return new PurchaseOrders(driver);
	}

	public MaterialInspection clickOnMaterialInspection() {
		return new MaterialInspection(driver);
	}

	public GoodsReceiveNotes clickOnGoodsRecieveNotes() {
		return new GoodsReceiveNotes(driver);
	}

	public ProductCategory clickOnProductCategory() {
		return new ProductCategory(driver);
	}

	public Products clickOnProducts() {
		return new Products(driver);
	}

	public Locations clickOnLocations() {
		return new Locations(driver);
	}

	public Departments clickOnDepartments() {
		return new Departments(driver);
	}

	public Budgets clickOnBudgets() {
		return new Budgets(driver);
	}

	public BudgetsReports clickOnBudgetsReports() {
		return new BudgetsReports(driver);
	}

	public Assets clickOnAssets() {
		return new Assets(driver);
	}

	public Inventory clickOnInventory() {
		return new Inventory(driver);
	}

	public Suppliers clickOnSuppliers() {
		return new Suppliers(driver);
	}

	public SuppliersBills clickOnSuppliersBills() {
		return new SuppliersBills(driver);
	}

	public MaterialReturn clickOnMaterialReturn() {
		return new MaterialReturn(driver);
	}

	public PurchaseOrderReturn clickOnPurchaseOrderReturn() {
		return new PurchaseOrderReturn(driver);
	}



}
