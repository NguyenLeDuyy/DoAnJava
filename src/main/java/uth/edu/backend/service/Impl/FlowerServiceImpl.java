package uth.edu.backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.dto.response.FlowerDTO;
import uth.edu.backend.entity.Category;
import uth.edu.backend.repository.FlowersRepository;
import uth.edu.backend.entity.Flower;
import uth.edu.backend.service.FlowerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerService {
    @Autowired
    private FlowersRepository flowersRepository;

    @Override
    public List<Flower> getAll() {
        return flowersRepository.findAll();
    }

    @Override
    public Boolean create(Flower flower) {
        try {
            this.flowersRepository.save(flower);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public Boolean update(Flower flower) {
        return null;
    }

    @Override
    public Boolean deleteCategory(Integer id) {
        return null;
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public List<FlowerDTO> findAllFlower(String name) {
        List<FlowerDTO> result = new ArrayList<>();
//        List<Flower> flowers = flowersRepository.findAll();
        List<Flower> flowers = flowersRepository.findAll();

        for (Flower item : flowers) {
            FlowerDTO flowerDTO = new FlowerDTO();
            flowerDTO.setName(item.getFlowerName());
            flowerDTO.setPrice(item.getPrice().intValue());
            flowerDTO.setCategory(item.getCategory().getId());
            flowerDTO.setSeason(item.getSeason());
            result.add(flowerDTO);
        }
        return result;
    }

    @Override
    public Flower addFlower(Flower flower) {
        if (flower != null) {
            return flowersRepository.save(flower);
        }
        return null;
    }

    @Override
    public Flower updateFlower(Integer id, Flower flower) {
        if (flower != null) {
            Flower flower1 = flowersRepository.getById(id);
            if (flower1 != null) {
                flower1.setFlowerName(flower.getFlowerName());
                flower1.setDescription(flower.getDescription());
                flower1.setPrice(flower.getPrice());
                flower1.setImageUrl(flower.getImageUrl());
                flower1.setSeason(flower.getSeason());

                return flowersRepository.save(flower1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteFlower(Integer id) {
        if (id >= 1) {
            Flower flower = flowersRepository.getById(id);
            if (flower != null) {
                flowersRepository.delete(flower);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Flower> getAllFlowers() {
        return flowersRepository.findAll();
    }
    @Override
    public Flower getOneFlower(Integer id) {
        return flowersRepository.getById(id);
    }

    @Override
    public void deleteByIdIn(Integer[] ids) {
        flowersRepository.deleteByIdIn(ids);
    }

    @Override
    public List<Flower> findByFlowerNameContaining(String s) {
        return flowersRepository.findByFlowerNameContaining(s);
    }

    @Override
    public List<Flower> findByFlowerNameContainingAndSeason(String name, String season) {
        return flowersRepository.findByFlowerNameContainingAndSeason(name, season);
    }

//    @Override
//    public void updateFlowerByIdAndSupplier(Integer id, Supplier supplier) {
//        flowersRepository.updateFlowerByIdAndSupplier(id, supplier);
//    }

//    @Override
//    public Flower updateFlowerByIdContainingAndSupplier(Integer id, Supplier supplier) {
//        return flowersRepository.updateFlowerByIdContainingAndSupplier(id, supplier);
//    }
}