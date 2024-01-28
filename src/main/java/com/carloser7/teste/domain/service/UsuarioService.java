package com.carloser7.teste.domain.service;

import com.carloser7.teste.domain.exception.ClienteNaoEncontradoException;
import com.carloser7.teste.domain.exception.EmpresaNaoEncontradaException;
import com.carloser7.teste.domain.model.Cliente;
import com.carloser7.teste.domain.model.Empresa;
import com.carloser7.teste.domain.model.Usuario;
import com.carloser7.teste.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public Empresa buscarEmpresaOuFalha(Long empresaID) {
        Optional<Usuario> empresa = usuarioRepository.findById(empresaID);
        if (!(empresa.get() instanceof Empresa))
            throw new EmpresaNaoEncontradaException(empresaID);

        return (Empresa) empresa.get();
    }

    public Cliente buscarClienteOuFalha(Long clienteID) {
        Optional<Usuario> cliente = usuarioRepository.findById(clienteID);
        if (!(cliente.get() instanceof Cliente))
            throw new ClienteNaoEncontradoException(clienteID);

        return (Cliente) cliente.get();
    }

}
