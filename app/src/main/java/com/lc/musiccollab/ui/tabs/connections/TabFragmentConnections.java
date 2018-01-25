package com.lc.musiccollab.ui.tabs.connections;

import android.support.v4.app.Fragment;
import android.widget.ImageButton;

import com.lc.musiccollab.R;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewsById;

/**
 * Created by topher on 1/24/2018.
 */

@EFragment(R.layout.fragment_tabs_connections)
public class TabFragmentConnections extends Fragment {

    @FragmentArg
    int index = 2;
}
