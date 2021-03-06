package com.coders.tourism.Map.MapFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

public class TopAttractions extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
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
                            LatLng(28.394339, 32.658090), 6));
            }
        });
        gMap.setOnMarkerClickListener(this);
    }

    private ArrayList<Items> getData() {
        ArrayList<Items> arr=new ArrayList<>();
        arr.add(new Items("Sharm El Sheikh",R.drawable.sharmelsheikh,"null",27.91582,34.32995,"When you meet the sea and the desert in one spot, you are certainly on a date with a charming adventure and breathtaking beauty, and this is what Sharm el-Sheikh hotels offer to its lovers, where the sea and the turquoise beaches that embrace the warm sun to create an oasis of comfort and relaxation from the trouble of bustling life. One of the most beautiful natural areas suitable for diving and exploring the coral reefs and creative marine life, and a short visit from Sharm El-Sheikh Beach to the island of \"Tiran\" located in the reserve will prove this talk, you can dive with the world of fish and strange creatures buried in the belly of the sea, while \"Shark Bay\" does not contain medicine It includes a bunch of the most luxurious resorts and beach hotels with stunning views and fine restaurants, equip many bottles of water, glasses and sunscreen caps and embark on a journey of suspense to the mysterious oases and deserts of Sinai, and enjoy a night in the hospitality of the Bedouin with Arabic coffee and brilliant stars In the clear sky of the desert, you will have the strange feeling of safety and peace we lack these days."));
        arr.add(new Items("Hurghada",R.drawable.hurghada,"null",27.25738,33.81291,"It is a busy three-hour trip to Luxor, while half an hour away from El Gouna and an hour from Safaga.Hurghada offers a world of luxury resorts and hotels that compete in its services and features, in addition to many entertainment cities. Water for children and families such as Makadi Water World and Aqua Park Jungle. The Marina is one of the most popular tourist areas, with a yacht marina and a wide pier shaded by beautiful palm trees, with dozens of restaurants, cafes and shops. From the most beautiful Shaw The world's coasts, characterized by shallow turquoise waters and white sand spotless, Hurghada represents a practical option to enjoy the sea and launch trips to the rest of the famous Egyptian cities."));
        arr.add(new Items("Sahl Hasheesh",R.drawable.sahlhasheesh,"null",27.016393,33.882691,"Sahl Hasheesh is located half an hour south of Hurghada Airport, one of the newly created huge tourist projects, to serve as a luxury tourist village that fascinates tourists with its facilities, beaches and luxury resorts. Luxury yachts, top-class golf courses, a horseback riding club and various sports centers. The most important resorts in this region are Palm Beach Piazza and Aubrey Sahl Hasheesh. These hotels offer an unparalleled tourist experience for high-cost trips. G temperatures mild winter, while in summer heat rises dramatically."));
        arr.add(new Items("Gouna",R.drawable.gouna,"null",27.394339,33.658090,"Also close to Hurghada and 22 km north of Hurghada Airport is the upscale tourist area \"El Gouna\", which is a large sunny and mild resort throughout the year and offers comfort, relaxation and privacy for travelers looking for calm and away from the hustle and bustle. Especially for swimming, one of the areas that attract lovers of marine sports, where diving, sailing, windsurfing, sailing and water skiing with rope, El Gouna consists of several neighborhoods designed intimate and tasteful, and has a large hospital and golf courses and spa centers Zaytuna Beach is the most beautiful beach in addition to the marina yacht \"Marina Abu Tig\", which extends on the coast a wonderful selection of restaurants and cafes with balconies overlooking the sea, and small boutiques selling gifts and souvenirs"));
        arr.add(new Items("Safaga",R.drawable.safaga,"null",26.750392,33.936661,"Safaga is about 53 km south of Hurghada, a quiet tourist area that does not experience much congestion, such as in Hurghada and Sharm El Sheikh, Safaga includes a group of cottages and small tourist villages with a sandy beach shallow and clear and beneficial to health, characterized by sunny weather and mild weather for days Surfing and snorkeling are among the most important activities here, especially in Sharm El Naga, which boasts exquisite colors of coral reefs and rare marine life. Safaga is famous for restaurants that offer seafood and fish. Luxor is about 231 km away."));
        arr.add(new Items("Soma Bay",R.drawable.somabay,"0122 326 0700",26.840104,33.950962,"Soma Bay is located 45 km south of Hurghada Airport and 25 km near Safaga. Soma Bay is characterized by beautiful coral reefs that attract diving enthusiasts. The Sheraton Soma Bay Resort and Kempinski Hotel are the most beautiful parts to visit in Soma Bay."));
        arr.add(new Items("Makadi Bay",R.drawable.makadibay,"null",26.982663,33.880581,"Makadi Bay is another bay of charming bays on the Red Sea coast of Egypt.It is located halfway between Hurghada and Safaga. Stunning and colorful, Makadi Bay also has stables with some of the best and most beautiful horses in Egypt. The gardens Msabhaa that offer a haven to relax and escape from the summer heat and the noise of life, of the most illustrious names here, \"Jazz Acquaviva Resort\" and \"Steijunbad Makadi Hôtel\" and many others."));
        arr.add(new Items("El Qoseir",R.drawable.elqoseir,"null",26.106493,34.279548,"It has been transformed from a gold mine in the Pharaonic era to a quiet and popular tourist resort for visitors, and is said to be called \"short\" because it shortens the distance between the coast and Upper Egypt, and is about two hours south of Hurghada and 3 hours from Luxor, and features a hot desert climate, so we recommend Visiting in the winter, which is warm in this city, Qusair is rich in its Pharaonic, Roman, Coptic and Islamic monuments, most notably the \"Castle of Quseir\", is also a vital point for diving because of its neighborhoods and coral rich, and the most important hotels and resorts in the beautiful Quseir And 'Radis N Blue Resort. \""));
        arr.add(new Items("Marsa Alam",R.drawable.marsaalam,"null",25.065149,34.897320,"Marsa Alam is about an hour and a half away from Quseir, one of the famous tourist places in Egypt, which is receiving increasing popularity from Arab and foreign visitors.Marsa Alam has a mild climate that makes it suitable for holidays all year round.Also, there is an airport about half an hour from the city center. Scuba diving is one of the most practiced marine sports here, where coral reefs and nature reserves are less frequent. The Dolphin Reserve provides a golden opportunity for those who dream of diving and playing with dolphins. Sharm El-Luli Beach is one of the most beautiful beaches in the world, which has recently gained its reputation. Advanced rating At the beaches of the world, the traveler will feel that in one of the charming beaches of the Maldives, where the soft white sand and shallow turquoise and scattered trees here and there like you are in a piece of paradise, and there are a number of recreational water parks such as \"Coraya\" water park, and the most famous parts Marsa Alam is worth a visit to the harbor or what is known as the \"Port Ghalib\", which has been established around many hotels and resorts in Marsa Alam, and has a beautiful pier along the beach and a number of cafes, restaurants and shops that sell gifts, souvenirs and Egyptian manufactures."));
        arr.add(new Items("Mersa Matruh",R.drawable.mersamatruh,"null",31.354742,27.236631,"Marsa Matrouh is about two and a half hours west of Alexandria. The mild climate Despite the high temperatures in summer, the city contains a number of ancient Pharaonic monuments such as \"Temple of Ramses II\" which is half an hour from\n" + " The city center is also famous for the beautiful sandy beaches that made it a prestigious place in the world of tourism and travel in addition to the hotels in Marsa Matrouh, which attracts a lot of visitors. In addition to the \"Cleopatra Beach\" which resembles a lake or a natural jacuzzi pool, the legend says that the beautiful Cleopatra was bathing in this place, while the beach \"Gram\" was named after the famous Egyptian artist \"Leila Murad\", which sang for love and love near him, and after that The traveler takes a premium Adequate love and imagination advise them to go to the \"Libyan market\" to tour a popular shopping and buy clothes, accessories, perfumes and spices that is unprecedented."));
        arr.add(new Items("El Alamein",R.drawable.elalamein,"null",30.824721,29.005837,"The city of El Alamein is located east of Marsa Matrouh, about an hour and a half from Alexandria, accessible by air where there is an international airport, in addition to a road linking it to Cairo and Alexandria,\n" + " It is a city with a mild heat and has a nice climate even in the hot summer, has been associated with the name of this city of World War II, where a fierce battle ended with the defeat of the Germans, and scattered military sites, memorials and cemeteries of the victims of the war or the so-called \"Commonwealth Cemetery\" Apart from the wars, El Alamein offers luxury and charming sandy beaches stretching on its Mediterranean coast. C. This small village has become a first-class resort, surrounded by hotels, luxury resorts, playgrounds, spaces and green gardens. Bar and Marassi Resort."));
        arr.add(new Items("Ain Sokhna",R.drawable.ainsokhna,"null",29.668633,32.337377,"Overlooking the Gulf of Suez and about an hour and a half from Cairo, Ain Sokhna is a popular place for Egyptians. This makes Ain Sokhna hotels and resorts suitable for holidays in summer and winter, has become a luxury tourist attraction, Ain Sokhna scattered along the huge resorts resembling small towns, in addition to the quiet sandy beaches where various activities and water sports such as go Jazz Little Venice Resort is one of the best entertainment centers, which offers fun and entertainment for adults and children, and there are dozens of restaurants, cafes, shops, galleries, cinema, entertainment cities, games and amusement parks for children, and so Ain Sokhna is a suitable city for family tourism. If you are near do not miss the opportunity to taste delicious seafood and fresh fish in the restaurant \"Abu Ali\" famous."));
        arr.add(new Items("Taba",R.drawable.taba,"null",29.492275,34.895381,"Taba is located on the Gulf of Aqaba, and is about three hours away from Sharm El Sheikh, where Taba hotels are considered to be quiet places that are not congested and is an ideal holiday for privacy seekers, summer temperatures rise above forty degrees, while mild winter, and what distinguishes these The spot is the meeting point of three countries, where you can see the coasts of Jordan, Saudi Arabia and Palestine from its dreamy beach, \"Castle Zaman\" offers a unique tourist experience in this simple resort that offers delicious cuisine cooked with stunning views of the Gulf of Aqaba, can take a boat trip to Pharaoh's Island which is listening Above it is the Saladin Castle as one of the most prominent Islamic monuments in the Taba region. Golfers can practice their favorite sport at the vast golf club \"Taba Heights\". Safari and adventure enthusiasts are on a date with a round of challenge aboard the quad bikes that start in A trip to the \"colored valley\" or the groove, a rare natural phenomenon in the Taba Reserve, extending in the form of twisted rock valleys with dazzling shapes and colors, exciting and exciting at a cost of $ 50 per person."));
        arr.add(new Items("Dahab",R.drawable.dahab,"null",28.509133,34.513607,"Overlooking the Gulf of Aqaba, Dahab is an hour and a half away from Sharm El Sheikh. It has gained a wide reputation in the world of tourism because of its nature reserves, scenic spots and beaches. For tourists, the name Dahab is associated with \"Blue Hole\" which attracts tourists from all over the world to participate in professional diving races. And Horse riding is also a popular sport in Dahab, where there are beautiful horses for a wonderful trip on the beach, bazaars and popular markets offering various Egyptian manufactures and gifts at competitive prices with a series of quiet cafes overlooking the sea, in addition to Elegant hotels and resorts such as Dahab Paradise and Sheikh Ali Dahab resorts. Dahab has many tourist offices that organize safaris to the oases, desert and mountains surrounding the area. Li Musa Mountain, where tranquility, comfort and stunning views, is located near this monastery many mountains suitable for climbing and oases inhabited by Bedouins who welcome every visitor with Arabic coffee, smile and friendly hospitality."));
        arr.add(new Items("Nuweiba",R.drawable.nuweiba,"null",28.973268,34.653517,"Located halfway between Dahab and Taba, Nuweiba is about an hour away from Dahab.It is a quiet natural place that has not been contaminated by human hands and modern civilization.Most of its inhabitants are Bedouin, and it is a haven for those looking for privacy in Nuweiba hotels that are calm and comfortable. On land and sea trips, in addition to the beautiful and uncrowded sandy beaches, where the ancient city of \"Nouamis\", which dates back to prehistoric times, and is spread by beautiful green oases such as the oasis \"Ain Khadra\" near the Monastery of \"Saint Catherine\", which contains a natural spring Of pure fresh water, it is the most important Yam camping in Nuweiba is a camping trip in the desert."));
        arr.add(new Items("Luxor",R.drawable.luxor,"null",25.687241,32.639631,"Luxor city is located in the center of Egypt on the Nile Delta, and about 3 and a half hours from Aswan,\n" +
                " Perhaps the trip to Egypt can only be completed by visiting this ancient city and ancient history, it has many treasures of the Pharaonic traveler dive into secrets and fictional stories, and Luxor hotels are witnessing a large crowd of visitors who flock to it from all poles of the earth, and one of the most important things to see The \"Karnak Temple\" and \"Luxor Temple\", which tell the history of Egypt through the ages and represent an architectural monument and art painting very well and dazzling, in addition to the \"Valley of the Kings\", which includes many of the Pharaonic tombs of the dynasties that ruled Egypt, the atmosphere may become very hot In summer in these areas After touring the worlds of the ancient Pharaohs, we recommend that you take a tour of the balloon and enjoy the view of the city and the vast desert on its outskirts. Busy from early morning to 12pm, if your visit is long, try a trip\n" +
                "In the boats that cruise the Nile down to the city of Aswan south of Luxor, with the melodies of music and folkloric performances of Egypt and the sound of the flute that dances the Nile under a clear sky and carefree."));
        arr.add(new Items("Aswan",R.drawable.askwan,"null",24.088932,32.899832,"Aswan is located to the south of Luxor, an ancient city and a popular tourist destination for many, Aswan is characterized by Nubian culture and civilization, which is still present today in the villages and surrounding landmarks,\n" +
                "Elephantine Island is one of the lively museums that strongly exhibit Nubian houses and culture. Aswan's hotels and resorts vary from luxurious to affordable, in addition to the fact that Aswan houses many temples and ancient monuments.One of the most important activities that can be done in Aswan is by boat on the Nile to visit the Nubian villages scattered around the Delta, where colorful and decorated houses and small domes Like fictional villages, there are a number of popular markets selling spices, tea and aromatic herbs. High-end in Egypt,\n" +
                " The garden extends throughout the island and includes different forms and types of flowers, trees and plantations, and there is a wonderful restaurant overlooking the Nile River, and deserves 'Elephant Island' also worth strolling in its ancient temples and picturesque scenery, representing Aswan a creative world with its islands and protected areas and the richness of cultures and dazzling history."));
        arr.add(new Items("Siwa Oasis",R.drawable.siwaqasis,"null",29.203180,25.519557,"Siwa Oasis is located in the desert of Western Egypt and is approximately 3 and a half hours from Marsa Matrouh,\n" +
                "Visiting this area requires great courage and determination from the tourist who dreams of a trip to a secluded world\n" +
                " A long and difficult road to reach Siwa gives it an added value and make it a precious jewel in the heart of the vast desert, where we recommend to visit as part of a day trip from the city of Mersa Matruh, but if you want to spend a night or more we recommend you to try a hotel Albabenshal, which you can reserve by entering his name into our search engine to access his page. One of the most important landmarks in Siwa is the Citadel of Shali, one of the oldest historic cities in Egypt, and the nearby Mount of the Dead, which evokes awe and desire to explore its sights and learn about its fairy tale, is a collection of tombs dating back To the Pharaonic era, characterized by its strange conical shape, and if the sea away from the oasis of Siwa, the \"Great Sand Sea\" is very close, what do you think of skiing on a sea of \u200B\u200Bsoft sand dunes extending to the borderless?!, And complete the excitement of quad biking and challenge the harsh desert, and during Touring you in\n" +
                "Sea of \u200B\u200Bsand You will meet the \"one well\", a well of hot sulfurous water as if the eye of the angry desert in this wonderful place, and do not forget to visit the \"Cleopatra bath\" to enjoy swimming in the spring of hot water, which is wrapped around orchards and green gardens as if a planet from another world What we are used to, Siwa Oasis and the nearby oases belong to an unconventional tourist experience for the tourist seeking the truth."));
        arr.add(new Items("pyramids",R.drawable.pyramids,"null",29.977293,31.132500,"Egyptian pyramids are ancient pyramid-shaped buildings located in Egypt. As of November 2008, sources indicate that 118 or 138 is the number of specific Egyptian pyramids. [1] [2] Most were built as tombs of the country's pharaohs and their companions during the ancient and central periods. [3] [4] [5] The earliest known Egyptian pyramids are located in Saqqara, northwest of Memphis. The oldest of these pyramids is the Pyramid of Djoser, which was built c. 2630-2610 BC during the Third Dynasty. [6] This pyramid and its surrounding complex were designed by the architect Imhotep, and is generally considered the oldest massive structure in the world constructed from apostate construction. [7] The most famous Egyptian pyramids are those in Giza, on the outskirts of Cairo. Many of the pyramids of Giza are among the largest structures ever built. [8] The Pyramid of Cheops in Giza is the largest Egyptian pyramid. It is the only one of the seven wonders of the ancient world that persists"));

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