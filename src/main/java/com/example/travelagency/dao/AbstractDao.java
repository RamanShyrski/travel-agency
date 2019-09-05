package com.example.travelagency.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.travelagency.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

public abstract class AbstractDao<T> {

  protected SessionFactory sessionFactory;

  @Autowired
  public AbstractDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Transactional
  public void create(T... entities) {
    Session session = sessionFactory.getCurrentSession();
    for(T entity : entities) {
      session.save(entity);
    }
  }

  @Transactional
  public List<T> findAll(Class<T> clazz) {
    Session session = sessionFactory.getCurrentSession();
    return loadAllEntities(clazz, session);
  }

  @SuppressWarnings("unchecked")
  private <T> List<T> loadAllEntities(Class<T> type, Session session) {
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<T> criteria = builder.createQuery(type);
    criteria.from(type);
    return session.createQuery(criteria).getResultList();
  }

  public abstract void delete(long id);

  public abstract Optional<User> findById(long id);

  public abstract void update(User user);

}

