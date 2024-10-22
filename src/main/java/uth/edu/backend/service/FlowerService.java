package uth.edu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.backend.repository.FlowersRepository;
import uth.edu.backend.model.Flower;

import java.util.List;

@Service
public class FlowerService implements IFlowerService {
    @Autowired
    private FlowersRepository flowersRepository;

    @Override
    public Flower addFlower(Flower flower) {
        if(flower != null){
            return flowersRepository.save(flower);
        }
        return null;
    }

    @Override
    public Flower updateFlower(Integer id, Flower flower) {
        if(flower != null){
            Flower flower1 = flowersRepository.getById(id);
            if(flower1 != null){
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
        if(id >= 1){
            Flower flower = flowersRepository.getById(id);
            if(flower != null){
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
