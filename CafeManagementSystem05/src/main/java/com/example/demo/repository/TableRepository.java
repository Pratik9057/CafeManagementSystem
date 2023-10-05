package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Table;

@Repository

public interface TableRepository extends JpaRepository<Table, Integer>{

}
