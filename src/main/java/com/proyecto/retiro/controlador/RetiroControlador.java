package com.proyecto.retiro.controlador;

import com.proyecto.retiro.modelo.Retiro;
import com.proyecto.retiro.repositorio.RetiroRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/retiros")
public class RetiroControlador {

    private final RetiroRepositorio repo;

    public RetiroControlador(RetiroRepositorio repo) {
        this.repo = repo;
    }

    // LISTAR
    @GetMapping
    public String list(Model model) {
        model.addAttribute("resources", repo.findAll());
        return "retiros/retiros-lista";
    }

    // FORMULARIO NUEVO
    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("resource", new Retiro());
        return "retiros/retiros-formulario";
    }

    @GetMapping("/impresion")
    public String impresion(Model model) {
        model.addAttribute("resources", repo.findAll());
        return "retiros/retiros-impresion";
    }

    @GetMapping("/creditos")
    public String creditos(Model model) {
        model.addAttribute("creditos", "Desarrollado por Evelyn García, Javier Quill y Brian Paiz");
        return "retiros/retiros-creditos";
    }

    // CREAR
    @PostMapping
    public String create(@ModelAttribute Retiro resource) {
        repo.save(resource);
        return "redirect:/retiros";
    }

    // EDITAR
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Retiro resource = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("resource", resource);
        return "retiros/retiros-formulario";
    }

    // ACTUALIZAR
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Retiro resource) {
        resource.setId(id);
        repo.save(resource);
        return "redirect:/retiros";
    }

    // ELIMINAR
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/retiros";
    }
}