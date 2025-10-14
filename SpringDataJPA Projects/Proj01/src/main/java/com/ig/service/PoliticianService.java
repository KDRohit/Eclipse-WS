package com.ig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.entity.Politician;
import com.ig.repository.IPoliticianRepository;

@Service("polService")
public class PoliticianService  implements IPoliticianService{

	@Autowired
	private IPoliticianRepository politicianRepo;
	@Override
	public String registerPolitician(Politician politician)
	{
		// save the object (insert the record)
		Politician savedPolitician = politicianRepo.save(politician);
		// get the id value from the saved object.
		int id = savedPolitician.getPid();
		return "Politician object saved (recored inserted) using id:- "+id;
	}

}
