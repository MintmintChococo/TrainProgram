package com.mintchoco.mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MenuController menuController = new MenuController();

        do {
            System.out.println("=============== 티켓 관리 시스템 ===============");
            System.out.println("1.예매한 티켓 조회하기");
            System.out.println("2.새로운 티켓 구매하기");
            System.out.println("3.예매한 티켓 변경하기");
            System.out.println("4.예매한 티켓 취소하기");
            System.out.print("티켓 번호를 입력하세요 :");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuController.selectAllTicket();
                    break;
                case 2:
                    Object inputTicket = null;
                    menuController.purchaseTicket((Map<String, String>) inputTicket);
                    break;
                case 3:
                    menuController.modifyTicket(inputTicket());
                    break;
                case 4:
                    menuController.cancelTicket(inputTicket());
                    break;
                default:
                    System.out.println("티켓 번호를 잘못 입력하셨습니다.");
            }
        } while (true);
    }

    private static Map<String, String> inputTicket() {
        Scanner sc = new Scanner(System.in);
        System.out.println("티켓 번호를 입력하세요");
        String name = sc.nextLine();

        Map<String, String> parameter = new HashMap<>(Map.of());
        String number = "";
        parameter.put("number", "number");

        return parameter;
    }



}






