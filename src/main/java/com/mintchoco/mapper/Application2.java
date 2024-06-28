package com.mintchoco.mapper;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("============= 티켓 수정 관리 =============");
            System.out.println("1. 티켓번호 수정하기");
            System.out.println("2. 회원번호 수정하기");
            System.out.println("3. 기차번호 수정하기");
            System.out.print("번호를 입력하세요 : ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    modifyTicketNumber();
                    break;
                case 2:
                    modifyMemberNumber();
                    break;
                case 3:
                    modifyTrainNumber();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }

        } while (true);

    }

    static void modifyTrainNumber() {
    }


    static Map<String, Object> modifyTicketNumber() {

        Scanner sc = new Scanner(System.in);
        System.out.println("변경할 티켓번호를 입력하세요 : ");
        int MemberNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("변경 여부를 결정해주세요(Y/N) :");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();
        criteria.put("MemberNumber", MemberNumber);


        return criteria;


    }


    static Map<String, Object> modifyMemberNumber() {

        Scanner sc = new Scanner(System.in);
        System.out.println("변경할 티켓번호를 입력하세요 : ");
        int TrainNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("변경 여부를 결정해주세요(Y/N) :");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();
        criteria.put("TrainNumber", TrainNumber);


        return criteria;


    }
}



