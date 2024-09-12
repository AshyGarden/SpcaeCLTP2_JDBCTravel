package com.space.dao.functiondao;

import com.space.dao.interfacedao.TravelDAO;
import com.space.global.*;
import com.space.travel.TravelPackage;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JDBCTravelDAO implements TravelDAO{

    @Override
    public List<TravelPackage> findAllTravels() {  // 모든 여행 패키지 찾기

        List<TravelPackage> travels = new ArrayList<TravelPackage>();
        System.out.println("조회 규칙을 설정해주세요");
        System.out.println("[1. 오름차순 / 2. 내림차순]");
        System.out.print(">>>");
        int inputNum = AppFuncs.inputInteger();

        String chosen = "";
        boolean flag = false; //입력플래그
        while(!flag) {
            if(inputNum == 1){
                chosen = "ASC";
                flag = true;
            } else if(inputNum == 2){
                chosen = "DESC";
                flag = true;
            } else{
                System.out.println("값을 다시 입력해주세요");
                break;
            }
        }

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM TRAVELS "
                     + "ORDER BY TRAVEL_NO " + chosen);
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

            System.out.println("--- 여행 패키지 전제 조회 결과는 다음과 같습니다---");
            for(TravelPackage t: travels) {
                System.out.println(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return travels;
    }

    @Override
    public TravelPackage findTravel(int i) { // 숫자로 여행패키지 찾기
        TravelPackage travel = new TravelPackage();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM TRAVELS "
                     + "ORDER BY TRAVEL_NO ASC")) {

            ResultSet rs = pStat.executeQuery();
            if(rs.next()) {
                travel.setPackageNumber(rs.getInt("TRAVEL_NO"));
                travel.setPackageName(rs.getString("TRAVEL_NAME"));
                travel.setPackagePrice(rs.getInt("TRAVEL_PRICE"));
                travel.setPackageDeparture(rs.getDate("TRAVEL_DEPARTURE"));
                travel.setPackageArrival(rs.getDate("TRAVEL_ARRIVAL"));
            }

            System.out.println("--- 여행 패키지 번호로 조회 결과는 다음과 같습니다---");
            System.out.println(travel);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return travel;
    }

    @Override
    public List<TravelPackage> findTravels(int i) {
        return List.of();
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
}
