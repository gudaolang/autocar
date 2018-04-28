package com.leren.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author lee
 * @Date:22/02/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public abstract class BaseJunitTest {

    @Before
    public abstract void setUp();
}
