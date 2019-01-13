package com.coyotestudio.healthyfruitsinfo.juice_fruits_view.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

import butterknife.OnClick;

/**
 * Created by J. Carlos Medina Diaz @_CarlosMD on 01/02/2018.
 * Coyote Dev Studio
 * carlos.medj@gmail.com
 */

public class JuiceFruitAdapter extends RecyclerView.Adapter<JuiceFruitAdapter.ViewHolder> {

    ArrayList<JuiceFruit> mArraDataJuiceFruit;
    LayoutInflater mInflater;
    Context mContext;

    public JuiceFruitAdapter(Context context,  ArrayList<JuiceFruit> juiceFruitData){
        this.mArraDataJuiceFruit = juiceFruitData;
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public JuiceFruitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       final View itemView =  mInflater.inflate(R.layout.list_item_juice_fruit, parent, false);
       RecyclerViewClicksListener listener = (view, position)->{
           Toast.makeText(mContext, "Try juice fruit", Toast.LENGTH_SHORT).show();
       };


        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(JuiceFruitAdapter.ViewHolder holder, int position) {
        JuiceFruit currentJuice = mArraDataJuiceFruit.get(position);
        holder.bindTo(currentJuice);
        Glide.with(mContext).load(currentJuice.getImage()).into(holder.juiceHeader);

    }

    @Override
    public int getItemCount() {
        return mArraDataJuiceFruit.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView juiceHeader;
        private TextView tvTitleJuice;
        private TextView tvSubTitleJuice;
        private Button mLaunchActionCard;
        private RecyclerViewClicksListener listener;


        public ViewHolder(View itemView, RecyclerViewClicksListener listener) {
            super(itemView);
            juiceHeader = (ImageView) itemView.findViewById(R.id.card_image_juice_fruit);
            tvTitleJuice = (TextView) itemView.findViewById(R.id.card_title_juice_fruit);
            tvSubTitleJuice = (TextView) itemView.findViewById(R.id.card_text_juice_fruit);
            mLaunchActionCard = (Button) itemView.findViewById(R.id.card_button_action);
            this.listener = listener;

            mLaunchActionCard.setOnClickListener(this);


        }

        public void bindTo(JuiceFruit dataJuiceFruit){

            tvTitleJuice.setText(dataJuiceFruit.getTitleJuiceFruit());
            tvSubTitleJuice.setText(dataJuiceFruit.getSubTitleJuiceFruit());

        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }
}
