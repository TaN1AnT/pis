package com.hostel.Service;

import com.hostel.Model.Dao.ClassDao;
import com.hostel.Model.DaoFactory;
import com.hostel.Model.Entities.Class;

import java.util.ArrayList;

public class ClassService {
    final private ClassDao classDao = DaoFactory.createClassDao();
    public ArrayList<Class> getAllClasses(){
        return classDao.findAll();
    }
}
