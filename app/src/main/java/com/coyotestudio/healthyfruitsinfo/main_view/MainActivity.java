package com.coyotestudio.healthyfruitsinfo.main_view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.coyotestudio.healthyfruitsinfo.model.Fruta;
import com.coyotestudio.healthyfruitsinfo.utils.Util;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

import com.coyotestudio.healthyfruitsinfo.R;
import com.coyotestudio.healthyfruitsinfo.about.AboutOfActivity;
import com.coyotestudio.healthyfruitsinfo.main_view.data.MainViewAdapter;
import com.coyotestudio.healthyfruitsinfo.main_view.data.MainViewData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_main_container)
    RecyclerView rvMainViewOptions;
    private ArrayList<MainViewData> mArrayMenuInitial;
    private MainViewAdapter mAdapter;
    private final static String TAG = MainActivity.class.getSimpleName();
    public static ArrayList<Fruta> arrFrutas = new ArrayList<>();
    private FirebaseDatabase mDatabase = null;
    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        int gridColumnContent = getResources().getInteger(R.integer.grid_column_main_count);
        rvMainViewOptions.setLayoutManager(new GridLayoutManager(this, gridColumnContent));
        mArrayMenuInitial = new ArrayList<>();
        mAdapter = new MainViewAdapter(this, mArrayMenuInitial);
        initData();
        rvMainViewOptions.setAdapter(mAdapter);

        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        Fabric.with(this, new Crashlytics());

        // Get a reference to our frutas
        //final FirebaseDatabase database = FirebaseDatabase.getInstance();
        if (mDatabase == null) {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            //database.setPersistenceEnabled(true);
            mDatabase = database;
        }

        DatabaseReference ref = mDatabase.getReference("frutas");
        // Attach a listener to read the data from frutas
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Fruta frutas = dataSnapshot.getValue(Fruta.class);
                for (DataSnapshot frutaSanapShot :
                        dataSnapshot.getChildren()) {
                    Fruta fruta = frutaSanapShot.getValue(Fruta.class);
                    arrFrutas.add(fruta);
                    Log.i(TAG, "onDataChange: " + fruta.getNombre());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Log.i(TAG, "onCancelled: ");
                Toast.makeText(MainActivity.this,
                        "Error al momento de cargar los datos",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        //MenuItem item = menu.findItem(R.id.action_option_share);
        //mShareActionProvider = (ShareActionProvider) item.getActionProvider();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_about:
                //Toast.makeText(this, "About option listener", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, AboutOfActivity.class);
                startActivity(i);
                break;
            case R.id.action_option_share:
                //Toast.makeText(this, "Share option listener", Toast.LENGTH_SHORT).show();
                Util.createShareIntent(this);
                break;
            case R.id.option_contact:
                //Toast.makeText(this, "Contact option Listener", Toast.LENGTH_SHORT).show();
                Util.sendEmail(this);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab_search)
    public void searchMainView() {

        // Todo validar si es necesaria la busqueda en la vista inicial
        //Intent intent = new Intent(this, FruitsActivity.class);
        //startActivity(intent);
    }

    public void initData() {
        String[] mainTitlesOption = getResources().getStringArray(R.array.main_titles);
        TypedArray mainImagesResources = getResources().obtainTypedArray(R.array.main_images);

        mArrayMenuInitial.clear();

        for (int i = 0; i < mainTitlesOption.length; i++) {
            mArrayMenuInitial.add(new MainViewData(mainTitlesOption[i],
                    mainImagesResources.getResourceId(i, 0)));
        }

        mainImagesResources.recycle();
        mAdapter.notifyDataSetChanged();
    }


}
