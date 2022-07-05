package com.hostel.Model.Dao;

import com.hostel.Model.Entities.Class;

import java.sql.*;
import java.util.ArrayList;

public class ClassDao implements IDao<Class>{
    final static private String SELECT = "select * from class where id = ?";
    final static private String SELECTALL = "select * from class";
    final static private String INSERT = "insert into class (name) values(?)";
    final static private String DELETE = "delete from class where id = ?";
    final static private String UPDATE = "update class set name = ? where id = ?";
    @Override
    public Class findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Class(
                    rs.getInt(1),
                    rs.getString(2)
            );
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Class> findAll() {
        ArrayList<Class> classes = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                classes.add(new Class(
                        rs.getInt(1),
                        rs.getString(2))
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return classes;
    }

    @Override
    public void add(Class entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setString(1, entity.name());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Class entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setString(1, entity.name());
            ps.setInt(2, entity.id());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
