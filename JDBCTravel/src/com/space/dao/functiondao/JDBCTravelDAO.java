package com.space.dao.functiondao;

import com.space.dao.interfacedao.TravelDAO;
import com.space.global.*;
import com.space.service.TravelUpdateService;
import com.space.travel.TravelPackage;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JDBCTravelDAO implements TravelDAO{

    @Override
    public List<TravelPackage> findAllTravels() {  // 모든 여행 패키지 찾기

        List<TravelPackage> travels = new ArrayList<TravelPackage>();

        String sortSelect = AppFuncs.SortingLogic();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM TRAVELS "
                     + "ORDER BY TRAVEL_NO " + sortSelect);
             ResultSet rs = pStat.executeQuery()) {

            while(rs.next()) {
                TravelPackage travel = new TravelPackage();
                travel.setPackageNumber(rs.getInt("TRAVEL_NO"));
                travel.setPackageName(rs.getString("TRAVEL_NAME"));
                travel.setPackagePrice(rs.getInt("TRAVEL_PRICE"));
                travel.setPackageDeparture(rs.getDate("TRAVEL_DEPARTURE"));
                travel.setPackageArrival(rs.getDate("TRAVEL_ARRIVAL"));

                travels.add(travel);
            }

            System.out.println("--- 여행 패키지 전체 조회 결과는 다음과 같습니다---");
            for(TravelPackage t: travels) {
                System.out.println(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return travels;
    }

    @Override
    public TravelPackage findTravel(int inputNum) { // 숫자로 여행패키지 찾기
        TravelPackage travel = new TravelPackage();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM TRAVELS "
                     + "WHERE TRAVEL_NO = ?")) {

            pStat.setInt(1, inputNum);
            ResultSet rs = pStat.executeQuery();

            if(rs.next()) {
                travel.setPackageNumber(rs.getInt("TRAVEL_NO"));
                travel.setPackageName(rs.getString("TRAVEL_NAME"));
                travel.setPackagePrice(rs.getInt("TRAVEL_PRICE"));
                travel.setPackageDeparture(rs.getDate("TRAVEL_DEPARTURE"));
                travel.setPackageArrival(rs.getDate("TRAVEL_ARRIVAL"));
            }

            System.out.println("--- 여행 패키지 번호로 조회한 결과는 다음과 같습니다---");
            System.out.println(travel);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return travel;
    }

    @Override
    public List<TravelPackage> findTravels(int criteriaPrice) {
        List<TravelPackage> travels = new ArrayList<TravelPackage>();


        String sortSelect = AppFuncs.SortingLogic();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM TRAVELS "
                     );
             ResultSet rs = pStat.executeQuery()) {

            while(rs.next()) {
                TravelPackage travel = new TravelPackage();
                travel.setPackageNumber(rs.getInt("TRAVEL_NO"));
                travel.setPackageName(rs.getString("TRAVEL_NAME"));
                travel.setPackagePrice(rs.getInt("TRAVEL_PRICE"));
                travel.setPackageDeparture(rs.getDate("TRAVEL_DEPARTURE"));
                travel.setPackageArrival(rs.getDate("TRAVEL_ARRIVAL"));

                travels.add(travel);
            }

            System.out.println("--- 여행 패키지 전체 조회 결과는 다음과 같습니다---");
            for(TravelPackage t: travels) {
                System.out.println(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return travels;
    }

    @Override
    public List<TravelPackage> findTravels(String name) {
        return List.of();
    }

    @Override
    public List<TravelPackage> findTravels(LocalDateTime localDateTime) {
        return List.of();
    }

    //Delete
    @Override
    public void deleteTravelByNO(int travelNumber) {

        try (Connection connection = DataSource.getDataSource();
             PreparedStatement preparedStatement
                     = connection.prepareStatement("DELETE travels WHERE travel_no = ?"))
        {
            preparedStatement.setInt(1, travelNumber);
            preparedStatement.executeUpdate();
            AppUI.DeleteCompleteMessage();
        } catch (SQLIntegrityConstraintViolationException e) {
            // Specific catch block for foreign key violation
            System.out.println("예약된 정보를 먼저 삭제해주세요");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void updateTravelByNo(int travelNumber) {
		TravelUpdateService travelUpdateService = new TravelUpdateService();
		
    	TravelPackage travelPackage = new TravelPackage();
    	travelPackage = travelUpdateService.findById(travelNumber);

    	System.out.println("Enter new travel package name");
    	String inputName = AppFuncs.inputString();
    	
    	System.out.println("Enter new travel package price(If no change, press -1): ");
    	int inputPrice = AppFuncs.inputInteger();
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE TRAVELS SET TRAVEL_NAME = ?, TRAVEL_PRICE = ? WHERE TRAVEL_NO = ?")){ 
    			
    		if(!inputName.isEmpty()) {
    			pStatement.setString(1, inputName);
    		} else {
    			pStatement.setString(1, travelPackage.getPackageName());
    		}
			
    		if(inputPrice == -1) {
    			pStatement.setInt(2, travelPackage.getPackagePrice());
    		} else {
    			pStatement.setInt(2, inputPrice);
    			
    		}
			
		
			pStatement.setInt(3, travelNumber);
		
			
			pStatement.executeUpdate();


    			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
}
