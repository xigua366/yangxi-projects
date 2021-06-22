package cn.xigua366.sample.security.service;

import cn.xigua366.sample.domain.dto.SysUserDTO;
import cn.xigua366.sample.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 默认的UserDetailsService实现
 *
 * @author yangxi
 * @version 1.0
 * @date 2020-09-20 20:36
 */
@Component
public class DefaultUserDetailsServiceImpl implements UserDetailsService {

    private SysUserService sysUserService;

    @Autowired
    public DefaultUserDetailsServiceImpl(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     * @throws UsernameNotFoundException 用户信息不存在
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUserDTO sysUserDTO = sysUserService.getUserByUsername(username);
        if(sysUserDTO == null) {
            throw new UsernameNotFoundException("用户名【" + username + "】不存在");
        }

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        boolean admin = false;
//        boolean isAdmin = userDO.getAdmin();
//        if(isAdmin) {
//            grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        } else {
//            grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }

        String pwd = sysUserDTO.getPwd();
        MyUserDetails myUserDetails = new MyUserDetails(username, pwd, grantedAuthorityList);
        myUserDetails.setId(sysUserDTO.getId());
        myUserDetails.setAdmin(admin);
        return myUserDetails;
    }

}
