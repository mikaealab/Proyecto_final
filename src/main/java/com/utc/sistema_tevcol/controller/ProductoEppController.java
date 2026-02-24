package com.utc.sistema_tevcol.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.utc.sistema_tevcol.entity.ProductoEpp;
import com.utc.sistema_tevcol.service.ProductoEppService;
import com.utc.sistema_tevcol.service.CatalogoService;

@Controller
@RequestMapping("/productoepp")
public class ProductoEppController {

    private final ProductoEppService service;
    private final CatalogoService catalogoService;

    public ProductoEppController(ProductoEppService service,
                                 CatalogoService catalogoService) {
        this.service = service;
        this.catalogoService = catalogoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", service.listar());
        return "productoepp/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("producto", new ProductoEpp());
        model.addAttribute("catalogos", catalogoService.listar());
        return "productoepp/nuevo";
    }

    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute("producto") ProductoEpp producto,
            BindingResult result,
            RedirectAttributes ra,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("catalogos", catalogoService.listar());
            return producto.getCodigoPeep() == null
                    ? "productoepp/nuevo"
                    : "productoepp/editar";
        }

        boolean esNuevo = (producto.getCodigoPeep() == null);

        service.guardar(producto);

        if (esNuevo) {
            ra.addFlashAttribute("swal_icon", "success");
            ra.addFlashAttribute("swal_title", "Producto creado");
            ra.addFlashAttribute("swal_text", "El producto se registró correctamente");
        } else {
            ra.addFlashAttribute("swal_icon", "success");
            ra.addFlashAttribute("swal_title", "Producto actualizado");
            ra.addFlashAttribute("swal_text", "El producto se actualizó correctamente");
        }

        return "redirect:/productoepp";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        ProductoEpp producto = service.buscarPorId(id);
        if (producto == null) {
            return "redirect:/productoepp";
        }
        model.addAttribute("producto", producto);
        model.addAttribute("catalogos", catalogoService.listar());
        return "productoepp/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes ra) {

        service.eliminar(id);

        ra.addFlashAttribute("swal_icon", "success");
        ra.addFlashAttribute("swal_title", "Producto eliminado");
        ra.addFlashAttribute("swal_text", "El producto fue eliminado correctamente");

        return "redirect:/productoepp";
    }
}