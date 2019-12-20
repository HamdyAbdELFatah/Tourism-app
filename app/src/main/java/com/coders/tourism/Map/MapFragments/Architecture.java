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

public class Architecture extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
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
       /* LatLng cairoTower=new LatLng(30.045910, 31.224289);
        LatLng mohamed_ali=new LatLng(30.028699, 31.259916);
        LatLng salah_eldein=new LatLng(30.029884, 31.261081);
        LatLng qaitbay=new LatLng(31.214006, 29.885649);
        LatLng fnar_alex=new LatLng(31.214238, 29.891324);
        LatLng sawary_tower=new LatLng(31.182330, 29.896299);
        LatLng srperum=new LatLng(30.516825, 32.331061);
        LatLng alex_liberary=new LatLng(31.208869, 29.909201);
        LatLng soltan_hassan=new LatLng(30.032278, 31.256175);
        gMap.addMarker(new MarkerOptions().position(cairoTower)
                .title("Cairo Tower")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mark));
        gMap.addMarker(new MarkerOptions().position(mohamed_ali)
                .title("Mohamed Ali")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mark));
        gMap.addMarker(new MarkerOptions().position(salah_eldein)
                .title("Salh El Dein")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mark));
        gMap.addMarker(new MarkerOptions().position(qaitbay)
                .title("Citadel of Qaitbay")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mark));
        gMap.addMarker(new MarkerOptions().position(fnar_alex)
                .title("Fnar Alex")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mark));
        gMap.addMarker(new MarkerOptions().position(sawary_tower)
                .title("Sawary Tower")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mark));
        gMap.addMarker(new MarkerOptions().position(srperum)
                .title("Cairo Tower")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mark));
        gMap.addMarker(new MarkerOptions().position(alex_liberary)
                .title("Alex Liberary")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mark));
        gMap.addMarker(new MarkerOptions().position(soltan_hassan)
                .title("Soltan Hassan")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.mark));*/
        gMap.getCameraPosition();
        gMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new
                        LatLng(30.029884, 31.261081), 7));
            }
        });
        gMap.setOnMarkerClickListener(this);

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
