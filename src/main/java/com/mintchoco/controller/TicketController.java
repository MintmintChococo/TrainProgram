package com.mintchoco.controller;

import com.mintchoco.common.TicketDTO;
import com.mintchoco.mapper.TicketService;
import com.mintchoco.view.TicketPrintResult;

public class TicketController {

    private final TicketPrintResult ticketPrintResult;
    private final TicketService ticketService;

    public TicketController() {
        ticketPrintResult = new TicketPrintResult();
        ticketService = new TicketService();
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
}
