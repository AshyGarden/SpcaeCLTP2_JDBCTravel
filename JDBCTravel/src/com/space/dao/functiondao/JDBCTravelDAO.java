package com.space.dao.functiondao;

import com.space.dao.interfacedao.TravelDAO;
import com.space.global.*;
import com.space.service.*;
import com.space.travel.TravelPackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTravelDAO implements TravelDAO{

    //Insert Start
    @Override
    public void insertTravel() {
        AppUI.TypeSelection("패키지 번호");
        int inputTravelNO = AppFuncs.inputInteger();
        System.out.println(inputTravelNO);

        AppUI.TypeSelection("패키지 이름");
        String inputTravelName = AppFuncs.inputString();

        AppUI.TypeSelection("패키지 가격");
        int inputTravelPrice = AppFuncs.inputInteger();

        AppUI.TypeSelection("출발 시간");
        Date inputTravleDeparture = AppFuncs.inputDate();

        AppUI.TypeSelection("출발 시간");
        Date inputTravleArrival = AppFuncs.inputDate();


        try(Connection connection = DataSource.getDataSource();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Travels " +
                    "(TRAVEL_NO, TRAVEL_NAME, TRAVEL_PRICE, TRAVEL_DEPARTURE, TRAVEL_ARRIVAL) VALUES (?,?,?,?,?)"))
        {

            preparedStatement.setInt(1, inputTravelNO);
            preparedStatement.setString(2, inputTravelName);
            preparedStatement.setInt(3, inputTravelPrice);
            preparedStatement.setDate(3, inputTravleDeparture);
            preparedStatement.setDate(3, inputTravleArrival);

            preparedStatement.executeUpdate();

        }catch (SQLException e){

            e.printStackTrace();
        }
    }
    //Insert End

    //Search start
    @Override
    public List<TravelPackage> findAllTravels() {  // 모든 여행 패키지 찾기

        List<TravelPackage> travels = new ArrayList<TravelPackage>();
        String sortOrder = AppFuncs.SortingLogic();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM TRAVELS "
                     + "ORDER BY TRAVEL_NO " + sortOrder);

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
    public TravelPackage findTravelByID() {

        TravelPackage travel = new TravelPackage();

        System.out.println("패키지 번호를 입력해주세요.");
        System.out.print(">>>");
        int inputNum = AppFuncs.inputInteger();

        String sortSelect = AppFuncs.SortingLogic();
        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement(
                     "SELECT * FROM TRAVELS "+
                         "WHERE TRAVEL_NO = ? "+
                         "ORDER BY TRAVEL_NO " + sortSelect
             )) {
            pStat.setInt(1,inputNum);
            ResultSet rs = pStat.executeQuery();

            if(rs.next()) {
                travel.setPackageNumber(rs.getInt("TRAVEL_NO"));
                travel.setPackageName(rs.getString("TRAVEL_NAME"));
                travel.setPackagePrice(rs.getInt("TRAVEL_PRICE"));
                travel.setPackageDeparture(rs.getDate("TRAVEL_DEPARTURE"));
                travel.setPackageArrival(rs.getDate("TRAVEL_ARRIVAL"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return travel;
    }

    @Override
    public List<TravelPackage> findTravelsByName() {
        List<TravelPackage> travels = new ArrayList<TravelPackage>();

        System.out.println("패키지 이름을 입력해주세요");
        System.out.print(">>>");
        String inputName = AppFuncs.inputString();
        String sortSelect = AppFuncs.SortingLogic();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement(
                     "SELECT * FROM TRAVELS "+
                         "WHERE TRAVEL_NAME = ? "+
                         "ORDER BY TRAVEL_NAME " + sortSelect)){
            pStat.setString(1,inputName);
            ResultSet rs = pStat.executeQuery();
            while(rs.next()) {
                TravelPackage travel = new TravelPackage();
                travel.setPackageNumber(rs.getInt("TRAVEL_NO"));
                travel.setPackageName(rs.getString("TRAVEL_NAME"));
                travel.setPackagePrice(rs.getInt("TRAVEL_PRICE"));
                travel.setPackageDeparture(rs.getDate("TRAVEL_DEPARTURE"));
                travel.setPackageArrival(rs.getDate("TRAVEL_ARRIVAL"));

                travels.add(travel);
            }

            System.out.println("--- 여행 패키지 이름 조회 결과는 다음과 같습니다---");
            for(TravelPackage t: travels) {
                System.out.println(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return travels;
    }

    @Override
    public void findTravelsByPrice() {
        int inputPriceMin = 0, inputPriceMax = 0;
        String option1 = "", option2 = "", option3 = "";

        List<TravelPackage> travels = new ArrayList<TravelPackage>();

        System.out.println("가격조회 조건을 설정해주세요");
        System.out.println("[1. 최솟값만으로 조회 / 2. 최댓값만으로 조회 / 3. 범위조건(최소~최대)으로 조회]");
        System.out.print(">>>");
        int querySelector = AppFuncs.inputInteger();

        if(querySelector == 1){
            System.out.println("패키지 최소가격을 입력해주세요");
            System.out.print(">>>");
            inputPriceMin = AppFuncs.inputInteger();
            option1 = " TRAVEL_PRICE >= ? ";
        } else if(querySelector == 2){
            System.out.println("패키지 최대가격을 입력해주세요");
            System.out.print(">>>");
            inputPriceMax  = AppFuncs.inputInteger();
            option3 = " TRAVEL_PRICE <= ? ";
        } else if(querySelector == 3){
            System.out.println("패키지 최소가격을 입력해주세요");
            System.out.print(">>>");
            inputPriceMin = AppFuncs.inputInteger();
            option1 = " TRAVEL_PRICE > = ? ";
            System.out.println("패키지 최대가격을 입력해주세요");
            System.out.print(">>>");
            inputPriceMax  = AppFuncs.inputInteger();
            option3 = " TRAVEL_PRICE < = ? ";
            option2 = " AND ";
        } else{
            System.out.println("가격조회 조건을 잘못 입력하여 이전메뉴로 돌아갑니다.");
            return;
        }

        String sortOrder = AppFuncs.SortingLogic();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement(
                     "SELECT * FROM TRAVELS "+
                         "WHERE "+ option1 + " " + option2 + " " + option3 +
                         "ORDER BY TRAVEL_PRICE " + sortOrder)) {
            if(querySelector == 1){
               pStat.setInt(1, inputPriceMin);
            } else if(querySelector == 2){
                pStat.setInt(1, inputPriceMax);
            } else if(querySelector == 3){
                pStat.setInt(1, inputPriceMin);
                pStat.setInt(2, inputPriceMax);
            }

            ResultSet rs = pStat.executeQuery();
            while(rs.next()) {
                TravelPackage travel = new TravelPackage();
                travel.setPackageNumber(rs.getInt("TRAVEL_NO"));
                travel.setPackageName(rs.getString("TRAVEL_NAME"));
                travel.setPackagePrice(rs.getInt("TRAVEL_PRICE"));
                travel.setPackageDeparture(rs.getDate("TRAVEL_DEPARTURE"));
                travel.setPackageArrival(rs.getDate("TRAVEL_ARRIVAL"));

                travels.add(travel);
            }

            System.out.println("--- 여행 패키지 가격 조회 결과는 다음과 같습니다---");
            for(TravelPackage t: travels) {
                System.out.println(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findTravelsByDate() {
        int inputStartOption = 0, inputEndOption = 0;
        String inputStartDate = "", inputEndDate = "", option1 = "", option2 = "", option3 = "";

        List<TravelPackage> travels = new ArrayList<TravelPackage>();

        System.out.println("날짜조회 조건을 설정합니다.");
        System.out.println("[1. 출발일자로 조회 / 2. 도착일자으로 조회 / 3. 범위조건(최소~최대)으로 조회]");
        System.out.print(">>>");
        int querySelector = AppFuncs.inputInteger();

        System.out.println("날짜조회 상세 조건을 설정합니다.");
        if(querySelector == 1){
            System.out.println("[1. 입력일자 '이후' 출발로 조회 / 2. 입력일자 '이전' 출발로 조회]");
            System.out.print(">>>");
            inputStartOption = AppFuncs.inputInteger();

            if(inputStartOption == 1){ option1 = " TRAVEL_DEPARTURE >= ? "; }
            else if(inputStartOption == 2){ option1 = " TRAVEL_DEPARTURE <= ? "; }
            else{
                System.out.println("조건을 잘못 입력하여 이전 메뉴로 돌아갑니다.");
                return;
            }

            System.out.println("날짜를 입력받겠습니다.");
            System.out.println("연도를 입력해주세요.");
            System.out.print(">>>");
            int inputYear = AppFuncs.inputInteger();

            System.out.println("월을 입력해주세요.");
            System.out.print(">>>");
            int inputMonth = AppFuncs.inputInteger();

            System.out.println("일을 입력해주세요");
            System.out.print(">>>");
            int inputDay = AppFuncs.inputInteger();

            inputStartDate = inputYear+"/"+inputMonth+"/"+inputDay;
        } else if(querySelector == 2){
            System.out.println("[1. 입력일자 '이후' 도착로 조회 / 2. 입력일자 '이전' 도착로 조회]");
            System.out.print(">>>");
            inputStartOption = AppFuncs.inputInteger();

            if(inputStartOption == 1){option1 = " TRAVEL_ARRIVAL >= ? ";}
            else if(inputStartOption == 2){option1 = " TRAVEL_ARRIVAL <= ? ";}
            else{
                System.out.println("조건을 잘못 입력하여 이전 메뉴로 돌아갑니다.");
                return;
            }

            System.out.println("날짜를 입력받겠습니다.");
            System.out.println("연도를 입력해주세요.");
            System.out.print(">>>");
            int inputYear = AppFuncs.inputInteger();

            System.out.println("월을 입력해주세요.");
            System.out.print(">>>");
            int inputMonth = AppFuncs.inputInteger();

            System.out.println("일을 입력해주세요");
            System.out.print(">>>");
            int inputDay = AppFuncs.inputInteger();

            inputEndDate = inputYear+"/"+inputMonth+"/"+inputDay;
        } else if(querySelector == 3){
            System.out.println("범위조건 최소부분을 입력받겠습니다.");
            System.out.println("연도를 입력해주세요.");
            System.out.print(">>>");
            int inputYear1 = AppFuncs.inputInteger();

            System.out.println("월을 입력해주세요.");
            System.out.print(">>>");
            int inputMonth1 = AppFuncs.inputInteger();

            System.out.println("일을 입력해주세요");
            System.out.print(">>>");
            int inputDay1 = AppFuncs.inputInteger();

            inputStartDate = inputYear1+"/"+inputMonth1+"/"+inputDay1;

            System.out.println("범위조건 최소부분을 입력받겠습니다.");
            System.out.println("연도를 입력해주세요.");
            System.out.print(">>>");
            int inputYear = AppFuncs.inputInteger();

            System.out.println("월을 입력해주세요.");
            System.out.print(">>>");
            int inputMonth = AppFuncs.inputInteger();

            System.out.println("일을 입력해주세요");
            System.out.print(">>>");
            int inputDay = AppFuncs.inputInteger();

            inputStartDate = inputYear+"/"+inputMonth+"/"+inputDay;

            option2 = " AND ";
        } else{
            System.out.println("가격조회 조건을 잘못 입력하여 이전메뉴로 돌아갑니다.");
            return;
        }


        String sortOrder = AppFuncs.SortingLogic();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement(
                     "SELECT * FROM TRAVELS "+
                             "WHERE "+ option1 + " " + option2 + " " + option3
                        )) {

//            if(querySelector == 1){
//                pStat.setInt(1, inputPriceMin);
//            } else if(querySelector == 2){
//                pStat.setInt(1, inputPriceMax);
//            } else if(querySelector == 3){
//                pStat.setInt(1, inputPriceMin);
//                pStat.setInt(2, inputPriceMax);
//            }

            ResultSet rs = pStat.executeQuery();

            while(rs.next()) {
                TravelPackage travel = new TravelPackage();
                travel.setPackageNumber(rs.getInt("TRAVEL_NO"));
                travel.setPackageName(rs.getString("TRAVEL_NAME"));
                travel.setPackagePrice(rs.getInt("TRAVEL_PRICE"));
                travel.setPackageDeparture(rs.getDate("TRAVEL_DEPARTURE"));
                travel.setPackageArrival(rs.getDate("TRAVEL_ARRIVAL"));

                travels.add(travel);
            }

            System.out.println("--- 여행 패키지 날짜 조회 결과는 다음과 같습니다---");
            for(TravelPackage t: travels) {
                System.out.println(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Search End

    //Update Start
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
    //Update End

    //Delete Start
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
    //Delete End
}
