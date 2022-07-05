package com.hostel.Model.Dao;

import com.hostel.Model.Entities.Room;

import java.sql.*;
import java.util.ArrayList;

public class RoomDao implements IDao<Room> {
    final static private String SELECT = "select * from room where id = ?";
    final static private String SELECTALL = "select * from room";
    final static private String INSERT = "insert into room (number, places, class) values(?, ?, ?)";
    final static private String DELETE = "delete from room where id = ?";
    final static private String UPDATE = "update room set number = ?, places = ?, class = ? where id = ?";
    @Override
    public Room findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Room(
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
    public ArrayList<Room> findAll() {
        ArrayList<Room> rooms = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                rooms.add(new Room(
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
        return rooms;
    }

    @Override
    public void add(Room entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setInt(1, entity.number());
            ps.setInt(2, entity.places());
            ps.setInt(3, entity.class_id());
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
    public void update(Room entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setInt(1, entity.number());
            ps.setInt(2, entity.places());
            ps.setInt(3, entity.class_id());
            ps.setInt(4, entity.id());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
