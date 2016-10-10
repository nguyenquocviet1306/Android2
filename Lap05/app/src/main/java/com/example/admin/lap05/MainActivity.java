package com.example.admin.lap05;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    private boolean menusendVisible = true;
    private boolean menusearchVisible = true;
    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        showActionBar(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean ret =  super.onPrepareOptionsMenu(menu);
        MenuItem sendMenuItem = menu.findItem(R.id.action_send);
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        sendMenuItem.setVisible(menusendVisible);
        searchMenuItem.setVisible(menusearchVisible);

        return ret;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id) {
            case R.id.action_send:
                openFragment(new AmoutFragment(),true);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openFragment(Fragment fragment, boolean addToBackStack){

        if (addToBackStack) {
            getSupportFragmentManager().beginTransaction().replace(
                   R.id.drawer_layout, fragment).addToBackStack(null).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout,fragment).commit();
        }

    }
    public void setDefaultMain() {
        //edit toggle
        //remove basic
        toggle.setDrawerIndicatorEnabled(false);
        //set icon
        toggle.setHomeAsUpIndicator(R.drawable.ic_menu_black_24px);
        //add Listener
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
                toggle.syncState();
            }
        });
    }


    private void changeFragment(Fragment fragment, boolean addToBackStack){
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container,fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();


    }



    public void showActionBar(boolean visible) {
        if (visible) {
            getSupportActionBar().show();
        } else {
            getSupportActionBar().hide();
        }
    }
    public void showSendMenu(boolean visible) {
        this.menusendVisible = visible;
        this.invalidateOptionsMenu();
    }
    public void showSearchMenu(boolean visible) {
        this.menusearchVisible = visible;
        this.invalidateOptionsMenu();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_article) {
            setTitle("Article");

//            openFragment(new ArticleFragment(),true);
           changeFragment(new ArticleFragment(),true);

        } else if (id == R.id.nav_pay) {
            setTitle("Pay");

            changeFragment(new PayFragment(),true);
        } else if (id == R.id.nav_setting) {
            setTitle("Setting");

            changeFragment(new SettingFragment(),true);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
