package uth.edu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uth.edu.backend.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
//    void deleteByIdIn(Integer[] ids);
//    List<Supplier> findBySupplierNameContaining(String name);
//    Supplier updateSupplierByIdContainingAndFlowers(Integer id, Set<Flower> flowers);
//    Supplier findBySupplierNameContaining(String s);
}
