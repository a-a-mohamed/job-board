package com.aliswork.jobboard.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    Job getJob(Long id);
    void createJob(Job job);
    boolean updateJob(Long id, Job updatedJob);
    boolean deleteJob(Long id);
}
