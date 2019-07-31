package cn.controller;

import cn.constant.RedisWorkspace;
import cn.constant.ResultMsg;
import cn.constant.ResultStatus;
import cn.entity.TbUser;
import cn.service.IUserService;
import cn.util.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: sfpy
 * @Date: 19/07/31 20:00
 * @Descirption
 * @Version 1.0
 */
@RestController
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    // Redis服务器IP
    @Value("${jsoso.token}")
    public int tokenExpire;
    /**
     * 登陆
     *
     * @param user 用户
     */
    @PostMapping(value = "/subLogin", produces = "application/json;charset=UTF-8")
    public ResultMsg login(TbUser user, HttpServletRequest request) throws IOException {
        ResultMsg resultMsg = new ResultMsg();
        String userName = user.getUserName();
        String password = user.getPassword();
        TbUser dbUser = userService.getUserByAccount(userName, password);
        if(EmptyUtils.isNotEmpty(dbUser)) {
            String token = UUID.randomUUID().toString().replace("-", "");
            redisTemplate.opsForValue().set(RedisWorkspace.API_SPACE.getValue() + token, dbUser.getId(), tokenExpire);
            resultMsg.setExtData(token);
            resultMsg.setMsg("登录成功");
            resultMsg.setCode(ResultStatus.SUCCESS.getId());
            resultMsg.setUrl("index");
        } else {
            resultMsg.setMsg("登录失败， 账号或用户名不正确！");
            resultMsg.setCode(ResultStatus.FAIL.getId());
        }
        return resultMsg;
    }
}
