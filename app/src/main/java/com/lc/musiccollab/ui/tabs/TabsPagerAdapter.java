package com.lc.musiccollab.ui.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lc.musiccollab.ui.home.HomeActivity_;

/**
 * Created by topher on 1/24/2018.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter (FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return "TAB " + (position + 1);
    }

    @Override
    public Fragment getItem(int position)
    {
        return HomeActivity_.HomeFragment_.builder()
                .index(position + 1).build();
    }

    @Override
    public int getCount()
    {
        return 3;
    }
}