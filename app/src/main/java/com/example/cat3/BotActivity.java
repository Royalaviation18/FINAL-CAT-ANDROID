package com.example.cat3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BotActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);
        getSupportActionBar().hide();
        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnItemReselectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new AndFragment()).commit();
    }

    private NavigationBarView.OnItemReselectedListener navListener = new NavigationBarView.OnItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_mobile:
                    selectedFragment = new AndFragment();
                    break;

                case R.id.nav_ml:
                    selectedFragment = new MLFragment();
                    break;

                case R.id.nav_dekr:
                    selectedFragment = new DEKRFragment();
                    break;

                case R.id.nav_nlp:
                    selectedFragment = new NLPFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
        }


    };
}