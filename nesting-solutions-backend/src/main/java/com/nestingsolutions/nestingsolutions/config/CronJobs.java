package com.nestingsolutions.nestingsolutions.config;

import com.nestingsolutions.nestingsolutions.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CronJobs {

    private final StudentService studentService;

    @Scheduled(cron = "0 0 1 * * *")
    public void resetPaymentDoneForEveryMonth(){
        studentService.clearMonthlyPayment();
    }
}
