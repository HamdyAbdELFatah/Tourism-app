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

public class Museum extends Fragment{
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
        arr.add(new Items("Egyptian Museum",R.drawable.egyptianmuseum,"02 25794596",30.047014, 31.233649,"One of the most important tourist attractions in Cairo and Egypt in general; it is one of the largest museums area and collections, as the ancient museum contains about 150 thousand pieces dealing with the history of Egypt Pharaonic, Roman and Greek divided on two floors; one contains light collections such as small statues, manuscripts and pictures, and the other includes heavy pieces such as coffins and mummies However, you may need to have a private tour guide with you or your tour group to explain the evolution of Egyptian historical eras in their historical order, or you can use the guides and posters placed by the museum's management. Side of the exhibits. From the outside, the museum has a magnificent red-clad architectural design as well as its distinctive dome and windows that make it very similar to Islamic architecture."));
        arr.add(new Items("Coptic Museum",R.drawable.copticmuseum,"02 23628766", 30.005558, 31.230136,"Located next to the famous Roman fortress of Babylon, the Coptic Museum is the largest museum of Egyptian Coptic antiquities in the world, where you will see the most important collections dating back to the Coptic era of Egyptian history, which number about 16,000 artifacts from different regions of Egypt. The museum is characterized by its stone structure with a distinctive architectural design that mimics its era, and its beautiful facade resembling the mosque of the moon, and in front of it a statue of the founder of the museum, \"thick discotheque Pasha\" decorates its entrance, which was opened in 1910."));
        arr.add(new Items("Museum of Islamic Art",R.drawable.museumofislamicart,"02 23901520",30.044402, 31.252358,"The Museum of Islamic Art is located in Bab El-Khalq, one of the most important tourist attractions in Cairo and one of the largest Islamic museums in the world that simulates the era of Islamic rule in Egypt. For the Islamic era of glass and metal utensils, furniture, valuable stones, letter writing equipment, manuscripts, with information to give you what you see in Arabic and English and provides a corner for children."));
        arr.add(new Items("6th of October Panorama",R.drawable.thofoctoberpanorama,"02 24022317",30.074269, 31.306808,"The October War Panorama is one of Cairo's most important landmarks for history lovers. The performances are on display at the museum's theater, whose building appears from the outside in the form of a majestic circular building occupying a large area on Salah Salem Road.\n" +
                "Official working hours of the October War Panorama: Daily except Tuesday: 1- Morning 3 concerts 9.30, 11.00 and 12.30. 2- Evening: Two summer concerts: 6.00 and 7.30. Winter: 5.00, 6.30\n" +
                "October War Panorama Address: Salah Salem Street, Beside Cairo Stadium, Nasr City, Cairo ?, Egypt"));
        arr.add(new Items("Abdeen Palace",R.drawable.abdeenpalace,"02 23916909",30.042999, 31.247783,"One of the most important tourist places in Cairo reviews the history of the modern monarchy starting from the era of Khedive Ismail, who made a decision to build the palace in the last quarter of the 19th century until the end of the monarchy in Egypt by the 1952 revolution.\n" +
                "Located in the center of Cairo, the palace showcases this era of Egyptian history through a collection of museums in its surroundings, displaying the precious belongings of the royal family and the weapons used during their reign, as well as dedicated gifts from world presidents. An explanation is given by a guide appointed by the place management for a small fee.\n" +
                "During the journey between the various museums of the Abdin Palace, you can admire the beauty of the gardens and the vast green spaces that cover the surroundings of the palace and its outer roads, designed to emulate the history of its era."));
        arr.add(new Items("Alexandria Aquarium",R.drawable.alexandriaaquarium,"null",31.212797, 29.885005,"The Aquarium in Alexandria is a small museum that includes several species of fish and animals of the Mediterranean and Red Bahrain, as well as other species living in fresh water such as the Nile and the Amazon. Established in 1930, the museum is located near the Qaitbay Citadel in Anfoushi. In addition to the museum, the site includes an aquatic research institute."));
        arr.add(new Items("Alexandria National Museum",R.drawable.alexandrianationalmuseum,"03 4835519",31.200684, 29.913234,"Alexandria National Museum is one of Alexandria's museums in Egypt. The museum contains more than 1,800 artifacts representing most of the ages that passed to the city, which was founded in 332 BC. Address 110 Freedom Road."));
        arr.add(new Items("Graeco-Roman Museum",R.drawable.graecoromanmuseum,"050 2080119",31.199149, 29.906600,"The Greco-Roman Museum is a museum of archeology in Alexandria, Egypt. It presents a wide variety of antiquities found in Alexandria and its surroundings, most of which are from the Ptolemaic and subsequent Roman eras, especially since the emergence of Alexandria from the 3rd century BC to the 3rd century AD."));
        arr.add(new Items("Royal Jewelry Museum",R.drawable.royaljewelrymuseum,"03 5828348",31.240696, 29.963302,"The Royal Jewelry Museum is a museum displaying the jewelry of the royal families that ruled Egypt, and is located in Alexandria."));

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