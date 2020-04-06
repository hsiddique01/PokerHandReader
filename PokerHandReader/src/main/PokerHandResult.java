package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PokerHandResult {

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
		
		return null;
	}

}
