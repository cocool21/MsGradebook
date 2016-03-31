

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBUtil;
import model.Student;
import model.UserDB;



/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		message="";
		String input1=request.getParameter("id");
		String input2=request.getParameter("grade");
		if (input1 == null || input1.trim().isEmpty()||input2 == null) {
            message="Please enter id";
            request.setAttribute("message", message);
        } else if (!input1.matches("\\d+")||!input2.matches("\\d+")) {
            message="Please enter digits only";
            request.setAttribute("message", message);
        }else{
	    int id=Integer.parseInt(input1);
	    EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    try { 
			model.Msgradebook student = em.find(model.Msgradebook.class, (long)id); 
			BigDecimal grade=new BigDecimal(input2);
		    student.setGrade(grade);
		    UserDB.update(student);
		    message="Record updated, assignment id "+student.getAssignmentId()+" has grade changed to "+student.getGrade();
			} catch (Exception e){ 
			} finally { 
				em.close(); 
			}
		
        request.setAttribute("message", message);
        }
		 
			
		request.getRequestDispatcher("/UpdateRecords.jsp").forward(request, response);
	}
	

}
