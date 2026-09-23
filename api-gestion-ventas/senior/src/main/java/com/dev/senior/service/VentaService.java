package com.dev.senior.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.dev.senior.repository.*;
import com.dev.senior.model.*;

@Service 
public class VentaService {
    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository){
        this.ventaRepository = ventaRepository;
    }

    public Venta guardar(Venta venta){
        return ventaRepository.save(venta);
    }

    public List<Venta> listarTodas(){
        return ventaRepository.findAll();
    }

    public Optional<Venta> buscarPorId(Long id){
        return ventaRepository.findById(id);
    }

    public void eliminar(Long id){
        ventaRepository.deleteById(id);
    }

    

    
}
