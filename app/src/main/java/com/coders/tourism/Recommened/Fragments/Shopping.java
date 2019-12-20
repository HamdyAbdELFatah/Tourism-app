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

public class Shopping extends Fragment  {
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
        arr.add(new Items("DownTown",R.drawable.downtown,"02 23146182", 30.047736, 31.262256,"Downtown is one of the newest, largest and most beautiful shopping malls that you should not miss while visiting Cairo. Your family is one of the best places to go out in Cairo.\n" +
                "After this long tour of the most prominent tourist places in Cairo, we hope dear reader that you have decided where to go when you come to Egypt and during tourism in Cairo. Crazy Water Address: Plot A, 90th Street, 5th Settlement, New Cairo, Cairo ?, Egypt"));
        arr.add(new Items("Genena Mall",R.drawable.genena_mall,"02 20820621",30.061157, 31.332025,"One of the largest shopping malls you can visit while visiting Cairo, specifically in Nasr City. Next to its many shops and restaurants, the mall has its own ice-skating lounge. Genena Mall Address: 9 El Batrawy St., Off Abbas El Akkad Street, Nasr City, Cairo ?, Egypt"));
        arr.add(new Items("Khan El Khalili",R.drawable.khanelkhalili,"null",30.047736, 31.262256,"One of the most important tourist destinations in Cairo by Arab and foreign tourists and even local people; it is a popular market dating back to 6 centuries ago and is located near the neighborhood of Hussein. With Khan Al-Khalili you can buy the most beautiful souvenirs that remind you of your trip to Egypt from wood, copper and silver crafts, figurines, luminous glass lamps and more. While still enjoying the design of the place, the ancient Fatimid architecture has been preserved to date. Khan El Khalili Address: Aesthetic Department, Cairo ?, Egypt"));
        arr.add(new Items("City Stars Mall",R.drawable.citystars,"02 24800500",30.072978, 31.346046,"For shopping and entertainment lovers, one of the most important places of tourism in Cairo “City Stars” in Nasr City, where you can buy goods from the most famous local and international brands through a large number of shops in the mall on the five floors, as well as eat delicious and delicious meals and drinks in the most luxurious restaurants and cafes scattered in Place. The center also includes cinemas and distinctive halls for adult and young games, the most famous of which is iZone, Magic Galaxy, which provides billiards, bowling and video games in exchange for special cards that are bought and shipped with money as a calling card or Visa. City Stars Address: City Stars, Nasr City, Cairo ?, Egypt"));
        arr.add(new Items("Snow City",R.drawable.snowcity,"02 22692258",30.073651, 31.347365,"Zorb Ball is a giant ball that is inside it and descends on a cliff that really works and you can live and play videos. Ice Bumper Car, collision cars but in the snow. Skating, skiing with skiing tools as if you were in Russia already .. And the school inside the place you can learn to ski on the hands of foreign experts. The most important thing you can enjoy in the city of snow, is a winding slope where you sit on a sled on the ground, and take the winding ramp in a truly exciting atmosphere. Play Zone - Playing Zone, an open space full of snow, you can enjoy real games of ice balls or making shapes and snow houses .. Children can do many activities. Wooden House, a wooden place where you and your friends can imagine a high place panorama you can imagine with every place you play. The activities of Snow City are not just play-based. Educational activities are also available to families, schools and community groups, such as building an ice lolly hut and learning how to ski on a beginner's slope."));
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
