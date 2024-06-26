package com.mintchoco.mapper;

import com.mintchoco.common.MemberDTO;
import org.apache.ibatis.session.SqlSession;

import static com.mintchoco.common.Template.getSqlSession;

public class MemberService {
    private MemberMapper mapper;

    public void register(MemberDTO member) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(MemberMapper.class);

        int result = mapper.register(member);

        if(result > 0) {
            System.out.println("회원 가입 성공 !");
            sqlSession.commit();
        } else {
            System.out.println("회원 가입 실패 !");
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    public void deleteMember() {
    }

    public void updateMember() {
    }

    public void selectOneMember() {
    }

    public void selectAllMember() {
    }
}
