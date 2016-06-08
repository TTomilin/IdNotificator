package myapplication.activity;

import myapplication.model.Notification;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Tristan on 27.04.2016.
 */
public enum NotificationComparator implements Comparator<Notification> {
    SORT_STATUS {
        public int compare(Notification n1, Notification n2) {
            return n1.getCertificateStatus().compareTo(n2.getCertificateStatus());
        }
    },
    SORT_TYPE {
        public int compare(Notification n1, Notification n2) {
            return n1.getTransactionType().compareTo(n2.getTransactionType());
        }
    },
    SORT_METHOD {
        public int compare(Notification n1, Notification n2) {
            return n1.getTransactionMethod().compareTo(n2.getTransactionMethod());
        }
    },
    SORT_SERVICE {
        public int compare(Notification n1, Notification n2) {
            return n1.getServiceProvider().compareTo(n2.getServiceProvider());
        }
    },
    SORT_DATE {
        public int compare(Notification n1, Notification n2) {
            return n1.getCreatedAt().compareTo(n2.getCreatedAt());
        }
    };
}