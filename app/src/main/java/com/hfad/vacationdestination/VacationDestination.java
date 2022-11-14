package com.hfad.vacationdestination;

public class VacationDestination {

    private String placeName;
    private int imageId;
    private boolean favorite;

    public VacationDestination(String n, int i, boolean fav)
    {
        placeName = n;
        imageId = i;
        favorite = fav;

    }

    public String getPlaceName() {
        return placeName;
    }

    public int getImageId() {
        return imageId;
    }

    public boolean getFavorite(){return favorite;}

    public void setFavorite(boolean fav)
    {
        favorite = fav;
    }

}
