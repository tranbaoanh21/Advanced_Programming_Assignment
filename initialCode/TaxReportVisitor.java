public class TaxReportVisitor implements InstrumentVisitor {
    private double totalTaxLiability = 0.0;
    private StringBuilder reportBuilder = new StringBuilder();

    @Override
    public void visit(Stock stock) {
        // stock 
        double tax = stock.getCurrentPriceValue() * 0.15;
        totalTaxLiability += tax;
        reportBuilder.append("Stock ").append(stock.getSymbol())
                     .append(" Tax: $").append(String.format("%.2f", tax)).append("\n");
    }

    @Override
    public void visit(Bond bond) {
        // bond
        double tax = bond.annualCouponPayment(1) * 0.30;
        totalTaxLiability += tax;
        reportBuilder.append("Bond ").append(bond.getSymbol())
                     .append(" Tax: $").append(String.format("%.2f", tax)).append("\n");
    }

    @Override
    public void visit(Option option) {
        // option
        double tax = option.getCurrentPriceValue() * 0.20;
        totalTaxLiability += tax;
        reportBuilder.append("Option ").append(option.getSymbol())
                     .append(" Tax: $").append(String.format("%.2f", tax)).append("\n");
    }

    @Override
    public void visit(Future future) {
        // future
        double tax = future.getCurrentPriceValue() * 0.20;
        totalTaxLiability += tax;
        reportBuilder.append("Future ").append(future.getSymbol())
                     .append(" Tax: $").append(String.format("%.2f", tax)).append("\n");
    }

    public double getTotalTaxLiability() {
        return totalTaxLiability; // total Tax Liability
    }

    public String getReport() {
        // Tax report
        return "--- TAX REPORT ---\n" + 
               reportBuilder.toString() + 
               "Total Tax Liability: $" + String.format("%.2f", totalTaxLiability);
    }
}