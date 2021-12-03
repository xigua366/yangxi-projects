package cn.xigua366.sample.service.impl;

import cn.xigua366.sample.dao.UserDAO;
import cn.xigua366.sample.domain.LoginUser;
import cn.xigua366.sample.exception.BizErrorCodeEnum;
import cn.xigua366.sample.utils.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yangxi.cloud.framework.exception.BaseBizException;
import com.yangxi.cloud.framework.utils.CommonUtil;
import cn.xigua366.sample.domain.entity.UserDO;
import cn.xigua366.sample.domain.request.LoginRequest;
import cn.xigua366.sample.domain.request.RegisterRequest;
import cn.xigua366.sample.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户管理服务Service组件
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    /**
     * 用户注册
     * @param registerRequest
     * @return
     */
    @Override
    @Transactional
    public boolean register(RegisterRequest registerRequest) {

        UserDO userDO = new UserDO();
        userDO.setName(registerRequest.getName());
        userDO.setPhone(registerRequest.getPhone());

        //设置密码 生成秘钥 盐
        userDO.setSecret("$1$" + CommonUtil.getStringNumRandom(8));

        userDO.setPwd(registerRequest.getPwd());
        //密码+盐处理
        String cryptPwd = Md5Crypt.md5Crypt(registerRequest.getPwd().getBytes(), userDO.getSecret());
        userDO.setPwd(cryptPwd);

        // 唯一性检查
        if(!checkUnique(userDO.getPhone())) {
            throw new BaseBizException(BizErrorCodeEnum.ACCOUNT_REPEAT);
        }

        boolean result = userDAO.save(userDO);
        log.info("result:{},注册成功:{}", result, userDO.toString());
        return result;

    }

    /**
     * 校验用户账号唯一
     *
     * @param phone
     * @return
     */
    private boolean checkUnique(String phone) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<UserDO>().eq("phone", phone);
        List<UserDO> list = userDAO.list(queryWrapper);
        return list.size() <= 0;

    }

    /**
     * 用户登录
     * @param loginRequest
     * @return
     */
    @Override
    public String login(LoginRequest loginRequest) {

        // 验证手机号码+密码的逻辑
        UserDO userDO = userDAO.findUserByPhone(loginRequest.getPhone());
        if(userDO == null) {
            throw new BaseBizException(BizErrorCodeEnum.ACCOUNT_UNREGISTER);
        }

        String cryptPwd = Md5Crypt.md5Crypt(loginRequest.getPwd().getBytes(), userDO.getSecret());
        if (!cryptPwd.equals(userDO.getPwd())) {
            // 账号或密码错误
            throw new BaseBizException(BizErrorCodeEnum.ACCOUNT_PWD_ERROR);
        }

        // 登录成功，生成token
        LoginUser loginUser = new LoginUser();
        loginUser.setId(userDO.getId());
        loginUser.setName(userDO.getName());
        loginUser.setPhone(userDO.getPhone());
        loginUser.setHeadImg(userDO.getHeadImg());
        loginUser.setMail(userDO.getMail());

        String accessToken = JWTUtil.geneJsonWebToken(loginUser);
        return accessToken;

    }
}