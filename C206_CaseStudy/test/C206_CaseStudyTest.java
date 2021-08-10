import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	

	// Deal //
	private ArrayList<deal> dealList;
	private deal d1, d2;

	@Before
	public void setUp() throws Exception {
		d1 = new deal(0, "chair", "Von@email", "Franc@email", 20.00, "8/8");
		d2 = new deal(1, "table", "Bobert@email", "john@email", 50.00, "6/6");
		dealList = new ArrayList<deal>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void addDealTest() {
		// deal list is not null, so that can add a new deal - boundary
		assertNotNull("Check if there is valid deal arraylist to add to", dealList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addDeal(dealList, d1);
		assertEquals("Check that deal arraylist size is 1", 1, dealList.size());
		assertSame("Check that deal is added", d1, dealList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addDeal(dealList, d2);
		assertEquals("Check that deal arraylist size is 2", 2, dealList.size());
		assertSame("Check that deal is added", d2, dealList.get(1));
	}

	@Test
	public void retrieveAllDeals() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid deal arraylist to retrieve item", dealList);
		
		//test if the list of deal retrieved from the SourceCentre is empty - boundary
		String allDeal= C206_CaseStudy.retrieveAllDeal(dealList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allDeal);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addDeal(dealList, d1);
		C206_CaseStudy.addDeal(dealList, d2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, dealList.size());
		
		//test if the expected output string same as the list of deal retrieved from the SourceCentre	
		allDeal= C206_CaseStudy.retrieveAllDeal(dealList);
		testOutput = String.format("%-5s %-15s %-15s %-15s %-10s %-10s\n", "0","chair","Franc@email","Von@email","20.00","8/8");
		testOutput += String.format("%-5s %-15s %-15s %-15s %-10s %-10s\n", "1","table","john@email","Bobert@email","50.00","6/6");
	
		assertEquals("Test that ViewAllDeal", testOutput, allDeal);
		
	}
	
	@Test
	public void deleteDeals_test() {
		// Deal  list is not null, so that can add a new deal - boundary
		assertNotNull("Check if there is valid deal arraylist to add to", dealList);
		
		C206_CaseStudy.addDeal(dealList, d1);
		assertEquals(1, dealList.size());
		C206_CaseStudy.addDeal(dealList, d2);
		assertEquals(2, dealList.size());
		
		C206_CaseStudy.deleteDeal(dealList, 0);
		C206_CaseStudy.deleteDeal(dealList, 1);
		
	}
	
	// Bids //
	
	ArrayList<Bid> bidList = new ArrayList<Bid>();
	C206_CaseStudy main;
	
	@Test // Adding Normal
	public void testAdd() {
		Bid newBid = new Bid(1,"Testing","Testing","Testing",1.00);
		assertSame(true,C206_CaseStudy.addBid(bidList,newBid));
	}
	
	@Test // Adding Error
	public void testAddError() {
		Bid newBid = new Bid(1,"Testing","Testing","Testing",1.00);
		bidList.add(newBid);
		Bid testBid = new Bid(1,"Testing","Testing","Testing",0.50);
		assertSame(false,C206_CaseStudy.addBid(bidList, testBid));
		
	}
		
	@Test // Delete Normal
	public void testDelete() {
		Bid newBid = new Bid(1,"Testing","Testing","Testing",1.00);
		bidList.add(newBid);
		assertSame(true,C206_CaseStudy.deleteBid(bidList, 1));
		
	}
	
	@Test // Delete Error
	public void testDeleteError() {
		Bid newBid = new Bid(1,"Testing","Testing","Testing",1.00);
		bidList.add(newBid);
		assertSame(false,C206_CaseStudy.deleteBid(bidList, 2));
	}
	
	// Category // 
	
	@Before
	public void setUp1() throws Exception {
	}

	@After
	public void tearDown1() throws Exception {
	}

	@Test
	public void addCategoryTest() {
		ArrayList<Category> catList = new ArrayList<Category>();
		Category cat1 = new Category("CD");
		catList.add(cat1);
		
		assertEquals(1, catList.size());
	}
	
	@Test
	public void viewAllCategoriesTest() {

	}
	
	@Test
	public void deleteCategoryTest() {
		ArrayList<Category> catList = new ArrayList<Category>();
		Category cat1 = new Category("CD");
		catList.add(cat1);
		
		catList.remove(cat1);
		
		assertEquals(0, catList.size());
	}
	
	// Student //
	/*
	ArrayList<Student> studentList = new ArrayList<Student>();

	Student st1 = new Student("Ezekiel", "Role1", "ezekiel@gmail.com", "123456");
	Student st2 = new Student ("Daw", "Role2", "daw@gmail.com", "abc1235");
	@Test
	  public void removeStudentTest() {
	    assertNotNull("Test if there is valid Student arraylist to retrieve item", studentList);
	    
	    C206_CaseStudy.addStudent(studentList, st1);
	    assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
	    assertSame("Check that Student is added", st1, studentList.get(0));
	    
	    
	    C206_CaseStudy.addStudent(studentList, st2);
	    assertEquals("Check that Student arraylist size is 2", 2, studentList.size());
	    assertSame("Check that Student is added", st2, studentList.get(1));
	    
	    
	    C206_CaseStudy.removeStudent(studentList, st2.getStudentID());
	    assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
	    assertSame("Check that Student is added", st1, studentList.get(0));
	    
	  
	  }
	
	@Test
	  public void addStudentTest() {
	    // Item list is not null, so that can add a new item - boundary
	    assertNotNull("Check if there is valid Student arraylist to add to", studentList);
	    //Given an empty list, after adding 1 item, the size of the list is 1 - normal
	    //The item just added is as same as the first item of the list
	    C206_CaseStudy.addStudent(studentList, st1);
	    assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
	    assertSame("Check that Student is added", st1, studentList.get(0));
	    
	    //Add another item. test The size of the list is 2? -normal
	    //The item just added is as same as the second item of the list
	    C206_CaseStudy.addStudent(studentList, st2);
	    assertEquals("Check that Student arraylist size is 2", 2, studentList.size());
	    assertSame("Check that Student is added", st2, studentList.get(1));
	  }
		*/
	
}
