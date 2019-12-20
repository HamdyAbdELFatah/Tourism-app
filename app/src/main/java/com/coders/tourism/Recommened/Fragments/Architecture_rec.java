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

public class Architecture_rec extends Fragment  {
        ArrayList<Items> arr;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    int f=0;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recommend, container, false);
        arr=getData();
         recyclerView=v.findViewById(R.id.recommend_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerAdapter=new RecyclerAdapter(arr,getActivity().getApplicationContext());
        recyclerView.setAdapter(recyclerAdapter);

        return v;
    }

    private ArrayList<Items> getData() {
        ArrayList<Items> arr=new ArrayList<>();
               arr.add(new Items("Cairo Tower",R.drawable.cairotower,"02 27365112",30.045910, 31.224289,"The Cairo Tower is a landmark in Cairo, where many tourists want to visit, in order to enjoy the distinctive design, which symbolizes the ancient Egyptian civilization, it consists of sixteen floors, and a base of Aswan granite stones, used by the ancient Egyptians, to build At present, the number of visitors to this tower, especially visitors from Arab countries, who wish to climb to its roof, which is characterized by its magnificent view of Cairo, where the duration of the climb to the surface does not take more than seconds, through which Tourists can see many important places in Egypt such as TV building, Sphinx, Nile, Salah El-Din castle, Al-Azhar and Pyramids, in addition to the visitors' ability to have lunch in the restaurants available in this tower, the most important of which is the circular restaurant located on the 14th floor, which Rotating around a focal point that enables the visitor to see Cairo, and contains nineteen tables, each accommodates five people, and the possibility of enjoying different types of juices and drinks from the top of the tower"));
               arr.add(new Items("Mosque of Muhammad Ali",R.drawable.mohamedali,"null",30.028699, 31.259916,"The mosque consists of a rectangular form divided into two parts: the eastern section, which is the house of prayer or the campus of the mosque, and the western section, which is the courtyard with a watering hole. Each section has two opposite doors, that is, the mosque has four doors, and from the door in the middle of the sea wall of the mosque we enter the courtyard, which is a large courtyard area of \u200B\u200Babout 53 × 54 meters under a cistern, surrounded by four galleries with marble columns carrying columns Small domes carved on the inside and overlaid on the outside with lead plates with copper crescents.\n" +
                       "In the center of the open courtyard we find a dome of ablution established in 1263 AH - 1844 AD with a wooden flap and built on eight marble pillars and the interior of this dome decorated with colorful paintings representing landscapes influenced by Western style. Inside this dome is another eight-sided dome with a marble crescent inscribed with prominent motifs, grape clusters, and a colorful pattern inscribed with Persian calligraphy by the calligrapher \"Sinklach\" Koranic verses of ablution, and bearing the date in 1263 (1863 AH)."));
               arr.add(new Items("Srabyom",R.drawable.srabyom,"null",30.516825, 32.331061,"Sarabium is an archaeological temple located in the hill pillar area. This temple was of tourist importance as a place of healing, flocked to patients or seekers healing through dreams or so-called incubation of the disease, where there were rooms around a temple for the accommodation of these patients worshiped to the goddess Serapis"));
               arr.add(new Items("Pompey's Pillar",R.drawable.pompeyspillar,"null",31.182330, 29.896299,"Column Sawari is a Roman archaeological column located in the city of Alexandria in Egypt, and is one of the most famous monuments in it. It was built on Tell Bab Sidra between the area of the current Muslim cemetery known as Al-Amoud cemetery and the archaeological plateau of Kom el Shoqafa. It is about 27 meters long and is made of red granite."));
               arr.add(new Items("Lighthouse of Alexandria",R.drawable.lighthouseofalexandria,"null",31.214238, 29.891324,"The lighthouse of Alexandria or the lighthouse of Alexandria - Pharos Alexandria - one of the seven wonders of the world mentioned by the Greeks, and its location on the edge of the Pharos Peninsula, the current place of Qaitbay Castle in Alexandria, Egypt. Considered the first lighthouse in the world. It was built by Sostratus during the reign of Ptolemy II in 270 BC It was 120 meters high and was destroyed in an earthquake in 1323."));
               arr.add(new Items("Cairo Citadel",R.drawable.cairocitadel,"02 25121735",30.029884, 31.261081,"The Citadel of Salah al-Din or the Citadel of the Mountain is a castle located on Mount Mokattam"));
               arr.add(new Items("Citadel of Qaitbay",R.drawable.citadelofqaitbay,"null",31.214006, 29.885649,"This castle is located at the end of the island of Pharos in the far west of Alexandria. From its construction in 884 AH."));
               arr.add(new Items("Mosque-Madrassa of Sultan Hassan",R.drawable.madrassaofsultanhassan,"null",30.032278, 31.256175,"Mosque, school and dome of Sultan Nasser Hassan or Sultan Hassan's school or Sultan Hassan Mosque is one of the famous archaeological mosques in Cairo. Described as the Dora of Islamic Architecture in the East, it is the most harmonious and harmonious monument of Islamic Cairo, and represents the maturity of Mamluk architecture."));
               arr.add(new Items("Bibliotheca Alexandrina",R.drawable.bibliothecaalexandrina,"03 4839999",31.208869, 29.909201,"The ancient Bibliotheca Alexandrina, known as the Royal Library of Alexandria, or the Great Library, is the largest library of its time. The library was subjected to numerous fires"));

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