package HackerRankReflection;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

public class Solution {

    public static void main(String[] args) throws ClassNotFoundException {
        Object student = new Student();
        Method[] methods = student.getClass().getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for (Method m:methods){
            methodList.add(m.getName());
        }

        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
    public static ArrayList<String> getMethodNames(Method[] methods){
        ArrayList<String> methodList=new ArrayList<>();
        for (Method m:methods){
            methodList.add(m.getName());
        }
        return methodList;
    }

}