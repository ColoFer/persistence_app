package com.example.demo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;

    private String estado;

    private String tipoEnvio;

    private double total;

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_factura")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DetallePedido> detallePedidoList=new ArrayList<DetallePedido>();

    public void addDetallePedido(DetallePedido detail){
        this.detallePedidoList.add(detail);
    }

}
