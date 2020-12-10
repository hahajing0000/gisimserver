package com.zy.gisim.utils;

import com.zy.gisim.model.ResponseEntity;
import org.springframework.util.StringUtils;

public class ResponseUtils {
    /**
     * 成功消息
     *
     * @param object data数据
     * @param <T>    消息数据实体类型
     * @return
     */
    public static <T> ResponseEntity<T> success(T object) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        if (null == object) {
            responseEntity.setCode(-1);
            responseEntity.setMsg("请求失败");
            responseEntity.setData(object);
        } else {
            responseEntity.setCode(0);
            responseEntity.setMsg("请求成功");
            responseEntity.setData(object);
        }

        return responseEntity;
    }

    /**
     * 失败消息
     *
     * @param <T>
     * @return
     */
    public static ResponseEntity failed(String msg) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(-1);
        responseEntity.setMsg(StringUtils.isEmpty(msg) ? "请求失败" : msg);
        responseEntity.setData("");
        return responseEntity;
    }
}
