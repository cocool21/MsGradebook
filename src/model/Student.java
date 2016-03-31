package model;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Msgradebook;

public class Student {
public List<Msgradebook> selectStudentGrade(int i){
	EntityManager em=DBUtil.getEmFactory().createEntityManager();
	String qString="SELECT i FROM Msgradebook i where i.studentId ="+i;
	TypedQuery<Msgradebook> q=em.createQuery(qString, Msgradebook.class);
	List<Msgradebook>grades;
	try{
		grades=q.getResultList();
		if(grades==null||grades.isEmpty()){
			grades=null;
			}
		}finally{
			em.close();
		} 
		return grades;
	
}
}

