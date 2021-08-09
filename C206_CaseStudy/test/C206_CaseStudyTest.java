import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
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
	
	
}
