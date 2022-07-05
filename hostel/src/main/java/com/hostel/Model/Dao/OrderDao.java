package com.hostel.Model.Dao;

import com.hostel.Model.Entities.Order;
import com.hostel.Model.Entities.Room;

import java.sql.*;
import java.util.ArrayList;

public class OrderDao implements IDao<Order> {
    final static private String SELECT = "select * from orders where id = ?";
    final static private String SELECTALL = "select * from orders";
    final static private String INSERT = "insert into orders (places, class, user_id) values(?, ?, ?)";
    final static private String DELETE = "delete from orders where id = ?";
    final static private String UPDATE = "update orders set places = ?, class = ?, user_id = ? where id = ?";
    @Override
    public Order findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Order(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Order> findAll() {
        ArrayList<Order> orders = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                orders.add(new Order(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                ));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void add(Order entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setInt(1, entity.places());
            ps.setInt(2, entity.class_id());
            ps.setInt(3, entity.user_id());
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
    public void update(Order entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setInt(1, entity.places());
            ps.setInt(2, entity.class_id());
            ps.setInt(3, entity.user_id());
            ps.setInt(4, entity.id());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
