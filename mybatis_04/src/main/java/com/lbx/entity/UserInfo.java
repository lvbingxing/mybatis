package com.lbx.entity;


import lombok.*;
import org.apache.ibatis.type.Alias;

/**
 * TODO
 * @author 吕兵星
 * @date 2020/10/17 13:55
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Alias("userInfo")
public class UserInfo {
    int id;
    String username;
    char sex;
    String tel;
    String email;
    String addr;
    User user;
}
