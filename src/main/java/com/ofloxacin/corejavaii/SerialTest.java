package com.ofloxacin.corejavaii;

import com.ofloxacin.util.PrintUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.*;

/**
 * @author chens
 * @date 2018/11/27 12:49
 */
@Getter
@Setter
public class SerialTest extends SerialBase {
    private static final long serialVersionUID = -2624706092386320174L;
    private Integer b;

    public SerialTest(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(new SerialTest(50, 100));
            objectOutputStream.close();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            SerialTest serialTest = (SerialTest) objectInputStream.readObject();
            PrintUtil.printJson(serialTest);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
