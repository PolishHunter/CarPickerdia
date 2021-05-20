package com.example.carpickerdia.views.mainapp;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.carpickerdia.R;
import com.example.carpickerdia.viewmodels.mainapp.MainViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private View view;
    private GoogleMap mMap;
    private SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_map, container, false);
        prepareUI();
        return view;
    }

    private void prepareUI(){
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NotNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng acura = new LatLng(40.82865060306809, -73.43105394208412);
        mMap.addMarker(new MarkerOptions()
                .position(acura)
                .title("Acura Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(acura));

        LatLng alfa = new LatLng(40.769462465542375, -73.99435349611946);
        mMap.addMarker(new MarkerOptions()
                .position(alfa)
                .title("Alfa-Romeo Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(alfa));

        LatLng aston = new LatLng(40.798376410190606, -73.66493675704558);
        mMap.addMarker(new MarkerOptions()
                .position(aston)
                .title("Aston-Martin Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(aston));

        LatLng audi = new LatLng(40.882363152868635, -73.98289930317492);
        mMap.addMarker(new MarkerOptions()
                .position(audi)
                .title("Audi Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(audi));

        LatLng bmw = new LatLng(40.77045785827795, -73.99052803330942);
        mMap.addMarker(new MarkerOptions()
                .position(bmw)
                .title("BMW Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bmw));

        LatLng bentley = new LatLng(40.7666343988607, -73.99464914206803);
        mMap.addMarker(new MarkerOptions()
                .position(bentley)
                .title("Bentley Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bentley));

        LatLng buick = new LatLng(40.74088849375776, -73.66432886621925);
        mMap.addMarker(new MarkerOptions()
                .position(buick)
                .title("Buick Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(buick));

        LatLng cadillac = new LatLng(40.85195411486716, -73.16131822266443);
        mMap.addMarker(new MarkerOptions()
                .position(cadillac)
                .title("Cadillac Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cadillac));

        LatLng chevrolet = new LatLng(40.72184009303571, -73.84813763495467);
        mMap.addMarker(new MarkerOptions()
                .position(chevrolet)
                .title("Chevrolet Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chevrolet));

        LatLng chrysler = new LatLng(40.62251053460789, -73.7436358454562);
        mMap.addMarker(new MarkerOptions()
                .position(chrysler)
                .title("Chrysler Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chrysler));

        LatLng dodge = new LatLng(40.78089598729886, -73.55880456514271);
        mMap.addMarker(new MarkerOptions()
                .position(dodge)
                .title("Dodge Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dodge));

        LatLng fiat = new LatLng(40.76924284335324, -73.99453273880935);
        mMap.addMarker(new MarkerOptions()
                .position(fiat)
                .title("Fiat Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(fiat));

        LatLng ferrari = new LatLng(40.760352094633724, -73.9722021400077);
        mMap.addMarker(new MarkerOptions()
                .position(ferrari)
                .title("Ferrari Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ferrari));

        LatLng ford = new LatLng(40.63539964258156, -73.92794088331942);
        mMap.addMarker(new MarkerOptions()
                .position(ford)
                .title("Ford Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ford));

        LatLng gmc = new LatLng(40.65711603547012, -73.63377562277932);
        mMap.addMarker(new MarkerOptions()
                .position(gmc)
                .title("GMC Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gmc));

        LatLng honda = new LatLng(40.84317601420411, -73.84922485697459);
        mMap.addMarker(new MarkerOptions()
                .position(honda)
                .title("Honda Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(honda));

        LatLng hyundai = new LatLng(40.58957155857716, -74.08888353038536);
        mMap.addMarker(new MarkerOptions()
                .position(hyundai)
                .title("Hyundai Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hyundai));

        LatLng infiniti = new LatLng(40.58268430169865, -73.95541634238403);
        mMap.addMarker(new MarkerOptions()
                .position(infiniti)
                .title("Infiniti Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(infiniti));

        LatLng jaguar = new LatLng(40.76906998665528, -73.99307070707331);
        mMap.addMarker(new MarkerOptions()
                .position(jaguar)
                .title("Jaguar Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jaguar));

        LatLng jeep = new LatLng(40.614056641249704, -73.9277408865037);
        mMap.addMarker(new MarkerOptions()
                .position(jeep)
                .title("Jeep Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jeep));

        LatLng kia = new LatLng(40.72385518752332, -73.54238656005914);
        mMap.addMarker(new MarkerOptions()
                .position(kia)
                .title("Kia Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kia));

        LatLng lamborghini = new LatLng(40.7796248561475, -73.56654980444348);
        mMap.addMarker(new MarkerOptions()
                .position(lamborghini)
                .title("Lamborghini Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(infiniti));

        LatLng landRover = new LatLng(40.65663746765637, -73.58934285501887);
        mMap.addMarker(new MarkerOptions()
                .position(landRover)
                .title("Land-Rover Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(landRover));

        LatLng lexus = new LatLng(40.6366100695387, -74.01961612019416);
        mMap.addMarker(new MarkerOptions()
                .position(lexus)
                .title("Lexus Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lexus));

        LatLng lincoln = new LatLng(40.8989221029421, -73.97019303987261);
        mMap.addMarker(new MarkerOptions()
                .position(lincoln)
                .title("Lincoln Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lincoln));

        LatLng mini = new LatLng(40.76938751251511, -73.99240146758586);
        mMap.addMarker(new MarkerOptions()
                .position(mini)
                .title("Mini Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(infiniti));

        LatLng maserati = new LatLng(40.786261185421246, -73.4510957217697);
        mMap.addMarker(new MarkerOptions()
                .position(maserati)
                .title("Maserati Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(infiniti));

        LatLng mazda = new LatLng(40.58987295923301, -74.08872488804981);
        mMap.addMarker(new MarkerOptions()
                .position(mazda)
                .title("Mazda Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mazda));

        LatLng mclaren = new LatLng(40.79856941632568, -73.66512980103059);
        mMap.addMarker(new MarkerOptions()
                .position(mclaren)
                .title("McLaren Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mclaren));

        LatLng mercedes = new LatLng(40.59147735797476, -73.99582450536029);
        mMap.addMarker(new MarkerOptions()
                .position(mercedes)
                .title("Mercedes-Benz Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mercedes));

        LatLng mitsubishi = new LatLng(40.65236752255052, -73.9213552239372);
        mMap.addMarker(new MarkerOptions()
                .position(mitsubishi)
                .title("Mitsubishi Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mitsubishi));

        LatLng nissan = new LatLng(40.62232701112704, -73.7426642380972);
        mMap.addMarker(new MarkerOptions()
                .position(nissan)
                .title("Nissan Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(nissan));

        LatLng porsche = new LatLng(40.75417911091392, -73.92985838445038);
        mMap.addMarker(new MarkerOptions()
                .position(porsche)
                .title("Porsche Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(porsche));

        LatLng ram = new LatLng(40.71586189875193, -73.6306942846884);
        mMap.addMarker(new MarkerOptions()
                .position(mazda)
                .title("RAM Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ram));

        LatLng rolls = new LatLng(41.02394275041321, -73.6368209004216);
        mMap.addMarker(new MarkerOptions()
                .position(rolls)
                .title("Rolls-Royce Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rolls));

        LatLng scion = new LatLng(40.704692536067185, -73.81476551342078);
        mMap.addMarker(new MarkerOptions()
                .position(scion)
                .title("Scion Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rolls));

        LatLng subaru = new LatLng(40.7535196360188, -73.92111193957709);
        mMap.addMarker(new MarkerOptions()
                .position(subaru)
                .title("Subaru Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(subaru));

        LatLng toyota = new LatLng(40.66342455063566, -73.71584795104503);
        mMap.addMarker(new MarkerOptions()
                .position(toyota)
                .title("Toyota Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(toyota));

        LatLng volkswagen = new LatLng(40.65709774557822, -73.68824921686794);
        mMap.addMarker(new MarkerOptions()
                .position(volkswagen)
                .title("Volkswagen Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(volkswagen));

        LatLng volvo = new LatLng(40.7585517945879, -73.77552796569422);
        mMap.addMarker(new MarkerOptions()
                .position(volvo)
                .title("Volvo Dealership"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(volvo));
    }

}
