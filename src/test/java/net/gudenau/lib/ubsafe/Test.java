package net.gudenau.lib.ubsafe;

import net.gudenau.lib.unsafe.Unsafe;

public class Test{
    private byte byteValue = 0;
    private short shortValue = 0;
    private int intValue = 0;
    private long longValue = 0;

    public static void main(String[] args) throws InstantiationException, NoSuchFieldException{
        var test = Unsafe.allocateInstance(Test.class);

        Unsafe.putByte(test, Unsafe.objectFieldOffset(Test.class.getDeclaredField("byteValue")), Byte.MAX_VALUE);
        Unsafe.putShort(test, Unsafe.objectFieldOffset(Test.class.getDeclaredField("shortValue")), Short.MAX_VALUE);
        Unsafe.putInt(test, Unsafe.objectFieldOffset(Test.class.getDeclaredField("intValue")), Integer.MAX_VALUE);
        Unsafe.putLong(test, Unsafe.objectFieldOffset(Test.class.getDeclaredField("longValue")), Long.MAX_VALUE);

        System.out.printf("%02X\n", test.byteValue);
        System.out.printf("%04X\n", test.shortValue);
        System.out.printf("%08X\n", test.intValue);
        System.out.printf("%016X\n", test.longValue);
    }
}
