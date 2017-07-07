package com.tracepassenger.app;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.tracepassenger.fragments.FGroup;
import com.tracepassenger.fragments.FPassenger;

public class MainActivity extends AppCompatActivity {

    Drawer myDrawer;
    Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        myDrawer = new DrawerBuilder(this)
                .withRootView(R.id.drawer_container)
                .withToolbar(toolbar)
                .withDisplayBelowStatusBar(false)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.Home).withIcon(FontAwesome.Icon.faw_home).withIdentifier(0),
                        new PrimaryDrawerItem().withName(R.string.Passengers).withIcon(FontAwesome.Icon.faw_user).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.Groups).withIcon(FontAwesome.Icon.faw_users).withIdentifier(2),
                        new PrimaryDrawerItem().withName(R.string.Activity).withIcon(FontAwesome.Icon.faw_check).withIdentifier(3)
                )
                .withSavedInstance(savedInstanceState)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Fragment fragment;
                        switch ((int)drawerItem.getIdentifier())
                        {
                            case 0:
                                getSupportActionBar().setTitle(R.string.app_name);
                                getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
                                return false;
                            case 1:
                                fragment = FPassenger.newInstance();
                                getSupportActionBar().setTitle(R.string.Passengers);
                                currentFragment = fragment;
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment).commit();
                                return false;
                            case 2:
                                fragment = FGroup.newInstance();
                                currentFragment = fragment;
                                getSupportActionBar().setTitle(R.string.Groups);
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment).commit();
                                return false;
                            default:
                                return false;
                        }
                    }
                })
                .build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selected_groups, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
