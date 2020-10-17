package com.lbx.dao;

import com.lbx.entity.User;
import com.lbx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 吕兵星
 * @date 2020/10/17 14:02
 */
public class UserMapperTest {

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(888);
        System.out.println(userById);
    }

    @Test
    public void getUserByIdAndLevel() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByIdAndLevel(1);
        System.out.println(user);
    }
}