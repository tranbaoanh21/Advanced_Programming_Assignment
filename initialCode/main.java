import java.util.*;

public class main {
    public static void main(String[] args) {
        try {
            System.out.println("=== RUNNING ALL TEST CASES ===\n");

            // --- Problem 1: Stock ---
            Stock s = new Stock("AAPL", "Apple Inc.", 189.50, 3e12, "Technology");
            assertEqStr("TC1a Stock assetClass", "EQUITY", s.assetClass());
            assertEqDouble("TC1b Stock largeCap risk", 3.0, s.riskScore(), 0.001);

            // --- Problem 2: Bond ---
            Bond bShort = new Bond("US2Y", "US Treasury 2Y", 100.0, 4.5, 2);
            assertEqStr("TC1a Bond assetClass", "FIXED_INCOME", bShort.assetClass());
            assertEqDouble("TC1b Bond shortMaturity risk", 2.0, bShort.riskScore(), 0.001);

            // --- Problem 3: Option ---
            Option callOpt = new Option("AAPL-C", "AAPL Call 200", 185.0, 200.0, true, 30);
            assertEqBool("TC1a Call ITM spot above strike", true, callOpt.isInTheMoney(210.0));
            assertEqBool("TC1b Call OTM spot below strike", false, callOpt.isInTheMoney(190.0));

            // --- Problem 4: Strategy Pattern ---
            Stock sGoog = new Stock("GOOG", "Alphabet", 140.0, 2e12, "Tech");
            PricingStrategy simple = new SimplePricingStrategy();
            assertEqDouble("TC1a SimplePricing fairValue", 147.0, simple.calculateFairValue(sGoog), 0.001);
            assertEqStr("TC1b SimplePricing strategyName", "SimplePricingStrategy", simple.strategyName());

            // --- Problem 5: Priceable Interface ---
            Stock sP = new Stock("AAPL", "Apple", 189.0, 3e12, "Tech");
            assertEqDouble("TC1a Priceable getCurrentPriceValue", 189.0, ((Priceable)sP).getCurrentPriceValue(), 0.001);
            double change = ((Priceable)sP).getPriceChange(180.0);
            assertEqDouble("TC1b Priceable getPriceChange", 9.0, change, 0.001);
            double pct = ((Priceable)sP).getPriceChangePercent(180.0);
            assertEqDouble("TC1c Priceable getPriceChangePercent", 5.0, pct, 0.001);

            // --- Problem 6: Position & Portfolio ---
            Stock sTsla = new Stock("TSLA", "Tesla", 200.0, 6e11, "Auto");
            Position pos = new Position(sTsla, 10, 180.0);
            assertEqDouble("TC1a Position marketValue", 2000.0, pos.marketValue(), 0.001);
            assertEqDouble("TC1b Position unrealizedPnL", 200.0, pos.unrealizedPnL(), 0.001);
            
            Portfolio p = new Portfolio("PF001", "Alice");
            p.addPosition(sP, 5, 170.0);
            assertEqInt("TC2a Portfolio getPosition qty", 5, p.getPosition("AAPL").getQuantity());
            p.removePosition("AAPL");
            assertThrows("TC2b Portfolio removed position throws", PositionNotFoundException.class, () -> {
                try { p.getPosition("AAPL"); } catch (PositionNotFoundException e) { throw new RuntimeException(e); }
            });

            // --- Problem 7: Risk Analyzer ---
            RiskAnalyzer<Stock> ra = new RiskAnalyzer<>();
            ra.add(new Stock("A", "A", 100.0, 3e12, "Tech")); // risk 3.0
            ra.add(new Stock("B", "B", 50.0, 5e8, "Retail")); // risk 7.5
            assertEqDouble("TC1a averageRisk", 5.25, ra.averageRisk(), 0.001);
            assertEqStr("TC1b highestRisk symbol", "B", ra.highestRisk().getSymbol());
            assertEqStr("TC1c lowestRisk symbol", "A", ra.lowestRisk().getSymbol());

            // --- Problem 8: Visitor Pattern ---
            TaxReportVisitor visitor = new TaxReportVisitor();
            Stock sTax = new Stock("AAPL", "Apple", 200.0, 3e12, "Tech");
            sTax.accept(visitor);
            assertEqDouble("TC1a Stock tax = 200*0.15 = 30", 30.0, visitor.getTotalTaxLiability(), 0.001);

            System.out.println("\n=== ALL TESTS COMPLETED ===");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --- Helper Assertion Methods ---
    public static void assertEqStr(String name, String exp, String act) {
        if (exp.equals(act)) System.out.println("[PASSED] " + name);
        else System.out.println("[FAILED] " + name + " | Exp: " + exp + ", Act: " + act);
    }

    public static void assertEqDouble(String name, double exp, double act, double delta) {
        if (Math.abs(exp - act) <= delta) System.out.println("[PASSED] " + name);
        else System.out.println("[FAILED] " + name + " | Exp: " + exp + ", Act: " + act);
    }

    public static void assertEqBool(String name, boolean exp, boolean act) {
        if (exp == act) System.out.println("[PASSED] " + name);
        else System.out.println("[FAILED] " + name + " | Exp: " + exp + ", Act: " + act);
    }

    public static void assertEqInt(String name, int exp, int act) {
        if (exp == act) System.out.println("[PASSED] " + name);
        else System.out.println("[FAILED] " + name + " | Exp: " + exp + ", Act: " + act);
    }

    public static void assertThrows(String name, Class<? extends Throwable> exceptionClass, Runnable runnable) {
        try {
            runnable.run();
            System.out.println("[FAILED] " + name + " | Expected exception: " + exceptionClass.getSimpleName());
        } catch (Exception e) {
            System.out.println("[PASSED] " + name);
        }
    }
}