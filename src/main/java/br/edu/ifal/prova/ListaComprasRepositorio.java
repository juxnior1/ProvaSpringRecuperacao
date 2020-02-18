package br.edu.ifal.prova;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaComprasRepositorio extends CrudRepository<ListaCompras, Integer> {

    
}