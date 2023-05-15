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
public class TestInBaseRequest<T> {

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
    @JsonProperty("timestamp")
    private Long timestamp;



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

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TestInBaseRequest{" +
                "apikey='" + apikey + '\'' +
                ", mkey='" + mkey + '\'' +
                ", op='" + op + '\'' +
                ", data=" + data +
                ", action='" + action + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
