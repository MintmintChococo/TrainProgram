package com.mintchoco.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TicketDTO {

    private int ticketNO;
    private int MemberNO;
    private int trainNO;
    private String seatNO;
    private String departure;
    private String arrival;
    private String time;
}