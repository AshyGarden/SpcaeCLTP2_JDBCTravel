package com.space.dao.interfacedao;

import com.space.travel.Food;

import java.util.List;

public interface FoodDAO {

	//Insert
	void insertFood( );

	//Search(Select)
	List<Food> findAllFoods();
	Food findFoodByNo();
	Food findFoodByName();
//	Food findFoodById(int foodNumber);

	//Update
	void updateFoodByNO(int foodNumber);

	//Delete
	void deleteByFoodNO(int foodNumber);
}
