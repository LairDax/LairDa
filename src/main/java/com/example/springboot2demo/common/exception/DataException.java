package com.example.springboot2demo.common.exception;

import com.example.springboot2demo.common.enums.DataEnums;

/**
 * @author xnd
 * @since 2023/2/26 10:26
 */
public class DataException extends RuntimeException {
    private final int code;
    private final DataEnums dataEnums;
    public DataException(DataEnums dataEnums) {
        super(dataEnums.toString());
        this.code = dataEnums.getCode();
        this.dataEnums = dataEnums;
    }
    public DataException(String msg, int code) {
        super(msg);
        this.code = code;
        this.dataEnums = null;
    }
    public int getCode() {
        return code;
    }
    public DataEnums getDataEnums() {
        return dataEnums;
    }
    @Override
    public String toString() {
        return "DataException{" + "code=" + code + ", msg='" + super.getMessage() + '}';
    }
}
