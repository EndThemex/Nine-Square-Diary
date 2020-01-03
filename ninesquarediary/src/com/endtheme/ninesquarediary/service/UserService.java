package com.endtheme.ninesquarediary.service;

import com.endtheme.ninesquarediary.exception.ParameterException;
import com.endtheme.ninesquarediary.exception.ServiceException;
import com.endtheme.ninesquarediary.model.User;

public interface UserService {

    User login(String userName, String password) throws ParameterException, ServiceException;

}
