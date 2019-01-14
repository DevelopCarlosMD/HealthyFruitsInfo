package com.coyotestudio.healthyfruitsinfo.fruits_view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coyotestudio.healthyfruitsinfo.R;

public class ShowDetailInfoDialog extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dialog_detail_view, container, false);

        return rootView;
    }
}
