package com.kudin.alex.common.repositories;

import com.kudin.alex.common.entities.Tire;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

/**
 * This class represents methods to store and retrieve
 * data to/from database via Spring (JdbcTemplate and
 * NamedParameterJdbcTemplate) framework
 *
 * Created by KUDIN ALEKSANDR on 23.01.2018.
 */
@Repository
public class SpringJDBCTemplateStorage implements Storage<Tire>{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedTemplate;

    public void setNamedTemplate(NamedParameterJdbcTemplate namedTemplate) {
        this.namedTemplate = namedTemplate;
    }

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int saveEntity(Tire tire) {
        int productId;
        Map<String,Object> pMap = createTireMap(tire);
        String sql = "INSERT INTO tires(type, manufacturer, model, width, height, diameter, season, " +
                "load_index, speed_index, strengthen, studded, additional_param, country, year, balance, price) " +
                "VALUES (:_type, :manufacturer, :model, :width, :height, :diameter, :season," +
                ":load_index, :speed_index, :strengthen, :studded, :additional_param, :country, :_year, :balance, :price) RETURNING tires.tire_id";
        productId = namedTemplate.query(sql, pMap, rs -> {
            if(rs.next()) return rs.getInt(1);
            else return 0;
        });
        return productId;
    }

    /**
     * Maps the given Tire entity to proceed
     * storing it in the database. Uses for
     * namedTemplate ({@see} org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate)
     *
     * @param t  - Tire entity to store
     * @return map of Product entity
     */
    private Map<String, Object> createTireMap(Tire t){
        Map<String, Object> tMap= new HashMap<>();
        tMap.put("_type", t.getType());
        tMap.put("manufacturer", t.getManufacturer());
        tMap.put("model", t.getModel());
        tMap.put("width", t.getWidth());
        tMap.put("height", t.getHeight());
        tMap.put("diameter", t.getDiameter());
        tMap.put("season", t.getSeason());
        tMap.put("load_index", t.getLoadIndex());
        tMap.put("speed_index", t.getSpeedIndex());
        tMap.put("strengthen", t.isStrengthen());
        tMap.put("studded", t.isStudded());
        tMap.put("additional_param", t.getAdditionalParam());
        tMap.put("country", t.getCountry());
        tMap.put("_year", t.getYear());
        tMap.put("balance", t.getBalance());
        tMap.put("price", t.getPrice());
        return tMap;
    }
}
