public interface PricingStrategy {
    double calculateFairValue(Instrument instrument);
    String strategyName();
}
