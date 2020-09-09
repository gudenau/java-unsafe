package net.gudenau.lib.unsafe;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;

public class Unsafe{
    private static final MethodHandle getObjectInt;
    private static final MethodHandle putObjectInt;
    private static final MethodHandle getObjectObject;
    private static final MethodHandle putObjectObject;
    private static final MethodHandle getObjectBoolean;
    private static final MethodHandle putObjectBoolean;
    private static final MethodHandle getObjectByte;
    private static final MethodHandle putObjectByte;
    private static final MethodHandle getObjectShort;
    private static final MethodHandle putObjectShort;
    private static final MethodHandle getObjectChar;
    private static final MethodHandle putObjectChar;
    private static final MethodHandle getObjectLong;
    private static final MethodHandle putObjectLong;
    private static final MethodHandle getObjectFloat;
    private static final MethodHandle putObjectFloat;
    private static final MethodHandle getObjectDouble;
    private static final MethodHandle putObjectDouble;
    private static final MethodHandle getByte;
    private static final MethodHandle putByte;
    private static final MethodHandle getShort;
    private static final MethodHandle putShort;
    private static final MethodHandle getChar;
    private static final MethodHandle putChar;
    private static final MethodHandle getInt;
    private static final MethodHandle putInt;
    private static final MethodHandle getLong;
    private static final MethodHandle putLong;
    private static final MethodHandle getFloat;
    private static final MethodHandle putFloat;
    private static final MethodHandle getDouble;
    private static final MethodHandle putDouble;
    private static final MethodHandle getAddress;
    private static final MethodHandle putAddress;
    private static final MethodHandle allocateMemory;
    private static final MethodHandle reallocateMemory;
    private static final MethodHandle setObjectMemory;
    private static final MethodHandle setMemory;
    private static final MethodHandle copyObjectMemory;
    private static final MethodHandle copyMemory;
    private static final MethodHandle freeMemory;
    private static final MethodHandle objectFieldOffset;
    private static final MethodHandle staticFieldOffset;
    private static final MethodHandle staticFieldBase;
    private static final MethodHandle shouldBeInitialized;
    private static final MethodHandle ensureClassInitialized;
    private static final MethodHandle arrayBaseOffset;
    private static final MethodHandle arrayIndexScale;
    private static final MethodHandle addressSize;
    private static final MethodHandle pageSize;
    private static final MethodHandle defineAnonymousClass;
    private static final MethodHandle allocateInstance;
    private static final MethodHandle throwException;
    private static final MethodHandle compareAndSwapObject;
    private static final MethodHandle compareAndSwapInt;
    private static final MethodHandle compareAndSwapLong;
    private static final MethodHandle getObjectVolatile;
    private static final MethodHandle putObjectVolatile;
    private static final MethodHandle getIntVolatile;
    private static final MethodHandle putIntVolatile;
    private static final MethodHandle getBooleanVolatile;
    private static final MethodHandle putBooleanVolatile;
    private static final MethodHandle getByteVolatile;
    private static final MethodHandle putByteVolatile;
    private static final MethodHandle getShortVolatile;
    private static final MethodHandle putShortVolatile;
    private static final MethodHandle getCharVolatile;
    private static final MethodHandle putCharVolatile;
    private static final MethodHandle getLongVolatile;
    private static final MethodHandle putLongVolatile;
    private static final MethodHandle getFloatVolatile;
    private static final MethodHandle putFloatVolatile;
    private static final MethodHandle getDoubleVolatile;
    private static final MethodHandle putDoubleVolatile;
    private static final MethodHandle putOrderedObject;
    private static final MethodHandle putOrderedInt;
    private static final MethodHandle putOrderedLong;
    private static final MethodHandle unpark;
    private static final MethodHandle park;
    private static final MethodHandle getLoadAverage;
    private static final MethodHandle getAndAddInt;
    private static final MethodHandle getAndAddLong;
    private static final MethodHandle getAndSetInt;
    private static final MethodHandle getAndSetLong;
    private static final MethodHandle getAndSetObject;
    private static final MethodHandle loadFence;
    private static final MethodHandle storeFence;
    private static final MethodHandle fullFence;
    private static final MethodHandle invokeCleaner;

    static{
        try{
            var Unsafe = Class.forName("sun.misc.Unsafe");
            Object theUnsafe = null;
            {
                int mods = Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL;
                for(var field : Unsafe.getDeclaredFields()){
                    if(
                        field.getModifiers() == mods &&
                            field.getType() == Unsafe
                    ){
                        field.setAccessible(true);
                        var unsafe = field.get(null);
                        if(unsafe != null){
                            theUnsafe = unsafe;
                            break;
                        }
                    }
                }
                if(theUnsafe == null){
                    throw new RuntimeException("Failed to locate Unsafe instance");
                }
            }

            var lookup = MethodHandles.lookup();
            getObjectInt = lookup.findVirtual(Unsafe, "getInt", MethodType.methodType(int.class, Object.class, long.class)).bindTo(theUnsafe);
            getObjectObject = lookup.findVirtual(Unsafe, "getObject", MethodType.methodType(Object.class, Object.class, long.class)).bindTo(theUnsafe);
            getObjectBoolean = lookup.findVirtual(Unsafe, "getBoolean", MethodType.methodType(boolean.class, Object.class, long.class)).bindTo(theUnsafe);
            getObjectByte = lookup.findVirtual(Unsafe, "getByte", MethodType.methodType(byte.class, Object.class, long.class)).bindTo(theUnsafe);
            getObjectShort = lookup.findVirtual(Unsafe, "getShort", MethodType.methodType(short.class, Object.class, long.class)).bindTo(theUnsafe);
            getObjectChar = lookup.findVirtual(Unsafe, "getChar", MethodType.methodType(char.class, Object.class, long.class)).bindTo(theUnsafe);
            getObjectLong = lookup.findVirtual(Unsafe, "getLong", MethodType.methodType(long.class, Object.class, long.class)).bindTo(theUnsafe);
            getObjectFloat = lookup.findVirtual(Unsafe, "getFloat", MethodType.methodType(float.class, Object.class, long.class)).bindTo(theUnsafe);
            getObjectDouble = lookup.findVirtual(Unsafe, "getDouble", MethodType.methodType(double.class, Object.class, long.class)).bindTo(theUnsafe);

            putObjectInt = lookup.findVirtual(Unsafe, "putInt", MethodType.methodType(void.class, Object.class, long.class, int.class)).bindTo(theUnsafe);
            putObjectObject = lookup.findVirtual(Unsafe, "putObject", MethodType.methodType(void.class, Object.class, long.class, Object.class)).bindTo(theUnsafe);
            putObjectBoolean = lookup.findVirtual(Unsafe, "putBoolean", MethodType.methodType(void.class, Object.class, long.class, boolean.class)).bindTo(theUnsafe);
            putObjectByte = lookup.findVirtual(Unsafe, "putByte", MethodType.methodType(void.class, Object.class, long.class, byte.class)).bindTo(theUnsafe);
            putObjectShort = lookup.findVirtual(Unsafe, "putShort", MethodType.methodType(void.class, Object.class, long.class, short.class)).bindTo(theUnsafe);
            putObjectChar = lookup.findVirtual(Unsafe, "putChar", MethodType.methodType(void.class, Object.class, long.class, char.class)).bindTo(theUnsafe);
            putObjectLong = lookup.findVirtual(Unsafe, "putLong", MethodType.methodType(void.class, Object.class, long.class, long.class)).bindTo(theUnsafe);
            putObjectFloat = lookup.findVirtual(Unsafe, "putFloat", MethodType.methodType(void.class, Object.class, long.class, float.class)).bindTo(theUnsafe);
            putObjectDouble = lookup.findVirtual(Unsafe, "putDouble", MethodType.methodType(void.class, Object.class, long.class, double.class)).bindTo(theUnsafe);

            getByte = lookup.findVirtual(Unsafe, "getByte", MethodType.methodType(byte.class, long.class)).bindTo(theUnsafe);
            getShort = lookup.findVirtual(Unsafe, "getShort", MethodType.methodType(short.class, long.class)).bindTo(theUnsafe);
            getChar = lookup.findVirtual(Unsafe, "getChar", MethodType.methodType(char.class, long.class)).bindTo(theUnsafe);
            getInt = lookup.findVirtual(Unsafe, "getInt", MethodType.methodType(int.class, long.class)).bindTo(theUnsafe);
            getLong = lookup.findVirtual(Unsafe, "getLong", MethodType.methodType(long.class, long.class)).bindTo(theUnsafe);
            getFloat = lookup.findVirtual(Unsafe, "getFloat", MethodType.methodType(float.class, long.class)).bindTo(theUnsafe);
            getDouble = lookup.findVirtual(Unsafe, "getDouble", MethodType.methodType(double.class, long.class)).bindTo(theUnsafe);
            getAddress = lookup.findVirtual(Unsafe, "getAddress", MethodType.methodType(long.class, long.class)).bindTo(theUnsafe);

            putByte = lookup.findVirtual(Unsafe, "putByte", MethodType.methodType(void.class, long.class, byte.class)).bindTo(theUnsafe);
            putShort = lookup.findVirtual(Unsafe, "putShort", MethodType.methodType(void.class, long.class, short.class)).bindTo(theUnsafe);
            putChar = lookup.findVirtual(Unsafe, "putChar", MethodType.methodType(void.class, long.class, char.class)).bindTo(theUnsafe);
            putInt = lookup.findVirtual(Unsafe, "putInt", MethodType.methodType(void.class, long.class, int.class)).bindTo(theUnsafe);
            putLong = lookup.findVirtual(Unsafe, "putLong", MethodType.methodType(void.class, long.class, long.class)).bindTo(theUnsafe);
            putFloat = lookup.findVirtual(Unsafe, "putFloat", MethodType.methodType(void.class, long.class, float.class)).bindTo(theUnsafe);
            putDouble = lookup.findVirtual(Unsafe, "putDouble", MethodType.methodType(void.class, long.class, double.class)).bindTo(theUnsafe);
            putAddress = lookup.findVirtual(Unsafe, "putAddress", MethodType.methodType(void.class, long.class, long.class)).bindTo(theUnsafe);

            allocateMemory = lookup.findVirtual(Unsafe, "allocateMemory", MethodType.methodType(long.class, long.class)).bindTo(theUnsafe);
            reallocateMemory = lookup.findVirtual(Unsafe, "reallocateMemory", MethodType.methodType(long.class, long.class, long.class)).bindTo(theUnsafe);
            setObjectMemory = lookup.findVirtual(Unsafe, "setMemory", MethodType.methodType(void.class, Object.class, long.class, long.class, byte.class)).bindTo(theUnsafe);
            setMemory = lookup.findVirtual(Unsafe, "setMemory", MethodType.methodType(void.class, long.class, long.class, byte.class)).bindTo(theUnsafe);
            copyObjectMemory = lookup.findVirtual(Unsafe, "copyMemory", MethodType.methodType(void.class, Object.class, long.class, Object.class, long.class, long.class)).bindTo(theUnsafe);
            copyMemory = lookup.findVirtual(Unsafe, "copyMemory", MethodType.methodType(void.class, long.class, long.class, long.class)).bindTo(theUnsafe);
            freeMemory = lookup.findVirtual(Unsafe, "freeMemory", MethodType.methodType(void.class, long.class)).bindTo(theUnsafe);
            objectFieldOffset = lookup.findVirtual(Unsafe, "objectFieldOffset", MethodType.methodType(long.class, Field.class)).bindTo(theUnsafe);
            staticFieldOffset = lookup.findVirtual(Unsafe, "staticFieldOffset", MethodType.methodType(long.class, Field.class)).bindTo(theUnsafe);
            staticFieldBase = lookup.findVirtual(Unsafe, "staticFieldBase", MethodType.methodType(Object.class, Field.class)).bindTo(theUnsafe);
            shouldBeInitialized = lookup.findVirtual(Unsafe, "shouldBeInitialized", MethodType.methodType(boolean.class, Class.class)).bindTo(theUnsafe);
            ensureClassInitialized = lookup.findVirtual(Unsafe, "ensureClassInitialized", MethodType.methodType(void.class, Class.class)).bindTo(theUnsafe);
            arrayBaseOffset = lookup.findVirtual(Unsafe, "arrayBaseOffset", MethodType.methodType(int.class, Class.class)).bindTo(theUnsafe);
            arrayIndexScale = lookup.findVirtual(Unsafe, "arrayIndexScale", MethodType.methodType(int.class, Class.class)).bindTo(theUnsafe);
            addressSize = lookup.findVirtual(Unsafe, "addressSize", MethodType.methodType(int.class)).bindTo(theUnsafe);
            pageSize = lookup.findVirtual(Unsafe, "pageSize", MethodType.methodType(int.class)).bindTo(theUnsafe);
            defineAnonymousClass = lookup.findVirtual(Unsafe, "defineAnonymousClass", MethodType.methodType(Class.class, Class.class, byte[].class, Object[].class)).bindTo(theUnsafe);
            allocateInstance = lookup.findVirtual(Unsafe, "allocateInstance", MethodType.methodType(Object.class, Class.class)).bindTo(theUnsafe);
            throwException = lookup.findVirtual(Unsafe, "throwException", MethodType.methodType(void.class, Throwable.class)).bindTo(theUnsafe);
            compareAndSwapObject = lookup.findVirtual(Unsafe, "compareAndSwapObject", MethodType.methodType(boolean.class, Object.class, long.class, Object.class, Object.class)).bindTo(theUnsafe);
            compareAndSwapInt = lookup.findVirtual(Unsafe, "compareAndSwapInt", MethodType.methodType(boolean.class, Object.class, long.class, int.class, int.class)).bindTo(theUnsafe);
            compareAndSwapLong = lookup.findVirtual(Unsafe, "compareAndSwapLong", MethodType.methodType(boolean.class, Object.class, long.class, long.class, long.class)).bindTo(theUnsafe);

            getObjectVolatile = lookup.findVirtual(Unsafe, "getObjectVolatile", MethodType.methodType(Object.class, Object.class, long.class)).bindTo(theUnsafe);
            getIntVolatile = lookup.findVirtual(Unsafe, "getIntVolatile", MethodType.methodType(int.class, Object.class, long.class)).bindTo(theUnsafe);
            getBooleanVolatile = lookup.findVirtual(Unsafe, "getBooleanVolatile", MethodType.methodType(boolean.class, Object.class, long.class)).bindTo(theUnsafe);
            getByteVolatile = lookup.findVirtual(Unsafe, "getByteVolatile", MethodType.methodType(byte.class, Object.class, long.class)).bindTo(theUnsafe);
            getShortVolatile = lookup.findVirtual(Unsafe, "getShortVolatile", MethodType.methodType(short.class, Object.class, long.class)).bindTo(theUnsafe);
            getCharVolatile = lookup.findVirtual(Unsafe, "getCharVolatile", MethodType.methodType(char.class, Object.class, long.class)).bindTo(theUnsafe);
            getLongVolatile = lookup.findVirtual(Unsafe, "getLongVolatile", MethodType.methodType(long.class, Object.class, long.class)).bindTo(theUnsafe);
            getFloatVolatile = lookup.findVirtual(Unsafe, "getFloatVolatile", MethodType.methodType(float.class, Object.class, long.class)).bindTo(theUnsafe);
            getDoubleVolatile = lookup.findVirtual(Unsafe, "getDoubleVolatile", MethodType.methodType(double.class, Object.class, long.class)).bindTo(theUnsafe);

            putObjectVolatile = lookup.findVirtual(Unsafe, "putObjectVolatile", MethodType.methodType(void.class, Object.class, long.class, Object.class)).bindTo(theUnsafe);
            putIntVolatile = lookup.findVirtual(Unsafe, "putIntVolatile", MethodType.methodType(void.class, Object.class, long.class, int.class)).bindTo(theUnsafe);
            putBooleanVolatile = lookup.findVirtual(Unsafe, "putBooleanVolatile", MethodType.methodType(void.class, Object.class, long.class, boolean.class)).bindTo(theUnsafe);
            putByteVolatile = lookup.findVirtual(Unsafe, "putByteVolatile", MethodType.methodType(void.class, Object.class, long.class, byte.class)).bindTo(theUnsafe);
            putShortVolatile = lookup.findVirtual(Unsafe, "putShortVolatile", MethodType.methodType(void.class, Object.class, long.class, short.class)).bindTo(theUnsafe);
            putCharVolatile = lookup.findVirtual(Unsafe, "putCharVolatile", MethodType.methodType(void.class, Object.class, long.class, char.class)).bindTo(theUnsafe);
            putLongVolatile = lookup.findVirtual(Unsafe, "putLongVolatile", MethodType.methodType(void.class, Object.class, long.class, long.class)).bindTo(theUnsafe);
            putFloatVolatile = lookup.findVirtual(Unsafe, "putFloatVolatile", MethodType.methodType(void.class, Object.class, long.class, float.class)).bindTo(theUnsafe);
            putDoubleVolatile = lookup.findVirtual(Unsafe, "putDoubleVolatile", MethodType.methodType(void.class, Object.class, long.class, double.class)).bindTo(theUnsafe);

            putOrderedObject = lookup.findVirtual(Unsafe, "putOrderedObject", MethodType.methodType(void.class, Object.class, long.class, Object.class)).bindTo(theUnsafe);
            putOrderedInt = lookup.findVirtual(Unsafe, "putOrderedInt", MethodType.methodType(void.class, Object.class, long.class, int.class)).bindTo(theUnsafe);
            putOrderedLong = lookup.findVirtual(Unsafe, "putOrderedLong", MethodType.methodType(void.class, Object.class, long.class, long.class)).bindTo(theUnsafe);

            unpark = lookup.findVirtual(Unsafe, "unpark", MethodType.methodType(void.class, Object.class)).bindTo(theUnsafe);
            park = lookup.findVirtual(Unsafe, "park", MethodType.methodType(void.class, boolean.class, long.class)).bindTo(theUnsafe);
            getLoadAverage = lookup.findVirtual(Unsafe, "getLoadAverage", MethodType.methodType(int.class, double[].class, int.class)).bindTo(theUnsafe);

            getAndAddInt = lookup.findVirtual(Unsafe, "getAndAddInt", MethodType.methodType(int.class, Object.class, long.class, int.class)).bindTo(theUnsafe);
            getAndAddLong = lookup.findVirtual(Unsafe, "getAndAddLong", MethodType.methodType(long.class, Object.class, long.class, long.class)).bindTo(theUnsafe);
            getAndSetInt = lookup.findVirtual(Unsafe, "getAndSetInt", MethodType.methodType(int.class, Object.class, long.class, int.class)).bindTo(theUnsafe);
            getAndSetLong = lookup.findVirtual(Unsafe, "getAndSetLong", MethodType.methodType(long.class, Object.class, long.class, long.class)).bindTo(theUnsafe);
            getAndSetObject = lookup.findVirtual(Unsafe, "getAndSetObject", MethodType.methodType(Object.class, Object.class, long.class, Object.class)).bindTo(theUnsafe);

            loadFence = lookup.findVirtual(Unsafe, "loadFence", MethodType.methodType(void.class)).bindTo(theUnsafe);
            storeFence = lookup.findVirtual(Unsafe, "storeFence", MethodType.methodType(void.class)).bindTo(theUnsafe);
            fullFence = lookup.findVirtual(Unsafe, "fullFence", MethodType.methodType(void.class)).bindTo(theUnsafe);

            invokeCleaner = lookup.findVirtual(Unsafe, "invokeCleaner", MethodType.methodType(void.class, ByteBuffer.class)).bindTo(theUnsafe);
        }catch(ReflectiveOperationException e){
            throw new RuntimeException("Failed to setup Unsafe", e);
        }
    }

    public static int getInt(Object o, long offset){
        try{
            return (int)getObjectInt.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putInt(Object o, long offset, int x){
        try{
            putObjectInt.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static Object getObject(Object o, long offset){
        try{
            return getObjectObject.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putObject(Object o, long offset, Object x){
        try{
            putObjectObject.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static boolean getBoolean(Object o, long offset){
        try{
            return (boolean)getObjectBoolean.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putBoolean(Object o, long offset, boolean x){
        try{
            putObjectBoolean.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static byte getByte(Object o, long offset){
        try{
            return (byte)getObjectByte.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putByte(Object o, long offset, byte x){
        try{
            putObjectByte.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static short getShort(Object o, long offset){
        try{
            return (short)getObjectShort.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putShort(Object o, long offset, short x){
        try{
            putObjectShort.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static char getChar(Object o, long offset){
        try{
            return (char)getObjectChar.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putChar(Object o, long offset, char x){
        try{
            putObjectChar.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static long getLong(Object o, long offset){
        try{
            return (long)getObjectLong.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putLong(Object o, long offset, long x){
        try{
            putObjectLong.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static float getFloat(Object o, long offset){
        try{
            return (float)getObjectFloat.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putFloat(Object o, long offset, float x){
        try{
            putObjectFloat.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static double getDouble(Object o, long offset){
        try{
            return (double)getObjectDouble.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putDouble(Object o, long offset, double x){
        try{
            putObjectDouble.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static byte getByte(long address){
        try{
            return (byte)getByte.invokeExact(address);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putByte(long address, byte x){
        try{
            putByte.invokeExact(address, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static short getShort(long address){
        try{
            return (short)getShort.invokeExact(address);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putShort(long address, short x){
        try{
            putShort.invokeExact(address, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static char getChar(long address){
        try{
            return (char)getChar.invokeExact(address);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putChar(long address, char x){
        try{
            putChar.invokeExact(address, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static int getInt(long address){
        try{
            return (int)getInt.invokeExact(address);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putInt(long address, int x){
        try{
            putInt.invokeExact(address, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static long getLong(long address){
        try{
            return (long)getLong.invokeExact(address);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putLong(long address, long x){
        try{
            putLong.invokeExact(address, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static float getFloat(long address){
        try{
            return (float)getFloat.invokeExact(address);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putFloat(long address, float x){
        try{
            putFloat.invokeExact(address, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static double getDouble(long address){
        try{
            return (double)getDouble.invokeExact(address);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putDouble(long address, double x){
        try{
            putDouble.invokeExact(address, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static long getAddress(long address){
        try{
            return (long)getAddress.invokeExact(address);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putAddress(long address, long x){
        try{
            putAddress.invokeExact(address, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static long allocateMemory(long bytes){
        try{
            return (long)allocateMemory.invokeExact(bytes);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static long reallocateMemory(long address, long bytes){
        try{
            return (long)reallocateMemory.invokeExact(address, bytes);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void setMemory(Object o, long offset, long bytes, byte value){
        try{
            setObjectMemory.invokeExact(o, offset, bytes, value);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void setMemory(long address, long bytes, byte value){
        try{
            setMemory.invokeExact(address, bytes, value);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void copyMemory(Object srcBase, long srcOffset, Object destBase, long destOffset, long bytes){
        try{
            copyObjectMemory.invokeExact(srcBase, srcOffset, destBase, destOffset, bytes);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void copyMemory(long srcAddress, long destAddress, long bytes){
        try{
            copyMemory.invokeExact(srcAddress, destAddress, bytes);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void freeMemory(long address){
        try{
            freeMemory.invokeExact(address);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static final int INVALID_FIELD_OFFSET = -1;

    public static long objectFieldOffset(Field f){
        try{
            return (long)objectFieldOffset.invokeExact(f);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static long staticFieldOffset(Field f){
        try{
            return (long)staticFieldOffset.invokeExact(f);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static Object staticFieldBase(Field f){
        try{
            return (Object)staticFieldBase.invokeExact(f);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static <T> boolean shouldBeInitialized(Class<T> c){
        try{
            return (boolean)shouldBeInitialized.invokeExact(c);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static <T> void ensureClassInitialized(Class<T> c){
        try{
            ensureClassInitialized.invokeExact(c);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static <T> int arrayBaseOffset(Class<T> arrayClass){
        try{
            return (int)arrayBaseOffset.invoke(arrayClass);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static final int ARRAY_BOOLEAN_BASE_OFFSET = arrayBaseOffset(boolean[].class);
    public static final int ARRAY_BYTE_BASE_OFFSET = arrayBaseOffset(byte[].class);
    public static final int ARRAY_SHORT_BASE_OFFSET = arrayBaseOffset(short[].class);
    public static final int ARRAY_CHAR_BASE_OFFSET = arrayBaseOffset(char[].class);
    public static final int ARRAY_INT_BASE_OFFSET = arrayBaseOffset(int[].class);
    public static final int ARRAY_LONG_BASE_OFFSET = arrayBaseOffset(long[].class);
    public static final int ARRAY_FLOAT_BASE_OFFSET = arrayBaseOffset(float[].class);
    public static final int ARRAY_DOUBLE_BASE_OFFSET = arrayBaseOffset(double[].class);
    public static final int ARRAY_OBJECT_BASE_OFFSET = arrayBaseOffset(Object[].class);

    public static <T> int arrayIndexScale(Class<T> arrayClass){
        try{
            return (int)arrayIndexScale.invokeExact(arrayClass);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static final int ARRAY_BOOLEAN_INDEX_SCALE = arrayIndexScale(boolean[].class);
    public static final int ARRAY_BYTE_INDEX_SCALE = arrayIndexScale(byte[].class);
    public static final int ARRAY_SHORT_INDEX_SCALE = arrayIndexScale(short[].class);
    public static final int ARRAY_CHAR_INDEX_SCALE = arrayIndexScale(char[].class);
    public static final int ARRAY_INT_INDEX_SCALE = arrayIndexScale(int[].class);
    public static final int ARRAY_LONG_INDEX_SCALE = arrayIndexScale(long[].class);
    public static final int ARRAY_FLOAT_INDEX_SCALE = arrayIndexScale(float[].class);
    public static final int ARRAY_DOUBLE_INDEX_SCALE = arrayIndexScale(double[].class);
    public static final int ARRAY_OBJECT_INDEX_SCALE = arrayIndexScale(Object[].class);

    public static int addressSize(){
        try{
            return (int)addressSize.invokeExact();
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static final int ADDRESS_SIZE = addressSize();

    public static int pageSize(){
        try{
            return (int)pageSize.invokeExact();
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    @SuppressWarnings("unchecked")
    public static <A, P> Class<A> defineAnonymousClass(Class<P> hostClass, byte[] data, Object[] cpPatches){
        try{
            return (Class<A>)defineAnonymousClass.invokeExact(hostClass, data, cpPatches);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T allocateInstance(Class<T> cls) throws InstantiationException{
        try{
            return (T)(Object)allocateInstance.invokeExact(cls);
        }catch(InstantiationException e){
            throw e;
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void throwException(Throwable ee){
        try{
            throwException.invokeExact(ee);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static boolean compareAndSwapObject(Object o, long offset, Object expected, Object x){
        try{
            return (boolean)compareAndSwapObject.invokeExact(o, offset, expected, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static boolean compareAndSwapInt(Object o, long offset, int expected, int x){
        try{
            return (boolean)compareAndSwapInt.invokeExact(o, offset, expected, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static boolean compareAndSwapLong(Object o, long offset, long expected, long x){
        try{
            return (boolean)compareAndSwapLong.invokeExact(o, offset, expected, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static Object getObjectVolatile(Object o, long offset){
        try{
            return (Object)getObjectVolatile.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putObjectVolatile(Object o, long offset, Object x){
        try{
            putObjectVolatile.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static int getIntVolatile(Object o, long offset){
        try{
            return (int)getIntVolatile.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putIntVolatile(Object o, long offset, int x){
        try{
            putIntVolatile.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static boolean getBooleanVolatile(Object o, long offset){
        try{
            return (boolean)getBooleanVolatile.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putBooleanVolatile(Object o, long offset, boolean x){
        try{
            putBooleanVolatile.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static byte getByteVolatile(Object o, long offset){
        try{
            return (byte)getByteVolatile.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putByteVolatile(Object o, long offset, byte x){
        try{
            putByteVolatile.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static short getShortVolatile(Object o, long offset){
        try{
            return (short)getShortVolatile.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putShortVolatile(Object o, long offset, short x){
        try{
            putShortVolatile.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static char getCharVolatile(Object o, long offset){
        try{
            return (char)getCharVolatile.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putCharVolatile(Object o, long offset, char x){
        try{
            putCharVolatile.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static long getLongVolatile(Object o, long offset){
        try{
            return (long)getLongVolatile.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putLongVolatile(Object o, long offset, long x){
        try{
            putLongVolatile.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static float getFloatVolatile(Object o, long offset){
        try{
            return (float)getFloatVolatile.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putFloatVolatile(Object o, long offset, float x){
        try{
            putFloatVolatile.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static double getDoubleVolatile(Object o, long offset){
        try{
            return (double)getDoubleVolatile.invokeExact(o, offset);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putDoubleVolatile(Object o, long offset, double x){
        try{
            putDoubleVolatile.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putOrderedObject(Object o, long offset, Object x){
        try{
            putOrderedObject.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putOrderedInt(Object o, long offset, int x){
        try{
            putOrderedInt.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void putOrderedLong(Object o, long offset, long x){
        try{
            putOrderedLong.invokeExact(o, offset, x);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void unpark(Object thread){
        try{
            unpark.invokeExact(thread);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void park(boolean isAbsolute, long time){
        try{
            park.invokeExact(isAbsolute, time);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static int getLoadAverage(double[] loadavg, int nelems){
        try{
            return (int)getLoadAverage.invokeExact(loadavg, nelems);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static int getAndAddInt(Object o, long offset, int delta){
        try{
            return (int)getAndAddInt.invokeExact(o, offset, delta);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static long getAndAddLong(Object o, long offset, long delta){
        try{
            return (long)getAndAddLong.invokeExact(o, offset, delta);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static int getAndSetInt(Object o, long offset, int newValue){
        try{
            return (int)getAndSetInt.invokeExact(o, offset, newValue);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static long getAndSetLong(Object o, long offset, long newValue){
        try{
            return (long)getAndSetLong.invokeExact(o, offset, newValue);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getAndSetObject(Object o, long offset, T newValue){
        try{
            return (T)(Object)getAndSetObject.invokeExact(o, offset, (Object)newValue);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void loadFence(){
        try{
            loadFence.invokeExact();
        }catch(Throwable t){
            throw sneaky(t);
        }
    }
    
    public static void storeFence(){
        try{
            storeFence.invokeExact();
        }catch(Throwable t){
            throw sneaky(t);
        }
    }
    
    public static void fullFence(){
        try{
            fullFence.invokeExact();
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    public static void invokeCleaner(ByteBuffer directBuffer){
        try{
            invokeCleaner.invokeExact(directBuffer);
        }catch(Throwable t){
            throw sneaky(t);
        }
    }

    private static RuntimeException sneaky(Throwable t){
        if(t == null){
            throw new NullPointerException("t");
        }
        return sneaky0(t);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> T sneaky0(Throwable t) throws T{
        throw (T)t;
    }
}
