package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.PokerHandResult;

public class PokerHandResultTest {
	/**
	 * Poker cards are integers from 1-13 (A-K)
	 */

	@Test
	public void testFlushFunctionReturnsFalsebyDefault() {
		String[] cardTypes = {};
		boolean result = PokerHandResult.checkFlush(cardTypes);
		assertFalse("Expected a default of false", result);
	}
	
	@Test
	public void testFlushFunctionReturnsTrueWhenAllTheSameSuit() {
		String[] cardTypes = {"S", "S", "S", "S", "S",};
		boolean result = PokerHandResult.checkFlush(cardTypes);
		assertTrue("Expected true when same suits", result);
	}
	
	@Test
	public void testFlushFunctionReturnsFalseWhenAllDonnotMatch() {
		String[] cardTypes = {"D", "D", "S", "S", "S"};
		boolean result = PokerHandResult.checkFlush(cardTypes);
		assertFalse("Expected false when not the same suits", result);
	}
	
	@Test
	public void testCardValueInputIsInOrderReturnsTrueForNumericalCorellation() {
		List<Integer> cardValues = new ArrayList<Integer>();
				cardValues.add(4);
				cardValues.add(2);
				cardValues.add(5);
				cardValues.add(1);
				cardValues.add(3);
		boolean result = PokerHandResult.checkOrder(cardValues);
		assertTrue("Expected true when card input is in order", result);
	}
	
	@Test
	public void testCardValueInputOrderReturnsFalseWhenRandomCorellation() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(4);
		cardValues.add(2);
		cardValues.add(14);
		cardValues.add(1);
		cardValues.add(9);
		boolean result = PokerHandResult.checkOrder(cardValues);
		assertFalse("Expected false when card input has no correlation", result);
	}
	
	@Test
	public void testCardValueInputOrderReturnsTrueWhenHighStraight() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(10);
		cardValues.add(13);
		cardValues.add(11);
		cardValues.add(12);
		cardValues.add(1);
		boolean result = PokerHandResult.checkOrder(cardValues);
		assertTrue("Expected true when card input is correlating and is 10 - Ace", result);
	}
	
	@Test
	public void testCardValueInputCounterReturnsCardsAndCount() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(1);
		cardValues.add(2);
		cardValues.add(2);
		cardValues.add(2);
		cardValues.add(1);
		HashMap<Integer, Integer> result = PokerHandResult.valueCounterMap(cardValues);
		int count1 = result.get(1);
		int count2 = result.get(2); 
		assertEquals("Expected 2 values in HashMap", 2, result.size());
		assertEquals("Expected value 1 to have a count of 2", 2, count1);
		assertEquals("Expected value 2 to have a count of 3", 3, count2);
		assertTrue("Expected 1 to exist as a key", result.containsKey(1));
		assertTrue("Expected 2 to exist as a key", result.containsKey(2));
	}
	
	@Test
	public void checkCountExist() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(1);
		cardValues.add(3);
		cardValues.add(5);
		cardValues.add(6);
		cardValues.add(8);
		
		boolean result = PokerHandResult.checkCount(cardValues);
		assertFalse("Expected false when all input values are unique", result);
	}
	
	@Test
	public void testWhatKindOfFlushFunctionReturnsFlush() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(8);
		cardValues.add(6);
		cardValues.add(5);
		cardValues.add(3);
		cardValues.add(1);
		
		String result = PokerHandResult.whatKindOfFlush(cardValues);
		assertEquals("Expected Flush when unique values but identical types are provided", "Flush", result);
	}
	
	@Test
	public void testWhatKindOfFlushFunctionReturnsStrightFlush() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(4);
		cardValues.add(2);
		cardValues.add(5);
		cardValues.add(3);
		cardValues.add(1);		
		String result = PokerHandResult.whatKindOfFlush(cardValues);
		assertEquals("Expected Stright Flush when ordered values but identical types are provided", "Straight Flush", result);
	}
	
	@Test
	public void testWhatKindOfFlushFunctionReturnsRoyalFlush() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(11);
		cardValues.add(10);
		cardValues.add(13);
		cardValues.add(12);
		cardValues.add(1);		
		String result = PokerHandResult.whatKindOfFlush(cardValues);
		assertEquals("Expected Royal Flush when ordered values but identical types are provided", "Royal Flush", result);
	}
	
	@Test
	public void testProvidingMatchingSuitsSuitsSendsBackFlush() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(8);
		cardValues.add(6);
		cardValues.add(5);
		cardValues.add(3);
		cardValues.add(1);
	
		String[] cardTypes = {"S", "S", "S", "S", "S"};
		String result = PokerHandResult.whatIsMyHand(cardValues, cardTypes);
		assertEquals("Expected Flush when unique numbers but identifical types are sent", "Flush", result);			
	}	
	
	@Test
	public void testProvideNothingReturnsHighCard() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(8);
		cardValues.add(6);
		cardValues.add(5);
		cardValues.add(3);
		cardValues.add(1);
		String result = PokerHandResult.highCard(cardValues);
		assertEquals("Expect High Card 8 when cardValues are sent with 8 being the highest", "High Card 8", result);
	}
	
	@Test
	public void testWhatIsMyHandFunctionWithHighCardOnly() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(13);
		cardValues.add(6);
		cardValues.add(5);
		cardValues.add(3);
		cardValues.add(1);
	
		String[] cardTypes = {"A", "S", "H", "S", "S"};
		String result = PokerHandResult.whatIsMyHand(cardValues, cardTypes);
		assertEquals("Expect High Card 13 when cardValues are sent with 8 being the highest", "High Card 13", result);
	}
	
	@Test
	public void testWhatisMyHandReturnsAStriaghtWhenStraightIsSent() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(4);
		cardValues.add(2);
		cardValues.add(5);
		cardValues.add(3);
		cardValues.add(1);
	
		String[] cardTypes = {"A", "S", "H", "S", "S"};
		String result = PokerHandResult.whatIsMyHand(cardValues, cardTypes);
		assertEquals("Expected Straight when straight is sent", "Straight", result);
	}
	
	@Test
	public void testWhatKindOfCountFunctionReturnsOnePair() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(4);
		cardValues.add(3);
		cardValues.add(2);
		cardValues.add(1);
		cardValues.add(1);
		String result = PokerHandResult.whatKindOfCount(cardValues);
		assertEquals("Expected One Pair when double is sent", "One Pair", result);
	}
	
	@Test
	public void testWhatKindOfCountThreeReturnsThreeOfAKind() {
		HashMap<Integer, Integer> input = new HashMap<Integer, Integer>();
		input.put(10, 3);
		input.put(11, 1);
		input.put(12, 1);
		String result = PokerHandResult.whatKindOfCountThree(input);
		assertEquals("Expect Three Of A Kind when a triple is sent in", "Three Of A Kind", result);
	}
	
	@Test
	public void testWhatKindOfCountThreeReturnsTwoPairs() {
		HashMap<Integer, Integer> input = new HashMap<Integer, Integer>();
		input.put(10, 2);
		input.put(11, 2);
		input.put(12, 1);
		String result = PokerHandResult.whatKindOfCountThree(input);
		assertEquals("Expect Two Pairs when a two doubles are sent in", "Two Pairs", result);
	}
	
}