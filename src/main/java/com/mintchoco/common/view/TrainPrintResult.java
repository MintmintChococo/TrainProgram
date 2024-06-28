package com.mintchoco.common.view;

import com.mintchoco.common.SearchCriteria;
import com.mintchoco.common.TrainDTO;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TrainPrintResult {
    public void trainList(List<TrainDTO> trainList) {

        for (TrainDTO train : trainList) {

            LocalTime depTime = train.getDepTime();
            LocalTime arrivalTime = train.getArrivalTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            String formattedTime = depTime.format(formatter);
            String formattedTime2 = arrivalTime.format(formatter);

            System.out.println("운행번호:" + train.getScNo()
                    + " 기차명:" + train.getTrainName() + " 출발지:" + train.getDeparture() + " 목적지:" + train.getArrival() +
                    " 출발시간-" + formattedTime + " 도착시간-" + formattedTime2);
        }
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode) {
            case "selectList" : errorMessage = "기차 목록 조회를 실패했습니다."; break;
            case "selectOne" : errorMessage = "기차 조회를 실패했습니다."; break;
            case "insert" : errorMessage = "신규 기차 등록을 실패했습니다."; break;
            case "modify" : errorMessage = "기차 수정을 실패했습니다."; break;
            case "delete" : errorMessage = "기차 삭제를 실패했습니다."; break;
        }

        System.out.println(errorMessage);
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";
        switch (successCode) {
            case "insert" : successMessage = "신규 기차 등록을 성공했습니다."; break;
            case "modify" : successMessage = "기차 수정을 성공했습니다."; break;
            case "delete" : successMessage = "기차 삭제를 성공했습니다."; break;
        }
        System.out.println(successMessage);
    }

    public void printSearchTrainByTimeOrArea(List<TrainDTO> trainList, SearchCriteria searchCriteria) {

        if (searchCriteria.getCondition().equals("time")) {
            for (TrainDTO train : trainList) {

                LocalTime depTime = train.getDepTime();
                LocalTime arrivalTime = train.getArrivalTime();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

                String formattedTime = depTime.format(formatter);
                String formattedTime2 = arrivalTime.format(formatter);

                System.out.println("기차명:" + train.getTrainName() + " 출발시간-" + formattedTime + "도착시간-" + formattedTime2);
            }
        } else if (searchCriteria.getCondition().equals("departure")) {
            for (TrainDTO train : trainList) {
                System.out.println("기차명:" + train.getTrainName() + " 출발지:" + train.getDeparture());
            }
        } else if (searchCriteria.getCondition().equals("arrival")) {
            for (TrainDTO train : trainList) {
                System.out.println("기차명:" + train.getTrainName() + " 목적지:" + train.getArrival());
            }
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
    }
}
