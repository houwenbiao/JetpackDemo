/**
 * Created with JackHou
 * Date: 2021/2/25
 * Time: 11:06
 * Description:
 */

package com.qtimes.jetpackdemo.ui.activity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.qtimes.jetpackdemo.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationView = findViewById(R.id.nav_view);
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.main_fragment);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            NavigationUI.setupWithNavController(mBottomNavigationView, navController);
        }
    }
}
