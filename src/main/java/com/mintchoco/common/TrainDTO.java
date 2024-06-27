package com.mintchoco.common;

import lombok.*;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TrainDTO {

    private int trainNo;
    private String trainName;
    private String tourArea;
    private LocalTime startTime;

}
