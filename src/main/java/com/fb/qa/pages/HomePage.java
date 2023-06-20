package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class HomePage extends TestBase {

	private WebDriver driver;

	// Page Factory
	@FindBy(xpath = "//a[contains(@href, \"material-requisition\")]")
	private WebElement materialReq;

	@FindBy(xpath = "//a[@href='/outward']//div[@class='icon']//img[@alt='icon']")
	private WebElement outward;

	@FindBy(xpath = "//a[@href='/inward']//div[@class='icon']//img[@alt='icon']")
	private WebElement inward;

	@FindBy(xpath = "//a[@href='/material-issuance']//div[@class='icon']//img[@alt='icon']")
	private WebElement materialIssuance;

	@FindBy(xpath = "//a[@href='/purchase-orders']")
	private WebElement purchaseOrders;

	@FindBy(xpath = "//a[@href='/material-inspection']")
	private WebElement materialInspection;

	@FindBy(xpath = "//a[@href='/goods-received-note']")
	private WebElement goodsReceiveNote;

	@FindBy(xpath = "//a[@href=\"/product-categories\"]")
	private WebElement productCategory;

	@FindBy(xpath = "//a[@href='/products']")
	private WebElement products;

	@FindBy(xpath = "//a[@href='/locations']")
	private WebElement locations;

	@FindBy(xpath = "//a[@href='/departments']")
	private WebElement departments;

	@FindBy(xpath = "//a[@href='/budgets']")
	private WebElement budgets;

	@FindBy(xpath = "//a[@href='/budgets/report']")
	private WebElement budgetsReport;

	@FindBy(xpath = "//a[@href='/assets']")
	private WebElement assets;

	@FindBy(xpath = "//a[@href='/inventory']")
	private WebElement inventory;

	@FindBy(xpath = "//a[@href='/suppliers']")
	private WebElement suppliers;

	@FindBy(xpath = "//a[@href='/supplier-bills']")
	private WebElement suppliersBills;

	@FindBy(xpath = "//a[@href='/material-return']")
	private WebElement materialReturn;

	@FindBy(xpath = "//a[@href='/purchase-order-returns']")
	private WebElement purchaseOrderReturn;

	@FindBy(xpath = "//a[@href='/inventory/report']")
	private WebElement inventoryReports;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public MaterialRequisitionPage clickOnMaterialRequisition() {
		materialReq.click();
		return new MaterialRequisitionPage(driver);
	}

	public MaterialIssuancePage clickOnMaterialIssuance() {
		materialIssuance.click();
		return new MaterialIssuancePage(driver);
	}

	public OutwardPage clickOnOutward() {
		outward.click();
		return new OutwardPage(driver);
	}

	public InwardPage clickOnInward() {
		inward.click();
		return new InwardPage(driver);
	}

	public MaterialReturn clickOnMaterialReturn() {
		materialReturn.click();
		return new MaterialReturn(driver);
	}

	public PurchaseOrders clickOnPurchaseOrders() {
		purchaseOrders.click();
		return new PurchaseOrders(driver);
	}

	public PurchaseOrderReturn clickOnPurchaseOrderReturn() {
		purchaseOrderReturn.click();
		return new PurchaseOrderReturn(driver);
	}

	public MaterialInspection clickOnMaterialInspection() {
		materialInspection.click();
		return new MaterialInspection(driver);
	}

	public GoodsReceiveNotes clickOnGoodsReceiveNotes() {
		goodsReceiveNote.click();
		return new GoodsReceiveNotes(driver);
	}

	public Assets clickOnAssets() {
		assets.click();
		return new Assets(driver);
	}

	public Suppliers clickOnSuppliers() {
		suppliers.click();
		return new Suppliers(driver);
	}

	public SuppliersBills clickOnSuppliersBills() {
		suppliersBills.click();
		return new SuppliersBills(driver);
	}

	public Budgets clickOnBudgets() {
		budgets.click();
		return new Budgets(driver);
	}

	public BudgetsReports clickOnBudgetsReports() {
		budgetsReport.click();
		return new BudgetsReports(driver);
	}

	public Inventory clickOnInventory() {
		inventory.click();
		return new Inventory(driver);
	}

	public InventoryReports clickOnInventoryReports() {
		inventoryReports.click();
		return new InventoryReports(driver);
	}

	public Products clickOnProducts() {
		products.click();
		return new Products(driver);
	}

	public ProductCategory clickOnProductCategory() {
		productCategory.click();
		return new ProductCategory(driver);
	}

	public Locations clickOnLocations() {
		locations.click();
		return new Locations(driver);
	}

	public Departments clickOnDepartments() {
		departments.click();
		return new Departments(driver);
	}

}
