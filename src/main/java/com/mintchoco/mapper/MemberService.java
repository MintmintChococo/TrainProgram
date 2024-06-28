package com.mintchoco.mapper;

import com.mintchoco.common.MemberDTO;
import com.mintchoco.common.view.MemberPrintResult;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.mintchoco.common.Template.getSqlSession;

public class MemberService {
    private MemberMapper mapper;

    public boolean register(MemberDTO member) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(MemberMapper.class);

        int result = mapper.register(member);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean deleteMember(String memID) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(MemberMapper.class);

        int result = mapper.deleteMember(memID);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean updateMember(Map<String, String> criteria) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        int result = mapper.updateMember(criteria);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public MemberDTO selectOneMember(String memID) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        MemberDTO member = mapper.selectOneMember(memID);

        sqlSession.close();

        return member;
    }

    public List<MemberDTO> selectAllMember() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        List<MemberDTO> memberList = mapper.selectAllMember();

        sqlSession.close();

        return memberList;
    }
}
