package uz.abbos.jparepositoryfirst.contorller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.abbos.jparepositoryfirst.entity.Region;
import uz.abbos.jparepositoryfirst.service.RegionService;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionService regionService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getRegion(@PathVariable("id") Integer id){
        Region result = regionService.getRegion(id);
        return ResponseEntity.ok(result);
    }


    @PostMapping
    public ResponseEntity<?> createRegion(@RequestBody Region region){
        Region result = regionService.createRegion(region);
        return ResponseEntity.ok(result);
    }


    @PutMapping("{id}")
    public ResponseEntity<?> updateRegion(@PathVariable Integer id,
                                          @RequestBody Region region){

        boolean result = regionService.updateRegion(id,region);
        return ResponseEntity.ok(region);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteRegion(@PathVariable Integer id){
        boolean result = regionService.deleteRegion(id);
        return ResponseEntity.ok(result);
    }
}
