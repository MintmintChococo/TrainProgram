package com.mintchoco.mapper;

import com.mintchoco.common.TicketDTO;

public interface TicketMapper {

    int registTicket(TicketDTO ticket);


    int updateTicket(TicketDTO ticket);
}
