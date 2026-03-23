public abstract class Derivative extends Instrument {

    public Derivative(String symbol, String name, double currentPrice) {
        super(symbol, name, currentPrice);
    }

    
    @Override
    public String assetClass() {
        return "DERIVATIVE";
    }
}
