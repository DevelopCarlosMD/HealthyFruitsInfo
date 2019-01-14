package com.coyotestudio.healthyfruitsinfo.fruits_view;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.coyotestudio.healthyfruitsinfo.R;
import com.coyotestudio.healthyfruitsinfo.about.AboutOfActivity;
import com.coyotestudio.healthyfruitsinfo.fruits_view.data.Fruit;
import com.coyotestudio.healthyfruitsinfo.fruits_view.data.FruitAdapter;
import com.coyotestudio.healthyfruitsinfo.utils.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FruitsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_main_container)
    RecyclerView rvMainContainer;

    private ArrayList<Fruit> mFruitaData;
    private FruitAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        int gridColumnContent = getResources().getInteger(R.integer.grid_column_count);

        // Set the layout Manager
        rvMainContainer.setLayoutManager(new GridLayoutManager(this, gridColumnContent));
        mFruitaData = new ArrayList<>();
        mAdapter = new FruitAdapter(this, mFruitaData);
        initilizeData();
        rvMainContainer.setAdapter(mAdapter);
    }

    public void initilizeData() {
        String[] fruitNames = getResources().getStringArray(R.array.titulo_frutas);
        // Consider the info about the fruits

        TypedArray fruitsImageResources = getResources().obtainTypedArray(R.array.img_fruits);
        mFruitaData.clear();

        // Create the ArryList of Fruits with the titles and information about each fruit
        for (int i = 0; i < fruitNames.length; i++) {
            mFruitaData.add(new Fruit(fruitNames[i], fruitsImageResources.getResourceId(i, 0)));
        }

        fruitsImageResources.recycle();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.option_about:
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
}
