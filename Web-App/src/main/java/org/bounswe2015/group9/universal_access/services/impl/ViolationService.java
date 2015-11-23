package org.bounswe2015.group9.universal_access.services.impl;

import org.bounswe2015.group9.universal_access.daos.impl.ViolationDao;
import org.bounswe2015.group9.universal_access.entities.Violation;

public class ViolationService {
	
	ViolationDao vdao ; 
	
	public Violation getViolation(Long id){
		return vdao.read(id);
	}
	
	public  boolean createViolation(Violation violation){
		if(violation.getId() != null){
			throw new IllegalArgumentException("Id field should be null");
		}
		
		vdao.create(violation);
		
		return true;
	}
	

}
