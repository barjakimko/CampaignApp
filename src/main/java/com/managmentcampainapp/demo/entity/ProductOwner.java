package com.managmentcampainapp.demo.entity;

import javax.persistence.*;
import java.lang.Long;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "product_owner")
public class ProductOwner {
    @Id
    @SequenceGenerator(name= "owner_id_generator", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_id_generator")
    private Long id;

    private String nick;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> productList = new ArrayList<>();

    public ProductOwner() {
    }

    public ProductOwner(Long id, String nick) {
        this.id = id;
        this.nick = nick;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
