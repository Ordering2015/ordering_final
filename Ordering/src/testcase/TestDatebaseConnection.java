package testcase;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.factory.Factory;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TestDatebaseConnection {

	static Connection expected = null;

	@Before
	public void initEnvironment() {
		System.out.println("Creating Test Environment");
	}

	@Test
	public void testUTC_01() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		expected = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
		Connection actual = Factory.createOracleConnection();
		assertNotNull(actual);
	}

	@After
	public void clear() {
		System.out.println("Removing Test Environment");
	}

}
