package uth.edu.backend.service;

import org.springframework.stereotype.Service;
import uth.edu.backend.entity.Supplier;

import java.util.List;

@Service
public interface SupplierService {
    List<Supplier> getAllSuppliers();
    Boolean create(Supplier supplier);
    Boolean update(Supplier supplier);
    Boolean deleteSupplier(Integer id);
    Supplier findById(Integer id);
    Supplier getOneSupplier(Integer id);
}