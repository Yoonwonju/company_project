package company_project.ds;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

public class JdbcUtilJNDITest {

	@Test
	public void testGetConnection() {
		Connection con = JdbcUtilJNDI.getConnection();
		Assert.assertNotNull(con);
		System.out.println("con : " + con);
	}

}
