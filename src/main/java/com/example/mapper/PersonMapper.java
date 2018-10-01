package com.example.mapper;

import com.example.domain.Person;
import com.example.domain.PersonExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PersonMapper
 * realtour
 *
 * @author :        ChenYanxin
 * @date :          2018/10/1 11:01
 */
@Mapper
@Repository
public interface PersonMapper {

    /**
     * @mbggenerated 2018-10-01
     */
    int countByExample(PersonExample example);

    /**
     * @mbggenerated 2018-10-01
     */
    int deleteByExample(PersonExample example);

    /**
     * @mbggenerated 2018-10-01
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbggenerated 2018-10-01
     */
    int insert(Person record);

    /**
     * @mbggenerated 2018-10-01
     */
    int insertSelective(Person record);

    /**
     * @mbggenerated 2018-10-01
     */
    List<Person> selectByExample(PersonExample example);

    /**
     * @mbggenerated 2018-10-01
     */
    Person selectByPrimaryKey(Integer id);

    /**
     * @mbggenerated 2018-10-01
     */
    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonExample example);

    /**
     * @mbggenerated 2018-10-01
     */
    int updateByExample(@Param("record") Person record, @Param("example") PersonExample example);

    /**
     * @mbggenerated 2018-10-01
     */
    int updateByPrimaryKeySelective(Person record);

    /**
     * @mbggenerated 2018-10-01
     */
    int updateByPrimaryKey(Person record);
}
