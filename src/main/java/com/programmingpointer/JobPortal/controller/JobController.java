package com.programmingpointer.JobPortal.controller;

import com.programmingpointer.JobPortal.model.JobPost;
import com.programmingpointer.JobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/jobPost/{id}")
    public JobPost getJobPostByID(@PathVariable int id){
        return jobService.getJobPostByID(id);
    }

    @GetMapping("/jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return jobService.searchByKeyword(keyword);
    }
    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return jobService.getJobPostByID(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJobPostByID(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{id}")
    public void deleteJob(@PathVariable int id){
        jobService.deleteJob(id);
    }

    @GetMapping("load")
    public String loadData(){
        jobService.loadData();
        return "loaded";
    }
}
