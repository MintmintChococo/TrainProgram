package com.mintchoco.mapper;

import com.mintchoco.common.MemberDTO;
import com.mintchoco.common.TicketDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.mintchoco.common.Template.getSqlSession;

public class TicketService {

    private TicketMapper mapper;

    public boolean registTicket(TicketDTO ticket) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(TicketMapper.class);

        int result = mapper.registTicket(ticket);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean updateTicket(TicketDTO ticket) {


        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(TicketMapper.class);

        int result = mapper.updateTicket(ticket);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }

    public boolean deleteTicket(MemberDTO loggedInMember) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(TicketMapper.class);

        int result = mapper.deleteTicket(loggedInMember);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public List<TicketDTO> selectTicketByLoggedInMember(MemberDTO loggedInMember) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(TicketMapper.class);

        List<TicketDTO> ticketList = mapper.selectTicketByLoggedInMember(loggedInMember);

        sqlSession.close();

        return ticketList;
    }

    public List<TicketDTO> selectAllTicket() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(TicketMapper.class);

        List<TicketDTO> ticketList = mapper.selectAllTicket();

        sqlSession.close();

        return ticketList;
    }
}
