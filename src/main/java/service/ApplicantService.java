package service;

import model.Applicant;
import model.Application;
import org.bouncycastle.asn1.isismtt.x509.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by CoT on 12/2/17.
 */
@Transactional
@Service
public class ApplicantService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ApplicationService applicationService;

    public int addApplicant(Applicant applicant){

        //as when we post a applicant in json format: id of answer is not available
        for (Application application : applicant.getApplications()) {
            application.setApplicant(applicant);
        }

        int id = (Integer) sessionFactory.getCurrentSession().save(applicant);

        return id;
    }

//    public Applicant updateApplicant(Applicant newApplicant){
//        sessionFactory.getCurrentSession().update(newApplicant);
//        sessionFactory.getCurrentSession().save(newApplicant);
//        return newApplicant;
//    }

    public Applicant updateApplicant(final Applicant applicant){
        Set<Application> applications = applicant.getApplications();
        for (Application a : applications) {

            a.setApplicant(applicant);
            applicationService.updateApplication(a);
        }

        applicant.setApplications(applications);

        sessionFactory.getCurrentSession().saveOrUpdate(applicant);
        return applicant;
    }

    public Applicant getApplicant(int id){
        return (Applicant) sessionFactory.getCurrentSession().get(Applicant.class, id);
    }

    public List<Applicant> getAllApplicants(){
        return sessionFactory.getCurrentSession().createQuery("from Applicant").list();
    }

    public List<Applicant> searchApplicants(String keyword){
        String hql = "from Applicant as a " +
                "where a.name like :name";

        Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("name", "%"+keyword+"%");
        return query.list();

    }

    public List<Applicant> getApplicantbyKeyword(String keyword){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Applicant.class);
        criteria.add(Restrictions.like("applicant", keyword, MatchMode.ANYWHERE));
        return criteria.list();
    }

    public void deleteApplicant(Applicant applicant){
        sessionFactory.getCurrentSession().delete(applicant);
    }


}
