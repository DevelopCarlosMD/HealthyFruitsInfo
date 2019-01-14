package com.coyotestudio.healthyfruitsinfo.fruits_view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coyotestudio.healthyfruitsinfo.R;
import com.coyotestudio.healthyfruitsinfo.utils.Constants;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailFruitActivity extends AppCompatActivity {

    private static final String TAG = DetailFruitActivity.class.getSimpleName();
    @BindView(R.id.toolbar_detail)
    Toolbar toolbarDetail;
    @BindView(R.id.collapsing_detail)
    CollapsingToolbarLayout collapsing;
    //@BindView(R.id.tv_title_fruit_info)
    //TextView mInfoTitle;
    @BindView(R.id.iv_fruit_head)
    ImageView mImageHead;
    @BindView(R.id.fab_show_detail)
    FloatingActionButton mShowDetail;
    private String titleFruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fruit);
        initIntances();

    }


    public void initIntances() {
        ButterKnife.bind(this);
        titleFruit = getIntent().getStringExtra(Constants.TITLE_FRUIT);
        String titleAux = titleFruit.toLowerCase();
        if (titleAux.equals("piña")) {
            titleAux = "pinia";
        }
        int id = getApplication().getResources().getIdentifier(titleAux,
                "drawable", getApplication().getPackageName());

        initCollapsingTool(titleFruit);
        //FirebaseApp.initializeApp(this);
        setSupportActionBar(toolbarDetail);

        /*ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }*/
        mImageHead.setImageResource(id);
    }

    public void initCollapsingTool(String titlefruit) {
        // String from the title fruit
        //collapsing.setTitle(titlefruit);
        toolbarDetail.setTitle(titlefruit);
    }

    public void recoverData() {
        //mDatabase = FirebaseDatabase.getInstance().getReference();
        /*if (mDatabase != null) {
            //mDatabase.child("juicefruit
            Log.i(TAG, "Recover db success!!");
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        recoverData();

        return true;*/
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

    @OnClick(R.id.fab_show_detail)
    public void setmShowDetail() {

        FragmentManager fm = getSupportFragmentManager();
        ShowDetailInfoDialog detallePedidoEditDialog = new ShowDetailInfoDialog();
        //detallePedidoEditDialog.setParametros(pedidoPrecios, detallePedido);
        detallePedidoEditDialog.show(fm, "testsDialogo");
    }
}