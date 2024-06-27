package com.mintchoco.mapper;

import com.mintchoco.common.MemberDTO;

import java.util.Map;

public interface MemberMapper {
    int register(MemberDTO member);

    int deleteMember(String memID);

    int updateMember(Map<String, String> criteria);
}
