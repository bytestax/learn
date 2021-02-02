package com.example;

public final class Stock {
    final String ticker;
    final String name;

    public Stock(String ticker, String name) {
        this.ticker = ticker;
        this.name = name;
    }

    public final String getTicker() {
        return ticker;
    }

    public final String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Stock) {
            Stock src = (Stock) obj;
            return ticker.equals(src.getTicker());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ticker.hashCode();
    }
}
