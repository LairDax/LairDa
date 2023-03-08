package common.excel;

import java.util.List;

/**
 * @author xnd
 * @since 2023/3/8 14:11
 */
public interface ConvertList<E> {
    /**
     * excel与数据库不一致，手动实现转换方式
     *
     * @param list 初始集合
     * @return 处理后集合
     */
    List<E> convert(List<E> list);
}
