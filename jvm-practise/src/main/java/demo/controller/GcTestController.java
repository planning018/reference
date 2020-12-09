package demo.controller;

import demo.gc.Animal;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yxc
 * @since 2020-05-13 11:05
 **/
@RestController
@Slf4j
public class GcTestController {

    private List<Greeting> objectListCache = new ArrayList<>();

    @GetMapping("/greeting")
    public Greeting greeting(){
        Greeting greeting = new Greeting();
        if(objectListCache.size() >= 100000){
            log.info("clean the list");
            objectListCache.clear();
        }else{
            objectListCache.add(greeting);
        }
        return greeting;
    }

    @GetMapping("/calculateMemory")
    public void calculateMemory(){
        List<Animal> animals = new ArrayList<>(20000000);
        for (int i = 0; i < 20000000; i++) {
            Animal animal = new Animal();
            animals.add(animal);
        }
        //log.info("CalculateListMemory animals size is {}", animals.size());
    }


    @Data
    class Greeting {
        private String message1;
        private String message2;
        private String message3;
        private String message4;
        private String message5;
        private String message6;
        private String message7;
        private String message8;
        private String message9;
        private String message10;
        private String message11;
        private String message12;
        private String message13;
        private String message14;
        private String message15;
        private String message16;
        private String message17;
        private String message18;
        private String message19;
        private String message20;
    }
}