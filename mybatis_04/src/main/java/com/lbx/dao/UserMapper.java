package com.lbx.dao;

import com.lbx.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 吕兵星
 * @date 2020/10/17 13:57
 */
public interface UserMapper {
    /**
     * TODO
     * @author 吕兵星
     * @date 2020/10/17 14:42
     * @param id
     * @return com.lbx.entity.User
     */
    User getUserById(@Param("uid") Integer id);
    /**
     * TODO
     * @author 吕兵星
     * @date 2020/10/17 15:23
     * @param id
     * @return com.lbx.entity.User
     */
    User getUserByIdAndLevel(@Param("uid") Integer id);
}
