package uth.edu.backend.repository.Impl;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import uth.edu.backend.model.Category;
import uth.edu.backend.model.Flower;
import uth.edu.backend.repository.FlowersRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class FlowerRepositoryImpl implements FlowersRepository {
    static final String DB_URL = "jdbc:sqlserver://localhost:1434;databaseName=MyDB;encrypt=true;trustServerCertificate=true";
    static final String USER = "sa";
    static final String PASS = "Aesx5099@@";

    @Override
    public List<Flower> findByFlowerNameContaining(String name) {
        String sql = "SELECT * FROM flower f WHERE f.flower_name like '%" + name + "%'";
        List<Flower> flowers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Flower flower = new Flower();
                flower.setFlowerName(rs.getString("flower_name"));
                flower.setPrice(BigDecimal.valueOf(rs.getInt("price")));
                flower.setSeason(rs.getString("season"));
                Category category = new Category();
                category.setId(rs.getInt("category_id"));
                flower.setCategory(category);
                flower.setDescription(rs.getString("description"));
                flower.setImageUrl(rs.getString("image_url"));
                flowers.add(flower);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connected database failed ... ");
        }
        return flowers;
    }


    @Override
    public void flush() {

    }

    @Override
    public <S extends Flower> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Flower> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Flower> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Flower getOne(Integer integer) {
        return null;
    }

    @Override
    public Flower getById(Integer integer) {
        return null;
    }

    @Override
    public Flower getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Flower> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Flower> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Flower> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Flower> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Flower> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Flower> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Flower, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Flower> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Flower> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Flower> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Flower> findAll() {
        return List.of();
    }

    @Override
    public List<Flower> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Flower entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Flower> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Flower> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Flower> findAll(Pageable pageable) {
        return null;
    }
}
