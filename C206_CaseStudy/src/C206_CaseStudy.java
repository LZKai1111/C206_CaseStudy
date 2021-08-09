import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<deal> dealList = new ArrayList<deal>();
		deal d1 = new deal(0, "chair", "Von@email", "Franc@email", 20.00, "8/8");
		deal d2 = new deal(1, "table", "Bobert@email", "john@email", 50.00, "6/6");
		dealList.add(d1);
		dealList.add(d2);
		
		int option = 0;
		
		while(option != 4) {

			message();
			option = Helper.readInt("Enter your input > ");
			
			if(option == 1) {
				//Add
				deal dl = inputDeal();
				addDeal(dealList, dl);
				
			}
			else if(option == 2) {
				//View
				C206_CaseStudy.viewAllDeal(dealList);
			}
			else if(option == 3) {
				//Delete
				int deleteInput = Helper.readInt("Enter ID to delete > ");
				deleteDeal(dealList, deleteInput);
			}
		}
		System.out.println("Good Bye");
		
		

			
		
	}

	//=========== Option 1 Show (CRUD - Read) =================================
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

	//=========== Option 2 Add (CRUD - Read) ====================================
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
	
	
	//=========== Option 3 Delete (CRUD - Read) =================================
	
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
	
	

	
	
	//====================== Menu Message Output ====================================
	
	public static void message() {
		String message = "-------------------";
		message += "\n1.Add deal";
		message += "\n2.View deal";
		message += "\n3.Delete deal";
		message += "\n4.Exit";
		message += "\n-------------------";
		System.out.println(message);
	}
	
}
