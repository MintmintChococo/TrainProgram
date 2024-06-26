package com.mintchoco.mapper;

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
}
