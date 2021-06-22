package cn.xigua366.sample.security.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * spring security 中的自定义用户信息
 * @author yangxi
 * @version 1.0
 * @date 2020-11-20 18:43
 */
public class MyUserDetails extends User {

    private static final long serialVersionUID = 7109519787654785484L;


    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名称
     */
    private String realName;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 是否管理员
     */
    private boolean admin;

    public MyUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public MyUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
