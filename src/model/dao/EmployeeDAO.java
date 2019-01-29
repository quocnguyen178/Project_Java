/*
 * To change this license header, choose License Headers in Employee Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import uti.HibernateUtil;

/**
 *
 * @author MinhQuoc
 */
public class EmployeeDAO {
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<Employee>();
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = sess.getTransaction();
            tx.begin();
            
            Criteria cr = sess.createCriteria(Employee.class);
            list = cr.list();
            
            tx.commit();
            sess.close();
            return list;
        } catch (Exception e) {
            System.out.println("loi");
        }

        return list;
    }

    public void save(Employee p) {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = sess.getTransaction();
            tx.begin();
            
            sess.save(p);
            
            tx.commit();
            sess.close();
        } catch (Exception e) {
            System.out.println("loi");
        }
    }

    public void delete(Employee p) {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = sess.getTransaction();
            tx.begin();
            
            sess.delete(p);
            
            tx.commit();
            sess.close();
        } catch (Exception e) {
            System.out.println("loi");
        }
    }

    public void update(Employee p) {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = sess.getTransaction();
            tx.begin();
            
            sess.saveOrUpdate(p);
            
            tx.commit();
            sess.close();
        } catch (Exception e) {
            System.out.println("loi");
        }
    }

    public Employee get(int id) {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = sess.getTransaction();
            tx.begin();
            
            Employee e = (Employee) sess.get(Employee.class, id);
            
            tx.commit();
            sess.close();
            return e;
        } catch (Exception e) {
            System.out.println("loi");
        }
        return null;
    }
}
