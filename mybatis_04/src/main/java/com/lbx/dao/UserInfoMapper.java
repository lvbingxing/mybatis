package com.lbx.dao;

import com.lbx.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 吕兵星
 * @date 2020/10/17 13:57
 */
public interface UserInfoMapper {
    /**
     * TODO
     * @author 吕兵星
     * @date 2020/10/17 16:21
     * @param addr
     * @return java.util.List<com.lbx.entity.UserInfo>
     */
    List<UserInfo> getUsesByAddr(@Param("addr")String addr);
}
