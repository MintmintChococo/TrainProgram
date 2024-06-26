package com.mintchoco.mapper;

import com.mintchoco.common.TrainDTO;

import java.util.List;

public interface TrainMapper {
    List<TrainDTO> selectAllTrain();
}
