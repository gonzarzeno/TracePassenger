package com.tracepassenger.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.tracepassenger.adapters.AGroup;
import com.tracepassenger.adapters.APassenger;
import com.tracepassenger.domain.JourneyGroup;
import com.tracepassenger.domain.Passenger;

import java.util.List;

/**
 * Created by Gonzalo on 6/7/2017.
 */

public class ViewPassengersGroup extends AppCompatActivity {

    public static String EXTRA_INTENT_ID = "GroupId";
    public static String EXTRA_INTENT_NAME = "GroupName";
    private static RecyclerView mRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private static RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpassengersgroup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String groupId = getIntent().getStringExtra(EXTRA_INTENT_ID);
        String groupName = getIntent().getStringExtra(EXTRA_INTENT_NAME);
//        Passenger pass = new Passenger("Gonzalo","Arzeno");
//        pass.setGroupId(1);
//        pass.save();
        List<Passenger> passengerList = Passenger.find(Passenger.class, " Group_Id = ?",groupId);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new APassenger(passengerList);
        mRecyclerView.setAdapter(mAdapter);
        setTitle("Pasajeros de: " + groupName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_addeditgroup, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_save) {
//
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
