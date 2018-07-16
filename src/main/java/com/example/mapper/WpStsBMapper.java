package com.example.mapper;

import com.example.domain.WpStsB;
import com.example.domain.WpStsBExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WpStsBMapper {
    /**
     * @mbggenerated 2018-07-08
     */
    int countByExample(WpStsBExample example);

    /**
     * @mbggenerated 2018-07-08
     */
    int deleteByExample(WpStsBExample example);

    /**
     * @mbggenerated 2018-07-08
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbggenerated 2018-07-08
     */
    int insert(WpStsB record);

    /**
     * @mbggenerated 2018-07-08
     */
    int insertSelective(WpStsB record);

    /**
     * @mbggenerated 2018-07-08
     */
    List<WpStsB> selectByExample(WpStsBExample example);

    /**
     * @mbggenerated 2018-07-08
     */
    WpStsB selectByPrimaryKey(String id);

    /**
     * @mbggenerated 2018-07-08
     */
    int updateByExampleSelective(@Param("record") WpStsB record, @Param("example") WpStsBExample example);

    /**
     * @mbggenerated 2018-07-08
     */
    int updateByExample(@Param("record") WpStsB record, @Param("example") WpStsBExample example);

    /**
     * @mbggenerated 2018-07-08
     */
    int updateByPrimaryKeySelective(WpStsB record);

    /**
     * @mbggenerated 2018-07-08
     */
    int updateByPrimaryKey(WpStsB record);
}