/**
 * @title: ThreadUtil.java
 * @description:
 */
package org.nomt.base.thread;

import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rain Tang
 *
 */
public class ThreadUtil
{
    private static Logger logger = LoggerFactory.getLogger(ThreadUtil.class);

    /**
     * @Author : Rain Tang
     * @Description : 启动新线程，执行task任务
     * @param task
     */
    public static void startNewTask(Runnable task)
    {
        Thread instanceThread = new Thread(task);
        String threadName = task.toString();
        instanceThread.setName(threadName);
        instanceThread.start();
        logger.debug("Start new thread: " + threadName);
    }

    /**
     * @Author Rain Tang
     * @Description 启动新的定时任务
     * @param timerName
     *            定时器名称
     * @param task
     *            定时任务
     * @param delay
     *            延迟多久后启动任务
     * @param period
     *            重复的周期
     * @return
     */
    public static Timer startNewScheduleTask(String timerName, TimerTask task,
            long delay, long period)
    {
        Timer timer = new Timer(timerName);
        timer.schedule(task, delay, period);
        logger.debug("Timer " + timerName + " start.");
        return timer;
    }

    public static void scheduleTask(Timer timer, TimerTask task, long delay,
            long period)
    {
        timer.schedule(task, delay, period);
        logger.debug("TimerTask " + task.toString() + " start.");
    }

    public static void sleep(long millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException exception)
        {
            logger.debug("sleep() InterruptedException: {}", exception);
        }
    }

}
