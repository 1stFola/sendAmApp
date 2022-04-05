package africa.semicolon.sendAm.dtos.responses;

public class TrackingInfo {

    private String dateTime;
    private String information;

    public String getDateTime(String format) {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

}
