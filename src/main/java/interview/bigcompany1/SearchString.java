package interview.bigcompany1;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution to a coding challenge proposed by one of the big4 IT companies in US on 04/16/2019.
 * White-board coding style, remote interview. 
 * 
 * @author Cleber Baldan Junior
 */
public class SearchString {

	private static final String STRING_NOT_FOUND = "searched String not found";

	public List<Integer> findAll(String main, String search) throws Exception {

		validateParameters(main, search);

		List<Integer> positionList = new LinkedList<>();
		for (int mainPos = 0; (mainPos + search.length() - 1) < main.length(); mainPos++) {

			if (main.charAt(mainPos) == search.charAt(0)) {
				int auxMainPos = mainPos + 1;
				boolean found = true;

				for (int searchPos = 1; searchPos < search.length(); searchPos++, auxMainPos++) {
					if (main.charAt(auxMainPos) != search.charAt(searchPos)) {
						found = false;
						break;
					}
				}

				if (found) {
					positionList.add(mainPos);
					mainPos = auxMainPos;
				}
			}
		}

		if (positionList.size() == 0) {
			throw new Exception(STRING_NOT_FOUND);
		}

		return positionList;
	}

	private void validateParameters(String main, String search) throws Exception {
		final String stringCantBeNullSuffix = " String can’t be null";

		if (main == null || main.isEmpty()) {
			throw new Exception("main" + stringCantBeNullSuffix);
		}

		if (search == null || search.isEmpty()) {
			throw new Exception("search" + stringCantBeNullSuffix);
		}

		if (search.length() > main.length()) {
			throw new Exception(STRING_NOT_FOUND);
		}

		return;
	}

}
