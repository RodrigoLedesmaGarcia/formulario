package com.spring.www.registrousuarios.controller;

import com.spring.www.registrousuarios.entity.Contacto;
import com.spring.www.registrousuarios.service.ContactoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@Controller
public class ContactoController {

    private final ContactoServiceImpl contactoService;

    public ContactoController(ContactoServiceImpl contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping({"/listar", "", "/"})
    public String inicio(@RequestParam(defaultValue = "0") int page,
                         @RequestParam(defaultValue = "5") int size,
                         ModelMap model) {
        Page<Contacto> contactos = contactoService.paginar(page, size);
        model.put("contactos", contactos);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregarForm(ModelMap model){
        model.put("contacto", new Contacto()); // <-- nombre consistente
        return "agregar";
    }

    @PostMapping("/agregar")
    public String agregar(@Valid @ModelAttribute("contacto") Contacto contacto,
                          BindingResult br){
        if (br.hasErrors()) return "agregar";
        contactoService.crear(contacto);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable Long id, ModelMap model){
        Contacto contacto = contactoService.buscarContactoPorrId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.put("contacto", contacto);
        return "editar";
    }

    @PostMapping("/editar")
    public String editar(@Valid @ModelAttribute("contacto") Contacto contacto,
                         BindingResult br){
        if (br.hasErrors()) return "editar";
        contactoService.crear(contacto);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar (@PathVariable Long id){
        contactoService.eliminar(id);
        return "redirect:/";
    }

}


