package com.ofloxacin.corejavaii;

import com.ofloxacin.util.PrintUtil;

import java.awt.geom.Point2D;
import java.io.*;

/**
 * @author chens
 * @date 2018/12/3 14:50
 */
public class SerializationTest implements Serializable {
    private static final long serialVersionUID = 3229707741225041687L;
    private String name;
    private transient Point2D.Double point;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        SerializationTest test = new SerializationTest();
        test.name = "an obj";
        test.point = new Point2D.Double(100, 100);
        objectOutputStream.writeObject(test);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        SerializationTest o = (SerializationTest) objectInputStream.readObject();
        PrintUtil.print(o.name);
        PrintUtil.print(o.point);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeDouble(point.x);
        out.writeDouble(point.y);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        double x = in.readDouble();
        double y = in.readDouble();
        point = new Point2D.Double(x, y);
    }

    private Object readResolve() {
        return this;
    }
}
