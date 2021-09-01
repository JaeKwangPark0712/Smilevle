<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>

<section class="ftco-section ftco-destination">
    	<div class="container">
    		<div class="row justify-content-start mb-5 pb-3">
          <div class="col-md-7 heading-section ftco-animate">
          	<span class="subheading">${corona.count}명</span>
            <h2 class="mb-4"><strong>코로나가 적은 여행지는?</strong>   <strong>${corona.localName}</strong></h2>
          </div>
        </div>
    		<div class="row">
    			<div class="col-md-12">
    				<div class="destination-slider owl-carousel ftco-animate">
    					<c:forEach var="travelDest" items="${travelDestList}">
    					<div class="item">
		    				<div class="destination">
		    					<a href="tourOne.do?where=32&contentId=${travelDest.contentId}" class="img d-flex justify-content-center align-items-center" 
		    					style="background-image: url(${travelDest.firstImage})"> 
		    						<div class="icon d-flex justify-content-center align-items-center">
		    							<span class="icon-search2"></span>
		    						</div>
		    					</a>
		    					<div class="text p-3">
		    						<h3><a href="tourOne.do?where=32&contentId=${travelDest.contentId}">${travelDest.title}</a></h3>
		    						<span class="listing">${travelDest.address}</span>
		    					</div>
		    				</div>
	    				</div>
						</c:forEach>
					</div>
    			</div>
    		</div>
    	</div>
    </section>