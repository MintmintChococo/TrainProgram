package com.mintchoco.common;

import lombok.*;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TrainDTO {

    private int scNo;
    private String trainName;
    private String departure;
    private String arrival;
    private LocalTime depTime;
    private LocalTime arrivalTime;

}
