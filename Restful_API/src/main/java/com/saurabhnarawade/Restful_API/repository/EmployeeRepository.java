package com.saurabhnarawade.Restful_API.repository;

import com.saurabhnarawade.Restful_API.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByPhone(String phone);
    Optional<Employee> findByEmpId(String empId);

    @Transactional
    @Modifying
    @Query("update Employee set firstName = :fName, lastName = :lName, email = :email, phone = :phone, department = :dept, designation = :design where empId = :empId")
    void updateEmployee(String fName, String lName, String email, String phone, String dept, String design, String empId);



}
