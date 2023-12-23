package com.ucuncubinyil.springbootornek.service;

import java.util.List;

import com.ucuncubinyil.springbootornek.entity.Tutorial;

public interface TutorialService {
	
	
	List<Tutorial> getAll();
	
	Tutorial getById(Long id);
	
	Tutorial save(Tutorial tutorial);
	
	Tutorial update(Tutorial tutorial);
	
	Boolean delete(Long id);
	
}
