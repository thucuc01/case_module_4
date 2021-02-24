package com.cg.teddyamazing.service.product.impl;

import com.cg.teddyamazing.model.product.ManageProducts;
import com.cg.teddyamazing.model.product.Product;
import com.cg.teddyamazing.model.product.ProductWeb;
import com.cg.teddyamazing.repository.product.ManagerProductRepo;
import com.cg.teddyamazing.service.product.ManagerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ManagerServiceImpl implements ManagerProductService {
    @Autowired
    public ManagerProductRepo managerProductRepo;


    @Override
    public Page<ManageProducts> findAll(Pageable pageable) {
        return managerProductRepo.findAll(pageable);
    }


    @Override
    public void save(ManageProducts manageProducts) {
        managerProductRepo.save(manageProducts);
    }

    @Override
    public void remove(String id) {
        ManageProducts manageProducts=findById(id);
        managerProductRepo.delete(manageProducts);
    }

    @Override
    public Iterable<ManageProducts> findAllByProduct(Product product) {
        return managerProductRepo.findAllByProduct(product);
    }


    // nhom' theo Product
    @Override
    public List<ProductWeb> findAllGroupBy() {
        return managerProductRepo.findAllGroupBy();
    }

    @Override
    public List<ProductWeb> findAllOderByName() {
        return managerProductRepo.findAllOderByName();
    }
    @Override
    public List<ProductWeb> findAllOderByPrice() {
        return managerProductRepo.findAllOderByPrice();
    }

    @Override
    public List<ProductWeb> findAllFindByName(@Param("name") String name) {
        return managerProductRepo.findAllFindByName(name);
    }

    @Override
    public List<ManageProducts> findByProduct_Id(String id) {
        return managerProductRepo.findByProduct_Id(id);
    }

    @Override
    public ManageProducts findById(String id) {
        return managerProductRepo.findById(id).get();
    }

    @Override
    public List<ManageProducts> findAllByProductSort(String id) {
        return managerProductRepo.findAllByProductSort(id);
    }

    @Override
    public List<ProductWeb> findAllByProduct_Category_Id(String id) {
        return managerProductRepo.findAllByProduct_Category_Id(id);
    }

    @Override
    public List<ProductWeb> findAllByCategoryLimit(String id, String id1){
        return managerProductRepo.findAllByCategoryLimit(id,id1);
    }

}
