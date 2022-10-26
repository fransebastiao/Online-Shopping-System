/*
Region Repository
Author: Franciel Danilo de Carvalho Sebastiao
Student Number: 219466912
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Region;

@Repository
public interface IRegionRepository extends JpaRepository<Region, String> {

}