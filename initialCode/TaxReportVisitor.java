public class TaxReportVisitor implements InstrumentVisitor {
    private double totalTaxLiability = 0.0;
    private String reportContent = ""; 

    @Override
    public void visit(Stock stock) {
        double tax = stock.getCurrentPriceValue() * 0.15;
        this.totalTaxLiability += tax;
        this.reportContent += "Stock [" + stock.getSymbol() + "] - Tax: $" + String.format("%.2f", tax) + "\n";
    }

    @Override
    public void visit(Bond bond) {
        double tax = bond.annualCouponPayment(1) * 0.30;
        this.totalTaxLiability += tax;
        this.reportContent += "Bond [" + bond.getSymbol() + "] - Tax: $" + String.format("%.2f", tax) + "\n";
    }

    @Override
    public void visit(Option option) {
        double tax = option.getCurrentPriceValue() * 0.20;
        this.totalTaxLiability += tax;
        this.reportContent += "Option [" + option.getSymbol() + "] - Tax: $" + String.format("%.2f", tax) + "\n";
    }

    @Override
    public void visit(Future future) {
        double tax = future.getCurrentPriceValue() * 0.20;
        this.totalTaxLiability += tax;
        this.reportContent += "Future [" + future.getSymbol() + "] - Tax: $" + String.format("%.2f", tax) + "\n";
    }

    public double getTotalTaxLiability() {
        return this.totalTaxLiability;
    }

    public String getReport() {
        String finalReport = "=== TAX REPORT ===\n";
        finalReport += this.reportContent;
        finalReport += "------------------\n";
        finalReport += "Total Liability: $" + String.format("%.2f", this.totalTaxLiability);
        
        return finalReport;
    }
}