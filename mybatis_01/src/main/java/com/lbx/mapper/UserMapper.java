package com.lbx.mapper;

import com.lbx.pojo.User;

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
     * @date 2020/10/9 23:19
     * @param map
     * @return java.util.List<com.lbx.pojo.User>
     */
    List<User> getUsers(Map<String,Integer> map);
    /**
     * TODO
     * @author 吕兵星
     * @date 2020/10/16 11:49
     * @param id
     * @return java.lang.Object
     */
    User findOneById(int id);
    /**
     * TODO
     * @author 吕兵星
     * @date 2020/10/9 18:41
     * @param user
     * @return void
     */
     void addUser(User user);
     /**
      * TODO
      * @author 吕兵星
      * @date 2020/10/9 19:14
      * @param user
      * @return int
      */
     int insertOne(User user);
     /**
      * TODO
      * @author 吕兵星
      * @date 2020/10/9 20:02
      * @param user
      * @return int
      */
     int updateOne(User user);
     /**
      * TODO
      * @author 吕兵星
      * @date 2020/10/9 20:12
      * @param id
      * @return
      */
    int  deleteOne(int id);

    /**
     * TODO
     * @author 吕兵星
     * @date 2020/10/9 20:48
     * @param map  Map<String,Object> 可以任意传参 万能MAP
     * @return int
     */
    int insertUser(Map<String,Object> map);
    /**
     * TODO
     * @author 吕兵星
     * @date 2020/10/10 1:03
     * @param name
     * @return java.lang.String
     */
    User findOneByName(String name);
}
