package com.ofloxacin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author ChenShuai
 * @date 2018/6/21 14:59
 */
public class ObjectTest {

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        System.out.println(s1 == s2);
        System.out.println(Objects.equals(s1, s2));

        List<Student> studentList1 = new ArrayList<>();
        studentList1.add(s1);
        studentList1.add(s2);
        List<Student> studentList2 = new ArrayList<>();
        studentList2.add(s1);
        studentList2.add(s2);

        System.out.println(studentList1 == studentList2);
        System.out.println(Objects.equals(studentList1, studentList2));
        System.out.println(Objects.deepEquals(studentList1, studentList2));
        System.out.println(Objects.deepEquals(studentList1.toArray(), studentList2.toArray()));

        List<Integer> integers1 = Arrays.asList(700, 800);
        List<Integer> integers2 = Arrays.asList(700, 800);

        System.out.println(integers1 == integers2);
        System.out.println(Objects.equals(integers1, integers2));
        System.out.println(Objects.deepEquals(integers1, integers2));
        System.out.println(Objects.deepEquals(integers1.toArray(), integers2.toArray()));
    }
}
