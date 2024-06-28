package com.mintchoco.mapper.controller;

import com.mintchoco.common.TicketDTO;
import com.mintchoco.common.view.TicketPrintResult;
import com.mintchoco.mapper.TicketService;

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
}
