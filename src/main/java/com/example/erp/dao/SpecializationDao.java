package com.example.erp.dao;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Specialization;

import java.util.List;

public interface SpecializationDao {
    boolean registerSpecialization(Specialization specialization);
    List<Specialization> readSpecialization();
    boolean updateSpecialization(Specialization specialization);
    boolean deleteSpecialization(Specialization specialization);
    List<Specialization> fetchSpecialization();
   // boolean joinregSpecialization(Specialization specialization);
}
