package common.enums;

import lombok.Data;

/**
 * @author xnd
 * @since 2023/2/18 14:39
 */
@Data
public class Result<T> {

    private String msg;
    private int code;
    private T data;

    private Result(int code) {
        this.code = code;
    }

    private Result(String msg) {
        this.msg = msg;
    }

    private Result(DataEnums enums) {
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    private Result(T data, DataEnums enums) {
        this.data = data;
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    private Result(String msg, DataEnums enums) {
        this.msg = msg;
        this.code = enums.getCode();
    }

    private Result(String msg, int code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
    private Result(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public static <T> Result<T> success(T date) {
        return new Result<>(date, DataEnums.SUCCESS);
    }

    public static <T> Result<T> success() {
        return new Result<>(DataEnums.SUCCESS.getMsg(), DataEnums.SUCCESS);
    }

    public static <T> Result<T> failed() {
        return new Result<>(DataEnums.FAILED.getMsg(), DataEnums.FAILED);
    }

    public static <T> Result<T> failed( String msg ,int code) {
        return new Result<>(msg,code);
    }

    public static <T> Result<T> failed(String msg) {
        return new Result<>(msg, DataEnums.FAILED);
    }

    public static <T> Result<T> failed(String msg, int code, T data) {
        return new Result<>(msg, code, data);
    }

    public static <T> Result<T> failed(DataEnums enums) {
        return new Result<>(enums);
    }

    public static <T> Result<T> failed(DataEnums enums, T data) {
        return new Result<>(data, enums);
    }


}