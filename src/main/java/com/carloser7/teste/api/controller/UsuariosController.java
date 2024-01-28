package com.carloser7.teste.api.controller;

import com.carloser7.teste.domain.model.Cliente;
import com.carloser7.teste.domain.model.Empresa;
import com.carloser7.teste.domain.model.Usuario;
import com.carloser7.teste.domain.repository.UsuarioRepository;
import com.carloser7.teste.domain.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/clientes")
    public Cliente criar(@RequestBody @Valid Cliente cliente) {
        return (Cliente) this.usuarioService.criar(cliente);
    }

    @GetMapping("/clientes/{clienteID}")
    public Usuario buscarClientePorID(@PathVariable Long clienteID) {
        return usuarioService.buscarClienteOuFalha(clienteID);
    }

    @PostMapping("/empresas")
    public Empresa criar(@RequestBody @Valid Empresa empresa) {
        return (Empresa) this.usuarioService.criar(empresa);
    }

    @GetMapping("/empresas/{empresaID}")
    public Usuario buscarEmpresaPoID(@PathVariable Long empresaID) {
        return usuarioService.buscarEmpresaOuFalha(empresaID);
    }
}
