package com.endtheme.ninesquarediary.dao;

import com.endtheme.ninesquarediary.model.User;

public interface UserDao {

    User login(String userName, String password);

}
