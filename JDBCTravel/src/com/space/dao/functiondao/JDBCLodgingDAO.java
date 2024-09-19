package com.space.dao.functiondao;

import com.space.dao.interfacedao.LodgingDAO;
import com.space.travel.Lodging;
import com.space.global.*;
import com.space.travel.Place;
import com.space.travel.TravelPackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JDBCLodgingDAO implements LodgingDAO {

	@Override
	public void insertLodging() {
		System.out.println("enter the lodging number");
    	int inputNum = AppFuncs.inputInteger();
    	
    	System.out.println("Enter new lodging name");
    	String inputWord = AppFuncs.inputString();
    	
    	System.out.println("Enter the place number");
    	int inputNO = AppFuncs.inputInteger();
    	
    	System.out.println("Enter the departure date");
    	Date inputDeparture = AppFuncs.inputDate();
    	
    	System.out.println("Enter the arrival date");
    	Date inputArrival = AppFuncs.inputDate();
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("INSERT INTO PLACES VALUES (?, ?, ?, ?, ?)")){ 

				pStatement.setInt(1, inputNum);
				pStatement.setString(2, inputWord);
				pStatement.setDate(3, inputArrival);
				pStatement.setDate(4, inputDeparture);
				pStatement.setInt(5, inputNO);

				pStatement.executeUpdate();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
	}

	@Override
	public List<Lodging> findAllLodging() {
		List<Lodging> lodgings = new ArrayList<Lodging>();
		String sortOrder = AppFuncs.SortingLogic();

		try (Connection conn = DataSource.getDataSource();
			 PreparedStatement pStat = conn.prepareStatement("SELECT * FROM LODGINGS "
					 + "ORDER BY LODGING_NO " + sortOrder);
			 ResultSet rs = pStat.executeQuery()) {

			while(rs.next()) {
				Lodging lodging = new Lodging();
				lodging.setLodgingNumber(rs.getInt("LODGING_NO"));
				lodging.setLodgingName(rs.getString("LODGING_NAME"));
				lodging.setLodgingArrival(rs.getDate("LODGING_ARRIVAL"));
				lodging.setLodgingDeparture(rs.getDate("LODGING_DEPARTURE"));

				Place place = new Place();
				place.setPlaceNumber(rs.getInt("PLACE_NO"));
				lodging.setPlace(place);

				lodgings.add(lodging);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lodgings;
	}

	@Override
	public Lodging findLodgingByNO() {
		System.out.println("Please Type lodging number");
		int lodgingNumber = AppFuncs.inputInteger();

		Lodging lodging = null;
		try(Connection connection = DataSource.getDataSource();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM lodgings WHERE lodging_no= ?")){

			preparedStatement.setInt(1,lodgingNumber);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){

				lodging = new Lodging();
				lodging.setLodgingNumber(resultSet.getInt("lodging_no"));
				lodging.setLodgingName(resultSet.getString("lodging_name"));
				lodging.setLodgingArrival(resultSet.getDate("lodging_arrival"));
				lodging.setLodgingDeparture(resultSet.getDate("lodging_departure"));

				Place place = new Place();
				place.setPlaceNumber(resultSet.getInt("place_no"));
				lodging.setPlace(place);
			} else {
				System.out.println("There isn't such lodging");
			}

		} catch(SQLException e){
			System.err.println("There isn't such lodging");
		}
		return lodging;
	}

	@Override
	public Lodging findLodgingByName() {
		System.out.println("Please Type lodging name");
		String lodgingName = AppFuncs.inputString();

		Lodging lodging = null;
		try(Connection connection = DataSource.getDataSource();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM lodgings WHERE lodging_name= ?")){

			preparedStatement.setString(1,lodgingName);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){

				lodging = new Lodging();
				lodging.setLodgingNumber(resultSet.getInt("lodging_no"));
				lodging.setLodgingName(resultSet.getString("lodging_name"));
				lodging.setLodgingArrival(resultSet.getDate("lodging_arrival"));
				lodging.setLodgingDeparture(resultSet.getDate("lodging_departure"));

				Place place = new Place();
				place.setPlaceNumber(resultSet.getInt("place_no"));
				lodging.setPlace(place);
			} else {
				System.err.println("There isn't such lodging");
			}

		} catch(SQLException e){
			e.printStackTrace();
		}
		return lodging;
	}

	@Override
	public void updateLodgingByNO(int lodgingNumber) {
		Lodging lodging = new Lodging();

		System.out.println("Enter new Lodging Name");
		String inputWord = AppFuncs.inputString();

		try(Connection connection = DataSource.getDataSource();
			PreparedStatement pStatement = connection.prepareStatement("UPDATE LODGINGS SET LODGING_NAME = ? WHERE LODGING_NO = ?")){

			pStatement.setString(1, inputWord);
			pStatement.setInt(2, lodgingNumber);

			pStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteByLodgingNO(int lodgingNumber) {
		try (Connection connection = DataSource.getDataSource();
			 PreparedStatement preparedStatement
					 = connection.prepareStatement("DELETE lodgings WHERE lodging_no = ?")) {
			preparedStatement.setInt(1, lodgingNumber);
			preparedStatement.executeUpdate();
			AppUI.DeleteCompleteMessage();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
