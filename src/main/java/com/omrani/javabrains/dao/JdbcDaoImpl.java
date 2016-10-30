package com.omrani.javabrains.dao;

import com.omrani.javabrains.model.Cicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by salim on 30/10/16.
 */
@Component
public class JdbcDaoImpl {



    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    private final DataSource dataSource;


    @Autowired
    public JdbcDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Cicle getCircle(int circleId){

        Connection conn = null;

        try {
            conn =  dataSource.getConnection();


            PreparedStatement statement = conn.prepareStatement("SELECT * FROM test WHERE id = ?");
            statement.setInt(1,circleId);
            Cicle cicle =null;
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                cicle = new Cicle(circleId,resultSet.getString("name"));
            }
            resultSet.close();
            statement.close();
            return cicle;

        } catch (Exception e) {
           throw new RuntimeException(e);
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {}
        }


    }

    public int getCircleCount(){
        String sql = "SELECT COUNT(*) FROM springHybernate.test";
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public DataSource getDataSource() {
        return dataSource;
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
