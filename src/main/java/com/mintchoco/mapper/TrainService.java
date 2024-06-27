package com.mintchoco.mapper;

import com.mintchoco.common.SearchCriteria;
import com.mintchoco.common.TrainDTO;
import org.apache.ibatis.session.SqlSession;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.mintchoco.common.Template.getSqlSession;

public class TrainService {

    private TrainMapper mapper;

    public void selectAllTrain() {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(TrainMapper.class);

        List<TrainDTO> trainList = mapper.selectAllTrain();


        for (TrainDTO train : trainList) {

            LocalTime localTime = train.getStartTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            String formattedTime = localTime.format(formatter);

            System.out.println("기차번호:" + train.getTrainNo()
                    + " 기차명:" + train.getTrainName() + " 순회지역:" + train.getTourArea() + " 출발시간대-" + formattedTime);
        }
        sqlSession.close();
    }

    public void searchTrainByTimeOrArea(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(TrainMapper.class);

        List<TrainDTO> trainList = mapper.searchTrainByTimeOrArea(searchCriteria);


        if(searchCriteria.getCondition().equals("time")) {
            for(TrainDTO train : trainList) {

                LocalTime localTime = train.getStartTime();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

                String formattedTime = localTime.format(formatter);
                System.out.println("기차명:" + train.getTrainName() + " 기차시간-" + formattedTime);
            }
        } else if (searchCriteria.getCondition().equals("area")) {
            for(TrainDTO train : trainList) {
                System.out.println("기차명:" + train.getTrainName() + " 순회지역:" + train.getTourArea());
            }
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public void insertTrain(TrainDTO train) {

        SqlSession sqlSession = getSqlSession();

        System.out.println(train.getStartTime());

        mapper = sqlSession.getMapper(TrainMapper.class);

        int result = mapper.insertTrain(train);

        if(result > 0) {
            System.out.println("기차 추가 성공");
            sqlSession.commit();
        } else {
            System.out.println("기차 추가 실패");
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    public void modifyTrain(TrainDTO train) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(TrainMapper.class);

        int result = mapper.modifyTrain(train);

        if(result > 0) {
            System.out.println("기차 정보 변경에 성공하셨습니다.");
            sqlSession.commit();
        } else {
            System.out.println("기차 정보 변경에 실패하셨습니다[.");
            sqlSession.rollback();
        }
        sqlSession.close();
    }
}
