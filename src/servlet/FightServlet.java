package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.AirpotrsService;
import service.FightService;
import service.impl.AirportsServiceImpl;
import service.impl.FightServiceImpl;


import entity.Airports;
import entity.Fights;
import entity.Page;

public class FightServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String opr = request.getParameter("opr");
		FightService fightService  =new FightServiceImpl();
		AirpotrsService airpotrsService = new AirportsServiceImpl();
		
		if(opr.equals("list")){
			String currentPageStr = request.getParameter("currentPage");
			int currentPage = currentPageStr!=null?Integer.parseInt(currentPageStr):1;
			String fightDate = request.getParameter("fightDate");
			String tokeoffAirportId = request.getParameter("tokeoffAirportName");
			String landingAirportId = request.getParameter("landingAirportName");
			
			Page<Fights> page =new Page<Fights>();
			page.setCurrentPage(currentPage);	
			List<Fights> list = fightService.getAll(page,fightDate, tokeoffAirportId, landingAirportId);
			page.setList(list);
			page.setTotalCount(fightService.getTotalCount( fightDate, tokeoffAirportId, landingAirportId));
			List<Airports> airports = airpotrsService.getAllInfo();
			request.getSession().setAttribute("airports", airports);
			request.setAttribute("page", page);
			request.setAttribute("fightDate", fightDate);
			request.setAttribute("tokeoffAirportId", tokeoffAirportId);
			request.setAttribute("landingAirportId", landingAirportId);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if (opr.equals("detail")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Fights fights = fightService.getById(id);
			request.setAttribute("fights", fights);
			request.getRequestDispatcher("detail.jsp").forward(request, response);
			
		}else if (opr.equals("add")) {
			String uploadFilePath = request.getSession().getServletContext().getRealPath("image");
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			ServletFileUpload load  =new ServletFileUpload(diskFileItemFactory);
			Fights fights = new Fights();
			try {
				List<FileItem> list = load.parseRequest(request);
				for(FileItem i : list){
					if(i.isFormField()){
						String fieldName = i.getFieldName();
						String value = i.getString("UTF-8");
						if(fieldName.equals("fightCode")){
							fights.setFightCode(value);
						}
						if(fieldName.equals("fightDate")){
							fights.setFightDate(value);
						}
						if(fieldName.equals("airLine")){
							fights.setAirLine(value);
						}
						if(fieldName.equals("type")){
							fights.setType(value);
						}
						if(fieldName.equals("tokeoffAirportId")){
							fights.setTokeoffAirportId(Integer.parseInt(value));
						}
						if(fieldName.equals("landingAirportId")){
							fights.setLandingAirportId(Integer.parseInt(value));
						}
						if(fieldName.equals("fightTime")){
							fights.setFightTime(value);
						}
						if(fieldName.equals("stopAirport")){
							fights.setStopAirport(value);
						}
						if(fieldName.equals("referencePrice")){
							fights.setReferencePrice(Integer.parseInt(value));
						}
						if(fieldName.equals("takeoffTime")){
							fights.setTakeoffTime(value);
						}
						if(fieldName.equals("landingTime")){
							fights.setLandingTime(value);
						}
					
					}else{
						String fileName = i.getName();
						if(fileName!=null && fileName!=""){
							File fullFile  = new File(fileName);
							File savaFile = new File(uploadFilePath,fullFile.getName());
							i.write(savaFile);
						}
						fights.setSeatPic(fileName);
					}
					
				}
				int result = fightService.addInfo(fights);
				if(result > 0 ){
					out.print("<script>alert('新增成功');location.href='index.jsp';</script>");
				}else{
					out.print("<script>alert('新增失败');location.href='index.jsp';</script>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
