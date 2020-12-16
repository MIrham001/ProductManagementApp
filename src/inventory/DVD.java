package inventory;

public class DVD extends Product {
	int dvdLength;
	int ageRating;
	String filmStudio;
	
	//default constructor to initialize the default value
	public DVD() {
		super.itemNumber = 0;
		super.productName = "";
		super.unitInStock = 0;
		super.productPrice = 0.0;
		super.productStatus = true;
		this.dvdLength = 0;
		this.ageRating = 0;
		this.filmStudio ="";
	}
	
	//constructor to handle input from driver class
	public DVD(int number, String name,
			int qty, double price, boolean status, int dvdLength, int ageRating, String filmStudio) {
		super.itemNumber = number;
		super.productName = name;
		super.unitInStock = qty;
		super.productPrice = price;
		super.productStatus = status;
		this.dvdLength = dvdLength;
		this.ageRating = ageRating;
		this.filmStudio = filmStudio;
	}
	
	//Accessor	
	//DVD Length
	public int getDvdLength() {
		return this.dvdLength;
	}
	//Film Studio
	public String getFilmStudio() {
		return this.filmStudio;
	}
	//Age Rating
	public int getAgeRating() {
		return this.ageRating;
	}
	
	//Mutator
	//DVD Length
	public void setDvdLength(int dvd) {
		this.dvdLength = dvd;
	}
	
	//Film Studio
	public void setFilmStudio(String filmStudio) {
		this.filmStudio = filmStudio;
	}
	//Age Rating
	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}
	
	public double stockValue() {
		return (super.productPrice*super.unitInStock)*1.05; //extra 5% fee
	}
	
	//for printing purpose
		public String toString() {
			String newString = "";
			String status = super.productStatus==true ? "Active" : "Discontinued";
			newString = "-----------------------------\n"
					+ "Item Number\t\t: "+super.itemNumber+
					"\nName\t\t\t: "+super.productName+
					"\nMovie Length\t\t: "+this.dvdLength+
					"\nAge Rating\t\t: "+this.ageRating+
					"\nFilm Studio\t\t: "+this.filmStudio+
					"\nQuantity in stock\t: "+super.unitInStock+
					"\nPrice\t\t\t: "+super.productPrice+
					"\nStock Value\t\t: "+stockValue()+
					"\nProduct Status\t\t: "+status;
			return newString;
		}
}
