package ru.job4j.stream.card;

import java.util.Objects;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return suit == card.suit && value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suite -> Stream.of(Value.values())
                .map(values -> suite + " " + values))
                .forEach(System.out::println);
    }
}