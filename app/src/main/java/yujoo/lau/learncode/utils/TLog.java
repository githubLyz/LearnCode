package yujoo.lau.learncode.utils;

import android.util.Log;

/**
 * @author lew.liu
 * @date 2018/7/14
 * @description Log 工具
 */

public class TLog {
    private static final String TAG = "TLog";

    public static void i(String msg) {
        Log.i(TAG, createMessage(msg));
    }

    public static void e(String msg) {
        Log.e(TAG, createMessage(msg));
    }

    public static void d(String msg) {
        Log.d(TAG, createMessage(msg));
    }

    public static void w(String msg) {
        Log.w(TAG, createMessage(msg));
    }

    public static void v(String msg) {
        Log.v(TAG, createMessage(msg));
    }

    /**
     * 获取有类名与方法名的logString
     *
     * @param rawMessage
     * @return
     */
    private static String createMessage(String rawMessage) {
        /**
         * Throwable().getStackTrace()获取的是程序运行的堆栈信息，也就是程序运行到此处的流程，以及所有方法的信息
         * 这里我们为什么取2呢？0是代表createMessage方法信息，1是代表上一层方法的信息，这里我们
         * 取它是上两层方法的信息
         */
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        String fullClassName = stackTraceElement.getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        return className + "." + stackTraceElement.getMethodName() + "(): " + rawMessage;
    }


}
