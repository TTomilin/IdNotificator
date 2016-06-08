package myapplication.model;

import myapplication.activity.R;

/**
 * Created by Tristan on 17.04.2016.
 */
public enum CertificateStatus {
    GOOD(R.drawable.ic_check_circle_black_24dp),
    REVOKED(R.drawable.ic_cancel_black_24dp);

    private final int resource;

    CertificateStatus(final int value) {
        resource = value;
    }

    public int getResource() { return resource; }
}
