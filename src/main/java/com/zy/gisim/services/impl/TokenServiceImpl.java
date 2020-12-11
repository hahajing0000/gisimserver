package com.zy.gisim.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zy.gisim.model.UserEntity;
import com.zy.gisim.services.TokenService;
import org.springframework.stereotype.Service;

@Service("TokenService")
public class TokenServiceImpl implements TokenService {
    @Override
    public String getUserToken(UserEntity userInfo) {
        String token = "";
        token = JWT.create().withAudience(userInfo.getPhonenumber())
                .sign(Algorithm.HMAC256(userInfo.getPhonenumber()));
        return token;
    }
}
