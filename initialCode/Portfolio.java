import java.util.*;

public class Portfolio implements Observable<String> {
    private final String portfolioId;
    private final String ownerName;
    private final List<Position> positions;
    private final List<Observer<String>> observers;

    public Portfolio(String portfolioId, String ownerName) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public void addPosition(Instrument inst, int qty, double costBasis) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public void removePosition(String symbol) throws PositionNotFoundException {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public double totalMarketValue() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public double totalUnrealizedPnL() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public Position getPosition(String symbol) throws PositionNotFoundException {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public List<Position> getPositionsSortedByValue() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public Map<String, Double> allocationByAssetClass() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public void revalueAll(PricingStrategy strategy) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void addObserver(Observer<String> observer) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void removeObserver(Observer<String> observer) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void notifyObservers(String event) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public String getPortfolioId() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public String getOwnerName() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }
}
