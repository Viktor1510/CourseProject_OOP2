package com.oop2.passenger_transport.database.enums;


import lombok.Getter;

public enum Ratings {
    /**
     * No rating.
     */
    NONE("None", -1),

    /**
     * Zero-star rating.
     */
    ZERO_STAR("Zero star", 0),

    /**
     * One-star rating.
     */
    ONE_STAR("One star", 1),

    /**
     * Two-star rating.
     */
    TWO_STAR("Two star", 2),

    /**
     * Three-star rating.
     */
    THREE_STAR("Three star", 3),

    /**
     * Four-star rating.
     */
    FOUR_STAR("Four star", 4),

    /**
     * Five-star rating.
     */
    FIVE_STAR("Five star", 5);

    /**
     * The display value of the rating.
     */
    @Getter
    private final String displayValue;

    /**
     * The default value of the rating.
     */
    @Getter
    private final int value;

    /**
     * The current value used to determine current rating.
     */
    //@Setter
    //@Getter
    //private int currentValue;

    /**
     * The coefficient used to determine rating changes over time.
     */
    //private double coefficient = 0;

    /**
     * Constructs a new Rating with the specified display value and integer value.
     *
     * @param displayValue The display value of the rating.
     * @param value        The integer value of the rating.
     */
    Ratings(String displayValue, Integer value) {
        this.displayValue = displayValue;
        this.value = value;
    }
}