package com.coyotestudio.healthyfruitsinfo.fruits_view.data;

/**
 * Created by mac on 1/25/18.
 */

public class Fruit {

    //private int _id;
    private String name;
    //private String description;
    //private String scientificName;
    //private String propertiesFruit;
    private final int imageResource;

    public Fruit(String name, int imageResource) {
        //this._id = _id;
        this.name = name;
        this.imageResource = imageResource;
    }


    public String getName() {
        return name;
    }

    /**
     * Gets the image about the sport
     * @return The image id about the sport
     */
    public int getImageResource() {
        return imageResource;
    }
}
