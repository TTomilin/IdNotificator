package myapplication.model;

import android.view.View;
import android.widget.TextView;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import myapplication.activity.R;
import myapplication.adapter.ViewHolderClicks;

/**
 * Created by Tristan on 26.04.2016.
 */
public class NotificationChildViewHolder extends ChildViewHolder {

    private TextView transactionStatus;
    private ViewHolderClicks onClickListener;

    public NotificationChildViewHolder(View view, ViewHolderClicks onClickListener) {
        super(view);
        this.onClickListener = onClickListener;
        this.transactionStatus = (TextView) itemView.findViewById(R.id.test_text);
    }

    public TextView getTransactionStatus() {
        return transactionStatus;
    }
}
