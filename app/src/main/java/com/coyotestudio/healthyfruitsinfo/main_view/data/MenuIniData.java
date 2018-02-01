package com.coyotestudio.healthyfruitsinfo.main_view.data;

/**
 * Created by mac on 1/26/18.
 */

public class MenuIniData {

    private String optionName;
    private int imgResource;

    public MenuIniData(){

    }

    public MenuIniData(String optionMain, int imgResource) {
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
