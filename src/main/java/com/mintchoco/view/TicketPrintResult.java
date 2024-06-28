package com.mintchoco.view;

import com.mintchoco.common.MemberDTO;
import com.mintchoco.common.TicketDTO;

import java.util.List;

public class TicketPrintResult {

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode) {
            case "selectList": errorMessage = "티켓 목록 조회를 실패했습니다."; break;
            case "selectOne": errorMessage = "티켓 조회를 실패했습니다."; break;
            case "regist": errorMessage = "신규 티켓 등록을 실패했습니다."; break;
            case "update": errorMessage = "티켓 수정을 실패했습니다."; break;
            case "delete": errorMessage = "티켓 삭제를 실패했습니다."; break;
        }
        System.out.println(errorMessage);

    }
    public void printSuccessMessage(String successCode) {

        String successMessage = "";
        switch (successCode) {
            case "regist" : successMessage = "신규 티켓 등록을 성공했습니다."; break;
            case "update" : successMessage = "티켓 수정을 성공했습니다."; break;
            case "delete" : successMessage = "티켓 삭제를 성공했습니다."; break;
        }
        System.out.println(successMessage);
    }

    public void printTicket(List<TicketDTO> ticketList) {

        System.out.println("예매 내역 조회 {");

        for(TicketDTO ticket : ticketList) {
            System.out.println(ticket);
        }

        System.out.println("}");
    }

    public void printTicketList(List<TicketDTO> ticketList) {

        System.out.println("전체 티켓 목록 조회 {");

        for(TicketDTO ticket : ticketList) {
            System.out.println(ticket);
        }

        System.out.println("}");
    }
}
