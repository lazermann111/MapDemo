public class MyMapTests {
    public static void main(String[] args) {
        for (int i = 1; i < 1_000_000; i++) {
            checkMapNotAllowingDuplicateKeys(i);
            checkMapNotAllowingNulls(i);
            checkGetValues(i);
        }
    }

    static void checkGetValues(int capacity) {
        var m = new MyMap<Integer, Integer>(capacity);
        m.put(1, 123);
        m.put(2, 3);

        if (m.get(1) != 123)
            throw new IllegalArgumentException("checkGetValues !" + capacity);

        if (m.get(2) != 3)
            throw new IllegalArgumentException("checkGetValues !" + capacity);

        m.put(2, 4);
        if (m.get(2) != 4)
            throw new IllegalArgumentException("checkGetValues !" + capacity);
    }

    static void checkMapNotAllowingNulls(int capacity) {
        var m = new MyMap<Integer, Integer>(capacity);
        RuntimeException thrownException = null;
        try {
            m.put(null, 1);
        } catch (RuntimeException e) {
            thrownException = e;
        }

        if (thrownException == null)
            throw new IllegalArgumentException("checkMapNotAllowingNulls !" + capacity);

    }

    static void checkMapNotAllowingDuplicateKeys(int capacity) {
        var m = new MyMap<Integer, Integer>(capacity);
        m.put(1, 1);
        m.put(1, 3);
        if (m.size() != 1)
            throw new IllegalArgumentException("checkMapNotAllowingDuplicateKeys !" + capacity);

        var m2 = new MyMap<String, Integer>(capacity);
        m2.put("ABCD", 1);
        m2.put("ABCD", 3);
        if (m2.size() != 1)
            throw new IllegalArgumentException("checkMapNotAllowingDuplicateKeys !" + capacity);
    }


}
