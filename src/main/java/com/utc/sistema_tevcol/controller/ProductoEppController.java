package com.utc.sistema_tevcol.controller;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;



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

    public String guardar(@ModelAttribute ProductoEpp producto) {

        service.guardar(producto);

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

}