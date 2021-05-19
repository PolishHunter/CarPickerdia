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

public class CarAdapterModel extends RecyclerView.Adapter<CarAdapterModel.ViewHolder> implements Filterable {

    private List<String> modelList;
    final private OnListItemClickListener mOnListItemClickListener;

    public CarAdapterModel(OnListItemClickListener listener){
        mOnListItemClickListener = listener;
        modelList = new ArrayList<>();
    }

    public void setModelList(List<String> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_car_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        loadCarImage(viewHolder.imageView, modelList.get(position));
        viewHolder.textView.setText(modelList.get(position));
    }

    @Override
    public int getItemCount() {
        return modelList.size();
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
                filteredList.addAll(modelList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (String item : modelList) {
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
            modelList.clear();
            modelList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public String getModel(int index) {
        return modelList.get(index);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        ImageView imageView;
        SearchView searchView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_row_car_model);
            imageView = itemView.findViewById(R.id.image_row_car_model);
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


    private void loadCarImage(ImageView imageView, String model){
        switch (model){
            case "ilx":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ilx));
                break;

            case "rdx":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rdx));
                break;

            case "rlx":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rlx));
                break;

            case "tlx":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.tlx));
                break;

            case "4c":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.alfacoupe));
                break;

            case "4c-spider":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.alfaspider));
                break;

            case "db9-gt":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.db9));
                break;

            case "rapide-s":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rapides));
                break;

            case "v12-vantage-s":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.v12vantage));
                break;

            case "v8-vantage":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.v8vantage));
                break;

            case "vanquish":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.vanquish));
                break;

            case "a3":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.a3));
                break;

            case "a3-sportback-e-tron":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.a3etron));
                break;

            case "a4":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.a4));
                break;

            case "a6":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.a6));
                break;

            case "a7":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.a7));
                break;

            case "a8":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.a8));
                break;

            case "q3":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.q3));
                break;

            case "q5":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.q5));
                break;

            case "q7":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.q7));
                break;

            case "r8":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.r8));
                break;

            case "rs-5":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rs5));
                break;

            case "rs-7":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rs7));
                break;

            case "s3":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.s3));
                break;

            case "s4":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.s4));
                break;

            case "s5":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.s5));
                break;

            case "s6":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.s6));
                break;

            case "s7":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.s7));
                break;

            case "s8":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.s8));
                break;

            case "sq5":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sq5));
                break;

            case "tt":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.tt));
                break;

            case "tts":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.tts));
                break;

            case "allroad":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.allroad));
                break;

            case "2-series":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.series2));
                break;

            case "3-series":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.series3));
                break;

            case "3-series-gran-turismo":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.granturismo3));
                break;

            case "4-series":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.series4));
                break;

            case "4-series-gran-coupe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.grancoupe4));
                break;

            case "5-series":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.series5));
                break;

            case "5-series-gran-turismo":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.granturismo5));
                break;

            case "6-series":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.series6coupe));
                break;

            case "6-series-gran-coupe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.grancoupe6));
                break;

            case "7-series":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.series7));
                break;

            case "alpina-b6-gran-coupe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.alpinab6));
                break;

            case "alpina-b7":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.alpinab7));
                break;

            case "activehybrid-5":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.acrivehybrid5));
                break;

            case "activehybrid-7":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.activehybrid7));
                break;

            case "m2":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.m2));
                break;

            case "m3":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.m3));
                break;

            case "m4":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.m4));
                break;

            case "m5":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.m5));
                break;

            case "m6":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.m6));
                break;

            case "m6-gran-coupe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.m6grancoupe));
                break;

            case "x1":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.x1));
                break;

            case "x3":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.x3));
                break;

            case "x4":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.x4));
                break;

            case "x5":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.x5));
                break;

            case "x5-m":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.x5m));
                break;

            case "x5-edrive":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.x5edrive));
                break;

            case "x6":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.x6));
                break;

            case "x6-m":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.x6m));
                break;

            case "z4":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.z4));
                break;

            case "i3":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.i3));
                break;

            case "i8":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.i8));
                break;

            case "continental-gt":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.continentalgt));
                break;

            case "flying-spur":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.flyingspur));
                break;

            case "mulsanne":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mulsanne));
                break;

            case "cascada":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cascada));
                break;

            case "regal":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.regal));
                break;

            case "verano":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.verano));
                break;

            case "ats":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.atssedan));
                break;

            case "ats-coupe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.atscoupe));
                break;

            case "ats-v":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.atsv));
                break;

            case "ct6":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ct6));
                break;

            case "cts":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cts));
                break;

            case "cts-v":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ctsv));
                break;

            case "cts-v-coupe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.atsv));
                break;

            case "elr":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.elr));
                break;

            case "escalade":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.escalade));
                break;

            case "escalade-esv":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.escaladeesv));
                break;

            case "srx":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.srx));
                break;

            case "xt5":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.xt5));
                break;

            case "xts":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.xts));
                break;

            case "camaro":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.camaro));
                break;

            case "city-express":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cityexpress));
                break;

            case "colorado":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.colorado));
                break;

            case "corvette":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.corvette));
                break;

            case "cruze":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cruze));
                break;

            case "cruze-limited":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cruzelimited));
                break;

            case "express":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.express));
                break;

            case "express-cargo":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.expresscargo));
                break;

            case "impala":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.impala));
                break;

            case "malibu":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.malibu));
                break;

            case "malibu-limited":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.malibulimited));
                break;

            case "ss":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ss));
                break;

            case "silverado-1500":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.silverado));
                break;

            case "sonic":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sonic));
                break;

            case "spark":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.spark));
                break;

            case "spark-ev":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sparkev));
                break;

            case "suburban":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.suburban));
                break;

            case "tahoe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.tahoe));
                break;

            case "trax":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.trax));
                break;

            case "200":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.chrysler200));
                break;

            case "300":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.chrysler300));
                break;

            case "pacifica":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.pacifica));
                break;

            case "challenger":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.challenger));
                break;

            case "charger":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.charger));
                break;

            case "dart":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.dart));
                break;

            case "durango":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.durango));
                break;

            case "grand-caravan":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.grandcaravan));
                break;

            case "journey":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.journey));
                break;

            case "viper":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.viper));
                break;

            case "500":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.fiat500));
                break;

            case "500l":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.fiat500l));
                break;

            case "500x":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.fiat500x));
                break;

            case "458-italia":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.italia458));
                break;

            case "california-t":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.californiat));
                break;

            case "f12-berlinetta":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.berlinetta));
                break;

            case "ff":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ff));
                break;

            case "c-max-energi":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cmaxenergi));
                break;

            case "c-max-hybrid":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cmaxhybrid));
                break;

            case "edge":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.edge));
                break;

            case "escape":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.escape));
                break;

            case "explorer":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.explorer));
                break;

            case "f-450-super-duty":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.superduty));
                break;

            case "fiesta":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.fiesta));
                break;

            case "flex":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.flex));
                break;

            case "focus-rs":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.focusrs));
                break;

            case "focus-st":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.focusst));
                break;

            case "fusion":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.fusion));
                break;

            case "fusion-energi":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.fusionenergi));
                break;

            case "fusion-hybrid":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.fusionenergi));
                break;

            case "mustang":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mustang));
                break;

            case "shelby-gt350":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.gt350));
                break;

            case "taurus":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.taurus));
                break;

            case "transit-connect":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.transitconnect));
                break;

            case "transit-van":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.transitvan));
                break;

            case "transit-wagon":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.transitwagon));
                break;

            case "acadia":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.acadia));
                break;

            case "canyon":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.canyon));
                break;

            case "savana":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.savana));
                break;

            case "savana-cargo":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.savanacargo));
                break;

            case "sierra-2500hd":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sierra2500hd));
                break;

            case "sierra-3500hd":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sierra3500hd));
                break;

            case "terrain":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.terrain));
                break;

            case "yukon":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.yukon));
                break;

            case "yukon-xl":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.yukonxl));
                break;

            case "accord":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.accord));
                break;

            case "accord-hybrid":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.accordhybrid));
                break;

            case "cr-v":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.crv));
                break;

            case "cr-z":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.crz));
                break;

            case "crosstour":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.crosstour));
                break;

            case "fit":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.fit));
                break;

            case "hr-v":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.hrv));
                break;

            case "pilot":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.pilot));
                break;

            case "accent":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.accent));
                break;

            case "azera":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.azera));
                break;

            case "elantra":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.elantra));
                break;

            case "elantra-gt":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.elantragt));
                break;

            case "equus":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.equus));
                break;

            case "genesis":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.genesis));
                break;

            case "genesis-coupe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.genesiscoupe));
                break;

            case "santa-fe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.santafe));
                break;

            case "santa-fe-sport":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.santafesport));
                break;

            case "sonata":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sonata));
                break;

            case "sonata-hybrid":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sonatahybrid));
                break;

            case "sonata-plug-in-hybrid":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sonatahybrid));
                break;

            case "tucson":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.tuscon));
                break;

            case "veloster":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.veloster));
                break;

            case "q40":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.q40));
                break;

            case "q50":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.q50));
                break;

            case "q60-convertible":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.q60convertible));
                break;

            case "q70":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.q70));
                break;

            case "qx50":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.qx50));
                break;

            case "qx60":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.qx60));
                break;

            case "qx70":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.qx70));
                break;

            case "qx80":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.qx80));
                break;

            case "f-pace":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.fpace));
                break;

            case "f-type":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ftype));
                break;

            case "xe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.xe));
                break;

            case "xf":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.xf));
                break;

            case "xj":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.xj));
                break;

            case "xk":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.xk));
                break;

            case "cherokee":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cherokee));
                break;

            case "compass":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.compass));
                break;

            case "grand-cherokee":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.grandcherokee));
                break;

            case "grand-cherokee-srt":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.grandcherokeesrt));
                break;

            case "patriot":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.patriot));
                break;

            case "renegade":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.renegade));
                break;

            case "forte":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.forte));
                break;

            case "k900":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.k900));
                break;

            case "optima":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.optima));
                break;

            case "optima-hybrid":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.optimahybrid));
                break;

            case "rio":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rio));
                break;

            case "sedona":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sedona));
                break;

            case "sorento":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sorento));
                break;

            case "soul":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.soul));
                break;

            case "sportage":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sportage));
                break;

            case "aventador":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.aventador));
                break;

            case "huracan":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.huracan));
                break;

            case "discovery-sport":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.discoverysport));
                break;

            case "lr2":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.lr2));
                break;

            case "lr4":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.lr4));
                break;

            case "range-rover":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rangerover));
                break;

            case "range-rover-evoque":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.evoque));
                break;

            case "range-rover-sport":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rangeroversport));
                break;

            case "ct-200h":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ct200h));
                break;

            case "es-300h":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.es300h));
                break;

            case "es-350":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.es350));
                break;

            case "gs-200t":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.gs200t));
                break;

            case "gs-350":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.gs350));
                break;

            case "gs-450h":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.gs450h));
                break;

            case "gs-f":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.gsf));
                break;

            case "gx-460":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.gx460));
                break;

            case "is-200t":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.is200t));
                break;

            case "is-250":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.is250));
                break;

            case "is-250-c":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.is250c));
                break;

            case "is-300":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.is300));
                break;

            case "is-350":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.is350));
                break;

            case "is-350-c":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.is350c));
                break;

            case "ls-460":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ls460l));
                break;

            case "ls-600h-l":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ls600hl));
                break;

            case "lx-570":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.lx570));
                break;

            case "nx-200t":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.nx200t));
                break;

            case "nx-300h":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.nx300h));
                break;

            case "rc-200t":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rc200t));
                break;

            case "rc-300":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rc300));
                break;

            case "rc-350":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rc350));
                break;

            case "rc-f":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rcf));
                break;

            case "rx-350":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rx350));
                break;


            case "rx-450h":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rx450h));
                break;

            case "mkc":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mkc));
                break;

            case "mks":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mks));
                break;

            case "mkt":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mkt));
                break;

            case "mkx":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mkx));
                break;

            case "navigator":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.navigator));
                break;

            case "cooper":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cooper));
                break;

            case "cooper-clubman":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.clubman));
                break;

            case "cooper-countryman":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.countryman));
                break;

            case "cooper-coupe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.coupe));
                break;

            case "cooper-paceman":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.paceman));
                break;

            case "cooper-roadster":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.roadster));
                break;

            case "ghibli":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ghibli));
                break;

            case "granturismo":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.granturismo));
                break;

            case "granturismo-convertible":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.granturismocabrio));
                break;

            case "quattroporte":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.quattroporte));
                break;

            case "3":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mazda3));
                break;

            case "5":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mazda5));
                break;

            case "6":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mazda6));
                break;

            case "cx-3":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cx3));
                break;

            case "cx-5":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cx5));
                break;

            case "mx-5-miata":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mx5));
                break;

            case "650s-coupe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mclaren650s));
                break;

            case "650s-spider":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mclaren650spider));
                break;

            case "amg-gt":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.amggt));
                break;

            case "b-class-electric-drive":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.bclass));
                break;

            case "cla-class":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cla));
                break;

            case "cls-class":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cls));
                break;

            case "g-class":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.gwagon));
                break;

            case "gl-class":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.gl));
                break;

            case "gla-class":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.gla));
                break;

            case "glc-class":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.glc));
                break;

            case "gle-class":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.gle));
                break;

            case "gle-class-coupe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.glecoupe));
                break;

            case "glk-class":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.glk));
                break;

            case "maybach":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.maybach));
                break;

            case "metris":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.metris));
                break;

            case "sl-class":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sl));
                break;

            case "slk-class":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.slk));
                break;

            case "sls-amg-gt-final-edition":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sls));
                break;

            case "sprinter":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sprinter));
                break;

            case "sprinter-worker":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sprinterworker));
                break;

            case "lancer":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.lancer));
                break;

            case "lancer-evolution":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.lancerevo));
                break;

            case "mirage":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mirage));
                break;

            case "mirage-g4":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mirageg4));
                break;

            case "outlander":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.outlander));
                break;

            case "outlander-sport":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.outlandersport));
                break;

            case "i-miev":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.imiev));
                break;

            case "370z":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.nissan370z));
                break;

            case "altima":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.altima));
                break;

            case "frontier":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.frontier));
                break;

            case "gt-r":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.gtr));
                break;

            case "juke":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.juke));
                break;

            case "maxima":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.maxima));
                break;

            case "murano":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.murano));
                break;

            case "nv-cargo":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.nvcargo));
                break;

            case "nv-passenger":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.nvpassenger));
                break;

            case "nv200":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.nv200));
                break;

            case "pathfinder":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.pathfinder));
                break;

            case "quest":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.quest));
                break;

            case "rogue":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rogue));
                break;

            case "rogue-select":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rogueselect));
                break;

            case "sentra":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sentra));
                break;

            case "titan-xd":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.titanxd));
                break;

            case "versa":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.versa));
                break;

            case "versa-note":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.versanote));
                break;

            case "xterra":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.xterra));
                break;

            case "718-boxster":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.boxster718));
                break;

            case "911":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.carrera911));
                break;

            case "918-spyder":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.porsche918));
                break;

            case "boxster":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.boxsterspyder));
                break;

            case "cayenne":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cayenne));
                break;

            case "cayman":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cayman));
                break;

            case "macan":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.macan));
                break;

            case "panamera":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.panamera));
                break;

            case "1500":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ram1500));
                break;

            case "3500":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ram3500));
                break;

            case "cv-tradesman":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cvtrademan));
                break;

            case "promaster-cargo-van":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.promastercargo));
                break;

            case "promaster-city":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.rampromaster));
                break;

            case "promaster-window-van":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.promasterwindow));
                break;

            case "dawn":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.dawn));
                break;

            case "ghost-series-ii":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ghostserie2));
                break;

            case "phantom":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.phantom));
                break;

            case "phantom-coupe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.phantomcoupe));
                break;

            case "phantom-drophead-coupe":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.phantomdrophead));
                break;

            case "wraith":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.wraith));
                break;

            case "fr-s":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.frs));
                break;

            case "ia":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ia));
                break;

            case "im":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.im));
                break;

            case "iq":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.iq));
                break;

            case "tc":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.tc));
                break;

            case "xb":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.xb));
                break;

            case "brz":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.brz));
                break;

            case "crosstrek":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.crosstrek));
                break;

            case "forester":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.forester));
                break;

            case "legacy":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.legacy));
                break;

            case "outback":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.outback));
                break;

            case "wrx":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.wrx));
                break;

            case "xv-crosstrek":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.xvcrosstrek));
                break;

            case "4runner":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.runner));
                break;

            case "avalon":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.avalonnormal));
                break;

            case "avalon-hybrid":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.avalonhybrid));
                break;

            case "camry":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.camry));
                break;

            case "camry-hybrid":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.camryhybrid));
                break;

            case "corolla":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.corolla));
                break;

            case "highlander-hybrid":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.highlanderhybrid));
                break;

            case "land-cruiser":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.landcruiser));
                break;

            case "mirai":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.mirai));
                break;

            case "prius":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.prius));
                break;

            case "prius-plug-in":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.priusplugin));
                break;

            case "prius-c":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.priusc));
                break;

            case "prius-v":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.priusv));
                break;

            case "rav4":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ravfour));
                break;

            case "rav4-hybrid":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.ravhybrid));
                break;

            case "sequoia":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sequoia));
                break;

            case "sienna":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.sienna));
                break;

            case "tacoma":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.tacoma));
                break;

            case "tundra":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.tundra));
                break;

            case "venza":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.venza));
                break;

            case "yaris":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.yaris));
                break;

            case "beetle":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.beetle));
                break;

            case "beetle-convertible":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.beetleconvertible));
                break;

            case "cc":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.cc));
                break;

            case "eos":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.eos));
                break;

            case "golf":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.golf));
                break;

            case "golf-gti":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.golfgti));
                break;

            case "golf-r":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.golfr));
                break;

            case "golf-sportwagen":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.golfwagon));
                break;

            case "jetta":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.jetta));
                break;

            case "passat":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.passat));
                break;

            case "touareg":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.touareg));
                break;

            case "e-golf":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.egolf));
                break;

            case "s60":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.s60));
                break;

            case "s80":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.s80));
                break;

            case "v60":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.v60));
                break;

            case "v60-cross-country":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.v60crosscountry));
                break;

            case "xc60":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.xc60));
                break;

            case "xc70":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.xc70));
                break;

            case "xc90":
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.xc90));
                break;

        }
    }
}
