package com.pucese.appturistica.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pucese.appturistica.R;
import com.pucese.appturistica.view.fragment.*;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity {

    BottomNavigationView mbottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        mbottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        //Para seleccionar home por defecto
        mbottomNavigation.getMenu().findItem(R.id.thome).setChecked(true); showSelectedFragment(new HomeFragment());

        mbottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.thome) {
                    showSelectedFragment(new HomeFragment());
                }

                if(menuItem.getItemId() == R.id.tprofile) {
                    showSelectedFragment(new ProfileFragment());
                }

                if(menuItem.getItemId() == R.id.tsearch) {
                    showSelectedFragment(new SearchFragment());
                }

                if(menuItem.getItemId() == R.id.tcamera) {
                    showSelectedFragment(new ProfileFragment());
                }

                if(menuItem.getItemId() == R.id.tfavorite) {
                    showSelectedFragment(new SearchFragment());
                }

                return true;
            }
        });

        /*BottomBar bottomBar=(BottomBar) findViewById(R.id.bottombar);
        bottomBar.setDefaultTab(R.id.home);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId)
                {
                    case R.id.home:
                        HomeFragment homeFragment=new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment )
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.profile:
                        ProfileFragment profileFragment=new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment )
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.search:
                        SearchFragment searchFragment=new SearchFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, searchFragment )
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                }
            }
        });*/
    }

    private void showSelectedFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

}