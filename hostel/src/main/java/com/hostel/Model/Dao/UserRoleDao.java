package com.hostel.Model.Dao;

import com.hostel.Model.Entities.UserRole;

import java.sql.*;
import java.util.ArrayList;

public class UserRoleDao implements IDao<UserRole> {
    final static private String SELECT = "select * from user_role where user_id = ?";
    final static private String SELECTALL = "select * from user_role";
    final static private String INSERT = "insert into user_role (user_id, role_id) values(?, ?)";
    final static private String DELETE = "delete from user_role where user_id = ?";
    final static private String UPDATE = "update user_role set role_id = ? where user_id = ?";
    @Override
    public UserRole findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new UserRole(
                    rs.getInt(1),
                    rs.getInt(2)
            );
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<UserRole> findAll() {
        ArrayList<UserRole> userRoles = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                userRoles.add(new UserRole(
                        rs.getInt(1),
                        rs.getInt(2))
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return userRoles;
    }

    @Override
    public void add(UserRole entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setInt(1, entity.user_id());
            ps.setInt(2, entity.role_id());
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
    public void update(UserRole entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setInt(1, entity.role_id());
            ps.setInt(2, entity.user_id());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
