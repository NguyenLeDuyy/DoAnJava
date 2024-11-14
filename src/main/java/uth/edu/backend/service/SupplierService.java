package uth.edu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.repository.SupplierRepository;
import uth.edu.backend.entity.Supplier;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    // tạo mới Supplier
    public Supplier createSupplier(Supplier supplier) {
        if (supplier != null) {
            return supplierRepository.save(supplier);
        }
        return null;
    }

    // cập nhật thông tin Supplier
    public Supplier updateSupplier(Integer id, Supplier supplier) {
        if (supplier != null) {
            Supplier supplier1 = supplierRepository.getById(id);
            if (supplier1 != null) {
                supplier1.setName(supplier.getName());
                supplier1.setPhone(supplier.getPhone());
                supplier1.setAddress(supplier.getAddress());
                supplier1.setEmail(supplier.getEmail());
                supplier1.setStatus(supplier.getStatus());

                return supplierRepository.save(supplier1);
            }
        }
        return null;
    }

    // xóa Supplier
    public boolean deleteSupplier(Integer id) {
        if (id >= 1) {
            Supplier supplier = supplierRepository.getById(id);
            if (supplier != null) {
                supplierRepository.delete(supplier);
                return true;
            }
        }
        return false;
    }

    // lấy danh sách tất cả các Supplier
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    // lấy thông tin của một Supplier
    public Supplier getOneSupplier(Integer id) {
        return supplierRepository.getById(id);
    }
}


