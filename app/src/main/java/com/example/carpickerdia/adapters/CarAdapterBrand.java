package com.example.carpickerdia.adapters;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carpickerdia.R;
import com.example.carpickerdia.models.Car;

import java.util.ArrayList;
import java.util.List;

public class CarAdapterBrand extends RecyclerView.Adapter<CarAdapterBrand.ViewHolder> implements Filterable {

    private List<String> brandList;
    private List<Car> carList;
    private List<Car> carListFull;
    final private OnListItemClickListener mOnListItemClickListener;
    private Activity activity;

    CarAdapterBrand(List<String> brandList, List<Car> carList, OnListItemClickListener listener, Activity activity){
        this.brandList = brandList;
        this.carList = carList;
        carListFull = new ArrayList<>(carList);
        mOnListItemClickListener = listener;
        this.activity = activity;
    }

    public void setBrandList(List<String> brandList) {
       this.brandList = brandList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_expert_all_brands, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        loadCarImage(viewHolder.imageView, carList.get(position).getMake());
        viewHolder.button.setOnClickListener(v->{
            Bundle bundle = new Bundle();
            bundle.putString("make", carList.get(position).getMake());
            Navigation.findNavController(viewHolder.itemView).navigate(R.id.action_nav_expert_all_brands_to_nav_expert_all_models,bundle);
        });
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    @Override
    public Filter getFilter() {
        return carFilter;
    }

    private Filter carFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Car> filteredList = new ArrayList<>();

            if(constraint ==  null || constraint.length() == 0) {
                filteredList.addAll(carListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Car item : carListFull) {
                    if(item.getMake().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            carList.clear();
            carList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        ImageView imageView;
        Button button;
        SearchView searchView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_row_car_brand);
            imageView = itemView.findViewById(R.id.image_row_car_brand);
            searchView = itemView.findViewById(R.id.row_search_view_filter);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }


    private void loadCarImage(ImageView imageView, String make){
        switch (make){
            case "acura":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.acura));
                break;

            case "alfa-romeo":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.alfa));
                break;

            case "aston-martin":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.aston));
                break;

            case "audi":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.audi));
                break;

            case "bentley":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.bentley));
                break;

            case "bmw":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.bmw));
                break;

            case "buick":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.buick));
                break;

            case "cadillac":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.cadillac));
                break;

            case "chrysler":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.chrysler));
                break;

            case "chevrolet":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.chevrolet));
                break;

            case "dodge":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.dodge));
                break;

            case "ferrari":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ferrari));
                break;

            case "fiat":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.fiat));
                break;

            case "ford":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ford));
                break;

            case "gmc":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.gmc));
                break;

            case "honda":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.honda));
                break;

            case "hyundai":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.hyundai));
                break;

            case "infiniti":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.infiniti));
                break;

            case "jaguar":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.jaguar));
                break;

            case "jeep":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.jeep));
                break;

            case "kia":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.kia));
                break;

            case "lamborghini":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.lamborghini));
                break;

            case "land-rover":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.land));
                break;

            case "lexus":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.lexus));
                break;

            case "lincoln":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.lincoln));
                break;

            case "maserati":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.maserati));
                break;

            case "mazda":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.mazda));
                break;

            case "mclaren":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.mclaren));
                break;

            case "mercedes-benz":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.mercedes));
                break;

            case "mini":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.mini));
                break;

            case "mitsubishi":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.mitsubishi));
                break;

            case "nissan":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.nissan));
                break;

            case "porsche":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.porsche));
                break;

            case "ram":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ram));
                break;

            case "rolls-royce":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.rolls));
                break;

            case "scion":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.scion));
                break;

            case "subaru":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.subaru));
                break;

            case "toyota":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.toyota));
                break;

            case "volkswagen":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.volkswagen));
                break;

            case "volvo":
                imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.volvo));
                break;
        }
    }

}
