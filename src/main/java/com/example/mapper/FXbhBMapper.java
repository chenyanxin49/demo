package com.example.mapper;

import com.example.domain.FXbhB;
import com.example.domain.FXbhBExample;
import com.example.domain.FXbhBKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FXbhBMapper {
    /**
     *
     * @mbggenerated 2018-07-16
     */
    int countByExample(FXbhBExample example);

    /**
     *
     * @mbggenerated 2018-07-16
     */
    int deleteByExample(FXbhBExample example);

    /**
     *
     * @mbggenerated 2018-07-16
     */
    int deleteByPrimaryKey(FXbhBKey key);

    /**
     *
     * @mbggenerated 2018-07-16
     */
    int insert(FXbhB record);

    /**
     *
     * @mbggenerated 2018-07-16
     */
    int insertSelective(FXbhB record);

    /**
     *
     * @mbggenerated 2018-07-16
     */
    List<FXbhB> selectByExample(FXbhBExample example);

    /**
     *
     * @mbggenerated 2018-07-16
     */
    FXbhB selectByPrimaryKey(FXbhBKey key);

    /**
     *
     * @mbggenerated 2018-07-16
     */
    int updateByExampleSelective(@Param("record") FXbhB record, @Param("example") FXbhBExample example);

    /**
     *
     * @mbggenerated 2018-07-16
     */
    int updateByExample(@Param("record") FXbhB record, @Param("example") FXbhBExample example);

    /**
     *
     * @mbggenerated 2018-07-16
     */
    int updateByPrimaryKeySelective(FXbhB record);

    /**
     *
     * @mbggenerated 2018-07-16
     */
    int updateByPrimaryKey(FXbhB record);
}