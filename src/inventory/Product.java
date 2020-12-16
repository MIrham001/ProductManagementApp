package inventory;

public class Product {
	//instance field declarations
	int itemNumber;
	String productName;
	int unitInStock;
	double productPrice;
	boolean productStatus;
	
	
	//default constructor to initialize the default value
	public Product() {
		itemNumber = 0;
		productName = "";
		unitInStock = 0;
		productPrice = 0.0;
		productStatus = true;
	}
	
	//constructor to handle input from driver class
	public Product(int number, String name,
			int qty, double price, boolean status) {
		this.itemNumber = number;
		this.productName = name;
		this.unitInStock = qty;
		this.productPrice = price;
		this.productStatus = status;
	}

	//Accessor	
	//itemNumber
	public int getItemNumber() {
		return this.itemNumber;
	}
	//productName
	public String getProductName() {
		return this.productName;
	}	
	//unitInStock
	public int getUnitInStock() {
		return this.unitInStock;
	}
	//productPrice
	public double getProductPrice() {
		return this.productPrice;
	}
	//productStatus
	public boolean getProductStatus() {
		return this.productStatus;
	}
	
	//Mutator
	//itemNumber
	public void setItemNumber(int newNumber) {
		this.itemNumber = newNumber;
	}
	//productName
	public void setProductName(String newName) {
		this.productName = newName;
	}
	//unitInStock
	public void setUnitInStock(int newQty) {
		this.unitInStock = newQty;
	}
	//productPrice
	public void setProductPrice(double newPrice) {
		this.productPrice = newPrice;
	}
	//productStatus
	public void setProductStatus(boolean newStatus) {
		this.productStatus = newStatus;
	}
	
	//stockValue 
	public double stockValue() {
		return this.productPrice*this.unitInStock;
	}
	
	//for printing purpose
	public String toString() {
		String newString = "";
		String status = this.productStatus==true ? "Active" : "Discontinued";
		newString = "-----------------------------\n"
				+ "Item Number\t\t: "+this.itemNumber+
				"\nName\t\t\t: "+this.productName+
				"\nQuantity in stock\t: "+this.unitInStock+
				"\nPrice\t\t\t: "+this.productPrice+
				"\nStock Value\t\t: "+stockValue()+
				"\nProduct Status\t\t: "+status;
		return newString;
	}
	
	//add the number of units in stock
	public void addToInventory(int quantity) {
		
	}
	
	//deduct from the number of units in stock
	public void deductFromInventory(int quantity) {
		
	}
}
