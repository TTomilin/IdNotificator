package myapplication.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import myapplication.adapter.NotificationAdapter;
import myapplication.adapter.WrapContentLinearLayoutManager;
import myapplication.comparator.NotificationComparator;
import myapplication.comparator.SortParameter;
import myapplication.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Tristan on 21.04.2016.
 */
public class NotificationFragment extends Fragment {

    private NotificationComparator notificationComparator;
    private WrapContentLinearLayoutManager layoutManager;
    public static List<myapplication.activity.NotificationComparator> sortingParameters = new ArrayList<myapplication.activity.NotificationComparator>();
    private NotificationAdapter adapter;
    private RecyclerView recyclerView;
    private List<Notification> notifications;
    private View sortingParameter;

    public NotificationFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        notificationComparator = new NotificationComparator();
        super.onCreate(savedInstanceState);
    }

    private void displayNotifications() {
        recyclerView.setHasFixedSize(true);
        layoutManager = new WrapContentLinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        List<ParentObject> notifications = getTestList();
        this.adapter = new NotificationAdapter(getContext(), notifications);
        this.adapter.setParentClickableViewAnimationDefaultDuration();
        this.adapter.setParentAndIconExpandOnClick(true);
        this.recyclerView.setAdapter(adapter);
        if (sortingParameter != null) {
            sortingParameter.setBackgroundColor(getResources().getColor(R.color.accent));
        }
    }
    /*
    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
//        Animation anim = super.onCreateAnimation(transit, enter, nextAnim);
        AnimationSet animSet = null;
//        if (anim == null && nextAnim != 0) {
            if (enter) {
                Animation anim = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_up);
                animSet = new AnimationSet(true);
                animSet.addAnimation(anim);
            }
//        }
        return animSet;
    }
    */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notification, container, false);
        this.recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        this.sortingParameter = (View) rootView.findViewById(R.id.header_date);
        displayNotifications();
        return rootView;
    }

    private List<ParentObject> getTestList() {

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm.ss dd.MM.yyyy");
        List<Date> dates = new ArrayList<Date>();

        try {
            dates.add(sdf.parse("13:26.12 21.04.2016"));
            dates.add(sdf.parse("17:03.57 17.04.2016"));
            dates.add(sdf.parse("17:09.34 03.04.2016"));
            dates.add(sdf.parse("09:47.02 23.04.2016"));
            dates.add(sdf.parse("10:01.31 09.04.2016"));
            dates.add(sdf.parse("10:03.25 24.04.2016"));
            dates.add(new Date((new Date().getTime() - 7000)));
            dates.add(new Date(new Date().getTime() - 95000));
            dates.add(new Date(new Date().getTime() - 100000));
            dates.add(new Date(new Date().getTime() - 6000000));
            dates.add(sdf.parse("23:42.29 02.03.2016"));
            dates.add(sdf.parse("03:11.59 14.12.2015"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Notification not1 = new Notification(
                dates.get(0),
                TransactionType.AUTHENTICATION,
                TransactionMethod.MOBILE_ID,
                ServiceProvider.SWEDBANK,
                CertificateStatus.GOOD
        );

        Notification not2 = new Notification(
                dates.get(1),
                TransactionType.AUTHENTICATION,
                TransactionMethod.ID_CARD,
                ServiceProvider.SEB,
                CertificateStatus.GOOD
        );

        Notification not3 = new Notification(
                dates.get(2),
                TransactionType.DIGITAL_SIGNING,
                TransactionMethod.ID_CARD,
                ServiceProvider.EESTI_EE,
                CertificateStatus.GOOD
        );

        Notification not4 = new Notification(
                dates.get(3),
                TransactionType.AUTHENTICATION,
                TransactionMethod.MOBILE_ID,
                ServiceProvider.SWEDBANK,
                CertificateStatus.GOOD
        );

        Notification not5 = new Notification(
                dates.get(4),
                TransactionType.DIGITAL_SIGNING,
                TransactionMethod.MOBILE_ID,
                ServiceProvider.SWEDBANK,
                CertificateStatus.REVOKED
        );

        Notification not6 = new Notification(
                dates.get(5),
                TransactionType.DIGITAL_SIGNING,
                TransactionMethod.MOBILE_ID,
                ServiceProvider.EESTI_EE,
                CertificateStatus.GOOD
        );

        Notification not7 = new Notification(
                dates.get(6),
                TransactionType.AUTHENTICATION,
                TransactionMethod.ID_CARD,
                ServiceProvider.SEB,
                CertificateStatus.GOOD
        );

        Notification not8 = new Notification(
                dates.get(7),
                TransactionType.DIGITAL_SIGNING,
                TransactionMethod.ID_CARD,
                ServiceProvider.SEB,
                CertificateStatus.GOOD
        );

        Notification not9 = new Notification(
                dates.get(8),
                TransactionType.DIGITAL_SIGNING,
                TransactionMethod.ID_CARD,
                ServiceProvider.EESTI_EE,
                CertificateStatus.REVOKED
        );

        Notification not10 = new Notification(
                dates.get(9),
                TransactionType.DIGITAL_SIGNING,
                TransactionMethod.ID_CARD,
                ServiceProvider.SEB,
                CertificateStatus.GOOD
        );

        Notification not11 = new Notification(
                dates.get(10),
                TransactionType.AUTHENTICATION,
                TransactionMethod.MOBILE_ID,
                ServiceProvider.SWEDBANK,
                CertificateStatus.GOOD
        );

        Notification not12 = new Notification(
                dates.get(11),
                TransactionType.AUTHENTICATION,
                TransactionMethod.MOBILE_ID,
                ServiceProvider.SWEDBANK,
                CertificateStatus.GOOD
        );

        notifications = new ArrayList<Notification>();
        notifications.add(not1);
        notifications.add(not2);
        notifications.add(not3);
        notifications.add(not4);
        notifications.add(not5);
        notifications.add(not6);
        notifications.add(not7);
        notifications.add(not8);
        notifications.add(not9);
        notifications.add(not10);
        notifications.add(not11);
        notifications.add(not12);
//        Collections.sort(notifications, decending(getComparator(sortingParameters)));
        Collections.sort(notifications, notificationComparator);

        List<ParentObject> parentList = new ArrayList<ParentObject>();
        for (Notification notification : notifications) {
            ArrayList<Object> childList = new ArrayList<Object>();
            childList.add(new NotificationChild(CertificateStatus.GOOD));
            notification.setChildObjectList(childList);
            parentList.add(notification);
        }
        return parentList;
    }

    public void setSortingParameter(View view) {
        switch(view.getId()) {
            case R.id.header_status:
                notificationComparator.setSortingParameter(SortParameter.STATUS);
                break;
            case R.id.header_type:
                notificationComparator.setSortingParameter(SortParameter.TYPE);
                break;
            case R.id.header_method:
                notificationComparator.setSortingParameter(SortParameter.METHOD);
                break;
            case R.id.header_service:
                notificationComparator.setSortingParameter(SortParameter.SERVICE);
                break;
            case R.id.header_date:
                notificationComparator.setSortingParameter(SortParameter.DATE);
                break;
        }
        Collections.sort(notifications, notificationComparator);
        if (sortingParameter != view) {
            sortingParameter.setBackgroundColor(getResources().getColor(R.color.primary_light));
        }
        sortingParameter = view;
        displayNotifications();
    }

    public Comparator<Notification> descending(final Comparator<Notification> other) {
        return new Comparator<Notification>() {
            public int compare(Notification n1, Notification n2) {
                return -1 * other.compare(n1, n2);
            }
        };
    }

    public Comparator<Notification> getComparator(final List<NotificationComparator> options) {
        return new Comparator<Notification>() {
            public int compare(Notification o1, Notification o2) {
                for (NotificationComparator option : options) {
                    int result = option.compare(o1, o2);
                    if (result != 0) {
                        return result;
                    }
                }
                return 0;
            }
        };
    }
}
