package com.zy.gisim.services;

import com.zy.gisim.model.UserEntity;

public interface TokenService {
    String getUserToken(UserEntity userInfo);
}
