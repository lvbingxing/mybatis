package com.lbx.mapper;


import com.lbx.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Userinfo)表数据库访问层
 *
 * @author lvbingxing
 * @since 2020-10-10 00:26:59
 */
public interface UserinfoMapper {





    /**
     * 新增数据
     *
     * @param userinfo 实例对象
     * @return 影响行数
     */
    int insert(Userinfo userinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Userinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Userinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Userinfo> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Userinfo> entities);

    /**
     * 修改数据
     *
     * @param userinfo 实例对象
     * @return 影响行数
     */
    int update(Userinfo userinfo);


}