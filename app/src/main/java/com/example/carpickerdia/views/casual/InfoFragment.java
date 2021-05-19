package com.example.carpickerdia.views.casual;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.carpickerdia.R;
import com.example.carpickerdia.viewmodels.casual.InfoViewModel;

public class InfoFragment extends Fragment {

    private InfoViewModel viewModel;

    private Button suggest;
    private Button confirm;
    private Button randomPick;
    private EditText editText;
    private TextView textView;
    private ImageView imageView;
    private View view;
    private String brand;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this).get(InfoViewModel.class);

        view = inflater.inflate(R.layout.fragment_information, container, false);
        prepareUI();
        prepareOnClickEvents();
        return view;
    }

    private void prepareUI(){
        suggest = view.findViewById(R.id.button_info_suggest);
        confirm = view.findViewById(R.id.button_info_confirm);
        editText = view.findViewById(R.id.text_info);
        textView = view.findViewById(R.id.text_info_suggest_display);
        imageView = view.findViewById(R.id.image_view_info_car_suggest);
        randomPick = view.findViewById(R.id.button_random_pick_info);
    }

    private void prepareOnClickEvents(){
        confirm.setOnClickListener(v -> {
            viewModel.generateRandomPick(editText.getText().toString().toLowerCase());
            Navigation.findNavController(view).navigate(R.id.action_nav_info_to_nav_results);
        });

        suggest.setOnClickListener(v -> {
            viewModel.generateRandomBrand();
        });

        randomPick.setOnClickListener(v -> {
            viewModel.generateRandomPick(null);
            Navigation.findNavController(view).navigate(R.id.action_nav_info_to_nav_results);
        });

        viewModel.getRandomBrand().observe(getViewLifecycleOwner(), make -> {
            if(make != null) {
                textView.setText(make);
                editText.setText(make);
                loadCarImage(make);
                brand=make;
            }
        });
    }

    private void loadCarImage(String make){
        switch (make){
            case "acura":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.acura));
                break;

            case "alfa-romeo":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.alfa));
                break;

            case "aston-martin":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.aston));
                break;

            case "audi":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.audi));
                break;

            case "bentley":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.bentley));
                break;

            case "bmw":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.bmw));
                break;

            case "buick":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.buick));
                break;

            case "cadillac":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.cadillac));
                break;

            case "chrysler":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.chrysler));
                break;

            case "chevrolet":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.chevrolet));
                break;

            case "dodge":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.dodge));
                break;

            case "ferrari":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ferrari));
                break;

            case "fiat":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.fiat));
                break;

            case "ford":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ford));
                break;

            case "gmc":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.gmc));
                break;

            case "honda":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.honda));
                break;

            case "hyundai":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.hyundai));
                break;

            case "infiniti":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.infiniti));
                break;

            case "jaguar":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.jaguar));
                break;

            case "jeep":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.jeep));
                break;

            case "kia":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.kia));
                break;

            case "lamborghini":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.lamborghini));
                break;

            case "land-rover":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.land));
                break;

            case "lexus":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.lexus));
                break;

            case "lincoln":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.lincoln));
                break;

            case "maserati":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.maserati));
                break;

            case "mazda":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.mazda));
                break;

            case "mclaren":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.mclaren));
                break;

            case "mercedes-benz":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.mercedes));
                break;

            case "mini":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.mini));
                break;

            case "mitsubishi":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.mitsubishi));
                break;

            case "nissan":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.nissan));
                break;

            case "porsche":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.porsche));
                break;

            case "ram":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ram));
                break;

            case "rolls-royce":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.rolls));
                break;

            case "scion":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.scion));
                break;

            case "subaru":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.subaru));
                break;

            case "toyota":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.toyota));
                break;

            case "volkswagen":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.volkswagen));
                break;

            case "volvo":
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.volvo));
                break;
        }
    }
}
