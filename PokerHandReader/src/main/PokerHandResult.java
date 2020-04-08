package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PokerHandResult {

/**
 * CardType = String Array
 * CardValue = List int
 * 
 * Function:
 * 	Flush check
 * 	Order check
 * 	Counter
 * 		- returns HashMap, Key is cardvalue, Value is counter
 * 		- For loop list, if cardValue exist in HashMap, increment Value  	
 * @param cardTypes
 * @return
 */

	private static final String HAND_RESULT = "Flush";
	
//	public static String whatIsMyHand(List<Integer> cardValues, String[] cardTypes) {
//		if (checkFlush(cardTypes)) {
//			return whatKindOfFlush(cardValues, cardTypes);
//		}
//		
//		return null;
//	}
	
	public static boolean checkFlush(String[] cardTypes) {
		int counter = 0;
		for(String cardType: cardTypes) {
			if (cardType.equals(cardTypes[0])) {
				counter ++;
			}
		}
		if (counter == 5) {
			return true;
		}
		return false;
	}

	public static boolean checkOrder(List<Integer> cardValues) {
		Collections.sort(cardValues);
		int counter = 0;
		for (int i = 0; i < cardValues.size() - 1; i++) {
			int first = cardValues.get(i);
			int second = cardValues.get(i+1);
			if (first + 1 == second) {
				counter ++;
			}
		}
		if (counter == 4) {
			return true;
		}
		if (counter == 3 && cardValues.get(0).equals(1) && cardValues.get(4).equals(13)) {
			return true;
		}
		return false;
	}

	public static HashMap<Integer, Integer> valueCounterMap(List<Integer> cardValues) {
		HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
		for(int i: cardValues) {
			if (result.containsKey(i)) {
				int count = result.get(i) + 1;
				result.remove(i);
				result.put(i, count);
			} else {
				result.put(i, 1);
			}
			
		}
		return result;
	}

	public static boolean isThereACount(List<Integer> cardValues) {
		HashMap<Integer, Integer> counterCheck = valueCounterMap(cardValues);
		return counterCheck.size() == 5? false: true;
	}

	public static String whatKindOfFlush(List<Integer> cardValues) {
		if (checkOrder(cardValues)) {
			return null;
		}
		return "Flush";
	}
}
