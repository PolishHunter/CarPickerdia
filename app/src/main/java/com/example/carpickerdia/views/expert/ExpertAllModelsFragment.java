package com.example.carpickerdia.views.expert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carpickerdia.R;
import com.example.carpickerdia.adapters.CarAdapterBrand;
import com.example.carpickerdia.adapters.CarAdapterModel;
import com.example.carpickerdia.viewmodels.expert.AllBrandsViewModel;
import com.example.carpickerdia.viewmodels.expert.AllModelsViewModel;

public class ExpertAllModelsFragment extends Fragment implements CarAdapterModel.OnListItemClickListener {

    private RecyclerView modelList;
    private CarAdapterModel adapter;
    private View view;
    private AllModelsViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this).get(AllModelsViewModel.class);
        view = inflater.inflate(R.layout.fragment_expert_all_models, container, false);
        loadData();
        return view;
    }

    private void loadData() {
        adapter = new CarAdapterModel(this);
        modelList = view.findViewById(R.id.expert_car_model_list);
        modelList.hasFixedSize();
        modelList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        viewModel.getAllModels().observe(getViewLifecycleOwner(), models -> {
            adapter.setModelList(models);
            System.out.println("Car Model" + models.size());
        });
        modelList.setAdapter(adapter);
        System.out.println();
    }

    @Override
    public void onListItemClick(int modelId) {
        viewModel.getCarByModel(adapter.getModel(modelId));
        Navigation.findNavController(view).navigate(R.id.action_nav_expert_all_models_to_nav_expert_specific_model);
    }

//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getActivity().getMenuInflater();
//        inflater.inflate(R.menu.search_menu, menu);
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//
//        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//        return true;
//    }
}
