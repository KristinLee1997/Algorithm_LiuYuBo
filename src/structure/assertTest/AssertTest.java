package structure.assertTest;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/5 16:07
 * @desc 断言:每个类都要在edit configurations里 VM一栏填写-ea,否则不抛出断言异常
 **/
public class AssertTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        assert a > b : "错误,a不大于b";
    }
}