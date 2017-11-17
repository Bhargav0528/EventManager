package com.example.bhargavbv.eventmanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.bhargavbv.eventmanager.Fragments.BookedFragment;
import com.example.bhargavbv.eventmanager.Fragments.ComboServicesFragment;
import com.example.bhargavbv.eventmanager.Fragments.OccassionsFragment;
import com.example.bhargavbv.eventmanager.Fragments.OffersandPicsFragment;
import com.example.bhargavbv.eventmanager.Fragments.PopularCombosFragment;
import com.example.bhargavbv.eventmanager.Fragments.ProfileFragment;

/**
 * Created by BhargavBV on 15-11-2017.
 */
public class ComboPageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ComboPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PopularCombosFragment tab1 = new PopularCombosFragment();
                return tab1;
            case 1:
                ComboServicesFragment tab2 = new ComboServicesFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}