package com.space.dao.interfacedao;

import com.space.travel.Place;

import java.util.List;

public interface PlaceDAO {

    //Insert
    void insertPlace();

    //Search(Select)
    List<Place> findAllPlaces();
    Place findPlaceByNo();
    Place findPlaceByName();

    //Update
    void updatePlaceByNO(int placeNumber);

    //Delete
    void deletePlaceByNO(int placeNumber);

}
