/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aida
 */
@Embeddable
public class JobPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "employee_number")
    private int employeeNumber;
    @Basic(optional = false)
    @Column(name = "job_title")
    private String jobTitle;
    @Basic(optional = false)
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    public JobPK() {
    }

    public JobPK(int employeeNumber, String jobTitle, Date fromDate) {
        this.employeeNumber = employeeNumber;
        this.jobTitle = jobTitle;
        this.fromDate = fromDate;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) employeeNumber;
        hash += (jobTitle != null ? jobTitle.hashCode() : 0);
        hash += (fromDate != null ? fromDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobPK)) {
            return false;
        }
        JobPK other = (JobPK) object;
        if (this.employeeNumber != other.employeeNumber) {
            return false;
        }
        if ((this.jobTitle == null && other.jobTitle != null) || (this.jobTitle != null && !this.jobTitle.equals(other.jobTitle))) {
            return false;
        }
        if ((this.fromDate == null && other.fromDate != null) || (this.fromDate != null && !this.fromDate.equals(other.fromDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.businessapp.entity.JobPK[ employeeNumber=" + employeeNumber + ", jobTitle=" + jobTitle + ", fromDate=" + fromDate + " ]";
    }
    
}
