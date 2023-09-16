package com.example.demo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Rubro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;

    @OneToMany(cascade = CascadeType.MERGE,orphanRemoval = false)
    private List<Producto> productoList=new ArrayList<Producto>();

    public void addProducto(Producto prod){
        this.productoList.add(prod);
    }
}
