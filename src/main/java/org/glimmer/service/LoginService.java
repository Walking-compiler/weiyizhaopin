package org.glimmer.service;

import org.glimmer.domain.ResponseResult;
import org.glimmer.domain.User;

import java.util.HashMap;

public interface LoginService {
    public ResponseResult<HashMap<String, String>> login(User user);
    public ResponseResult logout();
}
