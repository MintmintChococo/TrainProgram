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
}
