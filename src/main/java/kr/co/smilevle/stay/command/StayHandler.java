package kr.co.smilevle.stay.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import kr.co.smilevle.common.command.CommandHandler;
import kr.co.smilevle.corona.model.Corona;
import kr.co.smilevle.corona.service.CoronaService;
import kr.co.smilevle.stay.model.Stay;
import kr.co.smilevle.stay.service.ListStayService;
import kr.co.smilevle.stay.service.StayPage;
import kr.co.smilevle.stay.service.StayService;
import kr.co.smilevle.util.AreacodeConverter;
import kr.co.smilevle.util.MapInfomation;

public class StayHandler implements CommandHandler{
	private ListStayService listStayService = new ListStayService();
		
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		String areaCode = req.getParameter("areaCode");
		String smallCategory = req.getParameter("smallCategory");
		String where = req.getParameter("where");
		String searchWord = req.getParameter("searchWord");

		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		CoronaService coronaService = new CoronaService();
		
		Corona corona = coronaService.selectCoronaLowOrderRandom();
	
		
		System.out.println(corona.getLocalName() + "과" +corona.getCount());
		
		
		MapInfomation mapInfomation = new MapInfomation();
		Map<String, String> areaMap = mapInfomation.getAreaMap();
		Map<String, String> stayMap = mapInfomation.getStayMap();
		StayPage stayPage = listStayService.getArticlePage(pageNo, areaCode, smallCategory, where, searchWord);
		req.setAttribute("stayPage", stayPage);
		req.setAttribute("pageNo", pageNo + "");
		req.setAttribute("areaCode", areaCode);
		req.setAttribute("areaMap", areaMap);
		req.setAttribute("stayMap", stayMap);
		req.setAttribute("smallCategory",  smallCategory);
		req.setAttribute("where", where);
		req.setAttribute("searchWord", searchWord);
		return "/WEB-INF/views/stay.jsp";
		
	}
	
	
}
