package cn.xigua366.sample.controller;

import cn.xigua366.sample.domain.dto.SysUserDTO;
import cn.xigua366.sample.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@RestController
@RequestMapping("/admin/v1/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/{username}")
    public SysUserDTO getUserByUsername(@PathVariable("username") String username) {
        SysUserDTO userDTO = new SysUserDTO();
        return null;
    }
}