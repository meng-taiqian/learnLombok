package com.qkh;


import com.qkh.entity.Task;
import com.qkh.service.GreetingService;
import com.qkh.service.HellowService;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


public class ReactiveTest extends TestCase{

    public static int LIST_SIZE = 12;

    public void testMethodOne(){
        List<Integer> list = prepare(LIST_SIZE);
        int sum = 0;
		
//        Observable<Integer> workflow = Observable.fromIterable(list);
//        Long start1 = System.currentTimeMillis();
//        workflow.subscribe(System.out :: print);
//        System.out.println();
//        System.out.println("time1:" + (System.currentTimeMillis() - start1));

        Stream<Integer> stream = list.stream();
        Long start2 = System.currentTimeMillis();
        stream.forEach(System.out::print);
        System.out.println();
        System.out.println("time2:" + (System.currentTimeMillis() - start2));

//        Stream<Integer> stream1 = list.parallelStream();
//        long start3 = System.currentTimeMillis();
//        stream1.forEach(System.out::print);
//        System.out.println();
//        System.out.println("time3:" + (System.currentTimeMillis() - start3));
//
        long start4 = System.currentTimeMillis();
        list.forEach(System.out::print);
        System.out.println();
        System.out.println("time4:" + (System.currentTimeMillis() - start4));

    }

    public List<Integer> prepare(int len){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(i);
        }
        return list;
    }

    public void testMethodTwo(){
//        List<Integer> list = prepare(LIST_SIZE);
//        Object obj = list.stream().collect(averagingDouble(i -> i.doubleValue()));//Collectors.averagingDouble(i -> i.doubleValue())
//        System.out.println(obj);

        List<Task> tasks = prepareTask(LIST_SIZE);
//        HashMap<String, List<String>> taskGroup = tasks.stream().collect(groupingBy(Task::getType, HashMap::new, mapping(Task::getTaskName, toList())));
//        taskGroup.get("0").forEach(task -> System.out.println(task));
//        System.out.println(taskGroup.get("0").stream().collect(joining("&", "ta", "cc")));
//        tasks.stream().collect(minBy(new Comparator<Task>() {
//            @Override
//            public int compare(Task o1, Task o2) {
//                return o1.hashCode() - o2.hashCode();
//
//            }
//        }));
        Comparator<Task> comparator = Comparator.comparing(Task::getTaskId);
        System.out.println(tasks.stream().reduce(tasks.get(0), BinaryOperator.maxBy(comparator)));

        System.out.println(tasks.stream().reduce(BinaryOperator.maxBy(comparator)));

//        tasks.stream().reduce(tasks.get(0), mapping(Task::getTaskId, toList()), BinaryOperator.maxBy(comparator)); error
        tasks.stream().reduce(tasks.get(0),
                (Task, Integer) -> Task, ((task1, task2) -> task1.getTaskId() > task2.getTaskId() ? task1 : task2));


    }

    public void testMethodThree(){
        List<Integer> list = prepare(LIST_SIZE);
        System.out.println(list.stream().collect(summingDouble(Integer::longValue)));
    }

    private List<Task> prepareTask(int size) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            tasks.add(new Task(i%2 + "", "task" + i, i%4 == 0 || (i+1)%4 == 0, i));
        }
        return tasks;
    }

    public void testInterface(){
        HellowService.sayBye();
        GreetingService greeting = new GreetingService();
        greeting.sayGoodBye();
        greeting.sayHello();
        System.out.println(greeting.getName());

    }

    public void testOpenFile(){
        try {
            Runtime.getRuntime().exec("cmd /c start d://develop/code");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
