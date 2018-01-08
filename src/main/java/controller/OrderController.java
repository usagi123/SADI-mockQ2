package controller;

import model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ApplicantService;

import java.util.List;

/**
 * Created by CoT on 12/2/17.
 */
@RestController
public class OrderController {

    @Autowired
    private ApplicantService applicantService;

    @RequestMapping(path = "/applicants", method = RequestMethod.POST)
    public int addApplicant(@RequestBody Applicant applicant){
        int id = applicantService.addApplicant(applicant);
        return id;
    }

    @RequestMapping(path = "/applicants/find", method = RequestMethod.GET)
    public List<Applicant> findApplicants(@RequestParam(required = true, name = "query") String keyword){
        return applicantService.searchApplicants(keyword);
    }

    @RequestMapping(path = "/applicants/{id}", method = RequestMethod.PUT)
    public Applicant updateApplicant(@RequestBody Applicant applicant,@PathVariable int id){
        return applicantService.updateApplicant(applicant);
    }

    @RequestMapping(path = "/applicants", method = RequestMethod.GET)
    public List<Applicant> getApplicants(){
        return applicantService.getAllApplicants();
    }

    //Get By ID
    @RequestMapping(path = "/applicants/{id}", method = RequestMethod.GET)
    public Applicant getApplicant(@PathVariable int id){
        return applicantService.getApplicant(id);
    }

    //Delete
    @RequestMapping(path = "/applicants/{id}", method = RequestMethod.DELETE)
    public void deleteApplicant(@PathVariable int id){
        Applicant applicant = applicantService.getApplicant(id);
        applicantService.deleteApplicant(applicant);
    }

    //Find By Keyword

    @RequestMapping(path = "applicants/readByKeyword/{keyword}", method = RequestMethod.GET)
    public List<Applicant> getApplicantByKeyword(@PathVariable String keyword){
        return applicantService.getApplicantbyKeyword(keyword);
    }

}
