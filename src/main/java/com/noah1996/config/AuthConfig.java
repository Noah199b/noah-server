package com.noah1996.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class AuthConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用数据库管理权限


        // 测试使用内存数据
        auth.inMemoryAuthentication()
                .withUser("noah").password("123456").roles("ADMIN")
                .and()
                .withUser("test").password("123456").roles("USER");


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 所有用户可访问 login
                .antMatchers("/login").permitAll()
                // admin开头的请求 需要拥有 ADMIN角色 才可以访问
                // 或者
                //.antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/admin/**").hasRole("ADMIN")
                // 表示出了上面的权限其余的请求一律认证
                .anyRequest().authenticated()
                // ...
                .and()
                // 指定登录页
                .formLogin().loginPage("/login")
                .and()
                // 指定登出
                .logout()
                // 登出url  默认 logout
                .logoutUrl("/logout")
                // 登出成功跳转页面
                .logoutSuccessUrl("/home");

    }
}
