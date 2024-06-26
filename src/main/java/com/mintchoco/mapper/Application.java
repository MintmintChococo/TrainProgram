package com.mintchoco.mapper;

import com.mintchoco.common.SearchCriteria;
import com.mintchoco.common.MemberDTO;
import java.util.HashMap;
import java.util.Map;
import com.mintchoco.common.TrainDTO;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

                case 1: memberSubMenu(); break;
                case 2: trainSubMenu(); break;
                case 3: ticketSubMenu(); break;
            }
        } while (true);
    }

    private static void trainSubMenu() {
        Scanner sc = new Scanner(System.in);
        TrainService trainService = new TrainService();

        do {
            System.out.println("1. 전체 기차 정보 조회 ");
            System.out.println("2. 기차 시간 or 순회지역 조회");
            System.out.println("3. 신규 기차 등록(관리자)");
            System.out.println("4. 기차 정보 수정(관리자)");
            System.out.println("5. 기차 정보 삭제(관리자)");
            System.out.println("번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: trainService.selectAllTrain(); break;
                case 2: trainService.searchTrainByTimeOrArea(inputSearchCriteria()); break;
                case 3: trainService.insertTrain(inputTrain()); break;
                case 4: break;
                case 5: break;

            }
        } while (true);
    }

    private static TrainDTO inputTrain() {

        Scanner sc = new Scanner(System.in);
        System.out.println("추가할 기차명을 입력하세요 : ");
        String trainName = sc.nextLine();
        System.out.println("추가할 지역을 입력하세요 : ");
        String tourArea = sc.nextLine();
        System.out.println("추가할 시간을 입력하세요(HH:mm) : ");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Time startTime = null;
        try {
            startTime = new Time(sdf.parse(sc.nextLine()).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        TrainDTO train = new TrainDTO();
        train.setTrainName(trainName);
        train.setTourArea(tourArea);
        train.setStartTime(startTime);

        return train;
    }

    private static SearchCriteria inputSearchCriteria() {

        Scanner sc = new Scanner(System.in);
        System.out.println("검색 기준을 입력해주세요.(time or area) : ");
        String condition = sc.nextLine();
        System.out.println("검색어를 입력해주세요. : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }

    private static void memberSubMenu() {

        Scanner sc = new Scanner(System.in);

        MemberService memberService = new MemberService();

        do{
            System.out.println("=============== 회원관리 메뉴 ===============");
            System.out.println("1. 회원가입");
            System.out.println("2. 회원 탈퇴");
            System.out.println("3. 회원 정보 수정");
            System.out.println("4. 회원 정보 조회");
            System.out.println("5. 전체 회원 정보 조회(관리자)");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: memberService.register(inputmember()); break;
                case 2: memberService.deleteMember(inputmemberid()); break;
//                case 3: memberService.updateMember(); break;
//                case 4: memberService.selectOneMember(); break;
//                case 5: memberService.selectAllMember(); break;
            }
        } while (true);
    }

    private static MemberDTO inputmember() {

        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력해주세요 : ");
        String name = sc.next();
        System.out.print("전화번호를 입력해주세요 : ");
        String num = sc.next();
        System.out.print("ID를 설정해주세요 : ");
        String ID = sc.next();
        System.out.print("비밀번호를 설정해주세요 : ");
        String PWD = sc.next();

        MemberDTO member = new MemberDTO();

        member.setMemberName(name);
        member.setMemberNum(num);
        member.setMemberID(ID);
        member.setMemberPWD(PWD);

        return member;
    }

    private static Map<String, String> inputmemberid() {

        Scanner sc = new Scanner(System.in);
        System.out.print("회원 아이디를 입력하세요 : ");
        String memID = sc.next();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("memID", memID);

        return parameter;
    }

    private static void ticketSubMenu() {

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



