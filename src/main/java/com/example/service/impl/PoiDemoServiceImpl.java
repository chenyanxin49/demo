package com.example.service.impl;

import com.example.domain.FXbhB;
import com.example.mapper.FXbhBMapper;
import com.example.service.IPoiDemoService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by      Intellij IDEA
 *
 * @author :      ChenYanxin
 * Date    :       2018-03-21
 * Time    :       14:00
 * Version :       1.0
 * Company :       北京太比雅科技(武汉研发中心)
 */
@Service
public class PoiDemoServiceImpl implements IPoiDemoService {

    @Autowired
    private FXbhBMapper fXbhBMapper;

    /**
     * 获取sqlsession
     * 从spring注入原有的sqlSessionTemplate
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 批量保存区域实现
     *
     * @param areas
     */
    @Override
    public void saveBatch(List<FXbhB> areas) {
        int i = 0;
        // 新获取一个模式为BATCH，自动提交为false的session
        // 如果自动提交设置为true,将无法控制提交的条数，改为最后统一提交，可能导致内存溢出
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        // 通过新的session获取mapper
        fXbhBMapper = session.getMapper(FXbhBMapper.class);
        try {
            for (FXbhB area : areas) {
                i++;

                fXbhBMapper.insert(area);
                if (i % 1000 == 0) {
                    // 手动每1000个一提交，提交后无法回滚
                    session.commit();
                    // 清理缓存，防止溢出
                    session.clearCache();
                }
            }
            session.commit();
            // 清理缓存，防止溢出
            System.out.println("成功 = [" + i + "]");
        } catch (Exception e) {
            e.printStackTrace();
            // 没有提交的数据可以回滚
            session.rollback();
        } finally {
            session.close();
        }
    }
}
