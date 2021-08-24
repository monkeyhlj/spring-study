package com.monkey.springbootshrio.realm;

import com.monkey.springbootshrio.entity.Account;
import com.monkey.springbootshrio.service.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class AccountRealm extends AuthorizingRealm{

    @Autowired
    private AccountService accountService;


    /**
     * 授权（登陆之后）
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前登录的用户信息
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account)subject.getPrincipal();

        //设置角色
        Set<String> roles = new HashSet<>();
        roles.add(account.getRole());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

        //设置权限
        info.addStringPermission(account.getPerms());

        return info;
    }


    /**
     * 认证（登录）
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;//客户端传过来的用户名和密码
        Account account = accountService.findByUsername(token.getUsername());//从数据库中取出用户名进行验证
        if(account != null){
           return new SimpleAuthenticationInfo(account,account.getPassword(),getName());//验证密码  如果验证不通过则抛出异常
        }
        return null;//抛出用户不存在
    }
}
