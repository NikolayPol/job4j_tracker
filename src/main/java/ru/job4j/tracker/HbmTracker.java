package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс HbmTracker реализует методы для выполняет транзакций в БД через Hibernate.
 *
 * @author Nikolay Polegaev
 * @version 1.0 02.10.2021
 */
public class HbmTracker implements Store, AutoCloseable {
    private static final Logger LOG = LoggerFactory
            .getLogger(HbmTracker.class.getName());
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata()
            .buildSessionFactory();

    @Override
    public void init() {

    }

    @Override
    public Item add(Item item) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            item.setId(id);
            session.update(item);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Item item = new Item();
            item.setId(id);
            session.delete(item);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM Item");
            result = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM Item WHERE name = :name");
            query.setParameter("name", key);
            result = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            item = session.get(Item.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    /**
     * Ручное тестирвание HbmTracker
     */
    public static void main(String[] args) {
        HbmTracker hb = new HbmTracker();
        for (Item item : hb.findAll()) {
            System.out.println(item);
        }
    }
}
