package myapplication.model;

import myapplication.activity.R;

/**
 * Created by Tristan on 24.04.2016.
 */
public enum TransactionType {
    AUTHENTICATION(R.drawable.ic_fingerprint),
    DIGITAL_SIGNING(R.mipmap.ic_digisign);

    private final int resource;

    TransactionType(final int value) {
        resource = value;
    }

    public int getResource() { return resource; }
}
