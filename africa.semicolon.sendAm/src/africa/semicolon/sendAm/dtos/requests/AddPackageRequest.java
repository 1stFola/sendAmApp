package africa.semicolon.sendAm.dtos.requests;

public class AddPackageRequest {

    private String name;
    private double weightInGrammes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeightInGrammes() {
        return weightInGrammes;
    }

    public void setWeightInGrammes(double weightInGrammes) {
        this.weightInGrammes = weightInGrammes;
    }

}
