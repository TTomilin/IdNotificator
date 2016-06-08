package myapplication.comparator;

import myapplication.model.Notification;

import java.util.Comparator;

/**
 * Created by Tristan on 27.04.2016.
 */
public class NotificationComparator implements Comparator<Notification> {

    private SortParameter sortingParameter;
    private boolean descending;

    public NotificationComparator() {
        descending = false;
        sortingParameter = SortParameter.DATE;
    }

    public int compare(Notification n1, Notification n2) {
        int result;
        switch (sortingParameter) {
            case STATUS:
                result = n1.getCertificateStatus().compareTo(n2.getCertificateStatus());
                break;
            case TYPE:
                result = n1.getTransactionType().compareTo(n2.getTransactionType());
                break;
            case METHOD:
                result = n1.getTransactionMethod().compareTo(n2.getTransactionMethod());
                break;
            case SERVICE:
                result = n1.getServiceProvider().compareTo(n2.getServiceProvider());
                break;
            case DATE:
                result = n1.getCreatedAt().compareTo(n2.getCreatedAt()) * -1;
                break;
            default:
                result = n1.getCreatedAt().compareTo(n2.getCreatedAt()) * -1;
        }
        return result * (descending ? -1 : 1);
    }

    public SortParameter getSortingParameter() {
        return sortingParameter;
    }

    public void setSortingParameter(SortParameter sortingParameter) {
        if (this.sortingParameter == sortingParameter) {
            descending = descending ? false : true;
        }
        this.sortingParameter = sortingParameter;
    }
}
