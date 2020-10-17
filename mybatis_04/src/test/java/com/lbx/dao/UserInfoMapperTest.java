package com.lbx.dao;

import com.lbx.entity.UserInfo;
import com.lbx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 吕兵星
 * @date 2020/10/17 16:24
 */
public class UserInfoMapperTest {

    @Test
    public void getUsesByAddr() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        List<UserInfo> infoList = mapper.getUsesByAddr("陕西");
        for (UserInfo userInfo : infoList) {
            System.out.println(userInfo);
        }
    }
}