package br.com.xmrtecnologia.restwithspringboot3java18.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xmrtecnologia.restwithspringboot3java18.app.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}