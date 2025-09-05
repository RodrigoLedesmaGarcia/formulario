package com.spring.www.registrousuarios.service;

import com.spring.www.registrousuarios.entity.Contacto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ContactoService {

    Page<Contacto> paginar (int page, int size);

    Optional<Contacto> buscarContactoPorrId (Long id);

    Contacto crear (Contacto contacto);

    Contacto editar (Contacto contacto);

    void eliminar (Long id);
}
