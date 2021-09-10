/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entity;

import com.app.employee.Employee;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aida
 */
@Entity
@Table(name = "salaries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salary.findAll", query = "SELECT s FROM Salary s"),
    @NamedQuery(name = "Salary.findByEmployeeNumber", query = "SELECT s FROM Salary s WHERE s.salaryPK.employeeNumber = :employeeNumber"),
    @NamedQuery(name = "Salary.findBySalary", query = "SELECT s FROM Salary s WHERE s.salary = :salary"),
    @NamedQuery(name = "Salary.findByFromDate", query = "SELECT s FROM Salary s WHERE s.salaryPK.fromDate = :fromDate"),
    @NamedQuery(name = "Salary.findByToDate", query = "SELECT s FROM Salary s WHERE s.toDate = :toDate"),
    @NamedQuery(name = "Salary.findByPaid", query = "SELECT s FROM Salary s WHERE s.paid = :paid")})
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalaryPK salaryPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "salary")
    private BigDecimal salary;
    @Basic(optional = false)
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @Column(name = "paid")
    private Boolean paid;
    @JoinColumn(name = "employee_number", referencedColumnName = "employee_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public Salary() {
    }

    public Salary(SalaryPK salaryPK) {
        this.salaryPK = salaryPK;
    }

    public Salary(SalaryPK salaryPK, BigDecimal salary, Date toDate) {
        this.salaryPK = salaryPK;
        this.salary = salary;
        this.toDate = toDate;
    }

    public Salary(int employeeNumber, Date fromDate) {
        this.salaryPK = new SalaryPK(employeeNumber, fromDate);
    }

    public SalaryPK getSalaryPK() {
        return salaryPK;
    }

    public void setSalaryPK(SalaryPK salaryPK) {
        this.salaryPK = salaryPK;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salaryPK != null ? salaryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salary)) {
            return false;
        }
        Salary other = (Salary) object;
        if ((this.salaryPK == null && other.salaryPK != null) || (this.salaryPK != null && !this.salaryPK.equals(other.salaryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.businessapp.entity.Salary[ salaryPK=" + salaryPK + " ]";
    }
    
}
