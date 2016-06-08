package myapplication.model;

import android.widget.ImageView;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.Date;
import java.util.List;

/**
 * Created by Tristan on 07.04.2016.
 */
public class Notification implements ParentObject, Comparable<Notification> {

    private Date createdAt;
    private Enum transactionType;
    private Enum transactionMethod;
    private Enum serviceProvider;
    private Enum certificateStatus;
    private List<Object> childrenList;

    public Notification() {

    }

    public Notification(Date createdAt, Enum transactionType, Enum transactionMethod, Enum serviceProvider, Enum certificateStatus) {
        this.createdAt = createdAt;
        this.transactionType = transactionType;
        this.certificateStatus = certificateStatus;
        this.serviceProvider = serviceProvider;
        this.transactionMethod = transactionMethod;
    }

    @Override
    public int compareTo(Notification notification) {
        if (this.getCreatedAt().getTime() > notification.getCreatedAt().getTime()) {
            return -1;
        } else if (this.getCreatedAt().getTime() < notification.getCreatedAt().getTime()) {
            return 1;
        }
        return 0;
    }

    @Override
    public List<Object> getChildObjectList() {
        return childrenList;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        childrenList = list;
    }

    public Enum getCertificateStatus() {
        return certificateStatus;
    }

    public void setCertificateStatus(Enum certificateStatus) {
        this.certificateStatus = certificateStatus;
    }

    public Enum getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Enum type) {
        this.transactionType = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Enum getTransactionMethod() {
        return transactionMethod;
    }

    public void setTransactionMethod(Enum transactionMethod) {
        this.transactionMethod = transactionMethod;
    }

    public Enum getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(Enum serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}
