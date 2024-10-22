package uth.edu.backend.service;

import uth.edu.backend.model.Flower;

import java.util.List;

public interface IFlowerService {
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
}
