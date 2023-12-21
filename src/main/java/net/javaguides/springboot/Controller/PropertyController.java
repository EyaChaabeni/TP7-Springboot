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

import net.javaguides.springboot.Entity.Property;
import net.javaguides.springboot.Service.PropertyService;



@RestController
@RequestMapping("/api/properties")
public class PropertyController {

	private final PropertyService propertyService;

	@Autowired
	public PropertyController(PropertyService propertyService) {
		this.propertyService = propertyService;
	}

	@GetMapping
	public List<Property> getAllProperties() {
		return propertyService.getAllProperties();
	}

	@GetMapping("/{id}")
	public Property getPropertyById(@PathVariable Long id) {
		return propertyService.getPropertyById(id)
				.orElseThrow(() -> new RuntimeException("Property not found with id: " + id));
	}

	@PostMapping
	public Property saveProperty(@RequestBody Property property) {
		return propertyService.saveProperty(property);
	}

	@PutMapping("/{id}")
	public Property updateProperty(@PathVariable Long id, @RequestBody Property property) {
		property.setId(id);
		return propertyService.saveProperty(property);
	}

	@DeleteMapping("/{id}")
	public void deleteProperty(@PathVariable Long id) {
		propertyService.deleteProperty(id);
	}
}
