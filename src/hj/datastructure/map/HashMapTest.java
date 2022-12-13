package hj.datastructure.map;

import hj.datastructure.list.DoublyLinkedList;

import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<>();

        //1. 자료 구조가 비어있는 경우
        // Read
        testMap.get(0);
        // Update
        testMap.put("test1","empty map test");
        // Delete
        testMap.remove("test1");
        testMap.remove("test1");

        //2. 자료 구조에 단 하나의 요소가 들어있을 때
        // Create & Update
        testMap.put("test1","map test1");
        System.out.println(testMap.get("test1"));
        testMap.put("test1","map test1-1");
        System.out.println(testMap.get("test1"));
        testMap.put("test2","map test2");
        testMap.remove("test1");
        // Read
        System.out.println(testMap.get(0));
        System.out.println(testMap.get("test1"));
        System.out.println(testMap.get("test2"));
        // Delete
        testMap.remove("test1");
        testMap.remove("test2");
        System.out.println(testMap.get("test1"));
        System.out.println(testMap.get("test2"));
        System.out.println(testMap.get("test3"));
        System.out.println(testMap.size());

        // Create & Update
        testMap.put("test1","map test1");
        testMap.put("test2","map test2");
        testMap.put("test3","map test3");
        System.out.println(testMap.size());
        testMap.remove("test2");
        // Read
        System.out.println(testMap.get("test1"));
        System.out.println(testMap.get("test2"));
        System.out.println(testMap.get("test3"));
        // Delete
        System.out.println(testMap.size());
        testMap.remove("test1");
        testMap.remove("test2");
        System.out.println(testMap.size());
        testMap.remove("test3");
        System.out.println(testMap.size());


        Map<String, String> testMap2 = new java.util.HashMap<>();
        testMap2.put("test1","empty map test");
        testMap2.put("test1","empty map test2");
        System.out.println(testMap.get("test1"));



    }
}
