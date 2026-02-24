package com.utc.sistema_tevcol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.utc.sistema_tevcol.entity.Catalogo;
import com.utc.sistema_tevcol.service.CatalogoService;

@Controller
@RequestMapping("/catalogos")
public class CatalogoController {

    private final CatalogoService catalogoService;

    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("catalogos", catalogoService.listar());
        return "catalogos/listarcatalogo";
    }

    // FORMULARIO NUEVO
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("catalogo", new Catalogo());
        return "catalogos/nuevocatalogo";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Catalogo catalogo,
                          RedirectAttributes ra) {

        if (catalogo.getCodigoCat() == null) {
            ra.addFlashAttribute("mensaje", "Registro creado correctamente");
        } else {
            ra.addFlashAttribute("mensaje", "Registro actualizado correctamente");
        }

        catalogoService.guardar(catalogo);
        return "redirect:/catalogos";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("catalogo",
                catalogoService.buscarPorId(id));
        return "catalogos/editarcatalogo";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id,
                           RedirectAttributes ra) {

        catalogoService.eliminar(id);
        ra.addFlashAttribute("mensaje", "Registro eliminado correctamente");

        return "redirect:/catalogos";
    }
}