package io.metersphere.testin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 云测 OPENAPI 基础参数
 *
 * @author maguangming
 * @since 2023/5/9 16:59
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestInBaseRespond<T> {

    public static final long RESPOND_CODE_SUCCESS = 0;
    @JsonProperty("apikey")
    private String apikey;
    @JsonProperty("mkey")
    private String mkey;
    @JsonProperty("op")
    private String op;
    @JsonProperty("data")
    private T data;
    @JsonProperty("action")
    private String action;

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("code")
    private Long code;

    public boolean isSuccess() {
        return code != null && code.equals(RESPOND_CODE_SUCCESS);
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getMkey() {
        return mkey;
    }

    public void setMkey(String mkey) {
        this.mkey = mkey;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TestInBaseRespond{" +
                "apikey='" + apikey + '\'' +
                ", mkey='" + mkey + '\'' +
                ", op='" + op + '\'' +
                ", data=" + data +
                ", action='" + action + '\'' +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
