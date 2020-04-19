package cn.cupbread.glanzz.Component;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Date: 2020/1/12
 * @Author: CupOfBread
 * @Description: 格式化返回对象
 */
@Accessors(chain = true)
@Data
public class RetResponse<T> {
    private final static String SUCCESS = "success";
    public int code;
    private String msg;
    private T data;

    public  RetResponse makeOKRsp(int code) {
        return new RetResponse().setCode(code).setMsg(SUCCESS);
    }

    public RetResponse makeOKRsp(int code,T data) {
        return new RetResponse().setCode(code).setMsg(SUCCESS).setData(data);
    }

    public RetResponse makeOKRsp(int code,String msg,T data) {
        return new RetResponse().setCode(code).setMsg(msg).setData(data);
    }

    public RetResponse makeErrRsp(int code,String msg) {
        return new RetResponse().setCode(code).setMsg(msg);
    }

    public RetResponse makeErrRsp(int code,String msg,T data) {
        return new RetResponse().setCode(code).setMsg(msg).setData(data);
    }


}
