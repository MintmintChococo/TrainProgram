package com.mintchoco.mapper;

import com.mintchoco.common.SearchCriteria;
import com.mintchoco.common.TrainDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

import static com.mintchoco.common.Template.getSqlSession;

public class TrainService {

    private TrainMapper mapper;

    public void selectAllTrain() {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(TrainMapper.class);

        List<TrainDTO> trainList = mapper.selectAllTrain();

        for (TrainDTO train : trainList) {
            System.out.println(train);
        }
        sqlSession.close();
    }

    public void searchTrainByTimeOrArea(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(TrainMapper.class);

        List<TrainDTO> trainList = mapper.searchTrainByTimeOrArea(searchCriteria);


        if(searchCriteria.getCondition().equals("time")) {
            for(TrainDTO train : trainList) {
                System.out.println("기차명 : " + train.getTrainName() + " 기차시간 : " + train.getStartTime());
            }
        } else if (searchCriteria.getCondition().equals("area")) {
            for(TrainDTO train : trainList) {
                System.out.println("기차명 : " + train.getTrainName() + " 순회지역 : " + train.getTourArea());
            }
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }
}
