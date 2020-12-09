package demo.memory;

/**
 * 分析 JVM 内存模型
 *
 * @author yxc
 * @since 2020-05-15 16:49
 **/
public class MemoryValue {

    public static void main(String[] args) {
        int a = 10;
        Person p2 = new Person();
        p2.id = 222;
        new MemoryValue().function2(p2);
        System.out.println(p2.id);
    }

    private void function2(Person p) {
        int b = 10;
        //Person p = new Person();
        p.id = 1;
        p.name = "Jack";
        //System.out.println(a + b);
    }

    private void function1(int a) {
        int b = 10;
        System.out.println(a + b);
        a = 11;
    }
}

class Person {
    int id;
    String name;
}