package com.fgtpw.bobaapplication.current_runs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.fgtpw.bobaapplication.R;
import com.fgtpw.bobaapplication.networking.DataManager;

import java.util.ArrayList;

public class CurrentRunsFragment extends Fragment {

    public static CurrentRunsFragment newInstance() {
        CurrentRunsFragment fragment = new CurrentRunsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.currentruns, container, false);
        ListView list = (ListView) root.findViewById(R.id.currentruns_list);
        ArrayList<String> data = new ArrayList<String>();
        data.add("Boba");
        data.add("Chicken");
        DataManager dataManager = new DataManager(getActivity());
        dataManager.getCurrentRuns();
        list.setAdapter(new CurrentRunsAdapter(data, getActivity(),getFragmentManager()));
        return root;
    }
}
