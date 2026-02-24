package com.utc.sistema_tevcol.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        model.addAttribute("titulo", "Nuevo Catálogo");
        return "catalogos/nuevocatalogo";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute("catalogo") Catalogo catalogo,
            BindingResult result,
            Model model,
            RedirectAttributes ra) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Nuevo Catálogo");
            return "catalogos/nuevocatalogo";
        }

        if (catalogo.getCodigoCat() == null) {
            ra.addFlashAttribute("swal_icon", "success");
            ra.addFlashAttribute("swal_title", "Registro guardado");
            ra.addFlashAttribute("swal_text", "El catálogo fue creado correctamente");
        } else {
            ra.addFlashAttribute("swal_icon", "success");
            ra.addFlashAttribute("swal_title", "Registro actualizado");
            ra.addFlashAttribute("swal_text", "El catálogo fue actualizado correctamente");
        }

        catalogoService.guardar(catalogo);
        return "redirect:/catalogos";
    }
    
    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id,
                         Model model,
                         RedirectAttributes ra) {

        Catalogo catalogo = catalogoService.buscarPorId(id);

        if (catalogo == null) {
            ra.addFlashAttribute("mensaje", "El catálogo no existe");
            return "redirect:/catalogos";
        }

        model.addAttribute("catalogo", catalogo);
        model.addAttribute("titulo", "Editar Catálogo");
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