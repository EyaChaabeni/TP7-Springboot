package net.javaguides.springboot.Entity;

import com.api.realestate.entities.Owner;
import com.api.realestate.entities.Property;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class RentalContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Property property;

    @ManyToOne
    private Owner owner;

    private String tenant;
    private double monthlyRent;

    // Constructors, getters, and setters

    public RentalContract() {
        // Default constructor
    }

    public RentalContract(Long id, Property property, Owner owner, String tenant, double monthlyRent) {
        this.id = id;
        this.property = property;
        this.owner = owner;
        this.tenant = tenant;
        this.monthlyRent = monthlyRent;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }
}
