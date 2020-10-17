package com.lbx.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * @author 吕兵星
 * @date 2020/10/9 13:01
 */
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("user")
public class User {
    private Integer id;
    private String uname;
    private String pwd;
    private Integer levelid;
    private String addtime;
    private String updatetime;
}
