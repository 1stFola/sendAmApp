package africa.semicolon.sendAm.dtos.requests;

public class UpdateTrackingInfoRequest {
    private int trackingNumber;
    private String trackingInfo;

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingInfo() {
        return trackingInfo;
    }

    public void setTrackingInfo(String trackingInfo) {
        this.trackingInfo = trackingInfo;
    }
}
