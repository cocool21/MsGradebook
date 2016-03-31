import java.util.List;

//import javax.persistence.TypedQuery;

import model.Msgradebook;
import model.Student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MsServlet
 */
@WebServlet("/MsServlet")
public class MsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/Grades.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		message="";
		Student student=new Student();
		String input=request.getParameter("id");
		if (input == null || input.trim().isEmpty()) {
            message="Please enter id";
            request.setAttribute("message", message);
        } else if (!input.matches("\\d+")) {
            message="Please enter digits only";
            request.setAttribute("message", message);
        }else{
	    int id=Integer.parseInt(input);
	    
		List<Msgradebook> list=student.selectStudentGrade(id);
		if(list==null||list.isEmpty()){
			message="This student has no record in the database";
		}else{
			message="student id: "+id+"<br/>";
        for(Msgradebook grade:list){
        		message+=grade.getType()+": "+grade.getAssignmentName()+"; Score: "+grade.getGrade()+"<br/>";
        }
		}
        request.setAttribute("message", message);
        }
		 
			
		request.getRequestDispatcher("/Grades.jsp").forward(request, response);
	}

}
