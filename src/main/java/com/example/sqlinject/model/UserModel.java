package com.example.sqlinject.model;

import com.example.sqlinject.util.ConnectionUtil;
import com.example.sqlinject.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    Connection connection = ConnectionUtil.getConnection();

    public User getUser(String pName, String password) {
        User user = null;
        String sql = "select * from users where username = ? and password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("username");
                String pass = rs.getString("password");
                user = new User(name, pass);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public void addUser(String username, String password) {
        String sql = "INSERT INTO users  (username, password ) VALUES (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
