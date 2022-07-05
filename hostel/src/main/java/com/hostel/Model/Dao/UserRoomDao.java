package com.hostel.Model.Dao;

import com.hostel.Model.Entities.UserRole;
import com.hostel.Model.Entities.UserRoom;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class UserRoomDao implements IDao<UserRoom> {
    final static private String SELECTBYUSER = "select * from user_room where user_id = ?";
    final static private String SELECTBYROOM = "select * from user_room where room_id = ?";
    final static private String SELECTALL = "select * from user_room";
    final static private String INSERT = "insert into user_room (user_id, room_id) values(?, ?)";
    final static private String DELETE = "delete from user_room where user_id = ?";
    final static private String UPDATE = "update user_room set room_id = ? where user_id = ?";
    @Override
    public UserRoom findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECTBYUSER);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new UserRoom(
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
    public ArrayList<UserRoom> findAll() {
        ArrayList<UserRoom> userRooms = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                userRooms.add(new UserRoom(
                        rs.getInt(1),
                        rs.getInt(2))
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return userRooms;
    }

    @Override
    public void add(UserRoom entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setInt(1, entity.user_id());
            ps.setInt(2, entity.room_id());
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
    public void update(UserRoom entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setInt(1, entity.room_id());
            ps.setInt(2, entity.user_id());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Boolean isRoomFree(Integer id){
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECTBYROOM);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return !rs.next();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
