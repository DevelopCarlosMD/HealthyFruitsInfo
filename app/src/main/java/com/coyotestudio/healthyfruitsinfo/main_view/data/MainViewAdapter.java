package com.coyotestudio.healthyfruitsinfo.main_view.data;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.coyotestudio.healthyfruitsinfo.R;

import java.util.ArrayList;


import com.coyotestudio.healthyfruitsinfo.fruits_view.FruitsActivity;
import com.coyotestudio.healthyfruitsinfo.juice_fruits_view.JuiceFruitsActivity;
import com.coyotestudio.healthyfruitsinfo.recipies_view.RecipesActivity;
import com.coyotestudio.healthyfruitsinfo.utils.RecyclerViewClicksListener;

/**
 * Created by J. Carlos Medina Diaz @_CarlosMD on 2/2/18.
 * Coyote Dev Studio
 * carlos.medj@gmail.com
 */

public class MainViewAdapter extends RecyclerView.Adapter<MainViewAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<MainViewData> mArrayMenuData;

    public MainViewAdapter(Context context, ArrayList<MainViewData> mArrayMenuData) {
        mContext = context;
        this.mArrayMenuData = mArrayMenuData;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MainViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View itemView = inflater.inflate(R.layout.list_item_main, parent, false);
        RecyclerViewClicksListener listener = (view, position) -> {
            if (mArrayMenuData.get(position).getOptionName().equals("Fruits")) {
                Intent intent = new Intent(mContext, FruitsActivity.class);
                mContext.startActivity(intent);
                //Toast.makeText(mContext, "Fruits option", Toast.LENGTH_SHORT).show();
            } else if (mArrayMenuData.get(position).getOptionName().equals("Juice Fruits")) {
                Intent intent = new Intent(mContext, JuiceFruitsActivity.class);
                mContext.startActivity(intent);
                //Toast.makeText(mContext, "Juice Fruits", Toast.LENGTH_SHORT).show();
            } else if (mArrayMenuData.get(position).getOptionName().equals("Healthy Recipes")) {
                //Toast.makeText(mContext, "Healthy Recipes", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, RecipesActivity.class);
                mContext.startActivity(intent);
            }
        };

        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(MainViewAdapter.ViewHolder holder, int position) {
        MainViewData currentData = mArrayMenuData.get(position);
        holder.bindTo(currentData);

        Glide.with(mContext).
                load(currentData.getImgResource()).into(holder.mImageIniCard);

    }

    @Override
    public int getItemCount() {
        return mArrayMenuData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mTitleMainCard;
        ImageView mImageIniCard;

        private RecyclerViewClicksListener mListener;

        public ViewHolder(View itemView, RecyclerViewClicksListener mLister) {
            super(itemView);
            mTitleMainCard = (TextView) itemView.findViewById(R.id.tv_title_ini_main);
            mImageIniCard = (ImageView) itemView.findViewById(R.id.imv_pic_fruits_ini);
            this.mListener = mLister;

            itemView.setOnClickListener(this);
        }

        public void bindTo(MainViewData data) {
            mTitleMainCard.setText(data.getOptionName());
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }
}
