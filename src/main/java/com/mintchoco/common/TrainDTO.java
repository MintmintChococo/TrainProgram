package com.mintchoco.common;

import lombok.*;

import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TrainDTO {

    private int trainNo;
    private String trainName;
    private String tourArea;
    private Time startTime;

}
