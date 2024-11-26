package com.programmingpointer.JobPortal.service;

import com.programmingpointer.JobPortal.model.JobPost;
import com.programmingpointer.JobPortal.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepo jobRepo;

    public List<JobPost> getAllJobs(){
        return jobRepo.findAll();
    }

    public void addJob(JobPost jobPost){
        jobRepo.save(jobPost);
    }

    public JobPost getJobPostByID(int id) {
        return jobRepo.findById(id).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
         jobRepo.save(jobPost);
    }

    public void deleteJob(int id) {
        jobRepo.deleteById(id);
    }


    public void loadData(){

        List<JobPost> jobs = new ArrayList<>(Arrays.asList(new JobPost(1, "Java Developer", "Good knowledge of Java", 3, Arrays.asList("Java", "Spring", "Maven")),
                new JobPost(2, "CPP Developer", "Good knowledge of CPP", 3, Arrays.asList("CPP", "Docker", "Linux"))));

        jobRepo.saveAll(jobs);
    }

    public List<JobPost> searchByKeyword(String keyword) {
       return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
