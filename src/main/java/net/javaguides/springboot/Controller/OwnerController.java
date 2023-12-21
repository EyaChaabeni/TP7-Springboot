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

import net.javaguides.springboot.Entity.Owner;
import net.javaguides.springboot.Service.OwnerService;



@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable Long id) {
        return ownerService.getOwnerById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found with id: " + id));
    }

    @PostMapping
    public Owner saveOwner(@RequestBody Owner owner) {
        return ownerService.saveOwner(owner);
    }

    @PutMapping("/{id}")
    public Owner updateOwner(@PathVariable Long id, @RequestBody Owner owner) {
        owner.setId(id);
        return ownerService.saveOwner(owner);
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
    }
}
