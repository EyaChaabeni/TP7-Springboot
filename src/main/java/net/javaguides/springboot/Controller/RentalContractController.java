package net.javaguides.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.realestate.entities.RentalContract;
import com.api.realestate.services.RentalContractService;

@RestController
@RequestMapping("/api/rental-contracts")
public class RentalContractController {

    private final RentalContractService rentalContractService;

    @Autowired
    public RentalContractController(RentalContractService rentalContractService) {
        this.rentalContractService = rentalContractService;
    }

    @GetMapping
    public List<RentalContract> getAllRentalContracts() {
        return rentalContractService.getAllRentalContracts();
    }

    @GetMapping("/{id}")
    public RentalContract getRentalContractById(@PathVariable Long id) {
        return rentalContractService.getRentalContractById(id)
                .orElseThrow(() -> new RuntimeException("Rental Contract not found with id: " + id));
    }

    @PostMapping
    public RentalContract saveRentalContract(@RequestBody RentalContract rentalContract) {
        return rentalContractService.saveRentalContract(rentalContract);
    }

    @PutMapping("/{id}")
    public RentalContract updateRentalContract(@PathVariable Long id, @RequestBody RentalContract rentalContract) {
        rentalContract.setId(id);
        return rentalContractService.saveRentalContract(rentalContract);
    }

    @DeleteMapping("/{id}")
    public void deleteRentalContract(@PathVariable Long id) {
        rentalContractService.deleteRentalContract(id);
    }
}