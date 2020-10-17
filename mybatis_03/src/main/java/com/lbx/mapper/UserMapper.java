package com.lbx.mapper;


import com.lbx.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author 吕兵星
 * @date 2020/10/9 13:06
 */
public interface UserMapper {
        /**
         * TODO
         * @author 吕兵星
         * @date 2020/10/16 22:22
         * @param map
         * @return java.util.List<com.lbx.pojo.User>
         */
        @Select("select * from user limit #{startIndex},#{pageSize}")
        List<User> getUsers(Map<String,Integer> map);

        /**
         * 当有多个参数时需要添加 @Param绑定
         * @author 吕兵星
         * @date 2020/10/17 10:44
         * @param id
         * @param name
         * @return com.lbx.pojo.User
         */
        @Select("select * from user where id=#{id} or uname=#{name}")
        User getUserById(@Param("id")Integer id,@Param("name")String name);
}
