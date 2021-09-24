<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

	<title>관리자모드</title>
	
	<script src="/static/css/jquery-3.2.1.min.js"></script>
	
	<link rel="stylesheet" href="/static/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="/static/bootstrap/bootstrap-theme.min.css">
	<script src="/static/bootstrap/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="/static/css/admin/index.css">
	<link rel="stylesheet" href="/static/css/admin/goods/list.css">
	
	<link rel="icon" href="/static/images/gun.png" />
</head>

<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>
	
		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp"%>
			</div>
		</nav>
	
		<section id="container">
			<aside>
				<%@ include file="../include/aside.jsp"%>
			</aside>
			
			<div id="container_box">
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>썸네일</th>
							<th>이름</th>
							<th>카테고리</th>
							<th>가격</th>
							<th>수량</th>
							<th>등록일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${stayList}" var="stay">
						<tr>
							<td>${list.gdsNum }</td>
							<td><img src="${stay.firstImage}"></td>
							<td><a href="${stay.firstImage}">${stay.title}</a></td>
							<%-- <td>${list.cateCode }</td> --%>
							<td>${stay.title}</td>
							<td><fmt:formatNumber value="${list.gdsPrice }" pattern="###,###,###" /></td>
							<c:choose>
								<c:when test="${list.gdsStock <= 100}"><td style="color:red; width:200px;">${list.gdsStock }(수량 부족 임박!)</td></c:when>
								<c:when test="${list.gdsStock > 100}"><td style="width:200px;">${list.gdsStock }</td></c:when>
								<c:when test="${list.gdsStock <= 0 }"><td style="width:200px; text-decoration:line-through;">${list.gdsStock }(수량 없음)</td></c:when>
							</c:choose>
							
							<td><fmt:formatDate value="${list.gdsDate }" pattern="YYYY-MM-dd" /></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
	</div>
	
	<%@ include file="../include/TopBtn.jsp" %>
	
	<footer id="footer">
		<div id="footer_box">
			<%@ include file="../include/footer.jsp"%>
		</div>
	</footer>
</body>
</html>
