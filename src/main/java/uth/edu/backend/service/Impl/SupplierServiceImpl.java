//package uth.edu.backend.service.Impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import uth.edu.backend.entity.Supplier;
//import uth.edu.backend.repository.SupplierRepository;
//import uth.edu.backend.service.SupplierService;
//
//import java.util.List;
//
//@Service
//public class SupplierServiceImpl implements SupplierService {
//    @Autowired
//    private SupplierRepository supplierRepository;
//
//    @Override
//    public List<Supplier> getAllSuppliers() {
//        return supplierRepository.findAll();
//    }
//
//    @Override
//    public Boolean create(Supplier supplier) {
//        return null;
//    }
//
//    @Override
//    public Boolean update(Supplier supplier) {
//        return null;
//    }
//
//    @Override
//    public Boolean deleteSupplier(Integer id) {
//        return null;
//    }
//
//    @Override
//    public Supplier findById(Integer id) {
//        return null;
//    }
//
//    @Override
//    public Supplier getOneSupplier(Integer id) {
//        return null;
//    }
//}