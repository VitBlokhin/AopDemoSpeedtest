package app.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class MyLogger {
    public Object watchTime(ProceedingJoinPoint joinpoint) {
        long start = System.currentTimeMillis();
        System.out.println("method begin: " + joinpoint.getSignature().toShortString());
        Object output = null;

        for (Object obj : joinpoint.getArgs()) {
            System.out.println("Params: " + obj);
        }

        try {
            output = joinpoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("method end: " + joinpoint.getSignature().toShortString() + ", time=" + time + " ms");

        return output;
    }

    public void print(Object obj) {

        System.out.println("Print info begin:");

        if (obj instanceof Set) {
            Set set = (Set) obj;
            for (Object object : set) {
                System.out.println(object);
            }

        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            for (Object object : map.keySet()) {
                System.out.println("\tkey=" + object + ", " + map.get(object));
            }
        }

        System.out.println("Print info end");
        System.out.println();

    }
} // class MyLogger
