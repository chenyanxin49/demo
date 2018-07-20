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
     * @mbg.generated 2018-07-20
     */
    long countByExample(FXbhBExample example);

    /**
     *
     * @mbg.generated 2018-07-20
     */
    int deleteByExample(FXbhBExample example);

    /**
     *
     * @mbg.generated 2018-07-20
     */
    int deleteByPrimaryKey(FXbhBKey key);

    /**
     *
     * @mbg.generated 2018-07-20
     */
    int insert(FXbhB record);

    /**
     *
     * @mbg.generated 2018-07-20
     */
    int insertSelective(FXbhB record);

    /**
     *
     * @mbg.generated 2018-07-20
     */
    List<FXbhB> selectByExample(FXbhBExample example);

    /**
     *
     * @mbg.generated 2018-07-20
     */
    FXbhB selectByPrimaryKey(FXbhBKey key);

    /**
     *
     * @mbg.generated 2018-07-20
     */
    int updateByExampleSelective(@Param("record") FXbhB record, @Param("example") FXbhBExample example);

    /**
     *
     * @mbg.generated 2018-07-20
     */
    int updateByExample(@Param("record") FXbhB record, @Param("example") FXbhBExample example);

    /**
     *
     * @mbg.generated 2018-07-20
     */
    int updateByPrimaryKeySelective(FXbhB record);

    /**
     *
     * @mbg.generated 2018-07-20
     */
    int updateByPrimaryKey(FXbhB record);
}