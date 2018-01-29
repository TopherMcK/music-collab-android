package com.lc.musiccollab.ui.tabs.home.connections_list;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.lc.musiccollab.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

/**
 * Created by topher on 1/27/2018.
 */

@EFragment(R.layout.content_fragment_tab_connections)
public class ConnectionsFragment extends Fragment {
    public ConnectionsFragment(){}

    @FragmentArg
    int index;

    @ViewById
    TextView homeText;

    @AfterViews
    void init()
    {
        homeText.setText(String.format("Message Threads page selected", index));
    }
}
