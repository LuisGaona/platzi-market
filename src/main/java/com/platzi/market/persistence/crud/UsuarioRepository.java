package com.platzi.market.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.platzi.market.persistence.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
