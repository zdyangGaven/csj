package com.nsoft.csj.test.department.repository;

import com.nsoft.csj.test.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}