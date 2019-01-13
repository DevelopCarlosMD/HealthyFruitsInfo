package com.coyotestudio.healthyfruitsinfo.fruits_view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.coyotestudio.healthyfruitsinfo.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFruitActivity extends AppCompatActivity {

    private static final String TAG = DetailFruitActivity.class.getSimpleName();
    //@BindView(R.id.imv_fruit_detail)
    //ImageView imvFruitDetail;
    @BindView(R.id.toolbar_detail)
    Toolbar toolbarDetail;
    @BindView(R.id.fab_search)
    FloatingActionButton fabSearch;
    @BindView(R.id.collapsing_detail)
    CollapsingToolbarLayout collapsing;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fruit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        initIntances();
        recoverData();

        return true;
    }

    public void initIntances() {

        ButterKnife.bind(this);
        initCollapsingTool("");
        FirebaseApp.initializeApp(this);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }

    public void initCollapsingTool(String titlefruit) {
        // String from the title fruit
        collapsing.setTitle("Watermelon");
    }

    public void recoverData() {
        mDatabase = FirebaseDatabase.getInstance().getReference();

        if (mDatabase != null) {
            //mDatabase.child("juicefruit
            Log.i(TAG, "Recover db success!!");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.option_about:
                Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option_contact:
                Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option_share:
                Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}