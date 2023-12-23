package com.ucuncubinyil.springbootornek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucuncubinyil.springbootornek.entity.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial,Long> {

}
