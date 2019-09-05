package com.example.travelagency.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.example.travelagency.dao.AbstractDao;
import com.example.travelagency.model.User;

import javax.transaction.Transactional;

@Repository
public class UserDao
  extends AbstractDao<User> {

  // private Logger logger = LoggerFactory.getLogger(UserDao.class);

  public UserDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @Override
  @Transactional
  public void delete(long id) {
    Session session = sessionFactory.getCurrentSession();
    Optional<User> user = findById(id);
    user.ifPresent(session::delete);
  }

  @Override
  @Transactional
  public Optional<User> findById(long id) {
    Session session = sessionFactory.getCurrentSession();
    User user = session.get(User.class, id);
    return Optional.ofNullable(user);
  }

  @Override
  @Transactional
  public void update(User newUser) {
    Session session = sessionFactory.getCurrentSession();
    User user = session.load(User.class, newUser.getId());
    user.setLogin(newUser.getLogin());
    user.setPassword(newUser.getPassword());
  }
}
