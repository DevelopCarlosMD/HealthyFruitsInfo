package com.coyotestudio.healthyfruitsinfo.fruits_view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.coyotestudio.healthyfruitsinfo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFruitActivity extends AppCompatActivity {
    //@BindView(R.id.imv_fruit_detail)
    //ImageView imvFruitDetail;
    @BindView(R.id.toolbar_detail)
    Toolbar toolbarDetail;
    @BindView(R.id.fab_search)
    FloatingActionButton fabSearch;
    @BindView(R.id.collapsing_detail)
    CollapsingToolbarLayout collapsing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fruit);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarDetail);
        collapsing.setTitle("Watermelon");
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_fruits, menu);

        return true;
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