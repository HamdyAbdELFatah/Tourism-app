package com.coders.tourism.Favorite;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coders.tourism.Map.Place;
import com.coders.tourism.R;
import com.coders.tourism.Recommened.Fragments.Items;

import java.util.ArrayList;
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    GradientDrawable Circle;
    byte f=0;

    public RecyclerAdapter(TextView found, ArrayList<Items> arr, Context c) {
        this.found = found;
        this.arr = arr;
        this.c = c;
    }

    TextView found;

    ArrayList<Items> arr;
    Context c;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(c).inflate(R.layout.add_recommend,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {
        holder.tite.setText(arr.get(i).name);
        holder.im.setImageDrawable(c.getResources().getDrawable(arr.get(i).img));
        holder.favorite.setImageDrawable(c.getResources().getDrawable(R.drawable.favoriton));
        Circle = (GradientDrawable) holder.favorite.getBackground();
        Circle.setColor(c.getResources().getColor(R.color.white));
        SharedPreferences prefs = c.getSharedPreferences("FAVORITE", c.MODE_PRIVATE);
        String name = prefs.getString(arr.get(i).name, "Noname");
        if(!name.equals("Noname")){
            Circle.setColor(c.getResources().getColor(R.color.colorAccent));
            holder.favorite.setImageDrawable(c.getResources().getDrawable(R.drawable.favorite));
            f=1;
        }else f=0;
        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = c.getSharedPreferences("FAVORITE", c.MODE_PRIVATE);
                settings.edit().remove(arr.get(i).name).apply();
                arr.remove(arr.get(i));
                if (arr.size()==0)
                    found.setVisibility(View.VISIBLE);
                else
                    found.setVisibility(View.INVISIBLE);
                notifyDataSetChanged();

            }
        });
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(c, Place.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
                intent.putExtra("index",i);
                c.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout container;
        ImageView im;
        ImageButton favorite;
        TextView tite;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            container=itemView.findViewById(R.id.recommended_choosed);
            im=itemView.findViewById(R.id.imageView_rec);
            favorite=itemView.findViewById(R.id.favorite_rec);
            tite=itemView.findViewById(R.id.title_rec);
        }
    }

}
