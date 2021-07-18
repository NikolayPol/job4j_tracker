package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("login"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        String sql = String.format(
                "insert into items(name, created) values ('%s', '%s')",
                item.getName(),
                item.getCreated()
        );
        try (Statement statement = cn.createStatement()) {
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = true;
        String sql = String.format(
                "update items set name = '%s' where id = %s",
                item.getName(),
                id
        );
        try (Statement statement = cn.createStatement()) {
            statement.execute(sql);
        } catch (SQLException throwables) {
            rsl = false;
            throwables.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = true;
        String sql = String.format(
                "delete from items where id = %s",
                id
        );
        try (Statement statement = cn.createStatement()) {
            statement.execute(sql);
        } catch (SQLException throwables) {
            rsl = false;
            throwables.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        String sql = "select * from items";
        try (Statement statement = cn.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            Item item;
            while (rs.next()) {
                item = new Item(rs.getInt(1), rs.getString(2));
//                Timestamp timestamp = new Timestamp(rs.getInt(3));
//                LocalDateTime localDateTime = timestamp.toLocalDateTime();
                item.setCreated(LocalDateTime.now());
                list.add(item);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        String sql = String.format(
                "select * from items where name = '%s'",
                key
        );
        try (Statement statement = cn.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new Item(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        String sql = String.format(
                "select * from items where id = %s",
                id
        );
        try (Statement statement = cn.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                item = new Item(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }
}