package com.mintchoco.mapper;

import com.mintchoco.common.SearchCriteria;
import com.mintchoco.common.MemberDTO;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import com.mintchoco.common.TicketDTO;
import com.mintchoco.common.TrainDTO;
import com.mintchoco.controller.TicketController;
import com.mintchoco.controller.MemberController;
import com.mintchoco.controller.TrainController;

import java.util.Scanner;

import static com.mintchoco.controller.MemberController.loggedInMember;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MemberDTO member = new MemberDTO();
        MemberController memberController = new MemberController();

        System.out.println("=========== 민초레일 사이트를 방문해주셔셔 감사합니다~~ :) ===========");
        do{
            System.out.println("1. 기존 회원으로 로그인하기");
            System.out.println("2. 회원 가입");
            System.out.print("번호를 입력하세요 : ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    member = memberController.logIn(inputMemberIdAndPWD());
                    memberController.setLoginInfo(member);
                    break;

                case 2: memberController.register(inputMember()); break;
            }

        } while(member.getMemberID() == null);


        do {
            System.out.println("=========== 민초레일 운행 사이트 ===========");
            System.out.println("무엇을 도와드릴까요?");
            System.out.println("1. 회원 관리(가입, 탈퇴, 수정, 조회) ");
            System.out.println("2. 기차");
            System.out.println("3. 예매티켓");
            System.out.print("번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {

                case 1:
                    memberSubMenu();
                    break;
                case 2:
                    trainSubMenu();
                    break;
                case 3:
                    ticketSubMenu();
                    break;
            }
        } while (true);
    }

    private static void memberSubMenu() {

        Scanner sc = new Scanner(System.in);

        MemberController memberController = new MemberController();

        do {
            System.out.println("=============== 회원관리 메뉴 ===============");
            System.out.println("1. 회원가입");
            System.out.println("2. 회원 탈퇴");
            System.out.println("3. 회원 정보 수정");
            System.out.println("4. 회원 정보 조회");
            System.out.println("5. 전체 회원 정보 조회(관리자)");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: memberController.register(inputMember()); break;
                case 2: memberController.deleteMember(inputMemberId()); break;
                case 3: memberController.updateMember(updateMemberById()); break;
                case 4: memberController.selectOneMember(inputMemberId()); break;
                case 5:
                    if (checkAdmin()) {
                        memberController.selectAllMember(); break;
                    } else {
                        System.out.println("전체 회원 정보 기능은 관리자만 이용 가능합니다!!");
                        break;
                    }
            }
        } while (true);
    }

    public static boolean checkAdmin() {

        return loggedInMember.getMemberID().equals("admin") && loggedInMember.getMemberPWD().equals("admin123");
    }


    private static MemberDTO inputMember() {

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

    private static Map<String, String> inputMemberId() {

        Scanner sc = new Scanner(System.in);
        System.out.print("회원 아이디를 입력하세요 : ");
        String memID = sc.next();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("memID", memID);

        return parameter;
    }

    private static Map<String, String> updateMemberById() {

        Scanner sc = new Scanner(System.in);

//        System.out.println("회원정보를 수정하기 위해 회원 인증을 시도합니다...");
//        System.out.print("회원 아이디를 입력해주세요 : ");
//        String ID = sc.next();
//        System.out.print("회원 비밀번호를 입력해주세요 : ");
//        String PWD = sc.next();

        System.out.print("회원 아이디를 입력해주세요 : ");
        String ID = sc.nextLine();
        System.out.print("수정할 회원 이름을 입력해주세요 : ");
        String name = sc.nextLine();
        System.out.print("수정할 회원 전화번호를 입력해주세요 : ");
        String num = sc.nextLine();
        System.out.print("수정할 회원 비밀번호를 입력해주세요 : ");
        String PWD = sc.nextLine();

        Map<String, String> criteria = new HashMap<>();
        criteria.put("ID",ID);
        criteria.put("name",name);
        criteria.put("num",num);
        criteria.put("PWD",PWD);

        return criteria;
    }

    private static Map<String, String> inputMemberIdAndPWD() {

        Scanner sc = new Scanner(System.in);

        System.out.print("ID 입력 : ");
        String ID = sc.next();
        System.out.print("PWD 입력 : ");
        String PWD = sc.next();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("ID", ID);
        parameter.put("PWD", PWD);

        return parameter;
    }

    private static void trainSubMenu() {
        Scanner sc = new Scanner(System.in);
        TrainController trainController = new TrainController();


        do {
            System.out.println("1. 전체 기차 정보 조회 ");
            System.out.println("2. 기차 시간 or 순회지역 조회");
            System.out.println("3. 신규 기차 등록(관리자)");
            System.out.println("4. 기차 정보 수정(관리자)");
            System.out.println("5. 기차 정보 삭제(관리자)");
            System.out.println("번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    trainController.selectAllTrain(); break;
                case 2:
                    trainController.searchTrainByTimeOrArea(inputSearchCriteria()); break;
                case 3:
                    if (checkAdmin()) {
                        trainController.insertTrain(inputTrain()); break;
                    } else {
                        System.out.println("신규 기차 등록은 관리자만 이용 가능합니다!!");
                        break;
                    }
                case 4:
                    if (checkAdmin()) {
                        trainController.modifyTrain(inputChangeInfoTrain()); break;
                    } else {
                        System.out.println("기차 정보 수정은 관리자만 이용 가능합니다!!");
                        break;
                    }
                case 5:
                    if (checkAdmin()) {
                        trainController.deleteTrain(inputScNo()); break;
                    } else {
                        System.out.println("기차 정보 삭제는 관리자만 이용 가능합니다!!");
                        break;
                    }
            }
        } while (true);
    }

    private static int inputScNo() {

        Scanner sc = new Scanner(System.in);
        System.out.println("운행번호를 입력하세요 : ");
        int scNo = sc.nextInt();

        return scNo;
    }

    private static TrainDTO inputChangeInfoTrain() {

        Scanner sc = new Scanner(System.in);
        System.out.println("변경할 운행 번호를 입력하세요 : ");
        int scNo = sc.nextInt();
        System.out.println("변경할 기차명을 입력하세요 : ");
        sc.nextLine();
        String trainName = sc.nextLine();
        System.out.println("변경할 출발지를 입력하세요 : ");
        String departure = sc.nextLine();
        System.out.println("변경할 목적지를 입력하세요 : ");
        String arrival = sc.nextLine();
        System.out.println("변경할 출발 시간을 입력하세요 : ");
        String dTime = sc.nextLine();
        System.out.println("변경할 도착 시간을 입력하세요 : ");
        String aTime = sc.nextLine();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("H:mm");
        LocalTime depTime = LocalTime.parse(dTime, dateTimeFormatter);
        LocalTime arrivalTime = LocalTime.parse(aTime, dateTimeFormatter);

        TrainDTO train = new TrainDTO();
        train.setScNo(scNo);
        train.setTrainName(trainName);
        train.setDeparture(departure);
        train.setArrival(arrival);
        train.setDepTime(depTime);
        train.setArrivalTime(arrivalTime);

        return train;
    }

    private static TrainDTO inputTrain() {

        Scanner sc = new Scanner(System.in);
        System.out.println("추가할 기차명을 입력하세요 : ");
        String trainName = sc.nextLine();
        System.out.println("추가할 출발지역을 입력하세요 : ");
        String departure = sc.nextLine();
        System.out.println("추가할 도착지역을 입력하세요 : ");
        String arrival = sc.nextLine();
        System.out.println("추가할 출발시간을 입력하세요(HH:mm) : ");
        String dtime = sc.nextLine();
        System.out.println("추가할 도착시간을 입력하세요(HH:mm) : ");
        String atime = sc.nextLine();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("H:mm");

        LocalTime depTime = LocalTime.parse(dtime, dateTimeFormatter);
        LocalTime arrivalTime = LocalTime.parse(atime, dateTimeFormatter);

        TrainDTO train = new TrainDTO();
        train.setTrainName(trainName);
        train.setDeparture(departure);
        train.setArrival(arrival);
        train.setDepTime(depTime);
        train.setArrivalTime(arrivalTime);

        return train;
    }

    private static void ticketSubMenu() {

        Scanner sc = new Scanner(System.in);

        TicketController ticketController = new TicketController();

        do {
            System.out.println("============ 티켓 예매내역 확인 메뉴 ============");
            System.out.println("1. 티켓 전체 조회");
            System.out.println("2. 티켓 구매");
            System.out.println("3. 예매 내역 수정");
            System.out.println("4. 티켓 환불");
            System.out.println("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
//                case 1:
//                    ticketController.selectAllTicket(); break;
                case 2:
                    ticketController.registTicket(inputTicket()); break;
                case 3:
                    ticketController.updateTicket(inputChangeInfoTicket()); break;
                case 4:
                    ticketController.deleteTicket(); break;


            }
        } while (true);
    }

    private static TicketDTO inputChangeInfoTicket() {

        Scanner sc = new Scanner(System.in);
        System.out.println("변경할 티켓 번호를 입력하세요 : ");
        int ticketNo = sc.nextInt();
        System.out.println("변경할 회원 번호를 입력하세요 : ");
        int memNo = sc.nextInt();
        System.out.println("변경할 운행 번호를 입력하세요 : ");
        int scNo = sc.nextInt();
        System.out.println("변경할 좌석 번호를 입력하세요 : ");
        sc.nextLine();
        String seatNo = sc.nextLine();

        TicketDTO ticket = new TicketDTO();
        ticket.setTicketNo(ticketNo);
        ticket.setMemNo(memNo);
        ticket.setScNo(scNo);
        ticket.setSeatNo(seatNo);

        return ticket;
    }

    private static TicketDTO inputTicket() {

        Scanner sc = new Scanner(System.in);
        System.out.println("회원번호를 입력하세요 : ");
        int memNo = sc.nextInt();
        System.out.println("운행번호를 확인하세요 : ");
        sc.nextLine();
        int scNo = sc.nextInt();
        System.out.println("좌석번호를 입력하세요 : ");
        sc.nextLine();
        String seatNo = sc.nextLine();

        TicketDTO ticket = new TicketDTO();
        ticket.setMemNo(memNo);
        ticket.setScNo(scNo);
        ticket.setSeatNo(seatNo);

        return ticket;
    }

    private static SearchCriteria inputSearchCriteria() {

        Scanner sc = new Scanner(System.in);
        System.out.println("검색 기준을 입력해주세요.(time or departure or arrival) : ");
        String condition = sc.nextLine();
        System.out.println("검색어 입력해주세요. : ");
        String value = sc.nextLine();


        return new SearchCriteria(condition, value);
    }
}



