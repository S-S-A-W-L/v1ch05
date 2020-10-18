package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,5};
        a = (int[]) CopyOfTest.goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));

        String[] b = new String[]{"Tom","Dick","Harry"};
        b = (String[]) CopyOfTest.goodCopyOf(b,10);
        System.out.println(Arrays.toString(b));

        //System.out.println("The following call will generate an exception.");
        //b = (String[]) CopyOfTest.badCopyOf(b,10);
    }

    /**
     *
     * @param a the source array
     * @param newLength the new length
     * @return a larger array that contains all elements of a. However the return array has
     * type Object[],not the same type as a
     */
    public static Object[] badCopyOf(Object[] a,int newLength){
        //创建一个新数组
        Object[] newArray = new Object[newLength];
        //将旧数组中的元素复制到新数组中
        System.arraycopy(a,0,newArray,0,Math.min(a.length,newLength));
        return newArray;
    }

    /**
     *
     * @param a the array to grow. This can be an object array or
     *          a primitive type array
     * @param newLength the new length
     * @return a larger array that contains all elements of a
     */
    public static Object goodCopyOf(Object a,int newLength){
        //获取a数组的类对象
        Class a1 = a.getClass();
        //判断a对象是否是数组对象
        if(!a1.isArray()){
            return null;
        }
        //获取数组中元素的类型
        Class componentType = a1.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType,newLength);
        ////将旧数组中的元素复制到新数组中
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }
}
