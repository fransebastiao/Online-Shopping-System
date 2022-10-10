package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Region;
import za.ac.cput.service.RegionService;

import java.util.Set;

@RestController
@RequestMapping("online-shopping-system/region")
@Slf4j
public class RegionController {
    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService){
        this.regionService = regionService;
    }

    @PostMapping("save")
    public ResponseEntity<Region> save(@RequestBody Region region){
        Region save = this.regionService.save(region);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request{}", id);
        this.regionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Region> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Region region = this.regionService.read(id);
        return ResponseEntity.ok(region);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Region>> findAll(){
        Set<Region> regions = this.regionService.findAll();
        return ResponseEntity.ok(regions);
    }
}
