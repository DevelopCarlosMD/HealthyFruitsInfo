package com.coyotestudio.healthyfruitsinfo.recipies_view.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.coyotestudio.healthyfruitsinfo.R;
import com.coyotestudio.healthyfruitsinfo.utils.RecyclerViewClicksListener;

import java.util.ArrayList;

/**
 * Created by mac on 1/29/18.
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {
    private ArrayList<Recipe> mRecipeData;
    private LayoutInflater mInflater;
    private Context mContext;

    public RecipesAdapter(Context context, ArrayList<Recipe> recipeData) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        mRecipeData = recipeData;
    }

    @Override
    public RecipesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = mInflater.inflate(R.layout.list_item_recipes, parent, false);
        RecyclerViewClicksListener listener = (view, position) -> {
            Toast.makeText(mContext, "Try recipe!!", Toast.LENGTH_SHORT).show();
        };
        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(RecipesAdapter.ViewHolder holder, int position) {
        Recipe currentRecipe = mRecipeData.get(position);
        holder.bindTo(currentRecipe);

        Glide.with(mContext).
                load(currentRecipe.getImage()).into(holder.recipeHeader);
    }

    @Override
    public int getItemCount() {
        return mRecipeData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView recipeHeader;
        private TextView tvTitleRecipe;
        private TextView tvSubTitleRecipe;
        private Button mLaunchActionCard;
        private RecyclerViewClicksListener listener;

        public ViewHolder(View itemView, RecyclerViewClicksListener listener) {
            super(itemView);

            recipeHeader = (ImageView) itemView.findViewById(R.id.card_image_recipe);
            tvTitleRecipe = (TextView) itemView.findViewById(R.id.card_title_recipe);
            tvSubTitleRecipe = (TextView) itemView.findViewById(R.id.card_text_recipe);
            mLaunchActionCard = (Button) itemView.findViewById(R.id.card_button_action);
            this.listener = listener;
            //mLaunchActionCard.setOnClickListener(this);
        }

        public void bindTo(Recipe currentReceipe) {
            tvTitleRecipe.setText(currentReceipe.getTitleReipe());
            tvSubTitleRecipe.setText(currentReceipe.getSubTitleRecipe());
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }
}
