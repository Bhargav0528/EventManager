package com.example.bhargavbv.eventmanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.bhargavbv.eventmanager.Fragments.BookedFragment;
import com.example.bhargavbv.eventmanager.Fragments.OccassionsFragment;
import com.example.bhargavbv.eventmanager.Fragments.OffersandPicsFragment;
import com.example.bhargavbv.eventmanager.Fragments.ProfileFragment;


/**
 * Created by BhargavBV on 04-11-2017.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                OffersandPicsFragment tab1 = new OffersandPicsFragment();
                return tab1;
            case 1:
                OccassionsFragment tab2 = new OccassionsFragment();
                return tab2;
            case 2:
                BookedFragment tab3 = new BookedFragment();
                return tab3;
            case 3:
                ProfileFragment tab4 = new ProfileFragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}