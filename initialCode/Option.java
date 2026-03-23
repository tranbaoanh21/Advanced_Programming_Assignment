public class Option extends Derivative {
    private final double strikePrice;
    private final boolean isCall;
    private final int expiryDays;

    public Option(String symbol, String name, double currentPrice, double strikePrice, boolean isCall, int expiryDays) {
        super(symbol, name, currentPrice);
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public double riskScore() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }
    
    public boolean isInTheMoney(double spotPrice) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public double getStrikePrice() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public boolean isCall() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public int getExpiryDays() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }
}
