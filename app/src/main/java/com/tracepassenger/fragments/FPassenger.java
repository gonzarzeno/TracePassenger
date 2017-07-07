package com.tracepassenger.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tracepassenger.adapters.APassenger;
import com.tracepassenger.app.R;
import com.tracepassenger.domain.Passenger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gonzalo on 3/7/2017.
 */

public class FPassenger extends Fragment {

    private static RecyclerView mRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private static RecyclerView.LayoutManager mLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View thisFragment = inflater.inflate(R.layout.fpassenger, container, false);

        List<Passenger> passengersList = Passenger.listAll(Passenger.class);
        mRecyclerView = (RecyclerView) thisFragment.findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new APassenger(passengersList);
        mRecyclerView.setAdapter(mAdapter);
        return thisFragment;
    }

    public static FPassenger newInstance()
    {
        FPassenger f = new FPassenger();
        return f;
    }

}
