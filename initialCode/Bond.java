public class Bond extends Instrument {
    private final double couponRate;
    private final int maturityYears;

    public Bond(String symbol, String name, double currentPrice, double couponRate, int maturityYears) {
        super(symbol, name, currentPrice);
        this.couponRate = couponRate;
        this.maturityYears = maturityYears;
    }

    @Override
    public double riskScore() {
        if (maturityYears > 10) {
            return 4.0;
        }
        else {
            return 2.0;
        }
    }

    @Override
    public String assetClass() {
        return "FIXED_INCOME";
    }

    public double annualCouponPayment(int units) {
        return units * getCurrentPriceValue() * this.couponRate / 100;
    }

    public double getCouponRate() {
        return this.couponRate;
    }

    public int getMaturityYears() {
        return this.maturityYears;
    }
    @Override
    public void accept(InstrumentVisitor visitor) {
        visitor.visit(this);
    }
}
