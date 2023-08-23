package com.h.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.h.exception.NotFound;
import com.h.model.ScheduleSession;
import com.h.repo.ScheduleSessionRepo;



@Service
public class ScheduleSessionService {
	
	@Autowired
	ScheduleSessionRepo sessionrepo;
	
	public ScheduleSession addSession(ScheduleSession ss) {
		return sessionrepo.save(ss);
		
	}
	
	public List<ScheduleSession> listSession(){
		return sessionrepo.findAll();
	}
	
	public ScheduleSession listById(int id) {
		Optional <ScheduleSession> op = sessionrepo.findById(id);
		
		if(op.isPresent()) 
			return op.get();
		else {
			throw new NotFound("Session not found : "+id);
		}
		
	}
	
	public ScheduleSession updateSession(ScheduleSession ss) {
		boolean status = sessionrepo.existsById(ss.getSId());
		
		if(status!=false) 
			
			return sessionrepo.save(ss);
		else {
			throw new NotFound("Session not found");
		}
	}


	public ResponseEntity<String> deleteSession(int id) {
	    Optional<ScheduleSession> op = sessionrepo.findById(id);

	    if (op.isEmpty()) {
	        throw new NotFound("Doctor not found");
	    } else {
	    	sessionrepo.deleteById(id);
	        return ResponseEntity.ok().body("Deleted successfully");
	    }
	}

}
