package Train;

/**
 * @author LiHang
 * @school 哈尔滨理工大学
 * @date 2017/12/2 21:59
 * @desc beautiful number
 **/
public class BeatuifulNumber {
    private BeatuifulNumber() {
    }

    public static int beautiful(int n) {
        for (int radix = 2; radix < n; radix++) {
            if (isBeautiful(n, radix)) {
                return radix;
            }
        }
        return n - 1;
    }

    private static boolean isBeautiful(int n, int radix) {
        while (n > 0) {
            if (n % radix != 1) {
                return false;
            }
            n /= radix;
        }
        return true;
    }

    public static void main(String[] args) {
        int radix = beautiful(13);
        System.out.println(radix);
    }
}
