import java.util.ArrayList;

public class C206_CaseStudy {
	public static void main(String[] args) {
		
		//Bid Array List//
		ArrayList<Bid> bidList = new ArrayList<Bid>();
		
		//Deal Array List//
		ArrayList<deal> dealList = new ArrayList<deal>();
		
		//Student Array List//
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		//Category Array List//
		ArrayList<Category> catList = new ArrayList<Category>();
		
		int mainOption = 0;
		int subOption = 0;
		
		while(mainOption != 9) {
			mainMenu();
			mainOption = Helper.readInt("Enter an option number: ");
			
			if(mainOption == 1) {
				studentMenu();
				subOption = Helper.readInt("Enter an option number: ");
				
				
				if (subOption == 1) {
					String allstudentList = studentListToString(studentList);
					System.out.println(allstudentList);
					System.out.println("Total number of students: " + getallstudentList(studentList));
				}
				
				else if (subOption == 2) {
					String Name = Helper.readString("Enter Name > ");
		            String Role = Helper.readString("Enter Role > ");
		            String Email = Helper.readString("Enter  Email > ");
		            String Password = Helper.readString("Enter Password > ");
		            Student newSchedule = new Student(Name, Role, Email, Password);
		            boolean result = addStudent(studentList, newSchedule);
				}
				
				else if (subOption == 3) {
					String allstudentList = studentListToString(studentList);
					System.out.println(allstudentList);
					
					String deleteStudentemail = Helper.readString("Enter Student Email > ");

					String Studentdetails = getStudentListByEmail(studentList, deleteStudentemail);

					if (!Studentdetails.isEmpty()) {
						System.out.println(Studentdetails);
						char toDelete = Helper.readChar("Do you wish to delete this student account?(y/n) > ");

						if (toDelete == 'y') {
							boolean deleted = removeStudent(studentList, deleteStudentemail);

							if (deleted == true) {
								System.out.println(String.format("Student id %d account was deleted successfully.", deleteStudentemail));
							} else {
								System.out.println("Something went wrong, account was not deleted.");
							}
						}
					} else {
						System.out.println("That Student ID does not exist!");
					}
				}
				
				else {
					System.out.println("Enter a Valid Option Menu !");
				}
			}
			
			else if (mainOption == 2) {
				CategoryMenu();
				subOption = Helper.readInt("Enter option > ");
				
				if (subOption == 1) {
					
					addCategory(catList);
				}
				
				else if (subOption == 2) {
					viewAllCategories(catList);
				}
				
				else if (subOption == 3) {
					
					deleteCategory(catList);
					}
				
			}
			
			else if (mainOption == 3) {
				bidMenu();
				subOption = Helper.readInt("Enter an option number: ");
				
				if (subOption == 1) {
					System.out.println(" ");
					int bidID = Helper.readInt("Enter the Bid ID of the product: ");
					String itemName = Helper.readString("Enter the name of the product: ");
					String SEmail = Helper.readString("Enter the seller's email: ");
					String BEmail = Helper.readString("Enter the Buyer's email: ");
					double price = Helper.readDouble("Enter the Bid Price: ");

					Bid newBid = new Bid(bidID, itemName, SEmail, BEmail, price);
					
					boolean result = addBid(bidList, newBid);
					
					if (result == true) {
						System.out.println("Bid has been successfully added");
					} else {
						System.out.println("Bid has NOT been added, please include all the details correctly");
					}
				}
				
				else if (subOption == 2) {
					System.out.println(" ");
					
					boolean result = showAllBids(bidList);
					
					if (result == false) {
						System.out.println("There is nothing in the list");
					}
				}
				
				else if (subOption == 3) {
					System.out.println(" ");
					int bidID = Helper.readInt("Enter the Bid ID of the product you want to delete: ");
					
					boolean result = deleteBid(bidList, bidID);
					System.out.println(" ");
					
					if (result == true) {
						System.out.println("The Bid with the Bid ID of, " + bidID + " has been successfully removed");			
					} else {
						System.out.println("The Bid has not been deleted \nPlease try again");
					}
				}
			}
			
			else if (subOption == 4) {
				dealMenu();
				subOption = Helper.readInt("Enter an option number: ");
				
				if (subOption == 1) {
					deal dl = inputDeal();
					addDeal(dealList, dl);
				}
				
				else if (subOption == 2) {
					viewAllDeal(dealList);
				}
				
				else if (subOption == 3) {
					int deleteInput = Helper.readInt("Enter ID to delete > ");
					deleteDeal(dealList, deleteInput);
				}
			}
		}
		
		
	}
	
	
	public static void mainMenu() {
		System.out.println(" ");
		System.out.println("1. User Account");
		System.out.println("2. Category");
		System.out.println("3. Bid Items");
		System.out.println("4. Deals");
		System.out.println("9. Quit");
		System.out.println(" ");
	}
	
	// ============================Bidding Section============================== //
	
	public static void bidMenu() {
		System.out.println(" ");
		System.out.println("1. Add Bid Item: ");
		System.out.println("2. Show All Bids");
		System.out.println("3. Delete Bid Based on ID");
		System.out.println("4. Quit");
		System.out.println(" ");
	}
	
	public static boolean addBid(ArrayList<Bid> bidList, Bid bid) {
		if(bid.getBidID() == 0 || bid.getItemName().isEmpty() || bid.getSellerEmail().isEmpty() || bid.getBuyerEmail().isEmpty() || bid.getBidPrice() == 0) {
			return false;
		} else {
			for (int i = 0 ; i < bidList.size() ; i++) {
				if(bidList.get(i).getBidID() == bid.getBidID()) {
					if(bidList.get(i).getBidPrice() >= bid.getBidPrice()) {
						return false;
					}
					else {
						Bid newBid = new Bid(bid.getBidID(),bid.getItemName(),bid.getSellerEmail(),bid.getSellerEmail(),bid.getBidPrice());
						bidList.set(i, newBid);
						return true;
					}
				}
			}			
			Bid newBid = new Bid(bid.getBidID(),bid.getItemName(),bid.getSellerEmail(),bid.getSellerEmail(),bid.getBidPrice());
			bidList.add(newBid);
			return true;
		}
		
	}
	
	public static boolean showAllBids(ArrayList<Bid> bidList) {
		String output = "";
		if (bidList.size() == 0) {
			return false;
		}
		else {
			
			output += String.format("%-10s %-25s %-25s %-20s %-15s \n", "Bid ID", "Item Name","Seller's Email", "Buyer's Emai", "Bid Price");
			for (int x = 0; x < bidList.size(); x++) {
				Bid b = bidList.get(x);				
				output += String.format("%-10d %-25s %-25s %-20s %-15.2f \n", b.getBidID(), b.getItemName(),
						b.getSellerEmail(), b.getBuyerEmail(), b.getBidPrice());

				}
			
			System.out.println(output);
			return true;
		}
	}
	
	public static boolean deleteBid(ArrayList<Bid> bidList , int bidId) {
		
		for (int i = 0 ; i < bidList.size() ; i++) {
			if(bidList.get(i).getBidID() == bidId) {
				bidList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	// ============================Deal Section============================== //
	
	public static void dealMenu() {
		String message = "-------------------";
		message += "\n1.Add deal";
		message += "\n2.View deal";
		message += "\n3.Delete deal";
		message += "\n4.Exit";
		message += "\n-------------------";
		System.out.println(message);
	}
	
	public static String retrieveAllDeal(ArrayList<deal> dealList) {
		String output = "";
		
		for(int i=0; i<dealList.size(); i++) {
			deal get = dealList.get(i);
			
			output += String.format("%-5d %-15s %-15s %-15s %-10.2f %-10s", get.getId(), get.getName(), get.getBuyerEmail(), get.getSellerEmail(), get.getPrice(), get.getClosedate());
			output += "\n";
		}
		
		return output;
	}
	
	public static void viewAllDeal(ArrayList<deal> dealList) {
		String output = "DEAL LIST\n";
		output += String.format("%-5s %-15s %-15s %-15s %-10s %-10s\n", "ID","ITEM NAME","SELLER","BUYER","PRICE","DUE DATE");
		output += retrieveAllDeal(dealList);
		System.out.println(output);
	}
	
	public static deal inputDeal() {
		int dealID = Helper.readInt("Enter deal ID > ");
		String itemName = Helper.readString("Enter item name > ");
		String sellerEmail = Helper.readString("Enter seller email > ");
		String buyerEmail = Helper.readString("Enter buyer email > ");
		double price = Helper.readDouble("Enter transcation price > ");
		String closeDate = Helper.readString("Enter close date > ");
		
		deal dl = new deal(dealID, itemName, buyerEmail, sellerEmail, price, closeDate);
		return dl;
	}
	
	public static Boolean addDeal(ArrayList<deal> dealList, deal dl) {
		
		dealList.add(dl);
		System.out.println("Deal added");
		return true;
	}
	
	
	
	public static int findDeal(ArrayList<deal> dealList, int deleteInput) {
		int deleteIndex = 0;
		for(int i=0; i<dealList.size(); i++) {
			if(dealList.get(i).getId() == deleteInput) {
				deleteIndex = i;
			}
		}
		
		return deleteIndex;
	}
	
	public static void deleteDeal(ArrayList<deal> dealList, int deleteInput) {

		dealList.remove(findDeal(dealList, deleteInput));
		System.out.println("Deal successfully deleted!");
	}
	
	// ============================Student Section============================== //
	
	public static void studentMenu() {
		Helper.line(42, "-");
		System.out.println("WELCOME TO AUCTION");
		Helper.line(42, "-");
		
		System.out.println("1. View Student");
		System.out.println("2. Add Student");
		System.out.println("3. Delete Student");
	}
	
	private static String getallstudentList(ArrayList<Student> studentList) {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean removeStudent(ArrayList<Student> studentList, String deleteStudentemail) {
		// TODO Auto-generated method stub
		return false;
	}

	private static String getStudentListByEmail(ArrayList<Student> studentList, String deleteStudentemail) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String studentListToString(ArrayList<Student> studentList) {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean addStudent(ArrayList<Student> studentList, Student newSchedule) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// ============================Category Section============================== //
	
	public static void CategoryMenu() {
		Helper.line(50, "-");
		System.out.println("1. Add Category");
		System.out.println("2. View All Categories");
		System.out.println("3. Delete Category");
		System.out.println("4. Exit");
		Helper.line(50, "-");
	}
	
	private static void addCategory(ArrayList<Category> catList) {
		String catName = Helper.readString("Enter category name > ");
		Category newCat = new Category(catName);
		catList.add(newCat);
		
	}
	
	private static void viewAllCategories(ArrayList<Category> catList) {
		String output = String.format("%s\n", "CATEGORY");
		
		for (Category cat : catList) {
			output += String.format("%s\n", cat.getCatName());
		}
		
		System.out.println(output);
	}
	
	private static void deleteCategory(ArrayList<Category> catList) {
		String search = Helper.readString("Enter category name to delete > ");
		
		for (int i = 0; i < catList.size(); i++) {
			String splitStr[] = catList.get(i).getCatName().split(",");
			
			for (int j = 0; j < splitStr.length; j++) {
				if (splitStr[j].trim().equalsIgnoreCase(search)) {
					System.out.println(catList.get(i).getCatName());
				}
			}
		}
	}
}
