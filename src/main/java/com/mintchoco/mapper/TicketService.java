package com.mintchoco.mapper;

import com.mintchoco.common.TicketDTO;
import org.apache.ibatis.session.SqlSession;

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
}