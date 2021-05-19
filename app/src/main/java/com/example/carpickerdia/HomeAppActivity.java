package com.example.carpickerdia;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.carpickerdia.viewmodels.mainapp.HomeAppActivityViewModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class HomeAppActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private HomeAppActivityViewModel viewModel;
    private NavigationView navigationView;

    private View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomeAppActivityViewModel.class);
        setContentView(R.layout.activity_home_app);
        prepareToolbar();
        setNavigationViewListener();
        checkIfSignedIn();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_item_car_picker: {
                Navigation.findNavController(view).navigate(R.id.action_nav_main_view_to_nav_info);
            }
            case R.id.nav_item_brand_list: {
                Navigation.findNavController(view).navigate(R.id.action_nav_main_view_to_nav_expert_all_brands);
            }
            case R.id.nav_item_logout: {
                viewModel.signOut();
            }
        }
        return true;
    }

    private void prepareToolbar() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_fragment_main);
        NavController navController = navHostFragment.getNavController();
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(drawerLayout).build();

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    private void checkIfSignedIn() {
        viewModel.getCurrentUser().observe(this, user -> {
            if (user != null) {
                setNavigationHeader();
            } else {
                startActivity(new Intent(this, HomeAppActivityViewModel.class));
            }
        });
    }

    private void setNavigationViewListener() {
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setNavigationHeader() {
        View navHeader = navigationView.getHeaderView(0);
        ImageView avatar = navHeader.findViewById(R.id.image_avatar);
        TextView userName = navHeader.findViewById(R.id.text_nickname);
        TextView userEmail = navHeader.findViewById(R.id.text_email);

        viewModel.getCurrentUser().observe(this, user -> {
            if(user != null){
                userName.setText(user.getDisplayName());
                userEmail.setText(user.getEmail());
                Glide.with(this).load(user.getPhotoUrl()).into(avatar);
            }
        });
    }
}
