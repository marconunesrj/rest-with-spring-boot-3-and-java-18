package br.com.xmrtecnologia.restwithspringboot3java18.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.xmrtecnologia.restwithspringboot3java18.app.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}