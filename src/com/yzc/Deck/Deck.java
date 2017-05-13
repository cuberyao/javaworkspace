package com.yzc.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
	List<Card> cards = new ArrayList<>();
	private static final String[] Ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	private static final String[] Suits = {"黑桃","红桃","梅花","方片"};
	Deck() {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				Card tmp = new Card();
				tmp.setRank(Ranks[i]);
				tmp.setSuit(Suits[j]);
				cards.add(tmp);
			}
		}
		Card tmp = new Card();
		tmp.setRank("Joker");
		tmp.setSuit("大王");
		cards.add(tmp);
		tmp = new Card();
		tmp.setRank("Joker");
		tmp.setSuit("小王");
		cards.add(tmp);
	}
	public void shuffle() {
		Collections.shuffle(cards);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (Card c : cards) {
			sb.append(c.toString());
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
	}

}
