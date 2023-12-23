package com.ucuncubinyil.springbootornek.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ucuncubinyil.springbootornek.entity.Tutorial;
import com.ucuncubinyil.springbootornek.repository.TutorialRepository;
import com.ucuncubinyil.springbootornek.service.TutorialService;

@Service
public class TutorialServiceImpl implements TutorialService {

	private final TutorialRepository tutorialRepository;
	
	
	public TutorialServiceImpl(TutorialRepository tutorialRepository)
	{
		this.tutorialRepository = tutorialRepository;
	}
	
	@Override
	public List<Tutorial> getAll() {
		//select * from Tutorial 
		List<Tutorial> tutorialListesi = tutorialRepository.findAll();
		return tutorialListesi;
	}

	@Override
	public Tutorial getById(Long id) {
		
		//select * from Tutorial where id=id
		Tutorial tutorialDetay =   tutorialRepository.getOne(id);
		return tutorialDetay;
	}

	@Override
	public Tutorial save(Tutorial tutorial) {
		
		//insert into Tutorial (title) values( tutorial.title);
		Tutorial kaydedilenTutorial = tutorialRepository.save(tutorial);
		return kaydedilenTutorial;
	}

	@Override
	public Tutorial update(Tutorial tutorial) {
	
		   Tutorial guncellenecekTutorial = tutorialRepository.getOne(tutorial.getId());
		   guncellenecekTutorial.setTitle(tutorial.getTitle());
		   guncellenecekTutorial.setDescription(tutorial.getDescription());
		  // guncellenecekTutorial.setId(tutorial.getId());
		   Tutorial guncellenmisTutorial = tutorialRepository.save(guncellenecekTutorial);
		   
		return guncellenmisTutorial;
	}

	@Override
	public Boolean delete(Long id) {
		
		tutorialRepository.deleteById(id);
		return true;
	}

}
