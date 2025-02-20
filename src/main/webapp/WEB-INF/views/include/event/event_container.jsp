<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="ftco-section">
	<div class="container-fluid">
		<div class="row justify-content-start mb-5 pb-3">
			<div class="col-md-7 heading-section ftco-animate">
				<h2 class="mb-4">
					<strong>즐길 수 있는 볼거리는?</strong> Event
				</h2>
			</div>
		</div>
		<div class="owl-stage">
			<div class="row">
				<c:forEach var="event" items="${eventList}">
					<div class="col-md-6 col-lg-3 ftco-animate">
						<div class="destination">
							<a href="tourOne?where=32&contentId=${event.contentId}"
								class="img img-2 d-flex justify-content-center align-items-center"
								style="border: 1px solid #dee2e6; background-image: url(${event.firstImage});">
								<div
									class="icon d-flex justify-content-center align-items-center">
									<span class="icon-search2"></span>
								</div>
							</a>
							<div class="text p-3">
								<h3>
									<a href="tourOne?where=32&contentId=${event.contentId}">${event.title}</a>
								</h3>
								<p>${event.address}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</section>