package company_project.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import company_project.Impl.TitleDaoImpl;
import company_project.dto.Title;

public class TitleDaoTest {

	private TitleDao dao;

	@Before
	public void setUp() throws Exception {
		dao = TitleDaoImpl.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testSelectTitleByAll() {
		List<Title> list = dao.selectTitleByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testInsertTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectTitleByNo() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNextNo() {
		fail("Not yet implemented");
	}

}
