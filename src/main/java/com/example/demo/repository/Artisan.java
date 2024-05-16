package com.example.demo.repository;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Artisan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String artisanStoreName;

    private String craft;

    private String address;

    private String email;

    private String socialMediaLink;

    @OneToMany(mappedBy = "artisan", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Artisan() {
    }

    public Artisan(Long id, String artisanStoreName, String craft, String address, String email, String socialMediaLink, List<Product> products) {
        this.id = id;
        this.artisanStoreName = artisanStoreName;
        this.craft = craft;
        this.address = address;
        this.email = email;
        this.socialMediaLink = socialMediaLink;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Artisan{" +
                "id=" + id +
                ", artisanStoreName='" + artisanStoreName + '\'' +
                ", craft='" + craft + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", socialMediaLink='" + socialMediaLink + '\'' +
                ", products=" + products +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtisanStoreName() {
        return artisanStoreName;
    }

    public void setArtisanStoreName(String artisanStoreName) {
        this.artisanStoreName = artisanStoreName;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialMediaLink() {
        return socialMediaLink;
    }

    public void setSocialMediaLink(String socialMediaLink) {
        this.socialMediaLink = socialMediaLink;
    }
}
