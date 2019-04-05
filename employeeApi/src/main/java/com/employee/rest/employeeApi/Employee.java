package com.employee.rest.employeeApi;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee {

    @Id
    @Column(name = "EmployeeID")
    @GeneratedValue
    private long EmployeeID;
    @Column(name = "FullName")
    private String FullName;
    private String Position;
    private String EMPCode;
    private String Mobile;

    public Employee(long employeeID, String fullName, String position, String EMPCode, String mobile) {
        EmployeeID = employeeID;
        FullName = fullName;
        Position = position;
        this.EMPCode = EMPCode;
        Mobile = mobile;
    }

    public Employee() {
    }

    public long getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(long employeeID) {
        EmployeeID = employeeID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getEMPCode() {
        return EMPCode;
    }

    public void setEMPCode(String EMPCode) {
        this.EMPCode = EMPCode;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeID=" + EmployeeID +
                ", FullName='" + FullName + '\'' +
                ", Position='" + Position + '\'' +
                ", EMPCode='" + EMPCode + '\'' +
                ", Mobile='" + Mobile + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getEmployeeID() == employee.getEmployeeID() &&
                getFullName().equals(employee.getFullName()) &&
                getPosition().equals(employee.getPosition()) &&
                getEMPCode().equals(employee.getEMPCode()) &&
                getMobile().equals(employee.getMobile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeID(), getFullName(), getPosition(), getEMPCode(), getMobile());
    }
}
