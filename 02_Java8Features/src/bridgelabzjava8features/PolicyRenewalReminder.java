package bridgelabzjava8features;

public class PolicyRenewalReminder {

    private int policyId;
    private String policyHolderId;
    private long remainingDays;

    public PolicyRenewalReminder(int policyId, String policyHolderId, long remainingDays) {
        this.policyId = policyId;
        this.policyHolderId = policyHolderId;
        this.remainingDays = remainingDays;
    }

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public String getPolicyHolderId() {
        return policyHolderId;
    }

    public void setPolicyHolderId(String policyHolderId) {
        this.policyHolderId = policyHolderId;
    }

    public long getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(long remainingDays) {
        this.remainingDays = remainingDays;
    }

    @Override
    public String toString() {
        return "PolicyRenewalReminder{" +
                "policyId='" + policyId + '\'' +
                ", policyHolderId='" + policyHolderId + '\'' +
                ", remainingDays=" + remainingDays +
                '}';
    }
}
