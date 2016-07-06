<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<ul>
	<c:forEach items="${moniteSites}" var="moniteSite">
		<li class="parent_li">
			<span onclick="selectGeo('${moniteSite.siteId}',3)" class="badge btn-warning"><i class="fa fa-fw fa-sitemap"></i> ${moniteSite.sitName}</span>
		</li>
	</c:forEach>
</ul>