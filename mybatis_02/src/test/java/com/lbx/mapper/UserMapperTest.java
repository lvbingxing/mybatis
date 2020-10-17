package com.lbx.mapper;

import com.lbx.pojo.User;
import com.lbx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 吕兵星
 * @date 2020/10/9 13:19
 */
public class UserMapperTest {
    @Test
    public void findOneById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findOneById(1);
        sqlSession.close();
        System.out.println(user == null ? "查找失败" : "查找成功\n"+user);
    }
}