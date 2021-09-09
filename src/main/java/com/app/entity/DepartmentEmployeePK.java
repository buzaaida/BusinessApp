/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Aida
 */
@Embeddable
public class DepartmentEmployeePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "department_number")
    private int departmentNumber;
    @Basic(optional = false)
    @Column(name = "employee_number")
    private int employeeNumber;

    public DepartmentEmployeePK() {
    }

    public DepartmentEmployeePK(int departmentNumber, int employeeNumber) {
        this.departmentNumber = departmentNumber;
        this.employeeNumber = employeeNumber;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) departmentNumber;
        hash += (int) employeeNumber;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartmentEmployeePK)) {
            return false;
        }
        DepartmentEmployeePK other = (DepartmentEmployeePK) object;
        if (this.departmentNumber != other.departmentNumber) {
            return false;
        }
        if (this.employeeNumber != other.employeeNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.businessapp.entity.DepartmentEmployeePK[ departmentNumber=" + departmentNumber + ", employeeNumber=" + employeeNumber + " ]";
    }
    
}
