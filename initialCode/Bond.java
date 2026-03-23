public class Bond extends Instrument {
    private final double couponRate;
    private final int maturityYears;

    public Bond(String symbol, String name, double currentPrice, double couponRate, int maturityYears) {
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

    public double annualCouponPayment(int units) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public double getCouponRate() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public int getMaturityYears() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }
}
