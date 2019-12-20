package com.coders.tourism.Recommened.Fragments;
public class Items {
    public int img;
    public double lat,lng;
    public String name,phone,desc;
    public Items(String name, int img, String phone, double lat, double lng, String desc) {
        this.name = name;
        this.img = img;
        this.phone = phone;
        this.lat = lat;
        this.lng = lng;
        this.desc = desc;
    }
}
