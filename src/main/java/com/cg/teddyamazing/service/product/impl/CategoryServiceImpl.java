package com.cg.teddyamazing.service.product.impl;

import com.cg.teddyamazing.model.product.Category;
import com.cg.teddyamazing.repository.product.CategoryRepo;
import com.cg.teddyamazing.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public CategoryRepo categoryRepo;
    @PersistenceContext
    private EntityManager em;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(String id) {

        TypedQuery<Category> query = em.createQuery("select c from Category c where  c.id=:id", Category.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Category province) {

        categoryRepo.save(province);
    }

    @Override
    public void remove(String id) {
        Category category=findById(id);
        categoryRepo.delete(category);
    }
}