public interface Priceable {
    double getCurrentPriceValue();

    double getPriceChange(double previousPrice);

    double getPriceChangePercent(double previousPrice);
}
