package com.coyotestudio.healthyfruitsinfo.juice_fruits_view;

import android.content.res.TypedArray;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;


import com.coyotestudio.healthyfruitsinfo.R;
import com.coyotestudio.healthyfruitsinfo.juice_fruits_view.data.JuiceFruit;
import com.coyotestudio.healthyfruitsinfo.juice_fruits_view.data.JuiceFruitAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JuiceFruitsActivity extends AppCompatActivity {

    private static final String TAG = JuiceFruitsActivity.class.getSimpleName();
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_main_juice_fruit)
    RecyclerView rvJuiceFruits;
    @BindView(R.id.fab_search)
    FloatingActionButton fabSearch;

    private FirebaseDatabase mDatabase;
    private DatabaseReference dbRef;
    private JuiceFruitAdapter juiceFruitAdapter;
    private ArrayList<JuiceFruit> mArrJuiceFruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice_fruits);
        ButterKnife.bind(this);

        int gridColumnContent = getResources().getInteger(R.integer.grid_column_recipes);
        rvJuiceFruits.setLayoutManager(new GridLayoutManager(this, gridColumnContent));
        mArrJuiceFruit = new ArrayList<>();
        juiceFruitAdapter = new JuiceFruitAdapter(this, mArrJuiceFruit);
        initElements();
        initDataJuice();

        rvJuiceFruits.setAdapter(juiceFruitAdapter);
        mDatabase = FirebaseDatabase.getInstance();
        dbRef = mDatabase.getReference("healthyfruits-f026e");

        if(dbRef != null){
            dbRef.child("foodrecipe").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.i(TAG, "onDataChange: " + dataSnapshot.getValue());
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
            Log.d(TAG, "onCreate: Success firebase get data"  + dbRef.toString());
        }
    }

    public void initElements(){
        toolbar.setTitle(R.string.juice_fruits);
    }

    private void initDataJuice() {

        String[] mainTitlesRecipe = getResources().getStringArray(R.array.title_juice);
        TypedArray mainJuiceFruitImages = getResources().obtainTypedArray(R.array.img_juice_fruit);

        mArrJuiceFruit.clear();

        for (int i = 0; i < mainTitlesRecipe.length; i++) {

            mArrJuiceFruit.add(new JuiceFruit(mainJuiceFruitImages.getResourceId(i, 0)
                    , mainTitlesRecipe[i], "Text recipe"));
        }

        mainJuiceFruitImages.recycle();
        juiceFruitAdapter.notifyDataSetChanged();
    }






}
