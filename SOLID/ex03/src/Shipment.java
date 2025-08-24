public class Shipment {
    String type;
    double weightKg;

    Shipment(String type, double w) {
        this.type = type;
        this.weightKg = w;
    }

    public String getType() {
        return type;
    }

    public double getWeightKg() {
        return weightKg;
    }
}
