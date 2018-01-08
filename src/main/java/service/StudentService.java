package service;

import model.Student;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by CoT on 10/14/17.
 */
@Service
public class StudentService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveStudent(Student student){
        sessionFactory.getCurrentSession().save(student);
    }

    @Transactional
    public Student getStudent(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Student where id:id");
        query.setInteger("id", id);

        return (Student) query.uniqueResult();

    }

    @Transactional
    public List<Student> getAllStudents(){
        Query query = sessionFactory.getCurrentSession().createQuery("from Student");
        return query.list();

    }


}
