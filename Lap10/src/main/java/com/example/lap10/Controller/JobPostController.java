package com.example.lap10.Controller;

import com.example.lap10.Model.JobPost;
import com.example.lap10.Repository.JobPostRepository;
import com.example.lap10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobPost")
@RequiredArgsConstructor
public class JobPostController {
  private final JobPostService jobPostService;

  @GetMapping("/findAll")
  public ResponseEntity findAll(){
      return ResponseEntity.ok(jobPostService.findAll());
  }
  @PostMapping("/addJobPost")
  public ResponseEntity addJobPost(@RequestBody @Valid JobPost jobPost , Errors errors){
      if(errors.hasErrors()){
          return ResponseEntity.badRequest().body(errors.getAllErrors());
      }
      jobPostService.AddjobPost(jobPost);
      return ResponseEntity.ok().body("added is successful");

  }
  @PutMapping("/updateJobPost/{id}")
  public ResponseEntity updateJobPost(@PathVariable Integer id , @RequestBody @Valid JobPost jobPost , Errors errors){

      if(errors.hasErrors()){
          return ResponseEntity.badRequest().body(errors.getAllErrors());

      }
      Boolean isUpdated = jobPostService.updatejobPost(id, jobPost);
      if(isUpdated){
          return ResponseEntity.ok().body("update is successful");
      }
      return ResponseEntity.badRequest().body("update failed");
  }
  @DeleteMapping("/deleteJobPost/{id}")
  public ResponseEntity deleteJobPost(@PathVariable Integer id){
     boolean isDeleted= jobPostService.deletejobPost(id);
     if(isDeleted){
         return ResponseEntity.ok().body("delete is successful");
     }
     return ResponseEntity.badRequest().body("delete failed");

  }




}
