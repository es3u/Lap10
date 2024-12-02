package com.example.lap10.Service;

import com.example.lap10.Model.JobApplication;
import com.example.lap10.Repository.JobApplicationRepository;
import com.example.lap10.Repository.JobPostRepository;
import com.example.lap10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;

    public List findAll(){
        return jobApplicationRepository.findAll();
    }


    public Boolean apply_for_jop(JobApplication jobApplication){
        for (int i = 0; i < userRepository.findAll().size(); i++) {
            if (jobApplication.getUserId().equals(userRepository.findAll().get(i).getId())){
                for (int j = 0; j < jobPostRepository.findAll().size(); j++) {
                    if (jobApplication.getJobPostId().equals(jobPostRepository.findAll().get(j).getId())){
                        jobApplicationRepository.save(jobApplication);
                        return true;
                    }

                }
            }
        }
        return false;
    }



//    public Boolean updateJobApplication(Integer id , JobApplication jobApplication){
//        JobApplication oldJobApplication = jobApplicationRepository.findById(id).get();
//
//        if(oldJobApplication != null){
//            oldJobApplication.setUserId(jobApplication.getUserId());
//            oldJobApplication.setJobPostId(jobApplication.getJobPostId());
//            jobApplicationRepository.save(oldJobApplication);
//            return true;
//
//        }
//
//        return false ;
//
//    }



    public Boolean deleteJobApplication(Integer id){
        JobApplication oldJobApplication = jobApplicationRepository.findById(id).get();
        if(oldJobApplication != null){
            jobApplicationRepository.delete(oldJobApplication);
            return true ;

        }
        return false ;
    }
}
