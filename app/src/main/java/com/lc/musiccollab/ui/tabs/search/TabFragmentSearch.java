package com.lc.musiccollab.ui.tabs.search;

import android.support.v4.app.Fragment;
import android.widget.ImageButton;

import com.lc.musiccollab.R;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewsById;

/**
 * Created by topher on 1/24/2018.
 */

@EFragment(R.layout.fragment_tab_search)
public class TabFragmentSearch extends Fragment{

    @FragmentArg
    int index = 1;
}
