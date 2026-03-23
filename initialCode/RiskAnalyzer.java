import java.util.*;

public class RiskAnalyzer<T extends Instrument> {
    private final List<T> instruments = new ArrayList<>();

    public void add(T instrument) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public double averageRisk() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public T highestRisk() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public T lowestRisk() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public List<T> getAboveRiskThreshold(double threshold) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }
}
