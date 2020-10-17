package com.lbx.pojo;


import org.apache.ibatis.type.Alias;

/**
 * @author 吕兵星
 * @date 2020/10/9 13:01
 */
@Alias("user")
public class User {

    private Integer id;
    private String uname;
    private String pwd;
    private Integer levelid;
    private String addtime;
    private String updatetime;
    private Userinfo userinfo;

    public User() {
    }

    public User(Integer id, String uname, String pwd, Integer levelid,
                String addtime, String updatetime, Userinfo userinfo) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
        this.levelid = levelid;
        this.addtime = addtime;
        this.updatetime = updatetime;
        this.userinfo = userinfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getLevelid() {
        return levelid;
    }

    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", levelid=" + levelid +
                ", addtime='" + addtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                ", userinfo=" + userinfo +
                '}';
    }
}
