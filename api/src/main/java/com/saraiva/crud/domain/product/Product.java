package com.saraiva.crud.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Table(name="product")
@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor //constructor with arguments
@NoArgsConstructor //constructor without arguments
@EqualsAndHashCode(of = "id") //indicates the primary key type
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.UUID) //GeneratedValue:indicates that the id is auto generated
    private String id;

    private String name;

    private Integer price_in_cents;

    private Boolean active;

    public Product(RequestProductDTO requestProductDTO) { // this constructor is needed to manipualte the database
        this.name = requestProductDTO.name();
        this.price_in_cents = requestProductDTO.price_in_cents();
        this.active = true;
    }
}
