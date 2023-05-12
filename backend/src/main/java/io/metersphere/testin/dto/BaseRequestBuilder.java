package io.metersphere.testin.dto;

import java.util.Date;
import java.util.HashMap;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/9 17:44
 */
public final class BaseRequestBuilder<T> {
    private String apikey;
    private String mkey;
    private String op;
    private T data;
    private String action;
    private Long timestamp;

    private BaseRequestBuilder() {
    }

    public static <T> BaseRequestBuilder<T> builder() {
        return new BaseRequestBuilder<>();
    }

    public BaseRequestBuilder<T> withApikey(String apikey) {
        this.apikey = apikey;
        return this;
    }

    public BaseRequestBuilder<T> withMkey(String mkey) {
        this.mkey = mkey;
        return this;
    }

    public BaseRequestBuilder<T> withOp(String op) {
        this.op = op;
        return this;
    }

    public BaseRequestBuilder<T> withData(T data) {
        this.data = data;
        return this;
    }

    public BaseRequestBuilder<T> withAction(String action) {
        this.action = action;
        return this;
    }

    public BaseRequestBuilder<T> withTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public TestInBaseRequest<T> build() {
        TestInBaseRequest<T> testInBaseRequest = new TestInBaseRequest<>();
        testInBaseRequest.setApikey(apikey);
        testInBaseRequest.setMkey(mkey);
        testInBaseRequest.setOp(op);
        testInBaseRequest.setData(data);
        testInBaseRequest.setAction(action);
        if (timestamp==null){
            timestamp = System.currentTimeMillis();
        }
        testInBaseRequest.setTimestamp(timestamp);
        return testInBaseRequest;
    }
}
