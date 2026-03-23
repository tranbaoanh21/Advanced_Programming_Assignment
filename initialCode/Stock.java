public class Stock extends Instrument {
    private final double marketCap;
    private final String sector;

    public Stock(String symbol, String name, double currentPrice, double marketCap, String sector) {
        super(symbol, name, currentPrice);
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public double riskScore() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public String assetClass() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }
    
    public double getMarketCap() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public String getSector() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }
}
