public class Future extends Derivative {
    private final double contractSize;
    private final int expiryDays;

    public Future(String symbol, String name, double currentPrice, double contractSize, int expiryDays) {
        super(symbol, name, currentPrice);
        this.contractSize = contractSize;
        this.expiryDays = expiryDays;
    }

    @Override
    public double riskScore() {
        return 8.5;
    }

    public double getContractSize() {
        return contractSize;
    }

    public int getExpiryDays() {
        return expiryDays;
    }
    @Override
    public void accept(InstrumentVisitor visitor) {
        visitor.visit(this);
    }
}
