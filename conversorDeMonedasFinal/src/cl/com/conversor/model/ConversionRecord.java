package cl.com.conversor.model;

public class ConversionRecord {
    private final String fromCurrency;
    private final String toCurrency;
    private final double amount;
    private final double result;
    private final double rate;

    public ConversionRecord(String fromCurrency, String toCurrency, double amount, double result, double rate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.result = result;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s -> %.2f %s (Tasa: %.4f)", amount, fromCurrency, result, toCurrency, rate);
    }
}
