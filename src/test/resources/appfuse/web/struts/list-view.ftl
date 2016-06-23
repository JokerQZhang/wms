<#assign pojoNameLower = pojo.shortName.substring(0,1).toLowerCase()+pojo.shortName.substring(1)>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="${pojoNameLower}List.title"/></title>
	    <meta name="menu" content="${pojo.shortName}Menu"/>
	    <meta name="title.name" content="<fmt:message key="${pojoNameLower}List.heading"/>"/>
	</head>
	<#--
    <h2><fmt:message key="${pojoNameLower}List.heading"/></h2>
	-->
    <form method="post" action="${'$'}{ctx}/${util.getPluralForWord(pojoNameLower)}" id="${pojoNameLower}SearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#${pojoNameLower}SearchFormDiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
	    <div id="search" class="text-right">
	        <span class="col-sm-9">
	            <input type="text" size="20" name="q" id="query" value="${'$'}{param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        </span>
	        <div id="actions" class="btn-group">
		        <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="icon-search"></i> <fmt:message key="button.search"/>
		        </button>
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/edit${pojo.shortName}'/>',title:'<fmt:message key="${pojoNameLower}Detail.heading"/>',width:600,height:500,beforeDialogOpen:before${pojo.shortName}FormOpen,afterDialogOpen:after${pojo.shortName}FormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelect${pojo.shortName}) == "undefined"){
			afterSelect${pojo.shortName} = function(data){return true;};
		}
		if(typeof(before${pojo.shortName}FormOpen) == "undefined"){
			before${pojo.shortName}FormOpen = function(data){return true;};
		}
		if(typeof(after${pojo.shortName}FormOpen) == "undefined"){
			after${pojo.shortName}FormOpen = function(data){return true;};
		}
	</script>
	<#--
    <p><fmt:message key="${pojoNameLower}List.message"/></p>
    -->
    <div id="${pojoNameLower}SearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
<#foreach field in pojo.getAllPropertiesIterator()>
<#if !c2h.isCollection(field) && !c2h.isManyToOne(field) && !c2j.isComponent(field)>
				<th><fmt:message key="${pojoNameLower}.${field.name}"/></th>
</#if>
</#foreach>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${'$'}{${util.getPluralForWord(pojoNameLower)}}" var="${pojoNameLower}">
				<tr onclick="commonTableListSelect(this,afterSelect${pojo.shortName})">
<#foreach field in pojo.getAllPropertiesIterator()>
<#if field.equals(pojo.identifierProperty)>
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/edit${pojo.shortName}'/>',title:'<fmt:message key="${pojoNameLower}Detail.heading"/>',width:600,height:500,beforeDialogOpen:before${pojo.shortName}FormOpen,afterDialogOpen:after${pojo.shortName}FormOpen,data:{${field.name}:'${'$'}{${pojoNameLower}.${field.name}}',from:'list'}})">${'$'}{${pojoNameLower}.${field.name}}</a></td>
					
<#elseif !c2h.isCollection(field) && !c2h.isManyToOne(field) && !c2j.isComponent(field)>
					<td>${'$'}{${pojoNameLower}.${field.name}}</td>
</#if>
</#foreach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${'$'}{page.allRecordNum > page.pageSize}">
		<nav id="${pojoNameLower}PageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage(${'$'}('#${pojoNameLower}SearchForm'),'${'$'}{page.pageIndex-1}')">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    
			<c:set var="minpage" scope="page" value="${'$'}{page.pageIndex-2}"></c:set>
			<c:if test="${'$'}{minpage<1 || page.pageNum<=5}">
				<c:set var="minpage" scope="page" value="1"></c:set>
			</c:if>
			<c:set var="maxpage" scope="page" value="${'$'}{minpage+4}"></c:set>
			<c:if test="${'$'}{maxpage>page.pageNum}">
				<c:set var="maxpage" scope="page" value="${'$'}{page.pageNum}"></c:set>
				<c:if test="${'$'}{maxpage>5}">
					<c:set var="minpage" scope="page" value="${'$'}{maxpage-4}"></c:set>
				</c:if>
			</c:if>
			<c:forEach begin="${'$'}{minpage}" end="${'$'}{maxpage}" var="i">
				<li ${'$'}{i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage(${'$'}('#${pojoNameLower}SearchForm'),'${'$'}{i}')">${'$'}{i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage(${'$'}('#${pojoNameLower}SearchForm'),'${'$'}{page.pageIndex+1}')">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		    <li><span><fmt:message key="page.pagetitle"><fmt:param value="${'$'}{page.pageNum}"/><fmt:param value="${'$'}{page.allRecordNum}"/></fmt:message></span></li>
		  </ul>
		</nav>
	</c:if>
<%
}
%>
