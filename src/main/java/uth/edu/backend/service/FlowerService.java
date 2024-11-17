package uth.edu.backend.service;

import org.springframework.stereotype.Service;
import uth.edu.backend.dto.response.FlowerDTO;
import uth.edu.backend.entity.Category;
import uth.edu.backend.entity.Flower;

import java.util.List;

@Service
public interface FlowerService {
    List<Flower> getAll();
    Boolean create(Flower flower);
    Boolean update(Flower flower);
    Boolean deleteCategory(Integer id);
    Flower findById(Integer id);


    List<FlowerDTO> findAllFlower(String name);
    //them hoa
    public Flower addFlower(Flower flower);
    //chinh sua thong tin hoa
    public Flower updateFlower(Integer id, Flower flower);
    //xoa hoa
    public boolean deleteFlower(Integer id);
    //lay danh sach hoa
    public List<Flower> getAllFlowers();
    //lay ra mot hoa
    public Flower getOneFlower(Integer id);
    //delte by list id
    public void deleteByIdIn(Integer[] ids);
    //tim kiem hoa theo ten
    public List<Flower> findByFlowerNameContaining(String s);
    //tim kiem hoa theo ten va mua
    public List<Flower> findByFlowerNameContainingAndSeason(String name, String season);
    //cập nhật hoa theo ten va nha cung cap
//    public void updateFlowerByIdAndSupplier(Integer id, Supplier supplier);
//    Flower updateFlowerByIdContainingAndSupplier(Integer id, Supplier supplier);
}