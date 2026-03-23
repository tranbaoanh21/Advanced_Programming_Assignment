public interface InstrumentVisitor {
    void visit(Stock stock);
    void visit(Bond bond);
    void visit(Option option);
    void visit(Future future);
}