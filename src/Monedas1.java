import java.util.Map;

public class Monedas1 {
    private String base_code;
    
    private Map<String, Double> conversion_rates;

    public Monedas1(Map<String, Double> conversion_rates, String base_code) {
        this.conversion_rates = conversion_rates;
        this.base_code = base_code;
    }

    public Monedas1() {
    }

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    @Override
    public String toString() {
        return "Monedas1{" +
                "base_code='" + base_code + '\'' +
                ", conversion_rates=" + conversion_rates +
                '}';
    }
}
