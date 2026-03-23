import java.time.LocalDateTime;

public abstract class Instrument implements Tradeable, Priceable {
    private final String symbol;
    private String name;
    private double currentPrice;
    private LocalDateTime lastUpdated;

    public Instrument(String symbol, String name, double currentPrice) {
        this.symbol = symbol;
        this.name = name;
        this.currentPrice = currentPrice;
        this.lastUpdated = LocalDateTime.now();
    }

    public abstract double riskScore();

    public abstract String assetClass();
    
    public void updatePrice(double newPrice) {
        if (newPrice < 0) {
            throw new IllegalArgumentException("");
        }
        this.currentPrice = newPrice;
        this.lastUpdated = LocalDateTime.now();
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getName() {
        return this.name;
    }

    public double getCurrentPriceValue() {
        return this.currentPrice;
    }

    public LocalDateTime getLastUpdated() {
        return this.lastUpdated;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [symbol=" + symbol + ", price=" + currentPrice + ", risk=" + riskScore() + "]";
    }


    /* ----------------- PROBLEM 5 -------------- */
    @Override
    public double getPriceChange(double previousPrice) {
        return this.currentPrice - previousPrice;
    }
    
    @Override
    public double getPriceChangePercent(double previousPrice) {
        return ((this.currentPrice - previousPrice) / previousPrice) * 100;
    }
    
    @Override
    public boolean isAvailableForTrading() {
        return true;
    }
}
