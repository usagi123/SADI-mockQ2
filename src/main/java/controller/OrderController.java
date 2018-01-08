package controller;

import model.Applicant;
import model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ApplicantService;
import service.ApplicationService;

import java.util.List;

/**
 * Created by CoT on 12/2/17.
 */
@RestController
public class OrderController {

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private ApplicationService applicationService;

    //CREATE Visa == Applicant and Applications
    @RequestMapping(path = "/applicants", method = RequestMethod.POST)
    public int addApplicant(@RequestBody Applicant applicant){
        int id = applicantService.addApplicant(applicant);
        return id;
    }

    //READ Visa by name == Get by keyword
    @RequestMapping(path = "/applicants/find", method = RequestMethod.GET)
    public List<Applicant> findApplicants(@RequestParam(required = true, name = "query") String keyword){
        return applicantService.searchApplicants(keyword);
    }

    //READ All Visa == Get all Visa
    @RequestMapping(path = "/applicants", method = RequestMethod.GET)
    public List<Applicant> getApplicants(){
        return applicantService.getAllApplicants();
    }

    //READ Visa == Get Visa by ID
    @RequestMapping(path = "/applicants/{id}", method = RequestMethod.GET)
    public Applicant getApplicant(@PathVariable int id){
        return applicantService.getApplicant(id);
    }

    //READ Visa Applications == Get Applications by ID
    @RequestMapping(path = "/applications/{id}", method = RequestMethod.GET)
    public Application getApplication(@PathVariable int id){
        return applicationService.getApplication(id);
    }

    //UPDATE Visa == Applicant and Applications
    @RequestMapping(path = "/applicants/{id}", method = RequestMethod.PUT)
    public Applicant updateApplicant(@RequestBody Applicant applicant,@PathVariable int id){
        return applicantService.updateApplicant(applicant);
    }

    //DELETE Visa == Delete Visa by ID
    @RequestMapping(path = "/applicants/{id}", method = RequestMethod.DELETE)
    public void deleteApplicant(@PathVariable int id){
        Applicant applicant = applicantService.getApplicant(id);
        applicantService.deleteApplicant(applicant);
    }
}
