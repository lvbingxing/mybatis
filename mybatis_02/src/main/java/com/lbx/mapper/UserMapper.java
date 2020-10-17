package com.lbx.mapper;

import com.lbx.pojo.User;

/**
 * @author 吕兵星
 * @date 2020/10/9 13:06
 */
public interface UserMapper {
    /**
     * TODO
     * @author 吕兵星
     * @date 2020/10/16 11:49
     * @param id
     * @return java.lang.Object
     */
    User findOneById(int id);
}
