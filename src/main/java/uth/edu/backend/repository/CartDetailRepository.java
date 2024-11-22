package uth.edu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uth.edu.backend.entity.CartDetail;

import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

//    List<CartDetail> findByCartId(Long cartId);
//    CartDetail findByCartIdAndFlowerIdId(Long cartId, Long productId);
//    void deleteByCartId(Long cartId);
//    void deleteByCartIdAndFlowerId(Long cartId, Long productId);
//    void deleteByCartIdAndFlowerIdIn(Long cartId, List<Long> productIds);


//    void updateByQuantityAndCartIdAndFlowerId(Long quantity, Long cartId, Long productId);


}
