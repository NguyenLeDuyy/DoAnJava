//package uth.edu.backend.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import uth.edu.backend.entity.Supplier;
//import uth.edu.backend.service.SupplierService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/suppliers")
//public class SupplierController {
//    @Autowired
//    private SupplierService supplierService;
//
//    // api create supplier
//    @PostMapping
//    public Boolean create(@RequestBody Supplier supplier) {
//        return supplierService.create(supplier);
//    }
//
//    // api cập nhật supplier
//    @PutMapping
//    public Boolean update(@RequestBody Supplier supplier) {
//        return supplierService.update(supplier);
//    }
//
//
//    // api xóa order
//    @DeleteMapping("/{id}")
//    public boolean deleteSupplier(@PathVariable("id") Integer id) {
//        return supplierService.deleteSupplier(id);
//    }
//
//    // api lấy danh sách supplier
//    @GetMapping("/list")
//    public List<Supplier> getAllSuppliers() {
//        return supplierService.getAllSuppliers();
//    }
//
//    // api lấy 1 supplier
//    @GetMapping("/{id}")
//    public Supplier getOneSupplier(@PathVariable("id") Integer id) {
//        return supplierService.getOneSupplier(id);
//    }
//}
//
//
