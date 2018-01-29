package com.lc.musiccollab.ui.tabs.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lc.musiccollab.ui.tabs.home.connections_list.ConnectionsFragment_;
import com.lc.musiccollab.ui.tabs.home.notifications.NotificationsFragment_;
import com.lc.musiccollab.ui.tabs.home.suggested.SuggestedFragment_;

import org.androidannotations.annotations.EBean;

import javax.inject.Inject;

/**
 * Created by topher on 1/24/2018.
 */

public class HomeTabsPagerAdapter extends FragmentPagerAdapter {

    public HomeTabsPagerAdapter(FragmentManager fragmentManager)
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
        switch(position)
        {
            case 0:
                return SuggestedFragment_.builder()
                        .index(position + 1).build();
            case 1:
                return NotificationsFragment_.builder()
                        .index(position + 1).build();
            case 2:
                return ConnectionsFragment_.builder()
                        .index(position + 1).build();
            default:
                return SuggestedFragment_.builder()
                        .index(position + 1).build();
        }
    }

    @Override
    public int getCount()
    {
        return 3;
    }
}