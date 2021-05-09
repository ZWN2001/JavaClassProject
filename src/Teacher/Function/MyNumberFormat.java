package Teacher.Function;

import java.math.RoundingMode;
import java.text.NumberFormat;

public class MyNumberFormat {
    public static double formatDouble(double d) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        // 保留一位小数
        nf.setMaximumFractionDigits(1);
        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.UP);
        return Double.parseDouble(nf.format(d));
    }
}
