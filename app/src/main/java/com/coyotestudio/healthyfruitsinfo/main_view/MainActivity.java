package com.coyotestudio.healthyfruitsinfo.main_view;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.coyotestudio.healthyfruitsinfo.R;
import com.coyotestudio.healthyfruitsinfo.fruits_view.FruitsActivity;
import com.coyotestudio.healthyfruitsinfo.main_view.data.MainViewAdapter;
import com.coyotestudio.healthyfruitsinfo.main_view.data.MenuIniData;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_main_container)
    RecyclerView rvMainViewOptions;
    private ArrayList<MenuIniData> mArrayMenuInitial;
    private MainViewAdapter mAdapter;


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
                Toast.makeText(this, "About option listener", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option_share:
                Toast.makeText(this, "Share option listener", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option_contact:
                Toast.makeText(this, "Contact option Listener", Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab_search)
    public void searchMainView() {
        //Intent intent = new Intent(this, FruitsActivity.class);
        //startActivity(intent);
    }

    public void initData() {
        String[] mainTitlesOption = getResources().getStringArray(R.array.main_titles);
        TypedArray mainImagesResources = getResources().obtainTypedArray(R.array.main_images);

        mArrayMenuInitial.clear();

        for (int i = 0; i < mainTitlesOption.length; i++) {
            mArrayMenuInitial.add(new MenuIniData(mainTitlesOption[i],
                    mainImagesResources.getResourceId(i, 0)));
        }

        mainImagesResources.recycle();
        mAdapter.notifyDataSetChanged();

    }
}
