package com.endtheme.ninesquarediary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.endtheme.ninesquarediary.dao.UserDao;
import com.endtheme.ninesquarediary.exception.ParameterException;
import com.endtheme.ninesquarediary.exception.ServiceException;
import com.endtheme.ninesquarediary.model.User;
import com.endtheme.ninesquarediary.service.UserService;
import com.endtheme.ninesquarediary.util.StringUtil;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String userName, String password) throws ParameterException, ServiceException {
        User user = null;

        ParameterException parameterException = new ParameterException();
        if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
            parameterException.addErrorField("USER_NAME_TIP", "用户名不能为空");
            parameterException.addErrorField("PASSWORD_TIP", "密码不能为空");
        }

        if (parameterException.isErrorField()) {
            throw parameterException;
        }

        user =userDao.login(userName, password);

        if (user == null || !password.equals(user.getPassword())) {
            throw new ServiceException(1001, "用户名或密码错误");
        }
        user.setPassword("");

        return user;
    }

}
