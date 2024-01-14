package com.example;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronScheduleBuilder;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@Slf4j
@RestController
public class QuartzDemo {

    private Scheduler scheduler;

    public static void main(String[] args) {
        SpringApplication.run(QuartzDemo.class, args);
    }

    @Autowired
    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @GetMapping("/startup/{id}")
    public String startup(@PathVariable String id) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
            .usingJobData("job-name", id)
            .withIdentity(id, id + ".group")
            .build();// 执行
        Trigger trigger = TriggerBuilder.newTrigger()
            .usingJobData("job-name", id)
            .withIdentity(id, id + ".group")
            .startNow()
            .withSchedule(
                CronScheduleBuilder.cronSchedule("0/3 * * * * ?")
            )
            .build();
        scheduler.scheduleJob(jobDetail, trigger);
        if (scheduler.isShutdown()) {
            scheduler.start();
        }
        log.info("定时任务：{} 启动", id);
        return "SUCCESS";
    }

    @GetMapping("/pause/{id}")
    public String pause(@PathVariable String id) throws SchedulerException {
        scheduler.pauseTrigger(TriggerKey.triggerKey(id));
        scheduler.unscheduleJob(TriggerKey.triggerKey(id));
        scheduler.deleteJob(JobKey.jobKey(id));
        log.info("暂停 {} 任务成功", id);
        return "SUCCESS";
    }
}

@Slf4j
@DisallowConcurrentExecution
class TestJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String name = jobExecutionContext.getJobDetail().getJobDataMap().get("job-name").toString();
        log.info("Job name: {}", name);
        log.info("Executed: {}", name);
    }
}
