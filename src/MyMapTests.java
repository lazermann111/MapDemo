public class MyMapTests {
    public static void main(String[] args) {
        checkMapNotAllowingDuplicateKeys();
    }

    static void checkMapNotAllowingDuplicateKeys(){
        var m = new MyMap<Integer, Integer>();
        m.put(1,1);
        m.put(1,3);
        if(m.size() != 1)
            throw new IllegalArgumentException("checkMapNotAllowingDuplicateKeys !");

        var m2 = new MyMap<String, Integer>();
        m2.put("ABCD",1);
        m2.put("ABCD",3);
        if(m2.size() != 1)
            throw new IllegalArgumentException("checkMapNotAllowingDuplicateKeys !");
    }


}
