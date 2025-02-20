<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
      <a class="navbar-brand" href="/">smilevle.</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="oi oi-menu"></span> 메뉴
      </button>

      <div class="collapse navbar-collapse" id="ftco-nav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active"><a href="/" class="nav-link">메인</a></li>
          <li class="nav-item"><a href="stay?where=32" class="nav-link">숙소</a></li>
          <li class="nav-item"><a href="travel?where=12"class="nav-link">여행지</a></li>
          <li class="nav-item"><a href="event?where=15"class="nav-link">볼거리</a></li>
          <li class="nav-item"><a href="review" class="nav-link">리뷰</a></li>
	  <li class="nav-item"><a href="/myResSelect" class="nav-link">예약확인</a></li>
 <c:if test="${authUser.userType eq 'admin'}"> <li class="nav-item"><a href="/admin/index" class="nav-link">관리자</a></li></c:if>
          <u:notLogin>
          <li class="nav-item cta"><a href="/login" class="nav-link"><span>로그인</span></a></li>
          </u:notLogin>
          <u:isLogin>
          <li class="nav-item cta"><a href="/logout " class="nav-link"><span>로그아웃</span></a></li>
          </u:isLogin>
        </ul>
      </div>
    </div>
</nav>