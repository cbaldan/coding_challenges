package coding.website.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import coding.website.hackerrank.SherlockString;

public class SherlockStringTest {

	static final String YES = "YES";
	static final String NO = "NO";

	@Test
	public void singleChar() {
		String s = "a";
		String result = SherlockString.isValid(s);

		Assert.assertEquals(YES, result);
	}

	@Test
	public void singleCharTwice() {
		String s = "aa";
		String result = SherlockString.isValid(s);

		Assert.assertEquals(YES, result);
	}

	@Test
	public void twoChars() {
		String s = "ab";
		String result = SherlockString.isValid(s);

		Assert.assertEquals(YES, result);
	}

	@Test
	public void ThreeChar() {
		String s = "abc";
		String result = SherlockString.isValid(s);

		Assert.assertEquals(YES, result);
	}

	@Test
	public void threeCharsOneOnceTwoTwice() {
		String s = "abbcc";
		String result = SherlockString.isValid(s);

		Assert.assertEquals(YES, result);
	}

	@Test
	public void threeCharsOneTwoThree() {
		String s = "abbccc";
		String result = SherlockString.isValid(s);

		Assert.assertEquals(NO, result);
	}

	@Test
	public void threeCharsSingleSingleTwice() {
		String s = "abcc";
		String result = SherlockString.isValid(s);

		Assert.assertEquals(YES, result);
	}

	@Test
	public void threeCharsOneOneTriple() {
		String s = "abccc";
		String result = SherlockString.isValid(s);

		Assert.assertEquals(NO, result);
	}

	@Test
	public void threeCharsOneOneTripleOutOfOrder() {
		String s = "cabcc";
		String result = SherlockString.isValid(s);

		Assert.assertEquals(NO, result);
	}

	@Test
	public void threeCharsOneDoubleOutOfOrder() {
		String s = "cabc";
		String result = SherlockString.isValid(s);

		Assert.assertEquals(YES, result);
	}

	@Test
	public void sixCharsLastDoubleOufOfOrder() {
		String s = "fabcdef";
		String result = SherlockString.isValid(s);

		Assert.assertEquals(YES, result);
	}

	@Test
	public void fourCharsTwoDoubleTwoSingle() {
		String s = "aabbcd";
		String result = SherlockString.isValid(s);

		Assert.assertEquals(NO, result);
	}

	@Test
	public void TestCase7FromHackerRank() {
		String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
		String result = SherlockString.isValid(s);

		Assert.assertEquals(YES, result);
	}

	@Test
	public void TestCase7FromHackerRankImproved() {
		String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
		s += 'n';
		String result = SherlockString.isValid(s);

		Assert.assertEquals(NO, result);
	}

	@Test
	public void threeCharFirstSingle() {
		String s = "abbcc";
		String result = SherlockString.isValid(s);

		Assert.assertEquals(YES, result);
	}

}
