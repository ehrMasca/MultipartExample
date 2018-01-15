package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

/**
 * Servlet implementation class MultipartExampleServlet
 */
@WebServlet("/MultipartExampleServlet")
public class MultipartExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MultipartExampleServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);// see if is a multipart form

		if (isMultipart) {

			List<FileItem> multiparts = null;

			try {
				multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request); //split the multipart form in diferent FIleItems
			} catch (FileUploadException e1) {
				e1.printStackTrace();
			}

			String inputName = null;
			String projectName = null;
			String gitRepository = null;

			for (FileItem item : multiparts) {
				if (item.isFormField()) { // Check if is a form data (different of file)
					inputName = (String) item.getFieldName();
					if (inputName.equalsIgnoreCase("projectName")) {
						projectName = (String) item.getString();
					} else if (inputName.equalsIgnoreCase("gitRepository")) {
						gitRepository = (String) item.getString();
					}
				} else if (!item.isFormField()) { // Check if is a file

					File fileAux = new File("src/" + item.getName()); // create a new file with the uploaded file
					FileUtils.copyInputStreamToFile(item.getInputStream(), fileAux);// take the input file and transform
																					// it to a readable file
					// now, you can do what you want with fileAux

				}

			}
			
			System.out.println(projectName);
			System.out.println(gitRepository);
		}

	}

}
