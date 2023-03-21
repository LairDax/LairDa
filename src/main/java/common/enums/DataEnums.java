package common.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author xnd
 * @since 2023/2/18 14:44
 */
public enum DataEnums {
    /**
     * 成功
     */
    SUCCESS("成功", 200),

    /**
     * 入参数据为空.
     */
    DATA_IS_NULL("入参数据为空", 406),

    /**
     * 时间格式错误
     */
    TIME_FORMAT_MISTAKE("时间格式错误", 406),
    /**
     * 失败
     */
    FAILED("失败", 500);

    /**
     * 提示
     */
    private final String msg;
    /**
     * 编码
     */
    private final int code;

    DataEnums(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    @Override
    public String toString() {
        return this.toString();
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    private static final Map<String, Integer> DATE_ENUMS = new HashMap<>();

    static {
        Stream.of(DataEnums.values()).forEach(v -> DATE_ENUMS.put(v.msg, v.code));
    }

}