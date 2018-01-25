package com.lc.musiccollab.ui.tabs.home;

import android.support.v4.app.Fragment;
import android.widget.ImageButton;
import android.widget.TextView;

import com.lc.musiccollab.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;

/**
 * Created by topher on 1/24/2018.
 */

@EFragment(R.layout.content_fragment_tab_home)
public class TabFragmentHome extends Fragment {

    public TabFragmentHome(){}
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
