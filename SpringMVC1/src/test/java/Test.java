public class Test {
    public static String maskStoreKey(String key) {
        return key.replace("//", "/@") + '_';
    }
    @org.junit.jupiter.api.Test
    public void test(){
        String str = "123213/qqqqq/77test";
        String s = maskStoreKey(str);
        System.out.println(s);
    }
}
