package com.gp.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gp.tech.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

}
