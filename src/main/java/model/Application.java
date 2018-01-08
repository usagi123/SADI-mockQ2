package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by CoT on 12/2/17.
 */
@Entity
public class Application {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String date;

    @Column
    private String visatype;

    // 1 is single entry , 0 is multiple entry
    @Column
    private boolean isSingleEntry;


    @ManyToOne
    @JsonIgnore
    private Applicant applicant;



    public Application() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVisatype() {
        return visatype;
    }

    public void setVisatype(String visatype) {
        this.visatype = visatype;
    }

    public boolean isSingleEntry() {
        return isSingleEntry;
    }

    public void setSingleEntry(boolean singleEntry) {
        isSingleEntry = singleEntry;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }


}
