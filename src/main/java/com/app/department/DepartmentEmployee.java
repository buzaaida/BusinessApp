/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.department;

import com.app.department.Department;
import com.app.employee.Employee;
import java.io.Serializable;
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
@Table(name = "department_employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartmentEmployee.findAll", query = "SELECT d FROM DepartmentEmployee d"),
    @NamedQuery(name = "DepartmentEmployee.findByDepartmentNumber", query = "SELECT d FROM DepartmentEmployee d WHERE d.departmentEmployeePK.departmentNumber = :departmentNumber"),
    @NamedQuery(name = "DepartmentEmployee.findByEmployeeNumber", query = "SELECT d FROM DepartmentEmployee d WHERE d.departmentEmployeePK.employeeNumber = :employeeNumber"),
    @NamedQuery(name = "DepartmentEmployee.findByFromDate", query = "SELECT d FROM DepartmentEmployee d WHERE d.fromDate = :fromDate"),
    @NamedQuery(name = "DepartmentEmployee.findByToDate", query = "SELECT d FROM DepartmentEmployee d WHERE d.toDate = :toDate")})
public class DepartmentEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DepartmentEmployeePK departmentEmployeePK;
    @Basic(optional = false)
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Basic(optional = false)
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @JoinColumn(name = "employee_number", referencedColumnName = "employee_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "department_number", referencedColumnName = "department_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department;

    public DepartmentEmployee() {
    }

    public DepartmentEmployee(DepartmentEmployeePK departmentEmployeePK) {
        this.departmentEmployeePK = departmentEmployeePK;
    }

    public DepartmentEmployee(DepartmentEmployeePK departmentEmployeePK, Date fromDate, Date toDate) {
        this.departmentEmployeePK = departmentEmployeePK;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public DepartmentEmployee(int departmentNumber, int employeeNumber) {
        this.departmentEmployeePK = new DepartmentEmployeePK(departmentNumber, employeeNumber);
    }

    public DepartmentEmployeePK getDepartmentEmployeePK() {
        return departmentEmployeePK;
    }

    public void setDepartmentEmployeePK(DepartmentEmployeePK departmentEmployeePK) {
        this.departmentEmployeePK = departmentEmployeePK;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentEmployeePK != null ? departmentEmployeePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartmentEmployee)) {
            return false;
        }
        DepartmentEmployee other = (DepartmentEmployee) object;
        if ((this.departmentEmployeePK == null && other.departmentEmployeePK != null) || (this.departmentEmployeePK != null && !this.departmentEmployeePK.equals(other.departmentEmployeePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.businessapp.entity.DepartmentEmployee[ departmentEmployeePK=" + departmentEmployeePK + " ]";
    }
    
}
