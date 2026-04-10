package com.example.LastBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LastBoot.entity.Cartoon;

public interface CartoonRepository extends JpaRepository<Cartoon,Integer>{

}
