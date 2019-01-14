package com.coyotestudio.healthyfruitsinfo.fruits_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.coyotestudio.healthyfruitsinfo.R;
import com.coyotestudio.healthyfruitsinfo.about.AboutOfActivity;
import com.coyotestudio.healthyfruitsinfo.main_view.MainActivity;
import com.coyotestudio.healthyfruitsinfo.model.Fruta;
import com.coyotestudio.healthyfruitsinfo.utils.Constants;
import com.coyotestudio.healthyfruitsinfo.utils.Util;

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
    @BindView(R.id.tv_description_fruit)
    TextView mFruitDescription;

    private String titleFruit;
    private String[] arrDescription;

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
        arrDescription = getResources().getStringArray(R.array.arr_desc_fruits);
        validatedescriptionInfo();
    }

    private void validatedescriptionInfo() {

        if(titleFruit.equals("Cereza")){
            mFruitDescription.setText(arrDescription[0]);
        } else if(titleFruit.equals("Ciruela")){
            mFruitDescription.setText(arrDescription[1]);
        } else if (titleFruit.equals("Coco")){
            mFruitDescription.setText(arrDescription[2]);
        }else if (titleFruit.equals("Durazno")){
            mFruitDescription.setText(arrDescription[3]);
        }else if (titleFruit.equals("Fresa")){
            mFruitDescription.setText(arrDescription[4]);
        }else if (titleFruit.equals("Granada")){
            mFruitDescription.setText(arrDescription[5]);
        }
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
        recoverData();*/
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.option_about:
                Intent i = new Intent(this, AboutOfActivity.class);
                startActivity(i);
                break;
            case R.id.action_option_share:
                Util.createShareIntent(this);
                break;
            case R.id.option_contact:
                Util.sendEmail(this);
                break;
        }

        return true;
    }

    @OnClick(R.id.fab_show_detail)
    public void setmShowDetail() {

        FragmentManager fm = getSupportFragmentManager();
        ShowDetailInfoDialog detallePedidoEditDialog = new ShowDetailInfoDialog();
        Fruta frutaInfo = null;

        for (Fruta object:
                MainActivity.arrFrutas) {
            if(object.getNombre().equals(titleFruit.toLowerCase())){
                frutaInfo = object;
                break;
            }
        }


        detallePedidoEditDialog.setParametros(frutaInfo);
        detallePedidoEditDialog.show(fm, "dialogFruit");
    }
}