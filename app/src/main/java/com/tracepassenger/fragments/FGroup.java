package com.tracepassenger.fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Toast;

import com.tracepassenger.adapters.AGroup;
import com.tracepassenger.adapters.APassenger;
import com.tracepassenger.app.AddEditGroup;
import com.tracepassenger.app.R;
import com.tracepassenger.domain.JourneyGroup;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;


public class FGroup extends Fragment {

    private static RecyclerView mRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private static RecyclerView.LayoutManager mLayoutManager;
    private View thisFragment;
    private static Menu mMenu;
    public static ArrayList<Long> selectedIds = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        thisFragment = inflater.inflate(R.layout.fgroup, container, false);
        loadGroups(thisFragment);
        setHasOptionsMenu(true);
        FloatingActionButton fab = (FloatingActionButton) thisFragment.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddEditGroup.class);
                intent.putExtra(AddEditGroup.EXTRA_INTENT_ID, "");
                startActivityForResult(intent,1);
            }
        });
        selectedIds.clear();
        AGroup.itemsSelected = false;

        return thisFragment;
    }

    public static FGroup newInstance()
    {
        FGroup f = new FGroup();
        return f;
    }

    private void loadGroups(View thisFragment)
    {
        List<JourneyGroup> journeyGroupArrayList = JourneyGroup.listAll(JourneyGroup.class);
        mRecyclerView = (RecyclerView) thisFragment.findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AGroup(journeyGroupArrayList, getContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Toast.makeText(getActivity(), R.string.AddEditGroupSucces,
                        Toast.LENGTH_SHORT).show();

            }
            clearMenuItems();
            loadGroups(thisFragment);
        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        this.mMenu = menu;
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_edit:
                editItem();
                return true;
            case R.id.action_delete:
                dialogDelete();
                return true;
        }

        return super.onOptionsItemSelected(item); // important line
    }

    private void editItem()
    {
        Intent intent = new Intent(getContext(),AddEditGroup.class);
        intent.putExtra(AddEditGroup.EXTRA_INTENT_ID,selectedIds.get(0)+"");
        startActivityForResult(intent,1);
    }

    private void dialogDelete()
    {
        new AlertDialog.Builder(getActivity())
                .setMessage(selectedIds.size()>1?"¿Eliminar "+ selectedIds.size() + " grupos?":"¿Eliminar grupo?")
                .setNegativeButton(R.string.Cancel, null) // dismisses by default
                .setPositiveButton(R.string.Delete, new DialogInterface.OnClickListener() {
                    @Override public void onClick(DialogInterface dialog, int which) {
                        // do the acknowledged action, beware, this is run on UI thread
                        deleteItems();
                        loadGroups(thisFragment);
                    }
                })
                .create()
                .show();
    }

    private void deleteItems()
    {
        for(int i = 0; i<selectedIds.size();i++)
        {
            JourneyGroup mGroup = JourneyGroup.findById(JourneyGroup.class, selectedIds.get(i));
            mGroup.delete();
        }
        clearMenuItems();
    }

    private void clearMenuItems()
    {
        selectedIds.clear();
        switchMenuItems();
        AGroup.itemsSelected = false;
    }

    public static void switchMenuItems()
    {
        switch (selectedIds.size())
        {
            case 0:
                mMenu.findItem(R.id.action_edit).setVisible(false);
                mMenu.findItem(R.id.action_delete).setVisible(false);
                break;
            case 1:
                mMenu.findItem(R.id.action_edit).setVisible(true);
                mMenu.findItem(R.id.action_delete).setVisible(true);
                break;
            default:
                mMenu.findItem(R.id.action_edit).setVisible(false);
                mMenu.findItem(R.id.action_delete).setVisible(true);
                break;
        }

    }
}
