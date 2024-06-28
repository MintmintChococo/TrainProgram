package com.mintchoco.view;

import com.mintchoco.common.MemberDTO;

import java.util.List;

public class MemberPrintResult {

    public void printMemberList(List<MemberDTO> memberlist) {

        System.out.println("전체 회원 목록 조회 {");

        for(MemberDTO member : memberlist) {
            member.toStringExceptPWD();
        }

        System.out.println("}");
    }

    public void printMember(MemberDTO member) {
        System.out.println(member);
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";
        switch (successCode) {

            case "login" : successMessage = "로그인 성공!!"; break;
            case "insert" : successMessage = "신규 회원 등록을 성공했습니다."; break;
            case "update" : successMessage = "회원 수정을 성공했습니다."; break;
            case "delete" : successMessage = "회원 삭제를 성공했습니다."; break;

        }

        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";

        switch (errorCode) {
            case "selectList" : errorMessage = "회원목록 조회를 실패했습니다."; break;
            case "selectOne" : errorMessage = "회원 조회를 실패했습니다."; break;
            case "insert" : errorMessage = "신규 회원 등록을 실패했습니다."; break;
            case "update" : errorMessage = "회원 수정을 실패했습니다."; break;
            case "delete" : errorMessage = "회원 삭제를 실패했습니다."; break;
            case "login" : errorMessage = "로그인 실패!! \n 다시 로그인 해주세요..."; break;

        }

        System.out.println(errorMessage);
    }

}
