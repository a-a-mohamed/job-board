package com.aliswork.jobboard.job.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aliswork.jobboard.job.Job;
import com.aliswork.jobboard.job.JobRepository;
import com.aliswork.jobboard.job.JobService;

@Service
public class JobServiceImpl implements JobService{
    
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll(){
        return jobRepository.findAll();
    }

    @Override
    public Job getJob(Long id){
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void createJob(Job job){
        jobRepository.save(job);
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob){
        Optional<Job> optional = jobRepository.findById(id);
        if (optional.isPresent()){
            Job job = optional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteJob(Long id){
        try{
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
