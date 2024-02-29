package br.com.xmrtecnologia.restwithspringboot3java18.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.xmrtecnologia.restwithspringboot3java18.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
    // Utilizar caracteres maiusculos pois é convenção
	@Query("SELECT u FROM User u WHERE u.userName =:userName")
	User findByUsername(@Param("userName") String userName);
}