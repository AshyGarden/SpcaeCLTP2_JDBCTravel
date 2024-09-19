package com.space.dao.interfacedao;

import com.space.travel.Lodging;

import java.util.List;

public interface LodgingDAO {

	//Insert
	void insertLodging();

	//Search(Select)
	List<Lodging> findAllLodging();
	Lodging findLodgingByNO();
	Lodging findLodgingByName();

	//Update
	void updateLodgingByNO(int lodgingNumber);

	//Delete
	void deleteByLodgingNO(int lodgingNumber);

}
