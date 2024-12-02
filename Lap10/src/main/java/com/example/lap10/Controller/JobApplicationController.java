package com.example.lap10.Controller;

import com.example.lap10.Model.JobApplication;
import com.example.lap10.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jac")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;
    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(jobApplicationService.findAll());
    }

    @PostMapping("/Apply")
    public ResponseEntity Apply(@RequestBody@Valid JobApplication jobApplication , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
      Boolean isApply =  jobApplicationService.apply_for_jop(jobApplication);
        if(isApply){
            return ResponseEntity.ok().body("Apply Success");
        }
        return ResponseEntity.badRequest().body("Apply Failed , check user id OR Jop Post id");
    }
    
        @PostMapping("/deleteJobApplication/{id}")
    public ResponseEntity deleteJobApplication(@PathVariable Integer id){
        Boolean isDeleted = jobApplicationService.deleteJobApplication(id);
        if(isDeleted){
            return ResponseEntity.ok().body("Delete Success");
        }
        return ResponseEntity.badRequest().body(" job application not found");
    }
}
