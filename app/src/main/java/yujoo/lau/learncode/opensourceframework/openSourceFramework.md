开源框架:
   OkHttp：
      一:使用简介:1.创建OkHttpClient,只需要创建一个
                 2.创建request对象，通过内部类Builder调用生成Request对象
                 3.创建一个call对象，调用execute/enqueue方法执行网络请求
      二：源码剖析：会拦截之后分发           