package net.javaguides.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.Entity.Property;
import net.javaguides.springboot.Repository.PropertyRepository;



@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }
    

    public Property saveProperty(Property property) {
        return propertyRepository.save(property);
    }

	public void deleteProperty(Long id) {
		// TODO Auto-generated method stub
		
	}
    
}
    