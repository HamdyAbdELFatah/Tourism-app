package com.coders.tourism.Recommened;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.coders.tourism.R;
import com.coders.tourism.Recommened.Fragments.Architecture_rec;
import com.coders.tourism.Recommened.Fragments.Beach_rec;
import com.coders.tourism.Recommened.Fragments.FamilyAndKides;
import com.coders.tourism.Recommened.Fragments.Museum;
import com.coders.tourism.Recommened.Fragments.Parks;
import com.coders.tourism.Recommened.Fragments.Shopping;
import com.coders.tourism.Recommened.Fragments.TopAttractions;
import com.google.android.material.tabs.TabLayout;

public class RecommendedPlaces extends Fragment {
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_maps, container, false);
        viewPager = v.findViewById(R.id.ViewPager);
        viewPager.setAdapter(new viewpagerAdaptar(getChildFragmentManager()));
        tabLayout = v.findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        return v;
    }

    public class viewpagerAdaptar extends FragmentPagerAdapter {
        String []names={"Top Attractions","Architecture","Beach","FamilyAndKides","Museum","Parks","Shopping"};
        Fragment[]arr=new Fragment[7];
        public viewpagerAdaptar(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            arr[0]=new TopAttractions();
            arr[1]=new Architecture_rec();
            arr[2]=new Beach_rec();
            arr[3]=new FamilyAndKides();
            arr[4]=new Museum();
            arr[5]=new Parks();
            arr[6]=new Shopping();

            return arr[position];
        }
        @Override
        public int getCount() {
            return arr.length;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return names[position];
        }
    }
}
