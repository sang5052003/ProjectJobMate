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
 * Servlet implementation class searchController
 */
@WebServlet("/recruit/list.do")
public class RecruitListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Recruit> recruitList;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		recruitList = new ArrayList<>();
	

		String search = request.getParameter("searchText");
		String selectLoc = request.getParameter("location");
		String[] selectExp = request.getParameterValues("experience");
		String selectSchool = request.getParameter("school");

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			String uri = "http://api.saramin.co.kr/job-search?job_category=4"; //IT직무만 

			if (selectLoc != null) {
				uri += "&loc_cd=";

				switch (selectLoc) {
				case "seoul":
					uri += "101000";
					break;
				case "gyeonggi":
					uri += "102000";
					break;
				case "kwangju":
					uri += "103000";
					break;
				case "daegu":
					uri += "104000";
					break;
				case "daejun":
					uri += "105000";
					break;
				case "busan":
					uri += "106000";
					break;
				case "ulsan":
					uri += "107000";
					break;
				case "incheon":
					uri += "108000";
					break;
				}
			}

			if (selectSchool != null) {
				uri += "&edu_lv=";

				switch (selectSchool) {
				case "high":
					uri += "6";
					break;
				case "collage":
					uri += "7";
					break;
				case "univarsity":
					uri += "8";
					break;
				case "master":
					uri += "9";
					break;
				case "doctor":
					uri += "5";
					break;
				}

			}

			if (selectExp != null) {
				uri += "&career=";
				if (selectExp.length == 2)
					uri += "1%7C2";
				else
					uri += selectExp[0];
			}

			uri += "&keywords=";
			uri += search;

			uri += "&count=110";

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
					if (ele.getElementsByTagName("name").item(0).getAttributes().getNamedItem("href")
							.getNodeValue() != null)
						href = ele.getElementsByTagName("name").item(0).getAttributes().getNamedItem("href")
								.getNodeValue();

					String title = ele.getElementsByTagName("title").item(0).getTextContent();

					String location = ele.getElementsByTagName("location").item(0).getTextContent();

					String jobType = ele.getElementsByTagName("job-type").item(0).getTextContent();

					String requiredEducationLevel = ele.getElementsByTagName("required-education-level").item(0)
							.getTextContent();



					String expirationTimestamp = ele.getElementsByTagName("expiration-timestamp").item(0)
							.getTextContent();
					Date expirationTime = new Date(Long.parseLong(expirationTimestamp) * 1000);
					String expiration = expirationDateFormat.format(expirationTime);
					if (expirationTime.getYear() - today.getYear() > 2) {
						expiration = "채용시";
					}

					
					recruitList.add(new Recruit(id, name, title, requiredEducationLevel, jobType, location,
							expiration, href));

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
		request.getRequestDispatcher("/views/recruitList.jsp").forward(request, response);

	}

}
