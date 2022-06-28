package com.example.erp.service;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Specialization;
import com.example.erp.dao.SpecializationDao;
import com.example.erp.dao.implementation.SpecializationDaoImpl;

import java.util.List;

public class SpecializationService {
    SpecializationDao specializationDao = new SpecializationDaoImpl();

    public boolean registerSpecialization(Specialization specialization){
        return specializationDao.registerSpecialization(specialization);
    }

    public List<Specialization> readSpecialization (){
        return specializationDao.readSpecialization();
    }

    public boolean updateSpecialization(Specialization specialization){
        return specializationDao.updateSpecialization(specialization);
    }

    public boolean deleteSpecialization(Specialization specialization){
        return specializationDao.deleteSpecialization(specialization);
    }

    public List<Specialization> fetchSpecialization (){
        return specializationDao.fetchSpecialization();
    }
    /*
    public boolean joinregSpecialization(Specialization specialization){
        return specializationDao.registerSpecialization(specialization);
    }*/

}
