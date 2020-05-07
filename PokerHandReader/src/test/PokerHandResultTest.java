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
		String[] cardTypes = {"S", "S", "S", "S", "S"};
		boolean result = PokerHandResult.checkFlush(cardTypes);
		assertTrue("Expected true when same suits", result);
	}
	
	@Test
	public void testFlushFunctionReturnsFalseWhenAllDoNotMatch() {
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
		assertEquals("Expected Three Of A Kind when a triple is sent in", "Three Of A Kind", result);
	}
	
	@Test
	public void testWhatKindOfCountThreeReturnsTwoPairs() {
		HashMap<Integer, Integer> input = new HashMap<Integer, Integer>();
		input.put(10, 2);
		input.put(11, 2);
		input.put(12, 1);
		String result = PokerHandResult.whatKindOfCountThree(input);
		assertEquals("Expected Two Pairs when a two doubles are sent in", "Two Pairs", result);
	}
	
	@Test
	public void testWhatKindOfCountReturnsThreeOfAKindAndTwoPairs() {
		List<Integer> cardPairs = new ArrayList<Integer>();
		cardPairs.add(4);
		cardPairs.add(4);
		cardPairs.add(2);
		cardPairs.add(1);
		cardPairs.add(1);
		String resultPairs = PokerHandResult.whatKindOfCount(cardPairs);
		assertEquals("Expected Two Pairs when testing whatKindOfCount function", "Two Pairs", resultPairs);
		
		
		List<Integer> cardTriples = new ArrayList<Integer>();
		cardTriples.add(4);
		cardTriples.add(4);
		cardTriples.add(4);
		cardTriples.add(3);
		cardTriples.add(1);
		String resultTriple = PokerHandResult.whatKindOfCount(cardTriples);
		assertEquals("Expected Three Of A Kind testing whatKindOfCount function", "Three Of A Kind", resultTriple);
	}
	
	@Test
	public void testWhatKindofCountTwoReturnsFourOfAKind() {
		HashMap<Integer, Integer> input = new HashMap<Integer, Integer>();
		input.put(10, 4);
		input.put(11, 1);
		
		String result = PokerHandResult.whatKindOfCountTwo(input);
		assertEquals("Expected Four Of A Kind when sending in four of a kind", "Four Of A Kind", result);
	}
	
	@Test
	public void testWhatKindofCountTwoReturnsFullHouse() {
		HashMap<Integer, Integer> input = new HashMap<Integer, Integer>();
		input.put(10, 3);
		input.put(11, 2);
		
		String result = PokerHandResult.whatKindOfCountTwo(input);
		assertEquals("Expected Full House when sending in four of a kind", "Full House", result);
	}
	
	@Test
	public void testWhatKindOfCoundReturnsFourOfAKindAndFullHouse() {
		List<Integer> cardFour = new ArrayList<Integer>();
		cardFour.add(4);
		cardFour.add(1);
		cardFour.add(1);
		cardFour.add(1);
		cardFour.add(1);
		String resultFour = PokerHandResult.whatKindOfCount(cardFour);
		assertEquals("Expected Four Of A Kind when testing whatKindOfCount function", "Four Of A Kind", resultFour);
		
		
		List<Integer> cardFull = new ArrayList<Integer>();
		cardFull.add(4);
		cardFull.add(4);
		cardFull.add(4);
		cardFull.add(3);
		cardFull.add(3);
		String resultFull = PokerHandResult.whatKindOfCount(cardFull);
		assertEquals("Expected Full House testing whatKindOfCount function", "Full House", resultFull);
	}
	
	@Test
	public void testWhatIsMyHandFunctionWithFullHouse() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(4);
		cardValues.add(4);
		cardValues.add(4);
		cardValues.add(3);
		cardValues.add(3);
	
		String[] cardTypes = {"A", "S", "S", "S", "S"};
		String result = PokerHandResult.whatIsMyHand(cardValues, cardTypes);
		assertEquals("Expected Full House when unique numbers but identifical types are sent", "Full House", result);	
	}
	
	@Test
	public void testWhatIsMyHandFunctionWithFourOfAKind() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(4);
		cardValues.add(4);
		cardValues.add(4);
		cardValues.add(4);
		cardValues.add(3);
	
		String[] cardTypes = {"A", "S", "S", "S", "S"};
		String result = PokerHandResult.whatIsMyHand(cardValues, cardTypes);
		assertEquals("Expected Four Of A Kind when unique numbers but identifical types are sent", "Four Of A Kind", result);	
	}
	
	@Test
	public void testWhatIsMyHandFunctionWithTwoPairs() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(4);
		cardValues.add(4);
		cardValues.add(3);
		cardValues.add(1);
		cardValues.add(3);
	
		String[] cardTypes = {"A", "S", "S", "S", "S"};
		String result = PokerHandResult.whatIsMyHand(cardValues, cardTypes);
		assertEquals("Expected Two Pairs when unique numbers but identifical types are sent", "Two Pairs", result);	
	}
	
	@Test
	public void testWhatIsMyHandFunctionWithThreeOfAKind() {
		List<Integer> cardValues = new ArrayList<Integer>();
		cardValues.add(4);
		cardValues.add(4);
		cardValues.add(4);
		cardValues.add(1);
		cardValues.add(3);
	
		String[] cardTypes = {"A", "S", "S", "S", "S"};
		String result = PokerHandResult.whatIsMyHand(cardValues, cardTypes);
		assertEquals("Expected Three Of A Kind when unique numbers but identifical types are sent", "Three Of A Kind", result);	
	}
}