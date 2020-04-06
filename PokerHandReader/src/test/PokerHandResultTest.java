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
		cardValues.add(13);
		cardValues.add(11);
		cardValues.add(12);
		cardValues.add(1);
		HashMap<Integer, Integer> result = PokerHandResult.valueCounterMap(cardValues);
		
		assertEquals("Expected 4 values in HashMap", 4, result.size());
	}
	
}