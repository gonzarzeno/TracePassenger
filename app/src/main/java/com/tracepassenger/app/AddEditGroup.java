package com.tracepassenger.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tracepassenger.domain.JourneyGroup;

/**
 * Created by Gonzalo on 5/7/2017.
 */

public class AddEditGroup extends AppCompatActivity {

    public static String EXTRA_INTENT_ID = "GroupId";
    private EditText edtIdentifier;
    private EditText edtGroupName;
    private EditText edtCoordinatorName;
    private FloatingActionButton btnSave;
    private JourneyGroup mJourneyGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addeditgroup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edtIdentifier = (EditText) findViewById(R.id.edtIdentifier);
        edtCoordinatorName = (EditText) findViewById(R.id.edtCoordinatorName);
        edtGroupName = (EditText) findViewById(R.id.edtGroupName);
        final String groupId = getIntent().getStringExtra(EXTRA_INTENT_ID);
        setTitle(groupId.equals("") ? getString(R.string.AddGroup) : getString(R.string.EditGroup));
        mJourneyGroup = addOrEdit(groupId);
    }

    private boolean validateInputs()
    {
        return !edtIdentifier.getText().toString().equals("") || !edtCoordinatorName.getText().toString().equals("") || !edtGroupName.getText().toString().equals("");
    }

    private void addEditGroup(JourneyGroup mJourneyGroup)
    {
        mJourneyGroup.setCoordinatorName(edtCoordinatorName.getText().toString());
        mJourneyGroup.setGroupName(edtGroupName.getText().toString());
        mJourneyGroup.setIdentifier(edtIdentifier.getText().toString());
        mJourneyGroup.save();
    }

    private JourneyGroup addOrEdit(String groupId)
    {
        JourneyGroup journeyGroupSelected = new JourneyGroup();
        if(!groupId.equals(""))
        {
            journeyGroupSelected = JourneyGroup.findById(JourneyGroup.class, Long.parseLong(groupId));
            if(journeyGroupSelected != null)
            {
                edtIdentifier.setText(journeyGroupSelected.getIdentifier());
                edtCoordinatorName.setText(journeyGroupSelected.getCoordinatorName());
                edtGroupName.setText(journeyGroupSelected.getGroupName());
            }
        }
        return journeyGroupSelected;
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent returnIntent = getIntent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_addeditgroup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            if(validateInputs())
            {
                addEditGroup(mJourneyGroup);
                Intent returnIntent = getIntent();
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
            else
            {
                Toast.makeText(getApplicationContext(), R.string.NotEmptyInputsAllowed,
                        Toast.LENGTH_SHORT).show();
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
