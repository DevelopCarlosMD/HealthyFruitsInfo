package com.coyotestudio.healthyfruitsinfo.juice_fruits_view.data;

/**
 * Created by J. Carlos Medina Diaz @_CarlosMD on 01/02/2018.
 * Coyote Dev Studio
 * carlos.medj@gmail.com
 */

public class JuiceFruit {

    private int image;
    private String titleJuiceFruit;
    private String subTitleJuiceFruit;
    /*private String introInfo;
    private String ingredients;
    private String makeSteps;*/

    public JuiceFruit(int image, String titleJuiceFruit, String subTitleJuiceFruit) {
        this.image = image;
        this.titleJuiceFruit = titleJuiceFruit;
        this.subTitleJuiceFruit = subTitleJuiceFruit;
    }

    public int getImage() {
        return image;
    }

    public String getTitleJuiceFruit() {
        return titleJuiceFruit;
    }

    public String getSubTitleJuiceFruit() {
        return subTitleJuiceFruit;
    }
}
