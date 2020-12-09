package com.planning.tool;

import com.google.common.base.Preconditions;
import com.planning.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 如何优雅的做参数校验
 * @author planning
 * @since 2019-12-04 19:21
 **/
@Slf4j
public class CheckParams {

    public static void main(String[] args) {
        try{
            // checkParam("");
            useOptional();
        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }

    private static void checkParam(String str){
        // 参数校验
        Preconditions.checkArgument(StringUtils.isNotBlank(str),"参数不能为空");

    }

    private static void useOptional() throws Exception{
        Person person1 = new Person();
        Person person2 = null;

        // Optional.of(T)  T 不能为空，否则初始化报错
        Optional<Person> optionalPerson = Optional.of(person1);
        System.out.println(optionalPerson.isPresent() ? optionalPerson.get() : "---");

        // Optional.ofNullable(T)   T 为任意，可以为空
        Optional<String> name = Optional.ofNullable(person1.getName());
        System.out.println(name.isPresent() ? name.get() : "-");

        // 如果不为空，则返回指定字符串
        Optional.ofNullable("test").ifPresent(
                na -> {
                    System.out.println( na + " ifPresent");
                }
        );

        // 如果为空，则返回字符串
        System.out.println(Optional.ofNullable(null).orElse("-"));
        System.out.println(Optional.ofNullable("1").orElse("-"));

        // 如果为空，则返回指定方法或代码
        System.out.println(Optional.ofNullable(null).orElseGet(()->{
            return "test null code";
        }));

        System.out.println(Optional.ofNullable("1").orElseGet(()->{
            return "test notNull code";
        }));

        // 如果为空，则可以抛出异常
        /*System.out.println(Optional.ofNullable("1").orElseThrow(()->{
            throw new RuntimeException("ss");
        }));*/

        // Objects.requireNonNull(null, "obj is null");

        // 利用 Optional 进行多级判断
        Optional.ofNullable(person1)
                .map(Person::getName)
                .isPresent();

        // 判断对象中的 list
        Optional.ofNullable(new Person())
                .map(Person::getPersonList)
                .map(pers -> pers.stream().map(Person::getName).collect(Collectors.toList()))
                .ifPresent(per -> System.out.println("123"));
    }
}