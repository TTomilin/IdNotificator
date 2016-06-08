package myapplication.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private CharSequence title;
    private Toolbar toolbar;
    private FragmentDrawer drawerFragment;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        drawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

        displayView(0);
    }

    private void displayView(int position) {
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                currentFragment = new NotificationFragment();
                title = getString(R.string.nav_item_notifications);
                break;
            case 1:
                currentFragment = new SettingsFragment();
                title = getString(R.string.nav_item_settings);
                break;
            case 2:
                currentFragment = new AboutFragment();
                title = getString(R.string.nav_item_about);
                break;
            case 3:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

        if (currentFragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, currentFragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    @Override
    public void setTitle(CharSequence title) {
        this.title = title;
        toolbar.setTitle(title);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Delegate method call to NotificationFragment
    public void setSortingParameter(View view) {
        if (currentFragment instanceof NotificationFragment) {
            ((NotificationFragment) currentFragment).setSortingParameter(view);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.sort_status:
                NotificationFragment.sortingParameters.add(NotificationComparator.SORT_STATUS);
                break;
            case R.id.sort_type:
                NotificationFragment.sortingParameters.add(NotificationComparator.SORT_TYPE);
                break;
            case R.id.sort_method:
                NotificationFragment.sortingParameters.add(NotificationComparator.SORT_METHOD);
                break;
            case R.id.sort_service:
                NotificationFragment.sortingParameters.add(NotificationComparator.SORT_SERVICE);
                break;
            case R.id.sort_date:
                NotificationFragment.sortingParameters.add(NotificationComparator.SORT_DATE);
                break;
        }
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
