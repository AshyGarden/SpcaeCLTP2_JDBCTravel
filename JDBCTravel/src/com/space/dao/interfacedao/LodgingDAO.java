package com.space.dao.interfacedao;

import com.space.travel.Lodging;

public interface LodgingDAO {
	void updateLodgingByNO(int lodgingNumber);
	void deleteByLodgingNO(int lodgingNumber);
	void insertLodging();
	Lodging searchByNO();
	Lodging searchByName();

}
