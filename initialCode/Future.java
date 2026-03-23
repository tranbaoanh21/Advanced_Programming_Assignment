public class Future extends Derivative {
    private final double contractSize;
    private final int expiryDays;

    public Future(String symbol, String name, double currentPrice, double contractSize, int expiryDays) {
        super(symbol, name, currentPrice);
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public double riskScore() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public double getContractSize() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public int getExpiryDays() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }
}
