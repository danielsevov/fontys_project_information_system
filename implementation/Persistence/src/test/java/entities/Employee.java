package entities;

import businessentitiesapi.Entity;
import nl.fontys.sebivenlo.sebiannotations.Generated;
import nl.fontys.sebivenlo.sebiannotations.ID;
import persistence.usertypes.Email;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Dutch naming. (fields all lower case.)
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class Employee implements Entity {

    private static final long serialVersionUID = 1L;
    @ID
    private final Integer employeeid;
    private final String lastname;
    private final String firstname;
    private final Email email;
    private final Integer departmentid;
    private final Boolean available;
    private final LocalDate dob;
    @Generated
    private final LocalDate hiredate;

    public Employee(Integer employeeid, String lastname, String firstname,
                    Email email, Integer departmentid, Boolean available, LocalDate dob,
                    LocalDate hireDate) {
        this.employeeid = employeeid;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.departmentid = departmentid;
        this.available = available;
        this.dob = dob;
        this.hiredate = hireDate;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Email getEmail() {
        return email;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public Boolean getAvailable() {
        return available;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeid=" + employeeid + ", lastname="
                + lastname + ", firstname=" + firstname + ", email=" + email
                + ", departmentid=" + departmentid + ", available=" + available
                + ", dob=" + dob + ", hireDate=" + hiredate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.employeeid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        return Objects.equals(this.employeeid, other.employeeid);
    }

    @Override
    public int getId() {
        return 0;
    }
}
