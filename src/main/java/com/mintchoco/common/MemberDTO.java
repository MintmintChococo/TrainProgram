package com.mintchoco.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

    private int memberNO;
    private String memberName;
    private String memberNum;
    private String memberID;
    private String memberPWD;

    public void toStringExceptPWD() {
        System.out.println("회원정보[" +
                "memberNO=" + memberNO +
                ", memberName='" + memberName + '\'' +
                ", memberNum='" + memberNum + '\'' +
                ", memberID='" + memberID + '\'' +
                ']');
    }
}
