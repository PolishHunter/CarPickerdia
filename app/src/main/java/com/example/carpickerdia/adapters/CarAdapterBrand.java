package com.example.carpickerdia.adapters;

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
    final private OnListItemClickListener mOnListItemClickListener;

    public CarAdapterBrand(OnListItemClickListener listener){
        mOnListItemClickListener = listener;
        brandList = new ArrayList<>();
    }

    public void setBrandList(List<String> brandList) {
       this.brandList = brandList;
       notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_car_brand, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        loadCarImage(viewHolder.imageView, brandList.get(position));
        viewHolder.textView.setText(brandList.get(position));
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }

    @Override
    public Filter getFilter() {
        return carFilter;
    }

    private Filter carFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<String> filteredList = new ArrayList<>();

            if(constraint ==  null || constraint.length() == 0) {
                filteredList.addAll(brandList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (String item : brandList) {
                    if(item.toLowerCase().contains(filterPattern)) {
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
            brandList.clear();
            brandList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public String getBrand(int index) {
        return brandList.get(index);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        ImageView imageView;
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
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.acuralogo));
                break;

            case "alfa-romeo":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.alfalogo));
                break;

            case "aston-martin":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.astonlogo));
                break;

            case "audi":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.audilogo));
                break;

            case "bentley":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.bentleylogo));
                break;

            case "bmw":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.bmwlogo));
                break;

            case "buick":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.buicklogo));
                break;

            case "cadillac":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cadillaclogo));
                break;

            case "chrysler":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.chryslerlogo));
                break;

            case "chevrolet":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.chevroletlogo));
                break;

            case "dodge":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.dodgelogo));
                break;

            case "ferrari":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ferrarilogo));
                break;

            case "fiat":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.fiatlogo));
                break;

            case "ford":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.fordlogo));
                break;

            case "gmc":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.gmclogo));
                break;

            case "honda":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.hondalogo));
                break;

            case "hyundai":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.hyundailogo));
                break;

            case "infiniti":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.infinitilogo));
                break;

            case "jaguar":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.jaguarlogo));
                break;

            case "jeep":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.jeeplogo));
                break;

            case "kia":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.kialogo));
                break;

            case "lamborghini":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.lamborghinilogo));
                break;

            case "land-rover":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.landroverlogo));
                break;

            case "lexus":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.lexuslogo));
                break;

            case "lincoln":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.lincolnlogo));
                break;

            case "maserati":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.maseratilogo));
                break;

            case "mazda":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mazdalogo));
                break;

            case "mclaren":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mclarenlogo));
                break;

            case "mercedes-benz":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mercedeslogo));
                break;

            case "mini":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.minilogo));
                break;

            case "mitsubishi":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mitsubishilogo));
                break;

            case "nissan":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.nissanlogo));
                break;

            case "porsche":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.porschelogo));
                break;

            case "ram":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ramlogo));
                break;

            case "rolls-royce":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rollsroycelogo));
                break;

            case "scion":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.scionlogo));
                break;

            case "subaru":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.subarulogo));
                break;

            case "toyota":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.toyotalogo));
                break;

            case "volkswagen":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.volkswagenlogo));
                break;

            case "volvo":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.volvologo));
                break;
        }
    }

}
