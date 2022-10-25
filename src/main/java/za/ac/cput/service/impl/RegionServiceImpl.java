/*
Service Implementation for Region class
Author: Franciel Danilo de Carvalho Sebastiao
Student Number: 219466912
//25.10.2022
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Region;
import za.ac.cput.repository.IRegionRepository;
import za.ac.cput.service.RegionService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RegionServiceImpl implements RegionService {

    private final IRegionRepository repository;

    @Autowired
    public RegionServiceImpl(IRegionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Region save(Region region) {
        return this.repository.save(region);
    }

    @Override
    public Region read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public boolean delete(String s) {
        if (this.repository.existsById(s)) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }


    @Override
    public Set<Region> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}

