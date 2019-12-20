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

public class Parks extends Fragment {
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
        arr.add(new Items("Al-Azhar Park",R.drawable.alazharpark,"0114 440 0555",30.040759, 31.264740,"You will not need a special day to visit this beautiful park; it is not far from many of the tourist attractions in Cairo included in this article such as the Citadel of Salah al-Din and Sultan Hassan Mosque, one of the largest parks in Egypt and one of the most beautiful tourist attractions in Cairo and you will miss a lot if not You visit. The park offers you the opportunity to enjoy around 80 acres of greenery that surrounds you from every direction, a large fountain welcomes you on entry, water channels with small fountains distributed in different parts of the park, artificial waterfalls, roaming opportunities and wonderful sessions, restaurants and cafes, as well as sessions Morning and evening photography and weddings take place at events and weddings, making it one of Cairo's best nightlife venues and a good opportunity to socialize with the local customs."));
        arr.add(new Items("fustat park",R.drawable.fustatpark,"null",30.014781, 31.245250,"The Fustat park spans only 250 acres of greenery, making it a great spot for nature lovers and one of Cairo's oldest and largest parks. Near the park is the traditional crafts center and Fustat market, where you can enjoy seeing the most beautiful crafts and buying what you desire, while buying products and goods you will not find anywhere else, some made entirely of natural materials."));
        arr.add(new Items("The International Garden",R.drawable.theinternationalgarden,"02 23826579",30.049413, 31.336507,"Located in the Nasr City district, one of Cairo's most beautiful outings for families, it is an ideal destination for children, with a mini-zoo with a stuffed animal museum, along with a train that takes kids and adults on a short, fun tour around the spacious park and themed rest areas. Besides a wide variety of plants and flowers brought from all over the world, it is a joint venture between several countries whose flags will be installed at the entrance. Next to the international park is the beautiful theme park Wonderland, and you can go to Wonderland for fun games. Diverse and exciting then rest and recuperation in the international park, and next to them you will find a number of restaurants and cafes to eat fast food and drinks."));
        arr.add(new Items("Japanese Garden",R.drawable.japanesegarden,"0127 041 8322",29.848839, 31.340225,"One of Cairo's unique tourist attractions makes you feel as if Asia is in your hands while you are in North Africa. Built in the early 20th century in the Helwan district, the Japanese Garden is designed to represent East Asian civilizations. This is in addition to the natural scenery such as hills, trees and fish ponds, all this to the rhythms of live music emitted from the so-called garden stall making it a place to go out in Cairo suitable for families."));
        arr.add(new Items("Al-Andalus Garden",R.drawable.alandalusgarden,"null",30.044155, 31.227450,"One of the best tourist sites in Cairo for those looking for tranquility and recreation, where the park includes large areas of greenery and palm trees with vineyards overlooking the magnificent view of the Nile directly directly separated by only a wall of marble in a wonderful painting. In addition, you can take commemorative photos with the distinctive Andalusian arches, the black fountain and giant pharaonic statues next to the famous writer Ahmed Shawky, while enjoying the Andalusian architectural style that characterizes the garden located in Zamalek in front of the Teachers Club from the moment you enter it."));
        arr.add(new Items("Family Park",R.drawable.familypark,"0115 966 1880",30.042043, 31.225927,"The Freedom Park is one of Cairo's unique tourist attractions.It is not only based on green spaces, it was originally built to include statues of the greatest personalities who contributed to the freedom of their countries at the political and economic level or even through their writings and poems enthusiastic and influential. These statues represent Egypt in the figures of writers Ahmed Shawky and Hafez Ibrahim, the great economist Talaat Harb, as well as eight other statues of great figures who have influenced the history of freedom representing Mexico, Venezuela, and Ecuador. So, if you are looking for a cultural and historical meal, your visit to the park will be more fruitful."));
        arr.add(new Items("Maryland Park",R.drawable.marylandpark,"null",30.097928, 31.319005,"One of the most important places of entertainment in Cairo, and the largest gardens of the Heliopolis area. Spread over 50 acres of greenery and shady trees, this park features a beautiful lake where a small boat can be boarded, with skiing areas, as well as a range of upscale restaurants and cafés."));

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