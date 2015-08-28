package testcase;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.DAO.DateDao;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TestDate {
	DateDao d = new DateDao();
	Connection conn=null;
	PreparedStatement actual;
	@Before
	public void initEnvironment() {
		System.out.println("Creating Test Environment");
	}

	@Test
	public void testUTC_01() throws SQLException {
		System.out.println("1 Record Selected");
		List<Integer> actual = d.getdate("July");
		int a = actual.size();
		assertEquals(1, a);
	}

	@Test
	public void testUTC_02() throws SQLException {
		System.out.println("0 Record Selected");
		List<Integer> actual = d.getdate("December");
		int a = actual.size();
		assertEquals(0, a);
	}

	@Test
	public void testUTC_03() throws SQLException {
		System.out.println("Multiple Record Selected");
		List<Integer> actual = d.getdate("January");
		int a = actual.size();
		assertEquals(4,a);
	}

	@Test(expected=SQLException.class)
	public void testUTC_04() throws SQLException {
		System.out.println("Exception");
		throw new SQLException();
		}

	@After
	public void clear() {
		System.out.println("Removing Test Environment");
	}

}
