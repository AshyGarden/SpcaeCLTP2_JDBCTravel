package com.space.dao.interfacedao;

import com.space.travel.Food;

public interface FoodDAO {
	void updateFoodByNO(int foodNumber);
	void deleteByFoodNO(int foodNumber);
	void insertFood( );
	Food findFoodById(int foodNumber);

}
