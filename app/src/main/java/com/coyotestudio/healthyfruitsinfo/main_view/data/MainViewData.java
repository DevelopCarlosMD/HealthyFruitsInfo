package com.coyotestudio.healthyfruitsinfo.main_view.data;

/**
 * Created by J. Carlos Medina Diaz @_CarlosMD on 2/2/18.
 * Coyote Dev Studio
 * carlos.medj@gmail.com
 */
public class MainViewData {

    private String optionName;
    private int imgResource;

    public MainViewData(){

    }

    public MainViewData(String optionMain, int imgResource) {
        this.optionName = optionMain;
        this.imgResource = imgResource;
    }

    public String getOptionName() {
        return optionName;
    }

    public int getImgResource() {
        return imgResource;
    }
}
