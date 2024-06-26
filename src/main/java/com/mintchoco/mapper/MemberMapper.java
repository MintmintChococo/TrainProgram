package com.mintchoco.mapper;

import com.mintchoco.common.MemberDTO;

public interface MemberMapper {
    int register(MemberDTO member);

    int deleteMember(String memID);
}
