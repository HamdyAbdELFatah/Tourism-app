package com.coders.tourism.Recommened.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coders.tourism.Map.Place;
import com.coders.tourism.R;
import com.coders.tourism.Recommened.RecyclerAdapter;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;

public class Beach_rec extends Fragment {
    ArrayList<Items> arr;
    RecyclerAdapter recyclerAdapter;
    int f=0;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recommend, container, false);
        arr=getData();
        RecyclerView recyclerView=v.findViewById(R.id.recommend_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerAdapter=new RecyclerAdapter(arr,getActivity().getApplicationContext());
        recyclerView.setAdapter(recyclerAdapter);

        return v;
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
        if(f==1)
            recyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
        f=1;
    }
}