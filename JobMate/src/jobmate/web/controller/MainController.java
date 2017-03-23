package jobmate.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import jobmate.domain.Recruit;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//http://api.saramin.co.kr/job-search?job_category=4&bbs_gb=1&fields=count&sort=ac
		
		List<Recruit> recruitList = new ArrayList<>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			String uri = "http://api.saramin.co.kr/job-search?job_category=4&bbs_gb=1&fields=count&sort=ac&count=8"; //IT직무,지원수top
			Document doc = dBuilder.parse(uri);
			doc.getDocumentElement().normalize();


			NodeList nList = doc.getElementsByTagName("job");

			SimpleDateFormat expirationDateFormat = new SimpleDateFormat("~ yyyy년 MM/dd일(E)");
			Date today = new Date(); // 현재날짜
			for (int i = 0; i < nList.getLength(); i++) {

				Node node = nList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element ele = (Element) node;

					String id = ele.getElementsByTagName("id").item(0).getTextContent();
					String name = ele.getElementsByTagName("name").item(0).getTextContent();
					String href = "";
					

					String title = ele.getElementsByTagName("title").item(0).getTextContent();
					String applyCnt = ele.getElementsByTagName("apply-cnt").item(0).getTextContent();
	
					
					recruitList.add(new Recruit(name, title,applyCnt, href));

				}

			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("list", recruitList);
		request.getRequestDispatcher("/views/main.jsp").forward(request, response);
	}

}
