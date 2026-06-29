package com.ex.VaccinationCenter.Model;

import java.util.List;

import com.ex.VaccinationCenter.entity.VaccinationCenter;

import lombok.Data;

@Data
public class RequiredResponse {
	private VaccinationCenter center;
	private List<CitizenT> city;

}
