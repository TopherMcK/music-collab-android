package com.lc.musiccollab.ui.home;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lc.musiccollab.R;
import com.lc.musiccollab.data.SessionManager;
import com.lc.musiccollab.ui.tabs.TabsPagerAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

@EActivity(R.layout.activity_home)
@OptionsMenu(R.menu.primary_options_menu)
public class HomeActivity extends AppCompatActivity {

    @Bean
    SessionManager sessionManager;

    @OptionsItem(R.id.logout)
    public void logout()
    {
        sessionManager.logoutUser();
    }

    @ViewById(R.id.main_tab_layout)
    TabLayout mainTabLayout;

    @ViewById(R.id.pager)
    ViewPager viewPager;

//    @ViewById
//    BottomNavigationView bottomNav;

    @Override
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @AfterViews
    void init()
    {
        sessionManager.checkLogin(getApplicationContext());

//        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Pacifico-Regular.ttf");

//        mainTabLayout.addTab(mainTabLayout.newTab().setTag("Tab 1"));
//        mainTabLayout.addTab(mainTabLayout.newTab().setTag("Tab 2"));
//        mainTabLayout.addTab(mainTabLayout.newTab().setTag("Tab 3"));
//        mainTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

//        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(adapter);
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainTabLayout));
//
//        mainTabLayout.setupWithViewPager(viewPager);
//
//        mainTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
//        {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab)
//            {
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab)
//            {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab)
//            {
//
//            }
//        });

        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        mainTabLayout.setupWithViewPager(viewPager);
    }

    @EFragment(R.layout.content_fragment_tab_home)
    public static class HomeFragment extends Fragment
    {
        public HomeFragment(){}

        @FragmentArg
        int index;

        @ViewById
        TextView homeText;

        @AfterViews
        void init()
        {
            homeText.setText(String.format("Page %d selected", index));
        }
    }

}
