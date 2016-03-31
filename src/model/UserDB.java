package model;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;



 

public class UserDB {


public static void insert(Msgradebook grade) {
EntityManager em = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = em.getTransaction();
trans.begin();
try {
em.persist(grade);
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
em.close();
}
}

public static void update(Msgradebook grade) {
EntityManager em = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = em.getTransaction();
trans.begin();
try {
em.merge(grade);
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
em.close();
}
}

public static void delete(Msgradebook grade) {
EntityManager em = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = em.getTransaction();
trans.begin();
try {
em.remove(em.merge(grade));
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
em.close();
}
}


}