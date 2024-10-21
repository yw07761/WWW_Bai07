package daoImplement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.TinTucDAO;
import entities.DanhMuc;
import entities.TinTuc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;



public class DanhSachTinTucQuanLy implements TinTucDAO {
    private EntityManager entityManager;

    public DanhSachTinTucQuanLy(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<TinTuc> layTatCaTinTuc() {
        String query = "SELECT t FROM TinTuc t";  
        return entityManager.createQuery(query, TinTuc.class).getResultList();
    }

    public List<TinTuc> layTinTucTheoDanhMuc(int maDM) {
        String query = "SELECT t FROM TinTuc t WHERE t.danhMuc.maDM = :maDM";
        return entityManager.createQuery(query, TinTuc.class)
                            .setParameter("maDM", maDM)
                            .getResultList();
    }

   
    public void themTinTuc(TinTuc tinTuc) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            // Use merge() instead of persist() to handle detached entities
            entityManager.merge(tinTuc);
            transaction.commit();
            System.out.println("Thêm tin tức thành công!"); // Optional: log success message
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("Thêm tin tức không thành công: " + e.getMessage()); // Optional: log error message
        }
    }


    
    public void xoaTinTuc(int maTT) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            TinTuc tinTuc = entityManager.find(TinTuc.class, maTT);
            if (tinTuc != null) {
                entityManager.remove(tinTuc);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    
    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
   
}