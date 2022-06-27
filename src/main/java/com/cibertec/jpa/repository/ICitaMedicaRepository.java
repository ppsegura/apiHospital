package com.cibertec.jpa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.jpa.entity.CitaMedicaJPA;

@Repository("repositoriocita")
public interface ICitaMedicaRepository extends JpaRepository<CitaMedicaJPA, Serializable>{

}
