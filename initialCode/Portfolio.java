import java.util.*;

public class Portfolio implements Observable<String> {
    private final String portfolioId;
    private final String ownerName;
    private final List<Position> positions;
    private final List<Observer<String>> observers;

    public Portfolio(String portfolioId, String ownerName) {
        this.portfolioId = portfolioId;
        this.ownerName = ownerName;
        this.positions = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addPosition(Instrument inst, int qty, double costBasis) {
        boolean found = false;
        for (Position p : positions) {
            if (p.getInstrument().getSymbol().equals(inst.getSymbol())) {
                p.addQuantity(qty, costBasis);
                found = true;
                break;
            }
        }
        if (!found) {
            positions.add(new Position(inst, qty, costBasis));
        }
        notifyObservers("ADDED: " + inst.getSymbol() + " x" + qty);
    }

    public void removePosition(String symbol) throws PositionNotFoundException {
        // TODO
        Position p = getPosition(symbol);
        positions.remove(p);
        notifyObservers("REMOVED: " + symbol);
    }

    public double totalMarketValue() {
        // TODO
        double total = 0;
        for (Position p : positions) {
            total += p.marketValue();
        }
        return total;
    }

    public double totalUnrealizedPnL() {
        // TODO
        double total = 0;
        for (Position p : positions) {
            total += p.unrealizedPnL();
        }
        return total;
    }

    public Position getPosition(String symbol) throws PositionNotFoundException {
        // TODO
        for (Position p : positions) {
            if (p.getInstrument().getSymbol().equals(symbol)) {
                return p;
            }
        }
        throw new PositionNotFoundException("");
    }

    public List<Position> getPositionsSortedByValue() {
        // TODO
        List<Position> sortedList = new ArrayList<>(positions);
        sortedList.sort((p1, p2) -> Double.compare(p2.marketValue(), p1.marketValue()));
        return sortedList;
    }


    /* allocationByAssetClass hasn't been defined in Spec */

    public Map<String, Double> allocationByAssetClass() {
        // TODO
        Map<String, Double> map = new HashMap<>();
        double totalValue = totalMarketValue();
        if (totalValue == 0) return map;
        
        for (Position p : positions) {
            String assetClass = p.getInstrument().assetClass();
            map.put(assetClass, map.getOrDefault(assetClass, 0.0) + p.marketValue());
        }
        
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            entry.setValue((entry.getValue() / totalValue) * 100);
        }
        return map;
    }

    public void revalueAll(PricingStrategy strategy) {
        // TODO
        for (Position p : positions) {
            double newValue = strategy.calculateFairValue(p.getInstrument());
            p.getInstrument().updatePrice(newValue);
        }
        notifyObservers("REVALUED: " + strategy.strategyName());
    }

    @Override
    public void addObserver(Observer<String> observer) {
        // TODO
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<String> observer) {
        // TODO
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        // TODO
        for (Observer<String> obs : observers) {
            obs.onEvent(event);
        }
    }

    public String getPortfolioId() {
        // TODO
        return portfolioId;
    }

    public String getOwnerName() {
        // TODO
        return ownerName;
    }
}
