package daoImplement;

import java.util.List;

import dao.DanhMucDAO;
import entities.DanhMuc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DanhMucDAOIMPL implements DanhMucDAO{
	private EntityManager entityManager;

    public DanhMucDAOIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<DanhMuc> layTatCaDanhMuc() {
        String query = "SELECT d FROM DanhMuc d";
        List<DanhMuc> result = entityManager.createQuery(query, DanhMuc.class).getResultList();
       
        return result;
    }

    public void themDanhMuc(DanhMuc danhMucMoi) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(danhMucMoi);
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
               }
    }
}