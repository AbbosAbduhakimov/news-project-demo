package uz.abbos.jparepositoryfirst.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.abbos.jparepositoryfirst.entity.Region;
import uz.abbos.jparepositoryfirst.exception.BadRequestException;
import uz.abbos.jparepositoryfirst.repository.RegionRepository;

import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;


    public Region getRegion(Integer id) {
        Optional<Region> optional = regionRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequestException("region not found");
        }
        return optional.get();
    }

    public Region createRegion(Region region) {
        regionRepository.save(region);
        return region;
    }

    public boolean updateRegion(Integer id, Region region) {
        Region r = getRegion(id);
        r.setName(region.getName());
        regionRepository.save(r);
        return true;
    }

    public boolean deleteRegion(Integer id) {
        Region region = getRegion(id);
        region.setName(region.getName());
        regionRepository.save(region);
        return true;
    }
}
