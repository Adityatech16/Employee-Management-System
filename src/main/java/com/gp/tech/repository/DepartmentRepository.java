package com.gp.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gp.tech.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
