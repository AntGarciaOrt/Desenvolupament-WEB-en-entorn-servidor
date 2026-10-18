package com.clientes.clientes.controller;

import com.clientes.clientes.model.Cliente;
import com.clientes.clientes.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/clientes";
    }

    @GetMapping("/clientes")
    public String listar(Model model) {
        model.addAttribute("clientes", service.listar());
        return "clientes";
    }

    @GetMapping("/clientes/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("titulo", "Alta de cliente");
        return "formulario";
    }

    @GetMapping("/clientes/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        model.addAttribute("cliente", service.buscar(id));
        model.addAttribute("titulo", "Modificar cliente");
        return "formulario";
    }

    @PostMapping("/clientes/guardar")
    public String guardar(@Valid @ModelAttribute("cliente") Cliente cliente,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Corrige los errores");
            return "formulario";
        }
        service.guardar(cliente);
        return "redirect:/clientes";
    }

    @PostMapping("/clientes/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        service.eliminar(id);
        return "redirect:/clientes";
    }
}