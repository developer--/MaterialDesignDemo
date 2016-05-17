package com.myproject.materialdesigndemo;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton myFabButton;
    private CoordinatorLayout coordinatorLayout;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.my_coord_layout_id);
        initFabButton();


        initDrawer();


        initnavigationView();
    }


    private void initFabButton(){
        myFabButton = (FloatingActionButton) findViewById(R.id.fab_button_id);
        myFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "hello", Snackbar.LENGTH_SHORT)
                        .setAction("undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "წაშლა გაუქმდა", Toast.LENGTH_SHORT).show();
                            }
                        });
                snackbar.show();
            }
        });

    }

    private void initToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        assert actionBar != null;
        actionBar.setDisplayShowTitleEnabled(false);
    }

    private void initDrawer(){

        drawerLayout = (DrawerLayout) findViewById(R.id.my_drawer_layout_id);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout,toolbar,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
//                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(MainActivity.this, "ღიაა", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(MainActivity.this, "დახურულია", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        drawerToggle.syncState();
    }


    private void initnavigationView(){
        navigationView = (NavigationView) findViewById(R.id.navigation_view_id);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (item.getItemId()) {
                    case R.id.drawer_home:
                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.drawer_favourite:
                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_settings:
                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }

}
