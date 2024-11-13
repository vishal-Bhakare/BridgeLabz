package bridgelabzjava8features;

public class PolicyRiskAssessment {

    private int holderId;
    private String name;
    private double riskScore;

    public PolicyRiskAssessment(int holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public int getHolderId() {
        return holderId;
    }

    public void setHolderId(int holderId) {
        this.holderId = holderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(double riskScore) {
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return "PolicyRiskAssessment{" +
                "holderId='" + holderId + '\'' +
                ", name='" + name + '\'' +
                ", riskScore=" + riskScore +
                '}';
    }
}
