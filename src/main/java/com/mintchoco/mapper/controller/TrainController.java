package com.mintchoco.mapper.controller;

import com.mintchoco.common.SearchCriteria;
import com.mintchoco.common.TrainDTO;
import com.mintchoco.common.view.TrainPrintResult;
import com.mintchoco.mapper.TrainService;

import java.util.List;

public class TrainController {

    private final TrainPrintResult printResult;
    private final TrainService trainService;

    public TrainController() {
        printResult = new TrainPrintResult();
        trainService = new TrainService();
    }

    public void selectAllTrain() {

        List<TrainDTO> trainList = trainService.selectAllTrain();

        if (trainList != null) {
            printResult.trainList(trainList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void searchTrainByTimeOrArea(SearchCriteria searchCriteria) {

        List<TrainDTO> trainList = trainService.searchTrainByTimeOrArea(searchCriteria);

        if(trainList != null) {
            printResult.printSearchTrainByTimeOrArea(trainList, searchCriteria);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void insertTrain(TrainDTO trainDTO) {

        boolean result = trainService.insertTrain(trainDTO);

        if (result) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        } 
    }

    public void modifyTrain(TrainDTO trainDTO) {

        boolean result = trainService.modifyTrain(trainDTO);

        if (result) {
            printResult.printSuccessMessage("modify");
        } else {
            printResult.printErrorMessage("modify");
        }
    }

    public void deleteTrain(int scNo) {

        int result = trainService.deleteTrain(scNo);

        if (result > 0) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
        }
    }
