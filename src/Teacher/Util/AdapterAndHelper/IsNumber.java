package Teacher.Util.AdapterAndHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName:
 * @Description: 判断是否为数字
 * @author 赵炜宁
 * @date 2021.4.25
 *
 */
public class IsNumber {
    // 根据阿里巴巴代码规范，将Pattern设置为全局常量
    // 通过 -?[0-9]+(\\\\.[0-9]+)? 进行匹配是否为数字
    private static Pattern pattern = Pattern.compile("-?[0-9]+(\\\\\\\\.[0-9]+)?");

    public static boolean isNumber(String str) {
        // 通过Matcher进行字符串匹配
        Matcher m = pattern.matcher(str);
        // 如果正则匹配通过 m.matches() 方法返回 true ，反之 false
        return m.matches();
    }
}
