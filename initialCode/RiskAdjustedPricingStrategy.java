public class RiskAdjustedPricingStrategy implements PricingStrategy {
    @Override
    public double calculateFairValue(Instrument instrument) {
        return instrument.getCurrentPriceValue() * (1 + 0.01 * instrument.riskScore());
    }
    
    @Override
    public String strategyName() {
        return "RiskAdjustedPricingStrategy";
    }
}