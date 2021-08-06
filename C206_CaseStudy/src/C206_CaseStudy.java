import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<deal> dealList = new ArrayList<deal>();
		String SearchInput = Helper.readString("Enter keyword: ");

			
		
	}

	//=========== Option 1 Show (CRUD - Read) =================================
	public static String retrieveAllDeal(ArrayList<deal> dealList) {
		String output = "";
		
		for(int i=0; i<dealList.size(); i++) {
			
			int dealID = dealList.get(i).getId();
			output += String.format("", dealList.get(i).toString());
		}
		
		return output;
	}
	
	public static void viewAllDeal(ArrayList<deal> dealList) {
		String output = "DEAL LIST\n";
		output += String.format("%-10s %-15s %-30s %-30s %-10s %-10s", "ID","ITEM NAME","SELLER","BUYER","PRICE","DUE DATE");
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
		
		deal dl = new deal(dealID, itemName, sellerEmail, buyerEmail, price, closeDate);
		return dl;
	}
	
	public static void addDeal(ArrayList<deal> dealList, deal dl) {
		
		dealList.add(dl);
		System.out.println("Deal added");
	}
	
	
	//=========== Option 3 Delete (CRUD - Read) =================================
	
	public static int findDeal(ArrayList<deal> dealList) {
		int deleteIndex = 0;
		String searchKeyword = Helper.readString("Search > ");
		for(int i=0; i<dealList.size(); i++) {
			if(dealList.get(i).toString().contains(searchKeyword)) {
				deleteIndex = i;
			}
		}
		
		return deleteIndex;
	}
	
	public static void deleteDeal(ArrayList<deal> dealList, int index) {
		dealList.remove(index);
		System.out.println("Deal successfully deleted!");
	}
	
	
	//=========== Option 4 search deal (CRUD - Read) =================================
	
	public static int searchDeal(ArrayList<deal> dealList) {
		int findIndex = 0;
		String searchKeyword = Helper.readString("Search > ");
		for(int i=0; i<dealList.size(); i++) {
			if(dealList.get(i).toString().contains(searchKeyword)) {
				findIndex = i;
			}
		}
		
		return findIndex;
	}
	
	public static void showfindDeal(ArrayList<deal> dealList, int findIndex) {
		System.out.println(dealList.get(findIndex));
	}
	
	//=========== Option 4 search deal (CRUD - Read) =================================
	
	public static deal updateDeal() {
		
		int dealID = Helper.readInt("Enter deal ID > ");
		String itemName = Helper.readString("Enter item name > ");
		String sellerEmail = Helper.readString("Enter seller email > ");
		String buyerEmail = Helper.readString("Enter buyer email > ");
		double price = Helper.readDouble("Enter transcation price > ");
		String closeDate = Helper.readString("Enter close date > ");
		
		deal updateDL = new deal(dealID, itemName, sellerEmail, buyerEmail, price, closeDate);
		return updateDL;
	}
	
}
