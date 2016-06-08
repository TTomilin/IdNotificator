package myapplication.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import myapplication.activity.R;

/**
 * Created by Tristan on 26.04.2016.
 */
public class NavigationViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private ImageView icon;

    public NavigationViewHolder(View itemView) {
        super(itemView);
        this.title = (TextView) itemView.findViewById(R.id.title);
        this.icon = (ImageView) itemView.findViewById(R.id.drawer_row_icon);
    }

    public TextView getTitle() {
        return title;
    }

    public ImageView getIcon() {
        return icon;
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setIcon(int resource) {
        this.icon.setImageResource(resource);
    }
}
