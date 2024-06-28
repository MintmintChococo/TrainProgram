package com.mintchoco.view;

import com.mintchoco.common.TicketDTO;

import java.util.List;

public class TicketPrintResult {

    public void printErrorMessage(String errorCode) {

        String errorMessage = switch (errorCode) {
            case "selectList" -> "티켓 목록 조회를 실패했습니다.";
            case "selectOne" -> "티켓 조회를 실패했습니다.";
            case "regist" -> "신규 티켓 등록을 실패했습니다.";
            case "update" -> "티켓 수정을 실패했습니다.";
            case "delete" -> "티켓 삭제를 실패했습니다.";
            default -> "";
        };
        System.out.println(errorMessage);

    }
    public void printSuccessMessage(String successCode) {

        String successMessage = switch (successCode) {
            case "regist" -> "신규 티켓 등록을 성공했습니다.";
            case "update" -> "티켓 수정을 성공했습니다.";
            case "delete" -> "티켓 삭제를 성공했습니다.";
            default -> "";
        };
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
