package com.ofloxacin.base;

import org.junit.jupiter.api.Test;

/**
 * @author ChenShuai
 * @date 2018/6/21 18:22
 */
public class CloneTest {

    @Test
    public void cloneTest() {
        Student student = new Student("chenshuai", 123);
        student.setStudent(new Student("second", 99));

        Student student2 = null;
        try {
            student2 = (Student) student.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        student.setName("liming");
        student.getStudent().setName("qingqing");
        System.out.println(student2);
    }
}
