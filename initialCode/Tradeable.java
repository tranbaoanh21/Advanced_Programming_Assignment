public interface Tradeable {
    String getSymbol();

    double getCurrentPriceValue();

    boolean isAvailableForTrading();
    

    default String getTradingInfo() {
        String status = isAvailableForTrading() ? "AVAILABLE" : "UNAVAILABLE";
        return String.format("%s @ %.2f [%s]", getSymbol(), getCurrentPriceValue(), status);
    }
}

