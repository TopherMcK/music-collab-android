package com.lc.musiccollab.ui.home;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.lc.musiccollab.R;
import com.lc.musiccollab.data.SessionManager;
import com.lc.musiccollab.ui.BaseActivity;
import com.lc.musiccollab.ui.tabs.home.HomeTabsPagerAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

@EActivity(R.layout.activity_home)
@OptionsMenu(R.menu.primary_options_menu)
public class HomeActivity extends BaseActivity
{

    @AfterInject
    void onInjectDependencies()
    {
        AndroidInjection.inject(this);
    }

    //    @Inject
    HomeView homeView;

    HomeTabsPagerAdapter adapter;

    @Inject
    SessionManager sessionManager;

    @OptionsItem(R.id.logout)
    public void logout()
    {
        sessionManager.logoutUser();
    }

    @ViewById(R.id.pager)
    ViewPager viewPager;

    @ViewById(R.id.main_tab_layout)
    TabLayout mainTabLayout;

    @ViewById
    BottomNavigationView bottomNav;

    @AfterViews
    void init()
    {
        adapter = new HomeTabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        mainTabLayout.setupWithViewPager(viewPager);
    }

    public FragmentManager getHomeSupportFragmentManager()
    {
        return getSupportFragmentManager();
    }

}
