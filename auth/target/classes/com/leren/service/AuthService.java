package com.leren.service;

import com.leren.service.param.LoginParam;
import com.util.result.DataResult;

/**
 * @author lee
 * @Date:28/02/2018
 */

public interface AuthService {
    DataResult login(LoginParam loginParam);
}
