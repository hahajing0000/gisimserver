package com.zy.gisim.interceptor.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.google.gson.Gson;
import com.zy.gisim.utils.ResponseUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {

//    @Autowired
//    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        //String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        String usertk = httpServletRequest.getHeader("token");// 从http请求头中取出usertoken
//        String key_AES=httpServletRequest.getHeader("singkey");//获取key 改key使用服务器端下发的rsa publickey进行加密后的AES 密钥

        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            //校验Header
            boolean verifyResult= verifyHeader(httpServletRequest);
            if (!verifyResult){
                httpServletResponse.setStatus(1001);
                setRespData(httpServletResponse, new Gson().toJson(ResponseUtils.failed("请求头信息不完整")));
                return false;
            }
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        if (method.isAnnotationPresent(UserToken.class)) {
//            //校验Header
//            boolean verifyResult= verifyHeader(httpServletRequest);
//            if (!verifyResult){
//                httpServletResponse.setStatus(1001);
//                setRespData(httpServletResponse, new Gson().toJson(ResponseUtils.failed("请求头信息不完整")));
//                return false;
//            }
            UserToken userToken = method.getAnnotation(UserToken.class);
            if (userToken.required()) {
                if (StringUtils.isEmpty(usertk)) {
                    httpServletResponse.setStatus(401);
                    setRespData(httpServletResponse, new Gson().toJson(ResponseUtils.failed("请先登录获取Token")));
                    return false;
                }
                String phonenumbser=null;
                try{
                    phonenumbser = JWT.decode(usertk).getAudience().get(0);
                }catch (Exception ex){
                    httpServletResponse.setStatus(40111);
                    setRespData(httpServletResponse, new Gson().toJson(ResponseUtils.failed("发生错误，请检查Token，可能因为测试数据token不正确导致，要求必须通过登录接口获取正确token！！！")));
                    return false;
                }

                if (!StringUtils.isEmpty(phonenumbser)) {

//                    ResponseEntity<UserInfo> userInfoResponseEntity = userService.userExists(phonenumbser);
//                    if (userInfoResponseEntity == null || userInfoResponseEntity.getData() == null) {
//                        httpServletResponse.setStatus(40102);
//                        setRespData(httpServletResponse, new Gson().toJson(ResponseUtils.failed("验证失败，电话号码不存在")));
//                        return false;
//                    }
//                    String un = userInfoResponseEntity.getData().getPhonenumber();
                    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(phonenumbser)).build();
                    try {
                        jwtVerifier.verify(usertk);
                    } catch (JWTVerificationException e) {
                        httpServletResponse.setStatus(40103);
                    }
                    return true;
                } else {
                    httpServletResponse.setStatus(40101);
                    setRespData(httpServletResponse, new Gson().toJson(ResponseUtils.failed("验证失败，电话号码为空")));
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 校验是否传递了相关请求头信息
     * @param httpServletRequest
     * @return
     */
    private boolean verifyHeader(HttpServletRequest httpServletRequest) {
        String devicecode = httpServletRequest.getHeader("devicecode");
        if (StringUtils.isEmpty(devicecode)){
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

    private void setRespData(HttpServletResponse resp, String content){
        OutputStream outputStream = null;// 获取输出流
        try {
            outputStream = resp.getOutputStream();
            // 通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
            resp.setHeader("content-type", "application/json;charset=UTF-8");
            // 将字符转换成字节数组，指定以UTF-8编码进行转换
            byte[] dataByteArr = content.getBytes("UTF-8");
            //使用OutputStream流向客户端输出字节数组
            outputStream.write(dataByteArr);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}