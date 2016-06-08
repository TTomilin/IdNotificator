package myapplication.model;

/**
 * Created by Tristan on 17.04.2016.
 */
public class NotificationChild {

    private Enum certificateStatus;

    public NotificationChild(Enum certificateStatus) {
        this.certificateStatus = certificateStatus;
    }

    public Enum getCertificateStatus() {
        return certificateStatus;
    }

    public void setCertificateStatus(Enum certificateStatus) {
        this.certificateStatus = certificateStatus;
    }
}
