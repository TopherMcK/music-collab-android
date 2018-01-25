package com.lc.musiccollab.ui.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lc.musiccollab.MainActivity;
import com.lc.musiccollab.MainActivity_;
import com.lc.musiccollab.R;
import com.lc.musiccollab.ui.tabs.connections.TabFragmentConnections;
import com.lc.musiccollab.ui.tabs.home.TabFragmentHome;
import com.lc.musiccollab.ui.tabs.search.TabFragmentSearch;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.FragmentById;

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
        return MainActivity_.HomeFragment_.builder()
                .index(position + 1).build();
    }

    @Override
    public int getCount()
    {
        return 3;
    }
}
