package impl;

import entity.Employee;
import interfaces.GenericDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EmployeeDaoImpl implements GenericDao<Employee, Long>{

    @Override
    public void create(Employee employee) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.out.println("Error. Failed to create user.");
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public Employee read(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            tx.commit();
            return employee;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.out.println("Error. Failed to read user.");
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        return null;
    }

    @Override
    public void update(Employee employee) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.out.println("Error. Failed to update user.");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Employee employee) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.out.println("Error. Failed to delete user.");
            e.printStackTrace();
        }
    }
}
