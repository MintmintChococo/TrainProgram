package com.mintchoco.mapper;

import com.mintchoco.common.SearchCriteria;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        do {
            System.out.println("=========== 민초레일 운행 사이트 ===========");
            System.out.println("1. 회원");
            System.out.println("2. 기차");
            System.out.println("3. 예매티켓");
            System.out.println("번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: break;
                case 2: trainSubMenu(); break;
                case 3: break;
            }
        } while (true);
    }

    private static void trainSubMenu() {
        Scanner sc = new Scanner(System.in);
        TrainService trainService = new TrainService();

        do {
            System.out.println("1. 전체 기차 정보 조회 ");
            System.out.println("2. 기차 시간 or 순회지역 조회");
            System.out.println("3. 기차 시간 등록(관리자)");
            System.out.println("4. 기차 시간 수정(관리자)");
            System.out.println("5. 기차 시간 삭제(관리자)");
            System.out.println("번호을 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: trainService.selectAllTrain(); break;
                case 2: trainService.searchTrainByTimeOrArea(inputSearchCriteria()); break;
                case 3: break;
                case 4: break;
                case 5: break;

            }
        } while (true);
    }

    private static SearchCriteria inputSearchCriteria() {

        Scanner sc = new Scanner(System.in);
        System.out.println("검색 기준을 입력해주세요.(time or area) : ");
        String condition = sc.nextLine();
        System.out.println("검색어를 입력해주세요. : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }

}
