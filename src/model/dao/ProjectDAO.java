/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Employee;
import model.pojo.Project;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import uti.HibernateUtil;

/**
 *
 * @author MinhQuoc
 */
public class ProjectDAO {

    public List<Project> findAll() {
        List<Project> list = new ArrayList<Project>();
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = sess.getTransaction();
            tx.begin();
            
            Criteria cr=sess.createCriteria(Project.class);
            list = cr.list();
            
            tx.commit();
            sess.close();
            return list;
        } catch (Exception e) {
            System.out.println("loi");
        }

        return list;
    }

    public void save(Project p) {
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

    public void delete(Project p) {
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

    public void update(Project p) {
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

    public Project get(int id) {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = sess.getTransaction();
            tx.begin();
            Project p = (Project) sess.get(Project.class, id);
            
            
            tx.commit();
            sess.close();
            return p;
        } catch (Exception e) {
            System.out.println("loi");
        }
        return null;
    }
}
