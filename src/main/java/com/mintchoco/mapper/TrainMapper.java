package com.mintchoco.mapper;

import com.mintchoco.common.SearchCriteria;
import com.mintchoco.common.TrainDTO;

import java.util.List;
import java.util.Map;

public interface TrainMapper {
    List<TrainDTO> selectAllTrain();

    List<TrainDTO> searchTrainByTimeOrArea(SearchCriteria searchCriteria);

    int insertTrain(TrainDTO train);

    int modifyTrain(TrainDTO train);

    int deleteTrain(int scNo);
}
