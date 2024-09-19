package com.space.dao.interfacedao;

import com.space.reservation.Reservation;

import java.util.List;

public interface RsvDAO {

    //insert
    void insertRSV();

    //Search(Select)
    List<Reservation> findAllRsvs();
    Reservation findRsvsByID();
    List<Reservation> findRsvsByName();

    //Delete
    void deleteRSVByCustomerNO(int customerNumber);
    void deleteByRsvNO(int reservationNumber);
}
