package br.com.digix.estagix.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.digix.estagix.model.Local;

@Repository
public interface LocalRepository extends CrudRepository<Local, Long>  {
	
}
