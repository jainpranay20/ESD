package com.example.erp.dao.implementation;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Specialization;
import com.example.erp.dao.SpecializationDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class SpecializationDaoImpl implements SpecializationDao {

    @Override
    public boolean registerSpecialization(Specialization specialization) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(specialization);
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Specialization> readSpecialization() {
        List<Specialization> specialization = new ArrayList<>();
        Session session = SessionUtil.getSession();
        try {
            for (final Object spec : session.createQuery("from Specialization ").list()) {
                specialization.add((Specialization) spec);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return specialization;
    }

    @Override
    public boolean updateSpecialization(Specialization specialization) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("update Specialization set code=:code,name=:name,description=:description,year=:year,credits=:credits where specialization_id=:specialization_id");
            query.setParameter("code", specialization.getCode());
            query.setParameter("name", specialization.getName());
            query.setParameter("description", specialization.getDescription());
            query.setParameter("year", specialization.getYear());
            query.setParameter("credits", specialization.getCredits());
            query.setParameter("specialization_id", specialization.getSpecialization_id());

            Transaction transaction = session.beginTransaction();
            int result = query.executeUpdate();
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean deleteSpecialization(Specialization specialization) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("delete from Specialization where specialization_id=:specialization_id");
            query.setParameter("specialization_id", specialization.getSpecialization_id());

            Transaction transaction = session.beginTransaction();
            int result = query.executeUpdate();
            transaction.commit();
            session.close();

            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }

    }

    @Override
    public List<Specialization> fetchSpecialization() {
        List<Specialization> specialization = new ArrayList<>();
        Session session = SessionUtil.getSession();
        try {
            for (final Object spec : session.createQuery("from Specialization ").list()) {
                specialization.add((Specialization) spec);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return specialization;
    }

   /* @Override
    public boolean joinregSpecialization(Specialization specialization) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(specialization);
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }*/




}
