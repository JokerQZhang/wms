<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="com.joker.wms.model.*" %>

<head>
    <title><fmt:message key="salePlanList.title"/></title>
    <meta name="menu" content="SalePlanMenu"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>

    <form method="post" action="${ctx}/invertorys" id="invertorySearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#invertorySearchFormDiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
	    <div id="search" class="text-right" style="margin-top:0px;">
	        <input type="hidden" size="20" name="q" id="query" value="${param.q}" placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
            <select name="facilityId" class="form-control" onchange="$('#invertorySearchForm').submit();">
            	<option>请选择</option>
            	<%=request.getAttribute("facilityOptions") %>
            </select>
	    </div>
    </form>
	<script type="text/javascript">
		function modifyInvertory(productId,facilityId){
			
			ajaxLoadDaialog({url:'<c:url value='/editFacilityTransition'/>',title:'<fmt:message key="facilityTransitionDetail.heading"/>'
				,width:600,height:245,beforeDialogOpen:undefined
				,afterDialogOpen:undefined
				,data:{method:'Add',from:'list',productId:productId, facilityId:facilityId, directlyModify:'directly'}})
		}
	</script>
	<hr>
    <div id="invertorySearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>产品名称</th>
				<th>产品重量</th>
				<th>库存数量</th>
			</tr>
		</thead>
		<tbody>
<%
	List productList = (List)request.getAttribute("productList");
	Map invertoryMap = (Map)request.getAttribute("invertoryMap");
	if(productList!=null && !productList.isEmpty()){
		for(int i=0; i<productList.size(); i++){
			Product product = (Product)productList.get(i);
%>
			<tr>
				<td><%=product.getProductName() %></td>
				<td><%=product.getWeight() %></td>
				<td onclick="modifyInvertory('<%=product.getProductId() %>','<%=request.getAttribute("facilityId")%>')"><%=invertoryMap.get(product.getProductId().toString()) %></td>
			</tr>
<%
		}
	}
%>
		</tbody>
	</table>
<%
}
%>
