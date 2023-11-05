package com.binarfud.challenge6.Repository;

import com.binarfud.challenge6.Enum.MerchantStatus;
import com.binarfud.challenge6.Model.Merchant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, String> {

    @Query(nativeQuery = true, value = "select * from merchant")
    Page<Merchant> findAllWithPaging(Pageable pageable);

    @Query("SELECT m FROM Merchant m WHERE m.open = :merchantStatus")
    List<Merchant> findMerchantByStatus(@Param("merchantStatus") MerchantStatus merchantStatus);
}
