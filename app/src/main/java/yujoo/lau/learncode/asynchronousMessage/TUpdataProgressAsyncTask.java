package yujoo.lau.learncode.asynchronousMessage;

import android.os.AsyncTask;

/**
 * @author LEW.LIU
 * @date 2018/8/7
 * @description 下载进度条更新进度异步线程 AsyncTask<“启动任务执行的输入参数”, “后台任务执行的进度”，“后台计算结果的类型>
 */

public class TUpdataProgressAsyncTask extends AsyncTask<Integer, Integer, String> {

    public TUpdataProgressAsyncTask() {
        super();
    }

    /**
     * ui 线程调用，显示进度条
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    /**
     *  在onPreExecute调用之后调用，做一些耗时的计算，传递到onPostExecute
     * @param integers
     * @return
     */
    @Override
    protected String doInBackground(Integer... integers) {
        //渐变的进度计算
        publishProgress();
        return null;
    }

    /**
     * publishProgress调用之后调用，动态显示进度条
     * @param values
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    /**
     * 后台计算完成之后调用
     * @param s
     */
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }


}
