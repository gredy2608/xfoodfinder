package schronic.xfoodfinder;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setScrimColor(Color.TRANSPARENT);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        FragmentManager fm = getFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        HomeFragment home_frag = new HomeFragment();

        ft.add(R.id.fragment_main_container,home_frag);

        ft.addToBackStack(null);

        ft.commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fm = getFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        if(id == R.id.nav_promo){


            PromoFragment promo_frag = new PromoFragment();

            ft.replace(R.id.fragment_main_container,promo_frag);
            ft.addToBackStack("promo");

        }
        else if(id == R.id.nav_newresto){

            HomeFragment home_frag = new HomeFragment();

            home_frag.jenis = 1;

            ft.replace(R.id.fragment_main_container, home_frag);

            ft.addToBackStack("home");


        }
        else if(id == R.id.nav_barat_kategori){
            HomeFragment home_frag = new HomeFragment();

            home_frag.jenis = 2;

            ft.replace(R.id.fragment_main_container, home_frag);

            ft.addToBackStack("barat");
        }
        else if(id == R.id.nav_cn_kategori){
            HomeFragment home_frag = new HomeFragment();

            home_frag.jenis = 3;

            ft.replace(R.id.fragment_main_container, home_frag);
            ft.addToBackStack("chinese");
        }
        else if(id == R.id.nav_jp_kategori){
            HomeFragment home_frag = new HomeFragment();

            home_frag.jenis = 4;

            ft.replace(R.id.fragment_main_container, home_frag);

            ft.addToBackStack("jepang");
        }
        else if(id == R.id.nav_id_kategori){
            HomeFragment home_frag = new HomeFragment();

            home_frag.jenis = 5;

            ft.replace(R.id.fragment_main_container, home_frag);

            ft.addToBackStack("indonesia");
        }
        else if(id == R.id.nav_korea_kategori){
            HomeFragment home_frag = new HomeFragment();

            home_frag.jenis = 6;

            ft.replace(R.id.fragment_main_container, home_frag);
            ft.addToBackStack("korea");
        }



        ft.commit();
        /*if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onClickHomeButton(View view){
        FragmentManager fm = getFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        HomeFragment home_frag = new HomeFragment();

        ft.replace(R.id.fragment_main_container, home_frag);

        ft.addToBackStack("home");

        ft.commit();
    }

    public void onClickSearchButton(View view){
        FragmentManager fm = getFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        SearchFragment search_frag = new SearchFragment();

        ft.replace(R.id.fragment_main_container,search_frag);

        ft.addToBackStack("search");

        ft.commit();
    }

    public void onClickInfoDetail(View view){

        if(findViewById(R.id.detail_info_extend).getVisibility() == View.VISIBLE){
            findViewById(R.id.detail_info_extend).setVisibility(View.GONE);
        }
        else{
            findViewById(R.id.detail_info_extend).setVisibility(View.VISIBLE);
        }

    }

    public void onClickMenuDetail(View view){
        if(findViewById(R.id.detail_menu_extend).getVisibility() == View.VISIBLE){
            findViewById(R.id.detail_menu_extend).setVisibility(View.GONE);
        }
        else{
            findViewById(R.id.detail_menu_extend).setVisibility(View.VISIBLE);
        }
    }



    public void onClickDirectionDetail(View view){
        if(findViewById(R.id.detail_direction_extend).getVisibility() == View.VISIBLE){
            findViewById(R.id.detail_direction_extend).setVisibility(View.GONE);
        }
        else{
            findViewById(R.id.detail_direction_extend).setVisibility(View.VISIBLE);
        }
    }

    public void onClickGalleryDetail(View view){
        if(findViewById(R.id.detail_gallery_extend).getVisibility() == View.VISIBLE){
            findViewById(R.id.detail_gallery_extend).setVisibility(View.GONE);
        }
        else{
            findViewById(R.id.detail_gallery_extend).setVisibility(View.VISIBLE);
        }
    }

    public void onClickReviewDetail(View view){
        if(findViewById(R.id.detail_review_extend).getVisibility() == View.VISIBLE){
            findViewById(R.id.detail_review_extend).setVisibility(View.GONE);
        }
        else{
            findViewById(R.id.detail_review_extend).setVisibility(View.VISIBLE);
        }
    }

    public void showDialogBooking(View view){
        FragmentManager fm = getFragmentManager();

        BookFragment bf = new BookFragment();

        bf.show(fm,"Book Fragment");
    }

    public void showDialogRate(View view){
        FragmentManager fm = getFragmentManager();

        RateFragment rf = new RateFragment();

        rf.show(fm,"Book Fragment");
    }

    public void showReview(View view){
        EditText editText = (EditText)findViewById(R.id.user_review_new);

        LinearLayout new_review_container = (LinearLayout)findViewById(R.id.review_new_container);

        TextView custom_new_review = (TextView)findViewById(R.id.review_add_custom_text);

        custom_new_review.setText(editText.getText().toString());

        new_review_container.setVisibility(View.VISIBLE);
    }


}
