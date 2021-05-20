package com.example.carpickerdia.views.mainapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.carpickerdia.R;
import com.example.carpickerdia.viewmodels.mainapp.MainViewModel;

public class MainViewFragment extends Fragment {

    private View view;

    private Button buttonCasual;
    private Button buttonExpert;

    private MainViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        view = inflater.inflate(R.layout.fragment_main_view, container, false);

        prepareUI();
        prepareOnClickEvents();
        return view;
    }

    private void prepareUI() {
        buttonCasual = view.findViewById(R.id.main_fragment_button_usual);
        buttonExpert = view.findViewById(R.id.main_fragment_button_expert);
    }

    private void prepareOnClickEvents() {
        buttonCasual.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.action_nav_main_view_to_nav_info));
        buttonExpert.setOnClickListener(v -> {
            viewModel.getAllBrands();
            Navigation.findNavController(view).navigate(R.id.action_nav_main_view_to_nav_expert_all_brands);
        });
    }
}
