package com.example.lap10.Service;

import com.example.lap10.Model.JobPost;
import com.example.lap10.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {
    private final JobPostRepository jobPostRepository;

    public List findAll(){
        return jobPostRepository.findAll();
    }


    public void AddjobPost(JobPost jobPost){
        jobPostRepository.save(jobPost);
    }

    public Boolean updatejobPost(Integer id ,JobPost jobPost){

        JobPost jop = jobPostRepository.findById(id).get();

        if(jop != null){
            jop.setTitle(jobPost.getTitle());
            jop.setPostingDate(jobPost.getPostingDate());
            jobPostRepository.save(jop);
            return true;
        }
        return false;
    }

    public Boolean deletejobPost(Integer id){
        JobPost jop = jobPostRepository.findById(id).get();
        if(jop != null){
            jobPostRepository.delete(jop);
            return true;
        }
        return false;
    }

}
