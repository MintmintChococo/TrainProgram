package com.mintchoco.mapper;

import com.mintchoco.common.MemberDTO;
import com.mintchoco.common.TicketDTO;

public interface TicketMapper {

    int registTicket(TicketDTO ticket);

    int deleteTicket(MemberDTO loggedInMember);
}
