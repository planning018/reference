package demo.gc;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算 List 存放 两千万个对象所占用的大小
 * @author yxc
 * @since 2020-05-13 17:02
 **/
@Slf4j
public class CalculateListMemory {

    @Getter
    private static List<Animal> animals = new ArrayList<>(20000000);

    public CalculateListMemory() {
        for (int i = 0; i < 20000000; i++) {
            Animal animal = new Animal();
            animals.add(animal);
        }
    }

}