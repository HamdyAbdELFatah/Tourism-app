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

public class FamilyAndKides extends Fragment {
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
        arr.add(new Items("Nile Cruise",R.drawable.nilecruise,"0109 731 0207",30.023669, 31.218219,"One of the best places to stay in Cairo at night in front of the magnificent view of the Nile is the independence of one of the floating vessels fixed or moving, on which the various artistic items such as concerts, singing, belly dancing and folklore, in addition to delicious meals and tastier drinks.\n" + "One of the most famous is Neil Maxim in front of the Marriott Hotel in Zamalek, the Grand Hyatt of the hotel of the same name in Garden City, Al Saraya and Nile City in Zamalek or Al Jazeera near the October Bridge, among others.\n" + "If you want a Nile cruise away from the hustle and bustle you can take a simple traditional boat from the Corniche area in Zamalek or Maadi, where you enjoy the atmosphere of tranquility and recreation alone in the presence of the great Nile. If you like to socialize with the local population in its simplest form, here are the Nile Cruises with the River Bus, which is a means of entertainment at the same time. Do not miss the best aspects of tourism in Cairo and enjoy a wonderful Nile cruise by any means of hiking and transport to your liking"));
        arr.add(new Items("Aqua Park",R.drawable.aquapark,"02 24772246",30.172981, 31.538445,"The water parks are one of the most important places of entertainment in Cairo and an ideal destination for children and families and for all those seeking fun and enjoyment and adventure. Cairo is home to three of Egypt's oldest and largest water parks: Aqua Park on the Cairo-Ismailia Desert Road, Crazy Water in Sheikh Zayed and Fun Zoom inside the walls of the Sun Club in Nasr City. The industrial area, with a play area suitable for young children, makes it one of the most important places to go out in Cairo for families."));
        arr.add(new Items("Maadi Island",R.drawable.maadiisland,"null",29.965525, 31.239242,"Located on the Nile Corniche, specifically in the Maadi area of \u200B\u200Bthe most beautiful tourist sites in Cairo. The island has a wide range of exhilarating greenery, walking around, hiking, golfing or horse-drawn carts. In addition to water streams and artificial lakes that are crossed over wooden bridges that provide the visitor with unspeakable pleasure, these lakes also provide an opportunity to ride the boat and enjoy an interesting Nile cruise for a small fee. Restaurants, cafes and shaded areas operate on a minimum order basis but are reasonably priced, but the island does not allow foreign visitors to enter only Egyptians and Arabs."));
        arr.add(new Items("Key Action Sports Al Rehab",R.drawable.keyactionsportsalrehab,"0111 307 2722",30.065090, 31.489051,"One of the most suitable places of entertainment in Cairo for fans of adventure and fun and play, where the place depends on the idea of simulating wars, but between groups of friends in several scenarios and using fake bullets and uniforms of the place. One of the best places to go out in Cairo for young people is located in Al Rehab City Club on the Cairo-Suez Desert Road not far from Cairo International Airport."));
        arr.add(new Items("KidZania",R.drawable.kidzania,"null",30.031233, 31.405695,"It is like a fully integrated, closed community designed for children, located inside Cairo Festival City Mall in New Cairo, one of Cairo's most entertaining and fun places for children. In KidZania, your child is treated as a mature adult who works in the profession that he wishes to work in. Going out in Cairo for families with children aged 4-14 years."));
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