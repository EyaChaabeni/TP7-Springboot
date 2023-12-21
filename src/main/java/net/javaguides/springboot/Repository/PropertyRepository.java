package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.Entity.Property;



public interface PropertyRepository extends JpaRepository<Property, Long> {
}
