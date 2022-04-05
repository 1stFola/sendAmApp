package africa.semicolon.sendAm.dtos.responses;

import java.util.ArrayList;
import java.util.List;

public class TrackingPackageResponse {
    private List<TrackingInfo> trackingInfo = new ArrayList<TrackingInfo>();

    public List<TrackingInfo> getTrackingInfo() {
        return trackingInfo;
    }

    public void setTrackingInfo(List<TrackingInfo> trackingInfo) {
        this.trackingInfo = trackingInfo;
    }
}
