public class Stock extends Instrument {
    private final double marketCap;
    private final String sector;

    public Stock(String symbol, String name, double currentPrice, double marketCap, String sector) {
        super(symbol, name, currentPrice);
        this.marketCap = marketCap;
        this.sector = sector;
    }

    @Override
    public double riskScore() {
        if (this.marketCap < 1000000000.0) {
            return 7.5;
        }
        else if (this.marketCap < 10000000000.0) { 
            return 5.0;
        }
        else {
            return 3.0;
        }
    }

    @Override
    public String assetClass() {
        return "EQUITY";
    }
    
    public double getMarketCap() {
        return this.marketCap;
    }

    public String getSector() {
        return this.sector;
    }
    @Override
    public void accept(InstrumentVisitor visitor) {
        visitor.visit(this);
    }
}
