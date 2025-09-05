package com.spring.www.registrousuarios.service;

import com.spring.www.registrousuarios.entity.Contacto;
import com.spring.www.registrousuarios.repository.ContactoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ContactoServiceImpl implements ContactoService{

    private final ContactoRepository repository;

    public ContactoServiceImpl(ContactoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Contacto> paginar(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Contacto> buscarContactoPorrId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Contacto crear(Contacto contacto) {
        return repository.save(contacto);
    }

    @Override
    public Contacto editar(Contacto contacto) {
        return repository.save(contacto);
    }

    @Override
    public void eliminar(Long id) {
         repository.deleteById(id);
    }
}
