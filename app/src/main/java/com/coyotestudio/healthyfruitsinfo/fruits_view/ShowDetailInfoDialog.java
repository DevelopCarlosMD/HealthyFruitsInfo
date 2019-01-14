package com.coyotestudio.healthyfruitsinfo.fruits_view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coyotestudio.healthyfruitsinfo.R;
import com.coyotestudio.healthyfruitsinfo.model.Fruta;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowDetailInfoDialog extends DialogFragment {

    @BindView(R.id.tv_name_content)
    TextView mNameFruit;
    @BindView(R.id.tv_calories_content)
    TextView mCaloriesFruit;
    @BindView(R.id.tv_water_content)
    TextView mWaterFruit;
    @BindView(R.id.tv_fiber_content)
    TextView mFiberFruit;
    @BindView(R.id.tv_proteins_content)
    TextView mProteinsFruit;
    @BindView(R.id.tv_fats_content)
    TextView mFatsFruit;
    @BindView(R.id.tv_minerals_content)
    TextView mMineralsFruit;
    @BindView(R.id.tv_vitamins_content)
    TextView mVitaminsFruit;
    @BindView(R.id.tv_properties_content)
    TextView mPropertiesFruit;
    private Fruta frutaInfo;


    public void setParametros(Fruta fruta) {
        this.frutaInfo = fruta;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dialog_detail_view, container, false);
        ButterKnife.bind(this, rootView);

        setInformationFruits();
        return rootView;
    }

    private void setInformationFruits() {
        if (frutaInfo != null) {
            mNameFruit.setText(frutaInfo.getNombre().toUpperCase());
            mCaloriesFruit.setText(String.valueOf(frutaInfo.getCalorias()));
            mWaterFruit.setText(String.valueOf(frutaInfo.getAgua()));
            mFiberFruit.setText(String.valueOf(frutaInfo.getFibra()));
            mPropertiesFruit.setText(String.valueOf(frutaInfo.getProteinas()));
            mFatsFruit.setText(String.valueOf(frutaInfo.getGrasas()));
            mMineralsFruit.setText(frutaInfo.getMinerales());
            mVitaminsFruit.setText(frutaInfo.getVitaminas());
            mPropertiesFruit.setText(frutaInfo.getPropiedades());
        }


    }


}
