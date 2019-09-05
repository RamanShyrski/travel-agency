package com.example.travelagency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.travelagency.dao.AbstractDao;
import com.example.travelagency.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelagencyApplicationTests {
  @Autowired
  private AbstractDao userDao;

  @Test
  public void contextLoads() {

    User user = new User(1, "login", "password");
    User user2 = new User(2, "login", "password");
    User user3 = new User(3, "login", "password");
     System.out.println(userDao.findAll(User.class));
    //userDao.delete(2);


  }

}
