package coding.website.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Resolution to https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 * 
 * @author Cleber Baldan Junior
 *
 */
public class SherlockString {

	// Complete the isValid function below.
	public static String isValid(String s) {
		String result = "YES";
		boolean diffFound = false;

		if (s.length() > 1) {
			ArrayList<Integer> frequencyList = getFrequencyList(s);

			Collections.sort(frequencyList);

			int baseFrequency = frequencyList.get(0);
				for (int index = 1; index < frequencyList.size(); index++) {
				int currentFrequency = frequencyList.get(index);

				if (currentFrequency != baseFrequency) {
					int diff = Math.abs(baseFrequency - currentFrequency);

					// special case, first frequency is offender
					// allow change of base frequency one single time!
					if (index == 1 && baseFrequency == 1) {
						baseFrequency = currentFrequency;
					} else if (diff > 1 || diffFound) {
						result = "NO";
						break;
					}

					diffFound = true;
				}
			}
		}

		return result;
	}

	static ArrayList<Integer> getFrequencyList(String s) {
		int index = 0;
		Integer frequencySum;
		HashMap<Character, Integer> frequencyMap = new HashMap<>();

		while (index < s.length()) {
			Character c = s.charAt(index);

			frequencySum = frequencyMap.get(c);

			if (frequencySum == null) {
				frequencySum = Integer.valueOf(0);
			}

			frequencySum++;
			frequencyMap.put(c, frequencySum);

			index++;
		}

		ArrayList<Integer> frequencyList = new ArrayList<>(frequencyMap.size());
		for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
			frequencyList.add(entry.getValue());
		}

		return frequencyList;
	}
}
