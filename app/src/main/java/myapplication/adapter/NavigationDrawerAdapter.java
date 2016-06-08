package myapplication.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import myapplication.activity.R;
import myapplication.model.NavDrawerItem;
import myapplication.model.NavigationViewHolder;

import java.util.Collections;
import java.util.List;

/**
 * Created by Tristan on 20.04.2016.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationViewHolder> {
    private List<NavDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(Context context, List<NavDrawerItem> data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public NavigationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        NavigationViewHolder holder = new NavigationViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NavigationViewHolder holder, int position) {
        NavDrawerItem current = data.get(position);
        holder.setTitle(current.getTitle());
        holder.setIcon(current.getIcon());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}