package interview.bigcompany1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import interview.bigcompany1.SearchString;

public class SearchStringTest {

	@Test
	public void searchStringExists() throws Exception {

		String main = "testString";
		String search = "testString";
		int expectedIndex = 0;

		SearchString searchString = new SearchString();

		List<Integer> resultList = searchString.findAll(main, search);

		Assert.assertEquals("Expected String not found", new Integer(expectedIndex), resultList.get(0));
	}

	@Test
	public void googeTest() throws Exception {

		String main = "Havingababyis fun until baby needs to go to sleep";
		String search = "baby";

		SearchString searchString = new SearchString();
		List<Integer> actual = searchString.findAll(main, search);
		List<Integer> expected = new ArrayList<>(2);
		expected.add(7);
		expected.add(24);

		Assert.assertEquals("Results don't match", expected, actual);
	}

	@Test
	public void singleCharSearch() throws Exception {
		
		String singleString = "a";
		
		SearchString searchString = new SearchString();
		searchString.findAll(singleString, singleString);
	}

	@Test(expected = Exception.class)
	public void negativeException() throws Exception {

		String main = "testString";
		String search = "anotherString";

		SearchString searchString = new SearchString();

		searchString.findAll(main, search);
	}

}
