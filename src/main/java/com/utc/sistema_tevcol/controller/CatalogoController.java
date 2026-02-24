package com.utc.sistema_tevcol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.utc.sistema_tevcol.entity.Catalogo;
import com.utc.sistema_tevcol.service.CatalogoService;

@Controller
@RequestMapping("/catalogos")
public class CatalogoController {

    private final CatalogoService service;

    public CatalogoController(CatalogoService service) {
        this.service = service;
    }

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("catalogos", service.listar());
        return "catalogo/listar";
    }

    // FORM NUEVO
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("catalogo", new Catalogo());
        return "catalogo/formulario";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Catalogo catalogo) {
        service.guardar(catalogo);
        return "redirect:/catalogos";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("catalogo", service.buscarPorId(id));
        return "catalogo/formulario";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/catalogos";
    }
}