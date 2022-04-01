package com.clinica.odontologica.dao.impl;

import com.clinica.odontologica.dao.IDao;
import com.clinica.odontologica.model.Dentist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DentistDaoH2 implements IDao<Dentist> {
    // Logger
    private static Logger logger = LogManager.getLogger(DentistDaoH2.class);
    // Constantes
    private static final String DRIVER = "org.h2.Driver";
    private static final String URL_AND_SCRIPT = "jdbc:h2:~/test;";
    private static final String USER = "sa";
    private static final String PASS = "";


    public DentistDaoH2() {

    }

    @Override
    public Dentist save(Dentist dentist) {
        loadDriver();
        Connection connection = null;
        try {
            connection = getDbConnection();
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO DENTIST (license, name, last_name) " +
                            "VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, dentist.getLicense());
            insertStatement.setString(2, dentist.getName());
            insertStatement.setString(3, dentist.getLastName());
            if (insertStatement.executeUpdate() == 1) {
                ResultSet generatedKey = insertStatement.getGeneratedKeys();
                if (generatedKey.next() && generatedKey != null) {
                    dentist.setId(generatedKey.getLong(1));
                }
            }
        } catch (Exception e) {
            if (e.getMessage().contains("Unique index or primary key violation")) {
                logger.error("Cant save, dentist license already registered.");
            } else {
                logger.error("Error saving dentist to database: " + e.getMessage());
            }
        }
        return dentist;
    }

    @Override
    public Dentist findById(Long id) {
        loadDriver();
        Connection connection = null;
        Dentist dentistFound = new Dentist();
        try {
            connection = getDbConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM DENTIST WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                dentistFound.setId(resultSet.getLong("id"));
                dentistFound.setLicense(resultSet.getString("license"));
                dentistFound.setName(resultSet.getString("name"));
                dentistFound.setLastName(resultSet.getString("last_name"));
            }
        } catch (Exception e) {
            logger.error("Error finding dentist by id: " + e.getMessage());
        }
        return dentistFound;
    }

    @Override
    public List<Dentist> findAll() {
        loadDriver();
        Connection connection = null;
        List<Dentist> dentists = new ArrayList<>();
        try {
            connection = getDbConnection();
            PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM DENTIST;");
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Dentist dentist = new Dentist(
                        resultSet.getLong("id"),
                        resultSet.getString("license"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name")
                );
                dentists.add(dentist);
            }
        } catch (Exception e) {
            logger.error("Error searching dentists in database: " + e.getMessage());
        }
        return dentists;
    }

    @Override
    public Dentist updateName(Long id, String newName) {
        loadDriver();
        Connection connection = null;
        Dentist updatedDentist = new Dentist();
        try {
            connection = getDbConnection();
            PreparedStatement updateStatement = connection.prepareStatement("UPDATE DENTIST SET NAME = ? WHERE ID = ?;");
            updateStatement.setString(1, newName);
            updateStatement.setLong(2, id);
            Integer rowsAffected = updateStatement.executeUpdate();
            if (rowsAffected == 1) {
                updatedDentist = findById(id);
            } else {
                logger.error("Error updating dentist name.");
            }
        } catch (Exception e) {
            logger.error("Error updating dentist name: " + e.getMessage());
        }
        return updatedDentist;
    }

    @Override
    public void delete(Long id) {
        loadDriver();
        Connection connection = null;
        try {
            connection = getDbConnection();
            PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM DENTIST WHERE id = ?;");
            deleteStatement.setLong(1, id);
            deleteStatement.executeUpdate();
        } catch (Exception e) {
            logger.error("Error deleting dentist with id " + id + " : " + e.getMessage());
        }
    }

    // Metodo que conecta con la DB
    public Connection getDbConnection() {
        loadDriver();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL_AND_SCRIPT, USER, PASS);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return connection;
    }

    // Metodo que carga el driver
    public void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            logger.error("Error loading driver: " + e.getMessage());
            System.exit(1);
        }
    }

}
