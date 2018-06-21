package com.ofloxacin;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author ChenShuai
 * @date 2018/6/21 16:18
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -1722535715065018711L;
    private String name;
    private transient Integer age;

    public Student() {
        this(null, null);
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}