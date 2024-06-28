package com.mintchoco.controller;


import com.mintchoco.common.MemberDTO;
import com.mintchoco.view.MemberPrintResult;
import com.mintchoco.mapper.MemberService;
import lombok.Getter;

import java.util.List;
import java.util.Map;

public class MemberController {

    private final MemberService memberService;
    private final MemberPrintResult printResult;
    public static MemberDTO loggedInMember;


    public MemberController() {
        memberService = new MemberService();
        printResult = new MemberPrintResult();
    }

    public void register(MemberDTO member) {

        boolean result = memberService.register(member);

        // view 전달
        if (result) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }

    }

    public void deleteMember(Map<String, String> parameter) {

        String memID = parameter.get("memID");

        boolean result = memberService.deleteMember(memID);

        // view로 전달
        if(result) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }

    }

    public void updateMember(Map<String, String> criteria) {

        boolean result = memberService.updateMember(criteria);

        // view로 전달
        if(result) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void selectOneMember(Map<String, String> parameter) {

        String memID = parameter.get("memID");

        MemberDTO member = memberService.selectOneMember(memID);

        if(member != null) {
            printResult.printMember(member);
        } else {
            printResult.printErrorMessage("selectOne");
        }

    }

    public void selectAllMember() {

        List<MemberDTO> memberList = memberService.selectAllMember();

        if(memberList != null) {
            printResult.printMemberList(memberList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public MemberDTO logIn(Map<String, String> parameter) {

        MemberDTO member = memberService.logIn(parameter);

        if(member != null) {
            printResult.printSuccessMessage("login");
            System.out.println("============ 로그인 회원 정보 ============");
            System.out.println(member);
        } else {
            printResult.printErrorMessage("login");
        }

        return member;
    }

    public void setLoginInfo(MemberDTO member) {
        loggedInMember = member;
    }
}
