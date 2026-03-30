public class Position {
    private final Instrument instrument;
    private int quantity;
    private double averageCostBasis;

    public Position(Instrument instrument, int quantity, double averageCostBasis) {
        // TODO
        this.instrument = instrument;
        this.quantity = quantity;
        this.averageCostBasis = averageCostBasis;
    }

    public double marketValue() {
        // TODO
        return this.quantity * this.instrument.getCurrentPriceValue();
    }

    public double unrealizedPnL() {
        // TODO
        return marketValue() - (this.quantity * this.averageCostBasis);
    }

    public void addQuantity(int qty, double costBasis) {
        // TODO
        double newTotalCost = (this.quantity * this.averageCostBasis) + (qty * costBasis);
        this.quantity += qty;
        this.averageCostBasis = newTotalCost / this.quantity;
    }

    public Instrument getInstrument() {
        // TODO
        return this.instrument;
    }

    public int getQuantity() {
        // TODO
        return this.quantity;
    }

    public double getAverageCostBasis() {
        // TODO
        return this.averageCostBasis;
    }

    @Override
    public String toString() {
        return "Position[symbol=" + instrument.getSymbol() + ", qty=" + quantity + ", value=" + marketValue() + ", pnl=" + unrealizedPnL() + "]";
    }
}
