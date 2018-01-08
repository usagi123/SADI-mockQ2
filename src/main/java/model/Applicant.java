package model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;
import java.util.Set;

/**
 * Created by CoT on 12/2/17.
 */
@Entity
public class Applicant {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String dob;

    @Column
    private String gender;

    @OneToMany(mappedBy = "applicant")
    @Cascade(CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private Set<Application> applications;

    public Applicant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    public void setApplicant(){
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.applications = applications;
    }
}
