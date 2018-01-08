package service;

import model.Applicant;
import model.Application;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by CoT on 12/2/17.
 */
@Transactional
@Service
public class ApplicationService {

    @Autowired
    private SessionFactory sessionFactory;



    public void updateApplication(Application application){
        sessionFactory.getCurrentSession().saveOrUpdate(application);
    }

    public Application getApplication(int id){
        return (Application) sessionFactory.getCurrentSession().get(Application.class, id);
    }

    public List<Application> getAllApplications(){
        return sessionFactory.getCurrentSession().createQuery("from Application").list();
    }

    public List<Applicant> searchApplications(String keyword){
        String hql = "from Application as q inner join q.applicants as a " +
                "where q.content like :application or a.content like:applicant";

        Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("appplicant", "%"+keyword+"%");
        query.setString("application", "%"+keyword+"%");

        return query.list();

    }

}
