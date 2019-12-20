package com.coders.tourism.Map.MapFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.coders.tourism.Map.Place;
import com.coders.tourism.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Beach extends Fragment implements OnMapReadyCallback , GoogleMap.OnMarkerClickListener {
    ArrayList<Items> arr;
    MapView gMapView;
    GoogleMap gMap = null;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_choose, container, false);

        gMapView = (MapView) v.findViewById(R.id.map);
        gMapView.getMapAsync(this);
        gMapView.onCreate(savedInstanceState);
        gMapView.onResume(); // needed to get the map to display immediately
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return v;
    }
    @Override
    public void onMapReady(GoogleMap map) {
        gMap = map;
         arr=getData();
        for(Items i :arr){
            gMap.addMarker(new MarkerOptions().position(new LatLng(i.lat,i.lng))
                    .title(i.name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mark));
        }
             gMap.getCameraPosition();
        gMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new
                        LatLng(28.182654, 32.958374), 6));
            }
        });
        gMap.setOnMarkerClickListener(this);
    }
    private ArrayList<Items> getData() {
        ArrayList<Items> arr=new ArrayList<>();
        arr.add(new Items("Ras Am Side",R.drawable.rasamside,"069 3661815",27.858079, 34.316497,"Divers go to be impressed by the stunning coral forms, especially coral reefs, as well as the abundance of aquatic life, including various rare fish species, the area is located 5 km from Naama Bay."));
        arr.add(new Items("Sharm El Loly",R.drawable.loly,"0111 372 3483",24.556537, 35.150605,"One of the most beautiful beaches in the world, which has recently become renowned, and has achieved advanced positions in the rankings of global beaches, as the traveler will feel that he is in one of the beaches (Maldives) charming."));
        arr.add(new Items("Zeytuna Beach",R.drawable.zeytuna,"065 3580350",27.401446, 33.681399,"It is the most important beaches of the city of El Gouna, and the village of El Gouna is one of the most important and most beautiful suburbs of Hurghada."));
        arr.add(new Items("agiba beach",R.drawable.agiba,"0110 115 3532",31.414413, 27.006642,"One of the most beautiful beaches of all time, and is characterized by the wonderful rock forms that dot it, which gave him this name."));
        arr.add(new Items("Ras Shitan",R.drawable.rasshitan,"0100 101 3772",29.135239, 34.687375,"In the north of Nuweiba near Dahab, an area characterized by its tranquility and charming nature, you can stay in a tent on the beach and enjoy diving and swimming."));
        arr.add(new Items("Mahmya",R.drawable.mahmya,"0100 111 9792",27.182654, 33.958374,"Called the Paradise of God on Earth, it is your favorite destination for snorkeling and breathtaking views. Giftun Island is located near Hurghada and features a white sand beach and clear water."));
        arr.add(new Items("Mahmya Abu Galum",R.drawable.abugalum,"null",28.732113, 34.625495,"Famous for its colorful coral reefs, it is also an area of safari and camel rides."));
        arr.add(new Items("Taba",R.drawable.taba,"null",29.491665, 34.896903,"Located between Taba and Nuweiba, with clear blue waters and picturesque coral reefs, the Strait is the perfect place for professional divers."));
        arr.add(new Items("El Arish",R.drawable.elarish,"null",31.132404, 33.802807,"The beach is known as «Palm», due to the presence of palm tree forests along its length, and is characterized by the presence of the Corniche, which provides all tourist services."));

        return arr;
    }
    @Override
    public void onResume() {
        super.onResume();
        gMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        gMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        gMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        gMapView.onLowMemory();
    }
    @Override
    public boolean onMarkerClick(Marker marker) {
        Intent intent=new Intent(getActivity().getApplicationContext(), Place.class);
        int index =0;
        for(int i =0 ;i<arr.size();i++){
            if(arr.get(i).name.trim().equals(marker.getTitle().trim())){
                index=i;
                break;
            }
        }
        ArrayList<String> title=new ArrayList<>();
        ArrayList<String> lat=new ArrayList<>();
        ArrayList<String> lng=new ArrayList<>();
        ArrayList<String> desc=new ArrayList<>();
        ArrayList<String> phone=new ArrayList<>();
        ArrayList<Integer> img=new ArrayList<>();
        Items items;
        for(int i=0;i<arr.size();i++){
            items=arr.get(i);
            title.add(items.name);
            lat.add(items.lat+"");
            lng.add(items.lng+"");
            desc.add(items.desc);
            phone.add(items.phone);
            img.add(items.img);
        }
        intent.putStringArrayListExtra("name",title);
        intent.putStringArrayListExtra("lat",lat);
        intent.putStringArrayListExtra("lng",lng);
        intent.putStringArrayListExtra("desc",desc);
        intent.putStringArrayListExtra("phone",phone);
        intent.putIntegerArrayListExtra("img",img);
        intent.putExtra("index",index);
        startActivity(intent);
        return false;
    }
}