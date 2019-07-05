package com.nsoft.csj.test.department.repository;

import com.nsoft.csj.test.department.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
