package com.mintchoco.mapper;

import com.mintchoco.common.MemberDTO;
import com.mintchoco.common.TicketDTO;

import java.util.List;

public interface TicketMapper {

    int registTicket(TicketDTO ticket);

    int updateTicket(TicketDTO ticket);

    int deleteTicket(MemberDTO loggedInMember);

    List<TicketDTO> selectTicketByLoggedInMember(MemberDTO loggedInMember);
}
