package com.space.dao.interfacedao;

public interface TravelDAO {
    void deleteTravelByNO(int travelNumber);
    boolean updateTravelByNo(int travelNumber);
    void insertTravel();
}
