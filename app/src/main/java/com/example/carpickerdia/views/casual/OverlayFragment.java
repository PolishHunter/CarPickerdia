package com.example.carpickerdia.views.casual;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.carpickerdia.R;

public class OverlayFragment extends Fragment {

    private View view;

    private TextView textViewOverlay;
    private RatingBar ratingBar;
    private EditText editTextOverlay;
    private Button retryButton;
    private Button confirmAction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_overlay, container, false);
        prepareUI();
        prepareOnClickEvents();
        return view;
    }

    private void prepareUI() {
        textViewOverlay = view.findViewById(R.id.text_overlay);
        ratingBar = view.findViewById(R.id.rating_bar_overlay);
        editTextOverlay = view.findViewById(R.id.comment_overlay);
        retryButton = view.findViewById(R.id.try_again_overlay_button);
        confirmAction = view.findViewById(R.id.button_overlay_confirm);
    }

    private void prepareOnClickEvents() {
        retryButton.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.action_nav_overlay_to_nav_info));
        confirmAction.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_nav_overlay_to_nav_results);
        });
    }

}
