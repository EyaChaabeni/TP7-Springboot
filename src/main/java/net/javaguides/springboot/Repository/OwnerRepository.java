package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.Entity.Owner;



public interface OwnerRepository extends JpaRepository<Owner, Long> {

}

