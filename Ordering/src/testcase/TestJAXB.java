package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.customer.Table1;
import com.customer.Table2;
import com.customer.Table3;
import com.DAO.CreateXML;

public class TestJAXB {

	@Before
	public void initEnvironment() {
		System.out.println("Creating Test Environment");
	}

	@Test
	public void testTable1_01() {
		System.out.println("Negative Test Case");
		try {
			Table1 t1 = null;
			CreateXML.jaxbObjectToXML(t1);
			fail("Exception Not Thrown");
		} catch (Exception e) {
			assertTrue(true);
		}

	}

	@Test
	public void testTable1_02() {
		System.out.println("Positive Test Case");
		try {
			Table1 t1 = new Table1("Snigdha", "Reddy", "javabatch02@gmail.com",
					996390899, "New", "Residential", "Cheque");
			CreateXML.jaxbObjectToXML(t1);
			assertTrue(true);
		} catch (Exception e) {
			fail("Exception Thrown" + e);
		}
	}

	@Test
	public void testTable2_03() {
		System.out.println("Negative Test Case");
		try {
			Table2 t2 = null;
			CreateXML.jaxbTable2ToXML(t2);
			fail("Exception Not Thrown");
		} catch (Exception e) {
			assertTrue(true);
		}

	}

	@Test
	public void testTable2_04() {
		System.out.println("Positive Test Case");
		try {
			Table2 t2 = new Table2("Billing", "Whitefields", "Kondapur",
					"Hyderabad", "Telangana", "201", 311);
			CreateXML.jaxbTable2ToXML(t2);
			assertTrue(true);
		} catch (Exception e) {
			fail("Exception Thrown" + e);
		}
	}

	@Test
	public void testTable3_05() {
		System.out.println("Negative Test Case");
		try {
			Table3 t3 = null;
			CreateXML.jaxbTable3ToXML(t3);
			fail("Exception Not Thrown");
		} catch (Exception e) {
			assertTrue(true);
		}

	}

	@Test
	public void testTable3_06() {
		System.out.println("Positive Test Case");
		try {
			Table3 t3 = new Table3("1", "Fios", "2",
					"High quality Tv experience", "21-05-2014", "21-12-36",
					"25-06-2015", "31-07-2015", "PR", "New", "101",
					"Residential", "31-12-2016");
			CreateXML.jaxbTable3ToXML(t3);
			assertTrue(true);
		} catch (Exception e) {
			fail("Exception Thrown" + e);
		}
	}

	@After
	public void clear() {
		System.out.println("Removing Test Environment");
	}

}
