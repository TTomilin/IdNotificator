package myapplication.model;

import myapplication.activity.R;

/**
 * Created by Tristan on 13.04.2016.
 */
public enum TransactionMethod {
    ID_CARD(R.mipmap.id_card),
    MOBILE_ID(R.mipmap.mobile_id);

    private final int resource;

    TransactionMethod(final int value) {
        resource = value;
    }

    public int getResource() { return resource; }
}
