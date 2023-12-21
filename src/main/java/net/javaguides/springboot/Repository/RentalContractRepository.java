package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.Entity.RentalContract;


public interface RentalContractRepository extends JpaRepository<RentalContract, Long> {

}
