package myapplication.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import myapplication.activity.R;
import myapplication.model.*;

import java.util.List;
import java.util.Locale;

/**
 * Created by Tristan on 07.04.2016.
 */
public class NotificationAdapter extends ExpandableRecyclerAdapter<NotificationViewHolder, NotificationChildViewHolder> {

    private Context context;
    private List<ParentObject> notifications;
    private LayoutInflater inflater;

    public NotificationAdapter(Context context, List<ParentObject> notifications) {
        super(context, notifications);
        this.context = context;
        this.notifications = notifications;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public NotificationViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.item_notification, viewGroup, false);
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.slide_up);
        view.setAnimation(anim);
        NotificationViewHolder viewHolder = new NotificationViewHolder(view, null);
        /*NotificationAdapter.NotificationViewHolder viewHolder = new NotificationViewHolder(view, new ViewHolderClicks() {
            public void onPotato(View caller) {
                Log.d("onCreateViewHolder", "View 1 clicked");
            };
            public void onTomato(ImageView callerImage) {
                Log.d("onCreateViewHolder", "View 2 clicked");
            }
        });*/
        return viewHolder;
    }

    @Override
    public NotificationChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.item_notification_child, viewGroup, false);
        NotificationChildViewHolder childViewHolder = new NotificationChildViewHolder(view, null);
        /*NotificationAdapter.NotificationChildViewHolder childViewHolder = new NotificationChildViewHolder(view, new ViewHolderClicks() {
            public void onPotato(View caller) {
                Log.d("onCreateViewHolder", "View 1 clicked");
            };
            public void onTomato(ImageView callerImage) {
                Log.d("onCreateViewHolder", "View 2 clicked");
            }
        });*/
        return childViewHolder;
    }

    @Override
    public void onBindParentViewHolder(NotificationViewHolder viewHolder, int i, Object parentObject) {
        Notification notification = (Notification) parentObject;

        TransactionMethod method = TransactionMethod.valueOf(notification.getTransactionMethod().name());
        TransactionType type = TransactionType.valueOf(notification.getTransactionType().name());
        ServiceProvider provider = ServiceProvider.valueOf(notification.getServiceProvider().name());
        CertificateStatus status = CertificateStatus.valueOf(notification.getCertificateStatus().name());

        final CharSequence relativeTimeSpan = DateUtils.getRelativeTimeSpanString(notification.getCreatedAt().getTime(), System.currentTimeMillis(), 0);
//        PrettyTime p = new PrettyTime(new Locale("et"));

//        viewHolder.created.setText(p.format(notification.getCreatedAt()));
        viewHolder.getCreated().setText(relativeTimeSpan);
//        viewHolder.getTransactionType().setImageResource(type.getResource());
//        viewHolder.getTransactionMethod().setImageResource(method.getResource());
//        viewHolder.getServiceProvider().setImageResource(provider.getResource());
//        viewHolder.getCertificateStatus().setImageResource(status.getResource());
        viewHolder.getTransactionType().setImageBitmap(decodeSampledBitmapFromResource(context.getResources(), type.getResource(), 100, 100));
        viewHolder.getTransactionMethod().setImageBitmap(decodeSampledBitmapFromResource(context.getResources(), method.getResource(), 100, 100));
        viewHolder.getServiceProvider().setImageBitmap(decodeSampledBitmapFromResource(context.getResources(), provider.getResource(), 100, 100));
        viewHolder.getCertificateStatus().setImageBitmap(decodeSampledBitmapFromResource(context.getResources(), status.getResource(), 100, 100));
    }

    @Override
    public void onBindChildViewHolder(NotificationChildViewHolder childViewHolder, int i, Object childObject) {
        NotificationChild notificationChild = (NotificationChild) childObject;
        childViewHolder.getTransactionStatus().setText("lorem ipsum dolor sit amet");
    }

    @Override
    public int getItemCount() {
        return (notifications != null ? notifications.size() : 0);
    }

    private Bitmap resizeImage(int resource, float multiplier) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resource);
        float scaleWidth = multiplier * bitmap.getWidth();
        float scaleHeight = multiplier * bitmap.getHeight();

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);

        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return resizedBitmap;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}

