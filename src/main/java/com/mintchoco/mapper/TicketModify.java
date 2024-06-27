package com.mintchoco.mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.*;
public class TicketModify {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 티켓번호를 입력하세요 : ");
        int ticketnumber = sc.nextInt();
        System.out.print("변경할 회원번호을 입력하세요 : ");
        sc.nextLine();
        String membernumber = sc.nextLine();
        System.out.print("변경할 기차번호를 입력하세요 : ");
        int trainnumber = sc.nextInt();
        System.out.println("변경할 좌석번호를 입력하세요 : ");
        sc.nextLine();
        String SeatNumber = sc.nextLine();
        System.out.println("출발지를 입력하세요 : ");
        sc.nextLine();
        String departure = sc.nextLine();
        System.out.println("도착지를 입력하세요 : ");
        sc.nextLine();
        String arrivarl = sc.nextLine();
        System.out.println("시간을 입력하세요 : ");
        sc.nextLine();
        String time = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();
        criteria.put("ticketnumber", ticketnumber);
        criteria.put("membernumber", membernumber);
        criteria.put("trainnumber", trainnumber);
        Object seatnumber = null;
        criteria.put("seatnumber", seatnumber);
        criteria.put("departure", departure);
        criteria.put("arrival", arrivarl);
        criteria.put("time", time);


        return;
    }
}


