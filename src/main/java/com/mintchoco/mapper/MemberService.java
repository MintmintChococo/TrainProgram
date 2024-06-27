package com.mintchoco.mapper;

import com.mintchoco.common.MemberDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

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

    public void deleteMember(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(MemberMapper.class);

        String memID = parameter.get("memID");

        int result = mapper.deleteMember(memID);

        if(result > 0) {
            System.out.println("회원 탈퇴 성공 !");
            sqlSession.commit();
        } else {
            System.out.println("회원 탈퇴 실패 !");
            sqlSession.rollback();
        }
    }

    public void updateMember(Map<String, String> criteria) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        int result = mapper.updateMember(criteria);

        if(result > 0) {

            System.out.println("회원 정보 변경에 성공하셨습니다.");
            sqlSession.commit();

        } else {
            System.out.println("회원 정보 변경에 실패하셨습니다.");
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    public void selectOneMember(Map<String, String> memberID) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        String memID = memberID.get("memID");

        MemberDTO member = mapper.selectOneMember(memID);

        // view
        if(member != null) {

            System.out.println("회원 정보 조회에 성공하셨습니다.");
            System.out.println(member);
            sqlSession.commit();

        } else {
            System.out.println("회원 정보 조회에 실패하셨습니다.");
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    public void selectAllMember() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        List<MemberDTO> memberList = mapper.selectAllMember();

        // view
        if(memberList != null) {

            System.out.println("회원 정보 조회에 성공하셨습니다.");
            for(MemberDTO mem : memberList) {
                System.out.println(mem);
            }
            sqlSession.commit();

        } else {
            System.out.println("회원 정보 조회에 실패하셨습니다.");
            sqlSession.rollback();
        }

        sqlSession.close();
    }
}
