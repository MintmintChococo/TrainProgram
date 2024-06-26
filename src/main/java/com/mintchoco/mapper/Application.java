package com.mintchoco.mapper;

import com.mintchoco.common.MemberDTO;

import java.util.HashMap;
import java.util.Map;
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
                case 3: break;
            }
        } while (true);
    }

    private static void trainSubMenu() {
        Scanner sc = new Scanner(System.in);
        TrainService trainService = new TrainService();

        do {
            System.out.println("1. 전체 기차 정보 조회 ");
            System.out.println("2. 기차 시간 조회");
            System.out.println("3. 기차 시간 등록(관리자)");
            System.out.println("4. 기차 시간 수정(관리자)");
            System.out.println("5. 기차 시간 삭제(관리자)");
            System.out.println("6. 순회 지역 조회");
            System.out.println("번호을 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: trainService.selectAllTrain(); break;

                case 2: break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 6: break;
            }
        } while (true);
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
}
