package com.example.carpickerdia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.bumptech.glide.Glide;
import com.example.carpickerdia.viewmodels.HomeAppActivityViewModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class HomeAppActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private HomeAppActivityViewModel viewModel;
    private NavigationView navigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomeAppActivityViewModel.class);
        checkIfSignedIn();
        setContentView(R.layout.activity_home_app);
        prepareToolbar();
        setNavigationViewListener();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_item_car_picker: {
                navController.navigate(R.id.action_nav_main_view_to_nav_info);
                drawerLayout.close();
                break;
            }
            case R.id.nav_item_brand_list: {
                viewModel.getAllBrands();
                navController.navigate(R.id.action_nav_main_view_to_nav_expert_all_brands);
                drawerLayout.close();
                break;
            }
            case R.id.nav_item_map: {
                navController.navigate(R.id.action_nav_main_view_to_nav_map_fragment);
                drawerLayout.close();
                break;
            }
            case R.id.nav_item_feedback: {
                navController.navigate(R.id.action_nav_main_view_to_settingsFragment);
                drawerLayout.close();
                break;
            }
            case R.id.nav_item_logout: {
                viewModel.signOut();
                break;
            }
        }
        return true;
    }

    private void checkIfSignedIn() {
        viewModel.getCurrentUser().observe(this, user -> {
            if (user != null) {
                setNavigationHeader();
            } else {
                startActivity(new Intent(this, LoginActivity.class));
            }
        });
    }

    private void prepareToolbar() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_fragment_main);
        navController = navHostFragment.getNavController();
        drawerLayout = findViewById(R.id.drawer_layout);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(drawerLayout).build();

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    private void setNavigationViewListener() {
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setNavigationHeader() {
        View navHeader = navigationView.getHeaderView(0);
        ImageView avatar = navHeader.findViewById(R.id.img_nav_header);
        TextView userName = navHeader.findViewById(R.id.text_nav_header_name);
        TextView userEmail = navHeader.findViewById(R.id.text_nav_header_email);

       viewModel.getCurrentUser().observe(this, user -> {
            if(user != null){
                userName.setText(user.getDisplayName());
                userEmail.setText(user.getEmail());
                Glide.with(this).load(user.getPhotoUrl()).into(avatar);
            }
        });
    }
}
