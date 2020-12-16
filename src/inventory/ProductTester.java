package inventory;

import java.util.Scanner;

public class ProductTester {

	public static void main(String[] args) {
		//Local variable
		int maxSize, menuChoice;
		Scanner in = new Scanner(System.in);
		
		maxSize = getNumProducts(in);
		if(maxSize==0) {
			//Displaying a message if zero is entered
			System.out.println("No products required!");
			
		}
		else {
			Product[] product = new Product[maxSize];
			menuChoice = getMenuCD_DVD(in);
			executeMenuCD_DVD(menuChoice, product, in);
			do {
				menuChoice = getMenuOption(in);
				executeMenuChoice(menuChoice, product, in);
			}while(menuChoice!=0);
		}
		in.close();
	}
	
	//displaying all inventory
	public static void displayInventory(Product[] product) {
		for (Product myProduct : product) {
			System.out.println(myProduct);
		}
	}
	
	//add to inventory (product)
	public static void addToInventory(Product[] product, Scanner in) {
		//local variable
		int tempNumber;
		String tempName;
		int tempQty;
		double tempPrice;
		boolean tempStatus;
		
		//make object array
		for(int i=0;i<=product.length-1;i++) {
			//removing the last input data from user
			in.nextLine();
			//Take input from user
			System.out.print("\nPlease insert item number : ");
			tempNumber = in.nextInt();
			System.out.print("Please insert item name : ");
			tempName = in.next();
			System.out.print("Please insert quantity of the item : ");
			tempQty = in.nextInt();
			System.out.print("Please insert item price : ");
			tempPrice = in.nextDouble();
			System.out.print("Please insert item status : (true/false)");
			tempStatus = in.nextBoolean();
			//create new object using 4 parameter constructor
			product[i]=new Product(tempNumber,tempName,tempQty,tempPrice,tempStatus);
		}
	}
	
	//add to inventory (CD)
	public static void addCDToInventory(Product[] product, Scanner in) {
		//local variable
		int tempNumber;
		String tempName;
		int tempQty;
		double tempPrice;
		boolean tempStatus=true;
		String tempArtist;
		int tempNumberOfSong;
		String tempLabel;
		
		//make object array
		for(int i=0;i<=product.length-1;i++) {
			//removing the last input data from user
			in.nextLine();
			//Take input from user
			System.out.print("\nPlease enter the CD name : ");
			tempName = in.next();
			System.out.print("Please enter the artist name : ");
			tempArtist = in.next();
			System.out.print("Please enter the record label name : ");
			tempLabel = in.next();
			System.out.print("Please enter the number of songs : ");
			tempNumberOfSong = in.nextInt();
			System.out.print("Please enter the quantity of stock for this product : ");
			tempQty = in.nextInt();
			System.out.print("Please enter the price for this product : ");
			tempPrice = in.nextDouble();
			System.out.print("Please enter the item number : ");
			tempNumber = in.nextInt();
			//create new object using 4 parameter constructor
			product[i]=new CD(tempNumber,tempName,tempQty,tempPrice,tempStatus, tempArtist, tempNumberOfSong, tempLabel);
		}
	}
	
	//add to inventory (DVD)
	public static void addDVDToInventory(Product[] product, Scanner in) {
		//local variable
		int tempNumber;
		String tempName;
		int tempQty;
		double tempPrice;
		boolean tempStatus=true;
		String tempStudioName;
		int tempAge;
		int tempLength;
		
		//make object array
		for(int i=0;i<=product.length-1;i++) {
			//removing the last input data from user
			in.nextLine();
			//Take input from user
			System.out.print("\nPlease enter the DVD name : ");
			tempName = in.next();
			System.out.print("Please enter the film studio name : ");
			tempStudioName = in.next();
			System.out.print("Please enter the age rating : ");
			tempAge = in.nextInt();
			System.out.print("Please enter the length in minute : ");
			tempLength = in.nextInt();
			System.out.print("Please enter the quantity of stock for this product : ");
			tempQty = in.nextInt();
			System.out.print("Please enter the price for this product : ");
			tempPrice = in.nextDouble();
			System.out.print("Please enter the item number : ");
			tempNumber = in.nextInt();
			//create new object using 4 parameter constructor
			product[i]=new DVD(tempNumber,tempName,tempQty,tempPrice,tempStatus, tempLength, tempAge, tempStudioName);
		}
	}
	
	//Input for how many product user want to add
	public static int getNumProducts(Scanner in) {
		//Local variable
		int maxSize=-1;
		//do while looping for incorrect input handling
		do
		{
			//handling run-time error
			try {
				//instruction for user
				System.out.print("Enter the number of products you would like to add\n"
						+ "Enter 0 (zero) if you do not wish to add products: ");
						
				//Take input from user for the number of products to add
				maxSize = in.nextInt();
				if(maxSize<0) {
					System.out.println("Incorrect Value entered");
				}
			}
			catch (Exception e) {
				System.out.println("Incorrect data type entered!");
				in.nextLine();
			}	
		}while (maxSize<0);
		return maxSize;
	}
	
	//display and choose menu option
	public static int getMenuOption(Scanner in) {
		int menu=-1;
		do {
			try {
				System.out.print("\n------------------\n"+
							    "1. View Inventory\n"+
								"2. Add Stock\n"+
								"3. Deduct Stock\n"+
								"4. Discontinue Product\n"+
								"0. Exit\n"+
								"Please enter a menu option : ");
				menu = in.nextInt();
				if(menu<0) {
					System.out.println("Incorrect input value!\n");
				}
			}
			catch (Exception e) {
				System.out.println("Incorrect data type!\n");
				in.nextLine();
			}
		}while(menu<0);
		return menu;
	}
	
	//displaying index value of the array
	public static int getProductNumber(Product[] product, Scanner in) {
		int productChoice=-1;
		for(int i=0;i<product.length;i++) {
			System.out.println("Product index ["+i+"] = "+product[i].getProductName());
		}
		do {
			try {
				System.out.print("Insert the index number of the product you want to update [0 ~ "+ (int)(product.length-1) +"] : ");
				productChoice = in.nextInt();
				if(productChoice<0) {
					System.out.println("Invalid input value!\n");
				}
				else if(productChoice>=product.length) {
					System.out.println("Invalid input value!\n");
					productChoice=-1;
				}
			}
			catch (Exception e) {
				System.out.println("Invalid data type!\n");
				in.nextLine();
			}
		}while(productChoice<0);
		return productChoice;
	}
	
	//add stock
	public static void addInventory(Product[] product, Scanner in) {
		//local variable
		int productChoice;
		int updateValue = -1;
		
		productChoice = getProductNumber(product,in);
		if (product[productChoice].getProductStatus()==true) {
			do {
				try {
					System.out.print("How many products do you want to add? ");
					updateValue = in.nextInt();
					if (updateValue<0) {
						System.out.println("Invalid input value!\n");
					}
				}
		
				catch (Exception e) {
					System.out.println("Invalid data type!\n");
					in.nextLine();
				}
			}while(updateValue<0);
			product[productChoice].setUnitInStock(product[productChoice].getUnitInStock()+updateValue);
		}
		else {
			System.out.println("You can't add stock of discontinued product");
		}
		
	}
	
	//deduct stock
	public static void deductInventory(Product[] product, Scanner in) {
		//local variable
		int productChoice;
		int updateValue = -1;
		
		productChoice = getProductNumber(product,in);
		do {
			try {
				System.out.print("How many products do you want to deduct?");
				updateValue = in.nextInt();
				if (updateValue<0) {
					System.out.println("Invalid input value!\n");
				}
			}

			catch (Exception e) {
				System.out.println("Invalid data type!\n");
				in.nextLine();
			}
		}while(updateValue<0);
		product[productChoice].setUnitInStock(product[productChoice].getUnitInStock()-updateValue);
	}
	
	//discontinuing product
	public static void discontinueInventory(Product[] product, Scanner in) {
		//local variable
		int  productChoice;
		
		productChoice = getProductNumber(product, in);
		product[productChoice].setProductStatus(false);
	}
	
	//Choosing method from user input (menu option)
	public static void executeMenuChoice(int menuOption, Product[] product, Scanner in) {
		switch(menuOption) {
		case 0:
			System.out.println("Thank You");
			break;
		case 1 :
			System.out.println("View Product List");
			displayInventory(product);
			break;
		case 2 :
			System.out.println("Add Stock");
			addInventory(product,in);
			break;
		case 3 :
			System.out.println("Deduct Stock");
			deductInventory(product,in);
			break;
		case 4 :
			System.out.println("Discontinue Product");
			discontinueInventory(product,in);
			break;
		default:
			System.out.println("Invalid Command");
		}
	}
	
	//menu for choosing CD or DVD to add
	public static int getMenuCD_DVD(Scanner in) {
		int menu=-1;
		do {
			try {
				System.out.print("\n------------------\n"+
							    "1. CD\n"+
								"2. DVD\n"+
								"Please enter the product type : ");
				menu = in.nextInt();
				if(menu<0) {
					System.out.println("Only numbers 1 or 2 allowed!\n");
				}
				if(menu>2) {
					System.out.println("Only numbers 1 or 2 allowed!\n");
				}
			}
			catch (Exception e) {
				System.out.println("Incorrect data type!\n");
				in.nextLine();
			}
		}while(menu<0||menu>2);
		return menu;
	}

	//Choosing method from user input (menu option) for CD&DVD
	public static void executeMenuCD_DVD(int menuOption, Product[] product, Scanner in) {
		switch(menuOption) {
		case 1 :
			addCDToInventory(product,in);
			break;
		case 2 :
			addDVDToInventory(product,in);
			break;
		default:
			System.out.println("Invalid Command");
		}
	}
}


/*
 * Excess from before //two product created with default constructor Product pen
 * = new Product(); Product pencil = new Product(); //the product created with
 * intended value to match the parameter Product eraser = new Product(3,
 * "Eraser", 25, 5000); Product scissor = new Product(4, "Scissor", 10, 15000);
 * Product paper = new Product(5, "Paper", 500, 500); Product marker = new
 * Product(6, "Marker", 15, 7000);
 * 
 * //displaying the details of each product System.out.println(pen);
 * System.out.println(pencil); System.out.println(eraser);
 * System.out.println(scissor); System.out.println(paper);
 * System.out.println(marker);
 */

/*
 * //Take input from user for p1 //Scanner in = new Scanner(System.in);
 * System.out.println("\nMasukkan nomor barang :"); tempNumber = in.nextInt();
 * System.out.println("Masukkan nama barang :"); tempName = in.next();
 * System.out.println("Masukkan jumlah barang :"); tempQty = in.nextInt();
 * System.out.println("Masukkan harga barang :"); tempPrice = in.nextDouble();
 * System.out.println("Masukkan status barang :"); tempStatus =
 * in.nextBoolean();
 * 
 * //create p1 object using 4 parameter constructor Product p1 = new
 * Product(tempNumber,tempName,tempQty,tempPrice,tempStatus);
 * 
 * //removing the last input data from user in.nextLine(); //Take input from
 * user for p2 System.out.println("Masukkan nomor barang :"); tempNumber =
 * in.nextInt(); System.out.println("Masukkan nama barang :"); tempName =
 * in.next(); System.out.println("Masukkan jumlah barang :"); tempQty =
 * in.nextInt(); System.out.println("Masukkan harga barang :"); tempPrice =
 * in.nextDouble(); System.out.println("Masukkan status barang :"); tempStatus =
 * in.nextBoolean();
 * 
 * //create p2 object using 4 parameter constructor Product p2 = new
 * Product(tempNumber,tempName,tempQty,tempPrice,tempStatus);
 * 
 * //closing scanner in.close();
 * 
 * //printing product data System.out.println(p1); System.out.println(p2);
 */
