package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
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
        try (PreparedStatement ps =
                     cn.prepareStatement("insert into items(name, created) values (?, ?)")) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = true;
        try (PreparedStatement ps =
                     cn.prepareStatement("update items set name = ? where id = ?")) {
            ps.setString(1, item.getName());
            ps.setInt(2, id);
            ps.execute();
        } catch (SQLException throwables) {
            rsl = false;
            throwables.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = true;
        try (PreparedStatement ps =
                     cn.prepareStatement("delete from items where id = ?")) {
            ps.setInt(1, id);
            ps.execute();
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
                item.setCreated(rs.getTimestamp(3).toLocalDateTime());
                list.add(item);

                /* Из Timestamp в LocalDateTime
                long millis = System.currentTimeMillis();
                Timestamp timestamp = new Timestamp(millis);
                LocalDateTime localDateTime = timestamp.toLocalDateTime();
                Из LocalDateTime в Timestamp
                Timestamp timestampFromLDT = Timestamp.valueOf(localDateTime);*/
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
        try (PreparedStatement ps =
                     cn.prepareStatement("select * from items where name = ?")) {
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            Item item;
            while (rs.next()) {
                item = new Item(rs.getInt(1), rs.getString(2));
                item.setCreated(rs.getTimestamp(3).toLocalDateTime());
                list.add(item);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement ps =
                     cn.prepareStatement("select * from items where id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                item = new Item(rs.getInt(1), rs.getString(2));
                item.setCreated(rs.getTimestamp(3).toLocalDateTime());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }

}