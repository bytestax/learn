package com.example;

public class Stock {
    String ticker;
    String name;

    public Stock(String ticker, String name) {
        this.ticker = ticker;
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return ticker.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Stock) {
            Stock src = (Stock) obj;
            return ticker.equals(src.getTicker());
        }
        return false;
    }
}
