package com.coders.tourism.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.coders.tourism.R;
import com.coders.tourism.Recommened.Fragments.Items;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Place extends AppCompatActivity {
    ImageButton favorite;
    ImageView imageView;
    TextView desc;
    TextView title;
    TextView call;
    TextView share;
    TextView getthere;
    byte f = 0;
    Intent intent;
    GradientDrawable Circle;
    ArrayList<String> arrname;
    ArrayList<String> arrlat;
    ArrayList<String> arrlng;
    ArrayList<String> arrdesc;
    ArrayList<String> arrphone;
    ArrayList<Integer> arrimg;
    ArrayList<String> arrname1;
    ArrayList<String> arrlat1;
    ArrayList<String> arrlng1;
    ArrayList<String> arrdesc1;
    ArrayList<String> arrphone1;
    ArrayList<Integer> arrimg1;
    String myname,mylat,mylang,mydesc,myphone;
    int i,myi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        favorite = findViewById(R.id.favorite);
        Circle = (GradientDrawable) favorite.getBackground();
        Circle.setColor(getResources().getColor(R.color.white));
        favorite.setImageDrawable(getResources().getDrawable(R.drawable.favoriton));
        intent = getIntent();

       arrname1=new ArrayList<>();
        arrlat1=new ArrayList<>();
         arrlng1=new ArrayList<>();
        arrdesc1=new ArrayList<>();
       arrphone1=new ArrayList<>();
         arrimg1=new ArrayList<>();
         arrname=intent.getStringArrayListExtra("name");
         arrlat=intent.getStringArrayListExtra("lat");
         arrlng=intent.getStringArrayListExtra("lng");
         arrdesc=intent.getStringArrayListExtra("desc");
         arrphone=intent.getStringArrayListExtra("phone");
         arrimg=intent.getIntegerArrayListExtra("img");
        i = intent.getIntExtra("index",0);
        imageView = findViewById(R.id.imageView);
        desc = findViewById(R.id.description);
        title = findViewById(R.id.title);
        call = findViewById(R.id.call);
        share = findViewById(R.id.share);
        getthere = findViewById(R.id.get_thee);
        imageView.setImageDrawable(getResources().getDrawable(arrimg.get(i)));
        desc.setText(arrdesc.get(i));
        title.setText(arrname.get(i));
        RecyclerView recyclerView=findViewById(R.id.horizental_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new RecyclerAdapter());
        arrname1.addAll(arrname);
        arrlat1.addAll(arrlat);
        arrlng1.addAll(arrlng);
        arrdesc1.addAll(arrdesc);
        arrphone1.addAll(arrphone);
        arrimg1.addAll(arrimg);
        arrname1.remove(i);
        arrlat1.remove(i);
        arrlng1.remove(i);
        arrdesc1.remove(i);
        arrphone1.remove(i);
        arrimg1.remove(i);
        SharedPreferences prefs = getSharedPreferences("FAVORITE", MODE_PRIVATE);
        String name = prefs.getString(arrname.get(i), "Noname");
        if(!name.equals("Noname")){
            Circle.setColor(getResources().getColor(R.color.colorAccent));
            favorite.setImageDrawable(getResources().getDrawable(R.drawable.favorite));
            f=1;
        }
    }

    public void favorite_click(View view) {
        GradientDrawable Circle = (GradientDrawable) favorite.getBackground();
        SharedPreferences.Editor editor = getSharedPreferences("FAVORITE", MODE_PRIVATE).edit();
        if (f == 0) {
            Circle.setColor(getResources().getColor(R.color.colorAccent));
            favorite.setImageDrawable(getResources().getDrawable(R.drawable.favorite));
            editor.putString(arrname.get(i), "true");
            editor.apply();
            f = 1;
        } else {
            SharedPreferences settings = getSharedPreferences("FAVORITE", MODE_PRIVATE);
            settings.edit().remove(arrname.get(i)).apply();
            Circle.setColor(getResources().getColor(R.color.white));
            favorite.setImageDrawable(getResources().getDrawable(R.drawable.favoriton));
            f = 0;
        }
    }
    public void back(View view) {
        finish();
    }
    public void control(View view) {
        if(view.getId()==R.id.call){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            if(arrname.get(i).trim().equals("null"))
                Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
            else{
            intent.setData(Uri.parse("tel:"+ arrphone.get(i)));
            startActivity(intent);}
        }
        else if(view.getId()==R.id.share){
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT,"Visit Egypt\n" +
                    "I found "+ arrname.get(i)+" And Resorts on the Visit Egypt App and thought you might like to visit it! Download the Visit Egypt App ");
            startActivity(Intent.createChooser(intent,"Share Via"));
        }
        else{
            String url = "https://www.google.com/maps/dir/?api=1&destination=" + arrlat.get(i) + "," + arrlng.get(i) + "&travelmode=driving";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        }
    }
    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(Place.this).inflate(R.layout.circle_rec,parent,false));
        }
        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int j) {
        holder.cimgv.setImageDrawable(getResources().getDrawable(arrimg1.get(j)));
        holder.text.setText(arrname1.get(j));
        holder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Place.this, Place.class);
                    intent.putStringArrayListExtra("name",arrname);
                    intent.putStringArrayListExtra("lat",arrlat);
                    intent.putStringArrayListExtra("lng",arrlng);
                    intent.putStringArrayListExtra("desc",arrdesc);
                    intent.putStringArrayListExtra("phone",arrphone);
                    intent.putIntegerArrayListExtra("img",arrimg);
                    if(i<=j)
                        intent.putExtra("index",j+1);
                    else
                        intent.putExtra("index",j);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return arrname1.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            CircleImageView cimgv;
            TextView text;
            RelativeLayout container;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cimgv=itemView.findViewById(R.id.profile_image);
                text=itemView.findViewById(R.id.name_reco);
                container=itemView.findViewById(R.id.circle_container);
            }
        }

    }

}
