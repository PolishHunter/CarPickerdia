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
        loadCarImage(viewHolder.imageView, viewHolder.imageView2, brandList.get(position));
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
        ImageView imageView2;
        SearchView searchView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_row_car_brand);
            imageView = itemView.findViewById(R.id.image_row_car_brand);
            imageView2 = itemView.findViewById(R.id.image_nationality);
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


    private void loadCarImage(ImageView imageView, ImageView imageView2, String make){
        switch (make){
            case "acura":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.acuralogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.japan));
                break;

            case "alfa-romeo":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.alfalogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.italian));
                break;

            case "aston-martin":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.astonlogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.english));
                break;

            case "audi":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.audilogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.german));
                break;

            case "bentley":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.bentleylogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.english));
                break;

            case "bmw":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.bmwlogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.german));
                break;

            case "buick":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.buicklogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.american));
                break;

            case "cadillac":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cadillaclogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.american));
                break;

            case "chrysler":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.chryslerlogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.american));
                break;

            case "chevrolet":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.chevroletlogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.american));
                break;

            case "dodge":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.dodgelogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.american));
                break;

            case "ferrari":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ferrarilogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.italian));
                break;

            case "fiat":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.fiatlogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.italian));
                break;

            case "ford":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.fordlogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.american));
                break;

            case "gmc":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.gmclogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.american));
                break;

            case "honda":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.hondalogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.japan));
                break;

            case "hyundai":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.hyundailogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.korean));
                break;

            case "infiniti":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.infinitilogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.japan));
                break;

            case "jaguar":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.jaguarlogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.english));
                break;

            case "jeep":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.jeeplogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.american));
                break;

            case "kia":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.kialogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.korean));
                break;

            case "lamborghini":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.lamborghinilogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.italian));
                break;

            case "land-rover":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.landroverlogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.english));
                break;

            case "lexus":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.lexuslogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.japan));
                break;

            case "lincoln":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.lincolnlogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.american));
                break;

            case "maserati":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.maseratilogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.italian));
                break;

            case "mazda":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mazdalogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.japan));
                break;

            case "mclaren":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mclarenlogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.english));
                break;

            case "mercedes-benz":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mercedeslogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.german));
                break;

            case "mini":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.minilogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.english));
                break;

            case "mitsubishi":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mitsubishilogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.japan));
                break;

            case "nissan":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.nissanlogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.japan));
                break;

            case "porsche":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.porschelogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.german));
                break;

            case "ram":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ramlogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.american));
                break;

            case "rolls-royce":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rollsroycelogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.english));
                break;

            case "scion":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.scionlogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.japan));
                break;

            case "subaru":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.subarulogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.japan));
                break;

            case "toyota":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.toyotalogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.japan));
                break;

            case "volkswagen":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.volkswagenlogo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.german));
                break;

            case "volvo":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.volvologo));
                imageView2.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.swedish));
                break;
        }
    }

}
