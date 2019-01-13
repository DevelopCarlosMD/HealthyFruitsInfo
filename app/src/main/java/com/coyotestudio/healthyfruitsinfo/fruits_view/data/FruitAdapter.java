package com.coyotestudio.healthyfruitsinfo.fruits_view.data;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.coyotestudio.healthyfruitsinfo.R;
import com.coyotestudio.healthyfruitsinfo.fruits_view.DetailFruitActivity;
import com.coyotestudio.healthyfruitsinfo.utils.RecyclerViewClicksListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by J. Carlos Medina Diaz @_CarlosMD on 1/25/18.
 * Coyote Dev Studio
 * carlos.medj@gmail.com
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private ArrayList<Fruit> mFruitsData;
    private Context mContext;
    private LayoutInflater mInflater;
    private static final String TAG = FruitAdapter.class.getSimpleName();

    public FruitAdapter(Context context, ArrayList<Fruit> fruitsData) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mFruitsData = fruitsData;
    }


    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View itemView = mInflater.inflate(R.layout.list_item_fruit, parent, false);
        RecyclerViewClicksListener listener = (view, position) -> {
            // todo pass the information to show in the cardFruitMoreInfo
            // Fruit currentFruit = mFruitsData.get(position);

            Intent intent = new Intent(mContext, DetailFruitActivity.class);
            mContext.startActivity(intent);
            //Log.i(TAG, "itemFrutaClicked!!");
        };

        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(FruitAdapter.ViewHolder holder, int position) {
        Fruit currentFruit = mFruitsData.get(position);
        //populate the textviews with the data
        holder.bindTo(currentFruit);

        Glide.with(mContext)
                .load(currentFruit.getImageResource()).into(holder.mFruitView);

    }

    @Override
    public int getItemCount() {
        return mFruitsData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitleText;
        private TextView mSubTitle;
        private ImageView mFruitView;
        private RecyclerViewClicksListener mListener;

        public ViewHolder(View itemView, RecyclerViewClicksListener mListener) {
            super(itemView);
            this.mListener = mListener;

            mTitleText = (TextView) itemView.findViewById(R.id.tv_title_fruit);
            mFruitView = (ImageView) itemView.findViewById(R.id.imv_fruit);

            itemView.setOnClickListener(this);
        }

        public void bindTo(Fruit currentFruit) {
            // Populate the views from the item list fruits
            mTitleText.setText(currentFruit.getName());
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }
}
