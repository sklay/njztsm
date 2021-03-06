/*
 * Project:  sklay
 * Module:   sklay-web
 * File:     LoginUserHelper.java
 * Modifier: zhouning
 * Modified: 2012-12-13 上午9:46:26 
 *
 * Copyright (c) 2012 Sanyuan Ltd. All Rights Reserved.
 *
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent or the
 * registration of a utility model, design or code.
 */
package com.sklay.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sklay.model.User;
import com.sklay.service.UserService;

/**
 * 
 *  .
 * <p/>
 *
 * @author <a href="mailto:1988fuyu@163.com">fuyu</a>
 * 
 * @version v1.0 2013-8-15
 */
@Component
public class LoginUserHelper {

	private static UserService userService;

	@Autowired
	public void init(UserService userService) {
		LoginUserHelper.userService = userService;
	}
	
	public static Long getLoginUserId(){
		Subject currentUser = SecurityUtils.getSubject();
		User user =(User)currentUser.getPrincipal() ;
		return user == null ? null : user.getId();
	}
	
	public static User getLoginUser() {
		Long userId = getLoginUserId();
		return userId == null ? null : userService.getUser(userId);
	}

	public static void login(String username, String password,
			boolean rememberMe) {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isAuthenticated()) {
			currentUser.logout();
		}
		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		token.setRememberMe(rememberMe);
		currentUser.login(token);
	}

	public static void logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
	}

}
