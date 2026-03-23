public class SimplePricingStrategy implements PricingStrategy {
    @Override
    public double calculateFairValue (Instrument instrument){
        return instrument.getCurrentPriceValue() * 1.05;
    }

    @Override
    public String strategyName() {
        return "SimplePricingStrategy";
    }
}