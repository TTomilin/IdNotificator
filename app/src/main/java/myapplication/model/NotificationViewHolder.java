package myapplication.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import myapplication.activity.R;
import myapplication.adapter.ViewHolderClicks;

/**
 * Created by Tristan on 26.04.2016.
 */
public class NotificationViewHolder extends ParentViewHolder /*implements View.OnClickListener*/ {

    private TextView created;
    private ImageView transactionType;
    private ImageView transactionMethod;
    private ImageView serviceProvider;
    private ImageView certificateStatus;
    private ViewHolderClicks onClickListener;

    public NotificationViewHolder(View view, ViewHolderClicks onClickListener) {
        super(view);
        this.onClickListener = onClickListener;

        this.created = (TextView) view.findViewById(R.id.created_at);
        this.transactionType = (ImageView) view.findViewById(R.id.transaction_type);
        this.transactionMethod = (ImageView) view.findViewById(R.id.transaction_method);
        this.serviceProvider = (ImageView) view.findViewById(R.id.service_provider);
        this.certificateStatus = (ImageView) view.findViewById(R.id.certificate_status);

        this.created.setOnClickListener(this);
        this.transactionType.setOnClickListener(this);
        this.transactionMethod.setOnClickListener(this);
        this.serviceProvider.setOnClickListener(this);
        this.certificateStatus.setOnClickListener(this);
    }

    public TextView getCreated() {
        return created;
    }

    public ImageView getTransactionType() {
        return transactionType;
    }

    public ImageView getTransactionMethod() {
        return transactionMethod;
    }

    public ImageView getServiceProvider() {
        return serviceProvider;
    }

    public ImageView getCertificateStatus() {
        return certificateStatus;
    }

/*@Override
    public void onClick(View v) {
        if (v instanceof ImageView){
            onClickListener.onImageClick((ImageView)v);
        } else {
            onClickListener.onTextClick(v);
        }
    }*/
}
