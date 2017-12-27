package Train;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/2 22:26
 * @desc 给定一个数字, 寻找能够将其转换为指定个1是几进制
 **/
public class BeautifulNmberLarge {
    private BeautifulNmberLarge() {
    }

    private static long beautiful(long n) {
        for (int bits = 64; bits >= 2; bits--) {
            long radix = getRadix(n, bits);
            if (radix != -1) {
                return radix;
            }
        }
        return n - 1;
    }

    //找到将n转化为11111....1111的radix
    private static long getRadix(long n, int bits) {
        long minRadix = 2;
        long maxRadix = n;
        while (minRadix < maxRadix) {
            long m = minRadix + (maxRadix - minRadix) / 2;
            long t = convert(m, bits);
            if (t == n) {
                return m;
            } else if (t < n) {
                minRadix = m + 1;
            } else {
                maxRadix = m;
            }
        }
        return -1;
    }

    private static long convert(long radix, int bits) {
        long component = 1;
        long sum = 0;
        for (int i = 0; i < bits; i++) {
            if (Long.MAX_VALUE - sum < component) {

            }
            sum += component;
            if (Long.MAX_VALUE / component < radix) {
                component *= radix;
            }
            component *= radix;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
