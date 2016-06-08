package myapplication.model;

import myapplication.activity.R;

/**
 * Created by Tristan on 13.04.2016.
 */
public enum ServiceProvider {
    SEB(R.mipmap.seb),
    SWEDBANK(R.mipmap.ic_swedbank),
    EESTI_EE(R.mipmap.ic_eesti);

    private final int resource;

    ServiceProvider(final int value) {
        resource = value;
    }

    public int getResource() { return resource; }
}
