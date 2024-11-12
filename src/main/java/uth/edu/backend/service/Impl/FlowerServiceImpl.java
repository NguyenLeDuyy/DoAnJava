package uth.edu.backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.api.model.FlowerDTO;
import uth.edu.backend.repository.FlowersRepository;
import uth.edu.backend.model.Flower;
import uth.edu.backend.service.FlowerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerService {
    @Autowired
    private FlowersRepository flowersRepository;

    @Override
    public List<FlowerDTO> findAllFlower(String name) {
        List<FlowerDTO> result = new ArrayList<>();
        List<Flower> flowers = flowersRepository.findByFlowerNameContaining(name);

        for (Flower item : flowers) {
            FlowerDTO flowerDTO = new FlowerDTO();
            flowerDTO.setName(item.getFlowerName());
            flowerDTO.setPrice(item.getPrice().intValue());

            flowerDTO.setPriceToSeason(item.getPrice().toString() + item.getSeason());
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
}