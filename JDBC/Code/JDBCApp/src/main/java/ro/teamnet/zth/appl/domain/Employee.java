package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.util.Date;

/**
 * Created by Claudiu.Brandabur on 14-Jul-17.
 */
@Table (name = "employees")
public class Employee {

    @Id(name = "employee_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "hire_date")
    private Date hireDate;
    @Column(name = "job_id")
    private String jobID;
    @Column(name = "salary")
    private Long salary;
    @Column(name = "commission_pct")
    private Long commissionPCT;
    @Column(name = "manager_id")
    private Long managerID;
    @Column(name = "department_id")
    private Long departmentID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getCommissionPCT() {
        return commissionPCT;
    }

    public void setCommissionPCT(Long commissionPCT) {
        this.commissionPCT = commissionPCT;
    }

    public Long getManagerID() {
        return managerID;
    }

    public void setManagerID(Long managerID) {
        this.managerID = managerID;
    }

    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (jobID != employee.jobID) return false;
        if (Double.compare(employee.salary, salary) != 0) return false;
        if (Double.compare(employee.commissionPCT, commissionPCT) != 0) return false;
        if (managerID != employee.managerID) return false;
        if (departmentID != employee.departmentID) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (!lastName.equals(employee.lastName)) return false;
        if (!email.equals(employee.email)) return false;
        if (phoneNumber != null ? !phoneNumber.equals(employee.phoneNumber) : employee.phoneNumber != null)
            return false;
        return hireDate.equals(employee.hireDate);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + hireDate.hashCode();
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(commissionPCT);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (managerID ^ (managerID >>> 32));
        result = 31 * result + (int) (departmentID ^ (departmentID >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return  "Employee_Id: " + id + " ; firstName: " + firstName + " ; lastName: " + lastName +
                " ; email: " + email + " ; phoneNumber: " + phoneNumber + " ; hireDate: " + hireDate +
                " ; jobID: " + jobID + " ; salary: " + salary + " ; commissionPCT: " + commissionPCT +
                " ; managerID: " + managerID + " ; departmentID: " + departmentID + "\n";
    }
}
