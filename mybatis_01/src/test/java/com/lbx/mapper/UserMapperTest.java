package com.lbx.mapper;

import com.lbx.pojo.User;
import com.lbx.pojo.Userinfo;
import com.lbx.util.Uip;
import com.lbx.utils.MybatisUtils;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 吕兵星
 * @date 2020/10/9 13:19
 */
public class UserMapperTest {

    @Test
    public void getUsers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int x=100,rows=20;
        int page=(x-1)*rows;
        Map<String,Integer> map = new HashMap<>();
        map.put("page",page);
        map.put("rows",rows);
        List<User> users = mapper.getUsers(map);
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();

    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUname("liuyan001");
        user.setPwd("lyf123.");
        mapper.addUser(user);
        sqlSession.close();
    }

    @Test
    public void insertOne() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserinfoMapper mapper1 = sqlSession.getMapper(UserinfoMapper.class);
        User user = new User();
        Userinfo userinfo = new Userinfo();
        int j=0;
        for (int i=1;i<500000;i++) {
            String username=Uip.produceName();
            String name=getFullSpell(username);
            Boolean aBoolean = this.findOneByName(name);

            if (aBoolean) {
                user.setUname(name);
                user.setPwd(Uip.producePassword());

                int i1 = 0 ;
                try {
                    i1 = mapper.insertOne(user);
                    sqlSession.commit();

                } catch (Exception e) {
                    System.out.println("e+"+user.getId());
                    e.printStackTrace();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    continue;
                }
                System.out.println("p"+user.getId());
                userinfo.setId(user.getId());
                userinfo.setUsername(username);
                userinfo.setEmail(Uip.produceEmail());
                userinfo.setTel(Uip.produceTel().substring(0,11));
                mapper1.insert(userinfo);
                j+=i1;
            }
        }
        sqlSession.commit();
        System.out.println(j>0?"成功添加"+j+"条记录,ID为"+user.getId():"添加失败"+user.getId());
        sqlSession.close();
    }

    @Test
    public void updateOne() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setUname("liuyan01");
        user.setPwd("ly11111_1");
        int i = mapper.updateOne(user);
        sqlSession.commit();
        System.out.println(i>0?"成功修改"+i+"条记录,ID为"+user.getId():"修改失败");
        sqlSession.close();
    }

    @Test
    public void deleteOne() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteOne(599);
        sqlSession.commit();
        System.out.println(i>0?"删除了"+i+"条记录":"删除失败");
    }

    @Test
    public void insertUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id",null);
        map.put("name","zhaoyihuan4");
        map.put("password","zyh123.026");
        int i = mapper.insertUser(map);
        System.out.println(i>0?"OK,ID="+map.get("id"):"failed");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findOneById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findOneById(1);
        sqlSession.close();
        System.out.println(user == null ? "查找失败" : "查找成功\n"+user);
    }
    public Boolean findOneByName(String name) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User byName = mapper.findOneByName(name);
        System.out.println(byName);
        sqlSession.close();
        return byName == null;
    }

    public static String getFullSpell(String chinese) {
        // 用StringBuffer（字符串缓冲）来接收处理的数据
        StringBuffer sb = new StringBuffer();
        //字符串转换字节数组
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        //转换类型（大写or小写）
//        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        //定义中文声调的输出格式
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        //定义字符的输出格式
        defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);
        for (int i = 0; i < arr.length; i++) {
            //判断是否是汉子字符
            if (arr[i] > 128) {
                try {
                    sb.append(capitalize(PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat)[0]));
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                // 如果不是汉字字符，直接拼接
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
    public static String capitalize(String str) {
        char ch[];
        ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        String newString = new String(ch);
        return newString;
    }

}