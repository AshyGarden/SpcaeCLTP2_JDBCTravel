package com.space.dao.interfacedao;

import com.space.travel.Place;

public interface PlaceDAO {
    void deletePlaceByNO(int placeNumber);
    void updatePlaceByNO(int placeNumber);
    void insertPlace();
    Place searchByNo();
    Place searchByName();
    

}
