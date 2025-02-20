<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="ftco-section bg-light">
<div class="container">
		<div class="row justify-content-start mb-5 pb-3">
			<div class="col-md-7 heading-section ftco-animate">
				<span class="subheading">Special Offers</span>
				<h2 class="mb-4">
					<strong>주위에 있는 핫 플레이스</strong> view
				</h2>
			</div>
		</div>
		<div class="col-lg-12">
          	<div class="row">
				<c:forEach var="item" items="${itemList}">
					<div class="col-md-4 ftco-animate">
		    				<div class="destination width-middle">
		    					<a href="tourOne?where=${item.areaCode}&contentId=${item.contentId}" class="img img-2 d-flex justify-content-center align-items-center" style="background-image: url(${item.firstImage});">
		    						<div class="icon d-flex justify-content-center align-items-center">
    							<span class="icon-search2"></span>
    						</div>
		    					</a>
		    					<div class="text p-3">
		    						<div class="d-flex">
		    							<div class="one">
				    						<h3><a href="tourOne?where=${item.areaCode}&contentId=${item.contentId}">${item.title}</a></h3>
			    						</div>
			    						<div class="two">
			   
		    							</div>
		    						</div>
		    						<p><span>${item.address}</span></p>
		    					</div>
		    				</div>
		    			</div>
				</c:forEach>
			</div>
		</div>
	</div>
</section>