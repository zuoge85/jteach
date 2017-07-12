package org.forkjoin.jteach.core.utils;

import java.util.concurrent.*;

/**
 * @author zuoge85@gmail.com on 2017/7/6.
 */
public class ExecutorsUtils {
    public static ScheduledExecutorService newThreadPool(int corePoolSize, Thread.UncaughtExceptionHandler errorHandler) {
        return new ErrorHandlerThreadPoolExecutor(corePoolSize, errorHandler);
    }


    private static class ErrorHandlerThreadPoolExecutor extends ScheduledThreadPoolExecutor {
        private Thread.UncaughtExceptionHandler errorHandler;

        public ErrorHandlerThreadPoolExecutor(int corePoolSize, Thread.UncaughtExceptionHandler errorHandler) {
            super(corePoolSize);
            this.errorHandler = errorHandler;
        }

        public ErrorHandlerThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory, Thread.UncaughtExceptionHandler errorHandler) {
            super(corePoolSize, threadFactory);
            this.errorHandler = errorHandler;
        }

        public ErrorHandlerThreadPoolExecutor(int corePoolSize, RejectedExecutionHandler handler, Thread.UncaughtExceptionHandler errorHandler) {
            super(corePoolSize, handler);
            this.errorHandler = errorHandler;
        }

        public ErrorHandlerThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler, Thread.UncaughtExceptionHandler errorHandler) {
            super(corePoolSize, threadFactory, handler);
            this.errorHandler = errorHandler;
        }

        //        public ErrorHandlerThreadPoolExecutor(Thread.UncaughtExceptionHandler errorHandler, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
//                                              ThreadFactory threadFactory) {
//            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
//            this.errorHandler = errorHandler;
//        }
//
//        public ErrorHandlerThreadPoolExecutor(Thread.UncaughtExceptionHandler errorHandler, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
//                                              RejectedExecutionHandler handler) {
//            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
//            this.errorHandler = errorHandler;
//        }
//
//        public ErrorHandlerThreadPoolExecutor(Thread.UncaughtExceptionHandler errorHandler, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
//                                              ThreadFactory threadFactory, RejectedExecutionHandler handler) {
//            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
//            this.errorHandler = errorHandler;
//        }
//
//        public ErrorHandlerThreadPoolExecutor(Thread.UncaughtExceptionHandler errorHandler, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
//            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
//            this.errorHandler = errorHandler;
//        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            if (t == null && r instanceof Future<?>) {
                try {
                    Future<?> future = (Future<?>) r;
                    if (future.isDone()) {
                        future.get();
                    }
                } catch (CancellationException ce) {
                    t = ce;
                } catch (ExecutionException ee) {
                    t = ee.getCause();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
            if (t != null) {
                errorHandler.uncaughtException(Thread.currentThread(), t);
            }
        }
    }
}
