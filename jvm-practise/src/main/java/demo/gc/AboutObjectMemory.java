package demo.gc;

import org.openjdk.jol.info.ClassLayout;

/**
 * 计算对象所占的内存大小
 *
 * @author yxc
 * @since 2020-05-13 16:12
 **/
public class AboutObjectMemory {

    public static void main(String[] args) {
        /*
            com.planning.demo.gc.Animal object internals:
             OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
                  0    12        (object header)                           N/A
                 12     4    int Animal.age                                N/A
            Instance size: 16 bytes
            Space losses: 0 bytes internal + 0 bytes external = 0 bytes total

            对象头占用的内存是 8（运行时数据）+ 4（类型指针）= 12 Byte
            实例数据 占用的内存是 4 Byte
            所有总共占用了 16 Byte
         */
        System.out.println(ClassLayout.parseClass(Animal.class).toPrintable());

        /*
            java.lang.String object internals:
             OFFSET  SIZE     TYPE DESCRIPTION                               VALUE
                  0    12          (object header)                           N/A
                 12     4   char[] String.value                              N/A
                 16     4      int String.hash                               N/A
                 20     4          (loss due to the next object alignment)
            Instance size: 24 bytes
            Space losses: 0 bytes internal + 4 bytes external = 4 bytes total

            char[] 数组在这里相当于是引用对象存的，所以存的是 地址，占用 4个字节
            对象头 12 Byte + 实例数据 8 Byte + 对齐填充 4 Byte = 24 Byte
         */
        System.out.println(ClassLayout.parseClass(String.class).toPrintable());

        /*
            字符串 "abcdefg" 所占用的内存大小
            其中 String 对象占用的内存（24 Byte）是不会变的，变化的是 char[] 数组中的内容
             char[] 数组的大小为：
                对象头 ：8 （运行时数据） + 4 （类型指针） + 4 （记录数组长度） = 16 Byte
                实例数据： 7 * 2 = 14 Byte
                对其填充： 2 Byte
             16 + 14 + 2 = 32 Byte
             因此：字符串 "abcdefg" 占用的内存大小为 24 + 32 = 56 Byte
         */
    }
}