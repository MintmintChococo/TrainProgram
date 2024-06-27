package com.mintchoco.mapper;

import com.mintchoco.common.MemberDTO;

import java.util.List;
import java.util.Map;

public interface MemberMapper {
    int register(MemberDTO member);

    int deleteMember(String memID);

    int updateMember(Map<String, String> criteria);

    MemberDTO selectOneMember(String memID);

    List<MemberDTO> selectAllMember();
}
