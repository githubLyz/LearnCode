异步消息处理机制笔记：
     Handler:
            1.工作原理：Handler的工作原理是Handler发送消息给
            MessageQueue给形成Handle MessageQueue再由Handle 
            MessageQueue传递消息给Looper(一个对象）最后由Looper递交给 
            Handler处理(一个Handler里面必须要有一个Looper)
            2.Handler、Looper、MessageQueen、Message的关系 
            Message: Handler接收和处理的消息对象
            MessageQueen: 存储消息对象的队列
            Looper: 负责读取MessageQueen中的消息，读到消息之后就把消息交给Handler去处理。
            Handler：发送消息和处理消息
     AsyncTask:
            1.是一个抽象泛型类，封装了线程池以及handler 
            2.必须在主线程当中创建
            3.串行执行任务，因此不适合操作耗时任务 
            4.execute(启动)方法只能在主线程中调用，只能调用一次
     HandlerThread:
            1.继承Thread,内部建立了looper,是一个有轮循机制的Thread
            2.内部的run方法创建消息队列，是一个死循环。用完之后要quit或者quitSafely
     IntentService:
            1.启动方式和传统的service一样，当任务执行完毕，会自动停止
            2.每一个耗时操作会在onHandleIntent回调方法执行，异步方法
            3.每次只会执行一个工作线程，执行完才会执行下一个
            4.优先级比service高，在内部可以执行耗时操作
            5.内部就是使用handlerThread的，还封装了handler
            6.stopSelf(msg.arg1); 传入参数，当所有线程完成才会销毁，否则，直接销毁
              
               