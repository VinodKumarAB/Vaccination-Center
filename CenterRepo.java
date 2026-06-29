package com.ex.VaccinationCenter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.VaccinationCenter.entity.VaccinationCenter;

public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer>{

}
