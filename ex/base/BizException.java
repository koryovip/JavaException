package ex.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;

import ex.annotation.ExceptionMessage;

public abstract class BizException extends Exception {

    public BizException(String exceptionId) {
        super(exceptionId);
    }

    static protected <T extends BizException> T ddd(Class<? extends BizException> clazz, String id, Object... values) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // BL001Exceptions ex = new BL001Exceptions("");
        // String className = Thread.currentThread().getStackTrace()[1].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Method method = getMethod(clazz, methodName);
        ExceptionMessage exceptionMessage = method.getDeclaredAnnotation(ExceptionMessage.class);

        MessageFormat mf = new MessageFormat(exceptionMessage.value());

        // logger.fatal(mf.format(values));

        Constructor<T> constructor = (Constructor<T>) clazz.getConstructor(String.class);
        return constructor.newInstance(id + "-" + methodName + ":" + mf.format(values));
        // return new BL001Exceptions(getId() + "-" + methodName);
        // return null;
    }

    static protected String ddd2(Class<? extends BizException> clazz, String id, Object... values) {
        // BL001Exceptions ex = new BL001Exceptions("");
        // String className = Thread.currentThread().getStackTrace()[1].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Method method = getMethod(clazz, methodName);
        ExceptionMessage exceptionMessage = method.getDeclaredAnnotation(ExceptionMessage.class);
        MessageFormat mf = new MessageFormat(exceptionMessage.value());
        return String.format("[%s.%s]:%s", clazz.getSimpleName().substring(0, 5), methodName, mf.format(values));
    }

    static private Method getMethod(Class<? extends BizException> clazz, String methodName) {
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.getName().equals(methodName)) {
                return m;
            }
        }
        return null;
    }
}
