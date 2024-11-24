package Lab1_CDI.Interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.Arrays;

public class StorageInterceptor {

    @AroundInvoke
    public Object logOperation(InvocationContext ic) throws Exception {
        // Получаем реальный класс через метод getTarget(), если это прокси
        String className = ic.getTarget().getClass().getSuperclass().getSimpleName();
        String methodName = ic.getMethod().getName();
        String params = Arrays.toString(ic.getParameters());

        System.out.println(">>> [Start] " + className + "." + methodName + " | Parameters: " + params);

        Object result = null;
        try {
            result = ic.proceed();
        } finally {
            System.out.println("<<< [End] " + className + "." + methodName + " | Result: " + result);
        }

        return result;
    }
}
