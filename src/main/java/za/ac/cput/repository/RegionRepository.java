package za.ac.cput.repository;

/*
 Online-Shopping-System
 Region class repository
 Author: Franciel Danilo de Carvalho Sebastiao (219466912)
 Date: 8 April 2022
*/

import za.ac.cput.entity.Region;

import java.util.ArrayList;
import java.util.List;

public class RegionRepository implements IRepository<Region, String>{
    private static RegionRepository repo = null;
    private List<Region> listOfRegions = null;

    private RegionRepository(){
        listOfRegions = new ArrayList<Region>();
    }

    public static RegionRepository getRepo(){
        if(repo == null)
            repo = new RegionRepository();
        return repo;
    }

    public List<Region> getAll() {
        return listOfRegions;
    }

    @Override
    public Region create(Region region) {
        boolean myOperation = listOfRegions.add(region);
            if (!myOperation)
            return null;
        return region;
    }

    @Override
    public Region read(String regionId) {
        for (Region region : listOfRegions)
            if (region.getRegionId().equals(regionId))
                return region;
        return null;
    }

    @Override
    public Region update(Region region) {
        Region oldRegion = read(region.getRegionId());
        if (oldRegion != null){
            listOfRegions.remove(oldRegion);
            listOfRegions.add(region);
            return region;
        }
        return null;
    }

    @Override
    public boolean delete(String regionId) {
        Region deleteRegion = read(regionId);

        if (deleteRegion == null){
            throw new IllegalArgumentException("Failed to delete, there is nothing to delete");
        }
        listOfRegions.remove(regionId);
            return true;
    }
}

