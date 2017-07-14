package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Claudiu.Brandabur on 14-Jul-17.
 */
@Table(name = "jobs")
public class Job {

    @Id(name = "job_id")
    private long id;
    @Column(name = "job_title")
    private String job_title;
    @Column(name = "min_salary")
    private int min_salary;
    @Column(name = "max_salary")
    private int max_salary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public int getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(int min_salary) {
        this.min_salary = min_salary;
    }

    public int getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(int max_salary) {
        this.max_salary = max_salary;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return  "Job_Id: " + id + " ; Job_Title: " + job_title + " ; Min_salary: " + min_salary +
                " ; Max_salary: " + max_salary + "\n";
    }
}
