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

    public List<TrainDTO> selectAllTrain() {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(TrainMapper.class);

        List<TrainDTO> trainList = mapper.selectAllTrain();

        sqlSession.close();

        return trainList;
    }

    public List<TrainDTO> searchTrainByTimeOrArea(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(TrainMapper.class);

        List<TrainDTO> trainList = mapper.searchTrainByTimeOrArea(searchCriteria);

        sqlSession.close();

        return trainList;
    }

    public boolean insertTrain(TrainDTO train) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(TrainMapper.class);

        int result = mapper.insertTrain(train);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean modifyTrain(TrainDTO train) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(TrainMapper.class);

        int result = mapper.modifyTrain(train);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }

    public int deleteTrain(int scNo) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(TrainMapper.class);

        int result = mapper.deleteTrain(scNo);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result;
    }
}

