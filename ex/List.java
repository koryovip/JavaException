package ex;

import java.lang.reflect.Method;

import ex.annotation.ExceptionMessage;

public class List {

    public static void main(String[] args) {
        for (Method m : BL001Exceptions.class.getDeclaredMethods()) {
            ExceptionMessage mm = m.getDeclaredAnnotation(ExceptionMessage.class);
            if (mm == null) {
                continue;
            }
            System.out.println(m.getName() + "\t" + mm.value());
        }
    }

}
