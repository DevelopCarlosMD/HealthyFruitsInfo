package com.coyotestudio.healthyfruitsinfo.recipies_view;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.coyotestudio.healthyfruitsinfo.R;
import com.coyotestudio.healthyfruitsinfo.recipies_view.data.Recipe;
import com.coyotestudio.healthyfruitsinfo.recipies_view.data.RecipesAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_main_recipes)
    RecyclerView rvMainRecipes;
    @BindView(R.id.fab_search)
    FloatingActionButton fabSearch;

    private RecipesAdapter recipesAdapter;
    private ArrayList<Recipe> mArrRecipeData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipes);
        ButterKnife.bind(this);
        initElements();

        int gridColumnContent = getResources().getInteger(R.integer.grid_column_recipes);
        rvMainRecipes.setLayoutManager(new GridLayoutManager(this, gridColumnContent));
        mArrRecipeData = new ArrayList<>();
        recipesAdapter = new RecipesAdapter(this, mArrRecipeData);
        initDataRecipe();

        rvMainRecipes.setAdapter(recipesAdapter);
    }

    public void initElements() {
        toolbar.setTitle(R.string.recipes);
        setSupportActionBar(toolbar);
    }

    public void initDataRecipe() {
        String[] mainTitlesRecipe = getResources().getStringArray(R.array.title_recipes);
        TypedArray mainRecipeImages = getResources().obtainTypedArray(R.array.img_recipes);

        mArrRecipeData.clear();

        for (int i = 0; i < mainTitlesRecipe.length; i++) {

            mArrRecipeData.add(new Recipe(mainRecipeImages.getResourceId(i, 0)
                    , mainTitlesRecipe[i], "Text recipe"));
        }

        mainRecipeImages.recycle();
        recipesAdapter.notifyDataSetChanged();

    }
}
