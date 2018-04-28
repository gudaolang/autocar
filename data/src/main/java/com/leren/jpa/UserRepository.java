package com.leren.jpa;

import com.leren.entity.auth.ShopEmp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lee
 * @Date:24/02/2018
 */
public interface UserRepository extends JpaRepository<ShopEmp, String> {

//    ShopEmp findByUserName(String userName);
//
//    @Query(value = "select u from User u where u.uuid = :uuid")
//    ShopEmp findByUuid(@Param("uuid") String uuid);
}
