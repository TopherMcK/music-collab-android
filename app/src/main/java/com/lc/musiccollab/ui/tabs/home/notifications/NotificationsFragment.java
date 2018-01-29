package com.lc.musiccollab.ui.tabs.home.notifications;

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

@EFragment(R.layout.content_fragment_tab_notifications)
public class NotificationsFragment extends Fragment {
    public NotificationsFragment(){}

    @FragmentArg
    int index;

    @ViewById
    TextView homeText;

    @AfterViews
    void init()
    {
        homeText.setText(String.format("Notifications page selected", index));
    }
}
