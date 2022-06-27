package com.cibertec.jpa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.jpa.entity.HospitalJPA;

@Repository("repositoriohospital")
public interface IHospitalRepository extends JpaRepository<HospitalJPA, Serializable>{

}
