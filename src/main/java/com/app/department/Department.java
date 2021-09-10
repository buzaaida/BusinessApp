
package com.app.department;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "departments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDepartmentNumber", query = "SELECT d FROM Department d WHERE d.departmentNumber = :departmentNumber"),
    @NamedQuery(name = "Department.findByDepartmentName", query = "SELECT d FROM Department d WHERE d.departmentName = :departmentName")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "department_number")
    private Integer departmentNumber;
    @Basic(optional = false)
    @Column(name = "department_name")
    private String departmentName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<DepartmentEmployee> departmentEmployeeList;

    public Department() {
    }

    public Department(Integer departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public Department(Integer departmentNumber, String departmentName) {
        this.departmentNumber = departmentNumber;
        this.departmentName = departmentName;
    }

    public Integer getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(Integer departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @XmlTransient
    public List<DepartmentEmployee> getDepartmentEmployeeList() {
        return departmentEmployeeList;
    }

    public void setDepartmentEmployeeList(List<DepartmentEmployee> departmentEmployeeList) {
        this.departmentEmployeeList = departmentEmployeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentNumber != null ? departmentNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.departmentNumber == null && other.departmentNumber != null) || (this.departmentNumber != null && !this.departmentNumber.equals(other.departmentNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.businessapp.entity.Department[ departmentNumber=" + departmentNumber + " ]";
    }
    
}
