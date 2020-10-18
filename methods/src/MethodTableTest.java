import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTableTest {
    public static void main(String[] args) {
        try {
            //通过反射获取square和sqrt方法指针
            Method square = MethodTableTest.class.getMethod("square", double.class);
            Method sqrt = Math.class.getMethod("sqrt", double.class);

            printable(1,10,10,square);
            printable(1,10,10,sqrt);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static double square(double x){
        return x * x;
    }

    public static void printable(double from , double to, int n, Method method) {
        //打印方法头
        System.out.println(method);
        double dx = (to - from)/(n - 1);
        for (double x=from; x<=n; x += dx){
            try {
                //方法指针对象通过调用invoke方法来调用自身
                double y = (double) method.invoke(null,x);
                System.out.printf("%10.4f | %10.4f%n",x,y);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
