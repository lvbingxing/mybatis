package com.lbx.entity;

import lombok.*;
import org.apache.ibatis.type.Alias;

/**
 * @author 吕兵星
 * @date 2020/10/17 13:47
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Alias("user")
public class User {
    int id;
    String uname;
    String pwd;
    int levelId;
    UserInfo userInfo;
    Ulevel  ulevel;
}
