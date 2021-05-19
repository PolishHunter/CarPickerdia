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
import com.example.carpickerdia.viewmodels.casual.InfoViewModel;
import com.example.carpickerdia.viewmodels.expert.AllBrandsViewModel;

public class ExpertAllBrandsFragment extends Fragment implements CarAdapterBrand.OnListItemClickListener {

    private RecyclerView brandList;
    private CarAdapterBrand adapter;
    private View view;
    private AllBrandsViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this).get(AllBrandsViewModel.class);
        view = inflater.inflate(R.layout.fragment_expert_all_brands, container, false);
        loadData();
        return view;
    }

    private void loadData() {
        adapter = new CarAdapterBrand(this);
        brandList = view.findViewById(R.id.expert_car_brand_list);
        brandList.hasFixedSize();
        brandList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        viewModel.getAllBrands().observe(getViewLifecycleOwner(), brands -> {
            adapter.setBrandList(brands);
        });
        brandList.setAdapter(adapter);
    }

    @Override
    public void onListItemClick(int brandId) {
        Bundle bundle = new Bundle();
        bundle.putString(adapter.getBrand(brandId), "");
        Navigation.findNavController(view).navigate(R.id.action_nav_expert_all_brands_to_nav_expert_all_models, bundle);
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
