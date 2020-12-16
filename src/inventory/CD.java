package inventory;

public class CD extends Product {
	String artist;
	int numberOfSong;
	String label;
	
	//default constructor to initialize the default value
	public CD() {
		super.itemNumber = 0;
		super.productName = "";
		super.unitInStock = 0;
		super.productPrice = 0.0;
		super.productStatus = true;
		this.artist = "";
		this.numberOfSong = 0;
		this.label ="";
	}
	
	//constructor to handle input from driver class
	public CD(int number, String name,
			int qty, double price, boolean status, String artist, int numberOfSong, String label) {
		super.itemNumber = number;
		super.productName = name;
		super.unitInStock = qty;
		super.productPrice = price;
		super.productStatus = status;
		this.artist = artist;
		this.numberOfSong = numberOfSong;
		this.label = label;
	}
	
	//Accessor	
	//Artist name
	public String getArtist() {
		return this.artist;
	}
	//Label
	public String getLabel() {
		return this.label;
	}
	//Number of Song
	public int getNumberOfSong() {
		return this.numberOfSong;
	}
	
	//Mutator
	//CD Length
	//Artist name
	public void setArtist(String artist) {
		this.artist = artist;
	}
	//Label
	public void setLabel(String label) {
		this.label = label;
	}
	//Number of Song
	public void setNumberOfSong(int numberOfSong) {
		this.numberOfSong = numberOfSong;
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
			"\nArtist\t\t\t: "+this.artist+
			"\nSongs on Album\t\t: "+this.numberOfSong+
			"\nRecord label\t\t: "+this.label+
			"\nQuantity in stock\t: "+super.unitInStock+
			"\nPrice\t\t\t: "+super.productPrice+
			"\nStock Value\t\t: "+stockValue()+
			"\nProduct Status\t\t: "+status;
	return newString;
	}
}
