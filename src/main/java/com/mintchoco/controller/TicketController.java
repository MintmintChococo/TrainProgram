package com.mintchoco.controller;

import com.mintchoco.common.TicketDTO;
import com.mintchoco.mapper.TicketService;
import com.mintchoco.view.TicketPrintResult;

import java.util.List;
import java.util.Scanner;

import static com.mintchoco.controller.MemberController.loggedInMember;

public class TicketController {

    private final TicketPrintResult ticketPrintResult;
    private final TicketService ticketService;

    public TicketController() {
        ticketPrintResult = new TicketPrintResult();
        ticketService = new TicketService();
    }

    public void selectAllTicket() {

        List<TicketDTO> ticketList = ticketService.selectAllTicket();

        if(ticketList != null) {
            ticketPrintResult.printTicketList(ticketList);
        } else {
            ticketPrintResult.printErrorMessage("selectList");
        }

    }

    public void registTicket(TicketDTO ticketDTO) {

        boolean result = ticketService.registTicket(ticketDTO);

        if(result) {
            ticketPrintResult.printSuccessMessage("regist");
        } else {
            ticketPrintResult.printErrorMessage("regist");
        }

    }

    public void updateTicket(TicketDTO ticketDTO) {

        boolean result = ticketService.updateTicket(ticketDTO);

        if(result) {
            ticketPrintResult.printSuccessMessage("update");
        } else {
            ticketPrintResult.printErrorMessage("update");
        }
    }

    public void deleteTicket() {

        Scanner sc = new Scanner(System.in);

        System.out.print("정말로 환불하시겠습니까? (Y/N) : ");
        String really = sc.next();

        if (really.equals("Y")) {
            boolean result = ticketService.deleteTicket(loggedInMember);

            if(result) {
                ticketPrintResult.printSuccessMessage("delete");
            } else {
                ticketPrintResult.printErrorMessage("delete");
            }
        }

    }

    public void selectTicketByLoggedInMember() {

        List<TicketDTO> ticketList = ticketService.selectTicketByLoggedInMember(loggedInMember);

        if(ticketList != null) {
            ticketPrintResult.printTicket(ticketList);
        } else {
            ticketPrintResult.printErrorMessage("selectOne");
        }
    }
}
