package com.dev.senior.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.dev.senior.repository.*;
import com.dev.senior.model.*;

@Service 
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }

    public List<Producto> listarTodos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarPorId(Long id){
        return productoRepository.findById(id);
    }

    public void eliminar(Long id){
        productoRepository.deleteById(id);
    }


}
