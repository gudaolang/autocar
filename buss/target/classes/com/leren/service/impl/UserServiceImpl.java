package com.leren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author lee
 * @Date:23/02/2018
 */

@Service
public class UserServiceImpl  {


    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
//    public void addUser(ShopEmp user) {
//        jdbcTemplate.update("insert into user(username,password) VALUES(?,?)", user.getUserName(), user.getPassword());
//    }
//
//    public void delById(String uuid) {
//        jdbcTemplate.update("delete from user where uuid = ? ", uuid);
//    }
//
//    public void updateByUuid(ShopEmp user) {
//        jdbcTemplate.update("update user set user_name = ? ,password = ? where uuid = ? ", user.getUserName(), user.getPassword(), user.getUuid());
//    }
//
//    public List<ShopEmp> getUsersByParam(Map<String, Object> param) {
//        return CommonUtils.map2List(jdbcTemplate.queryForList("select * from user"), ShopEmp.class);
//    }
//
//    public ShopEmp getById(String uuid) {
//        return null;
//    }
}
