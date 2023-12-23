package com.ucuncubinyil.springbootornek.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ucuncubinyil.springbootornek.entity.Tutorial;
import com.ucuncubinyil.springbootornek.service.impl.TutorialServiceImpl;

@Controller
@CrossOrigin
//@RequestMapping("/api")
public class TutorialController {
	
	private TutorialServiceImpl tutorialServiceImpl;
	
	
	public TutorialController(TutorialServiceImpl tutorialServiceImpl )
	{
		this.tutorialServiceImpl = tutorialServiceImpl;
	}
	
	
	@GetMapping("/tumtutorillarigetir")
	public ResponseEntity<List<Tutorial>> getAllTutorials() {
		
		List<Tutorial> tutorialListesi = tutorialServiceImpl.getAll();
		return new ResponseEntity<>(tutorialListesi,HttpStatus.OK);
		
	}
	
	@GetMapping("/tumtutoriallarigetir2")
	public ModelAndView getAllTutorials2() {
		List<Tutorial> liste = tutorialServiceImpl.getAll();
		ModelAndView model = new ModelAndView("tutorials");
		model.addObject("tutorialListesi",liste);
		return model;
	}
	
	
	@RequestMapping(value="/editTutorial/{id}")
	public String tutorialDuzenle(@PathVariable Long id, Model m) {
		Tutorial tutorialDetay =tutorialServiceImpl.getById(id);
		m.addAttribute("command",tutorialDetay);
		return "edittutorial";
	}
	
	@PostMapping("/tutorialKaydet")
	public ResponseEntity<Tutorial> kaydet(@RequestBody Tutorial tutorial)
	{
		Tutorial kaydedilenTutorial = tutorialServiceImpl.save(tutorial);
		return new ResponseEntity<>(kaydedilenTutorial,HttpStatus.OK);
	}
	
	@PutMapping("/tutorialGuncelle")
	public ResponseEntity<Tutorial> guncelle(@RequestBody Tutorial tutorial)
	{
		//parametre olarak gelen tutorial aslında benim güncellemek için göndermiş olduğum tutorial olacak
		Tutorial guncellenecekTutorial = tutorialServiceImpl.getById(tutorial.getId());
		guncellenecekTutorial.setTitle(tutorial.getTitle());
		guncellenecekTutorial.setDescription(tutorial.getDescription());
		return new ResponseEntity<>(tutorialServiceImpl.save(guncellenecekTutorial),HttpStatus.OK);
	}
	
	@DeleteMapping("/tutorialSil/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id)
	{
		try
		{
			tutorialServiceImpl.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/newtutorial")
	public  ModelAndView yeniTutorialEkle()
	{
		return new ModelAndView("newtutorial","command",new Tutorial());
	}
	
	@RequestMapping(value="/addNewTutorial",method = RequestMethod.POST)
	public ModelAndView yeniKaydet(@ModelAttribute("tutorial")Tutorial tutorial,
			BindingResult result,ModelMap model)
	{

		tutorialServiceImpl.save(tutorial);
		return new ModelAndView("redirect:/tumtutoriallarigetir2");

	}
	
	
	@RequestMapping(value="/addNewTutorialString",method = RequestMethod.POST)
	public String yeniKaydetString(@ModelAttribute("tutorial")Tutorial tutorial,
			BindingResult result,ModelMap model)
	{
		Tutorial eklenenTutorial = tutorialServiceImpl.save(tutorial);
		if(eklenenTutorial!=null)
		{
			
		}
		return "redirect:/tumtutoriallarigetir2";
	
	}
	
	@RequestMapping(value="/tutorialSil2/{id}", method=RequestMethod.GET)
	public String tutorialDelete(@PathVariable Long id)
	{
		String sayfa="";
		try
		{
			tutorialServiceImpl.delete(id);
			sayfa = "redirect:/tumtutoriallarigetir2";
			return sayfa;
		}
		catch(Exception e) {
			return sayfa;
		}
	}
	
	@RequestMapping(value="/editsave",method=RequestMethod.POST)
	public String tutorialGuncelle(@ModelAttribute("tutorial")Tutorial tutorial)
	{
		tutorialServiceImpl.update(tutorial);
		return "redirect:/tumtutoriallarigetir2";
	}
	
	
	
	
}
