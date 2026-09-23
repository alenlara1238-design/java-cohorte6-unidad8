package com.dev.senior.controller;

import com.dev.senior.service.*;
import com.dev.senior.dto.*;
import com.dev.senior.model.*;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @PostMapping 
    public ResponseEntity<ProductoResponse> crear(@RequestBody ProductoRequest request){
        Producto producto = new Producto();
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());
        producto.setEstado(request.getEstado());

       Producto productoGuardado = productoService.guardar(producto);

       // Crear un método por cada controlador, que transforme Entity -> Response 
       // Crear un método por cada contolador, que transforme Request -> Entity

        ProductoResponse response = convertirAResponse(productoGuardado);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }   

    @GetMapping 
    public ResponseEntity<List<ProductoResponse>> listar(){
      List<ProductoResponse> productos =  productoService.listarTodos().stream()
                        .map(this::convertirAResponse) //este método está en esta clase
                        .toList();
        
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> buscarPorId(@PathVariable Long id){
       return productoService.buscarPorId(id)
                        .map(producto -> ResponseEntity.ok(convertirAResponse(producto)))
                        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    private ProductoResponse convertirAResponse(Producto producto){
        return new ProductoResponse(
            producto.getId(),
            producto.getNombre(),
            producto.getDescripcion(),
            producto.getPrecio(),
            producto.getStock(),
            producto.getEstado()
        );
    }

}
