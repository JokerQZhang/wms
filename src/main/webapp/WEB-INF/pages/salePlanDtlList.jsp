<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="com.joker.wms.model.*" %>
<%@ page import="java.math.BigDecimal" %>
<head>
    <title><fmt:message key="salePlanDtlList.title"/></title>
    <meta name="menu" content="SalePlanDtlMenu"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>
    <h2><fmt:message key="salePlanDtlList.heading"/></h2>

    <form method="post" action="${ctx}/salePlanDtls" id="salePlanDtlSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#salePlanDtlSearchFormDiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
    	<input type="hidden" name="salePlanId">
	    <div id="search" class="text-right">
	        
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectSalePlanDtl) == "undefined"){
			afterSelectSalePlanDtl = function(data){return true;};
		}
		if(typeof(beforeSalePlanDtlFormOpen) == "undefined"){
			beforeSalePlanDtlFormOpen = function(data){return true;};
		}
		if(typeof(afterSalePlanDtlFormOpen) == "undefined"){
			afterSalePlanDtlFormOpen = function(data){return true;};
		}
		function modifyPlanDtl(salePlanDtlId){
			ajaxLoadDaialog({url:'<c:url value='/editSalePlanDtl'/>'
				,title:'<fmt:message key="salePlanDtlDetail.heading"/>'
				,width:600,height:315,beforeDialogOpen:beforeSalePlanDtlFormOpen,afterDialogOpen:afterSalePlanDtlFormOpen
				,data:{salePlanDtlId:salePlanDtlId,from:'list'}});
		}
	</script>
    <p><fmt:message key="salePlanDtlList.message"/></p>
    <div id="salePlanDtlSearchFormDiv"></div>
<%
}else{
	Map facilityMap = (Map)request.getAttribute("facilityMap");
    Map productMap = (Map)request.getAttribute("productMap");
    Map salePlanMap = (Map)request.getAttribute("salePlanMap");
    Map invertoryMap = (Map)request.getAttribute("invertoryMap");
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>客户</th>
<%
	if(productMap!=null && !productMap.isEmpty()){
		for(Object pkey : productMap.keySet()){
			Product oProduct = (Product)productMap.get(pkey);
%>
				<th><%=oProduct.getProductName() %></th>
<%
		}
	}
%>
			</tr>
		</thead>
		<tbody>
<%
	if(facilityMap!=null && !facilityMap.isEmpty()){
		Map<Long, BigDecimal> sumpdnum = new HashMap<Long, BigDecimal>();
		for(Object fkey : facilityMap.keySet()){
			Facility oFacility = (Facility)facilityMap.get(fkey);
%>
			<tr>
				<td><%=oFacility.getFacilityName() %></td>
<%
			for(Object pkey : productMap.keySet()){
				Product oProduct = (Product)productMap.get(pkey);
				String keyFPPlan = oFacility.getFacilityId() + "-" + oProduct.getProductId();
				SalePlanDtl oSalePlanDtl = (SalePlanDtl)salePlanMap.get(keyFPPlan);
				if(sumpdnum.containsKey(oProduct.getProductId())){
					sumpdnum.put(oProduct.getProductId(), oSalePlanDtl.getNum().add(sumpdnum.get(oProduct.getProductId())));
				}else{
					sumpdnum.put(oProduct.getProductId(), oSalePlanDtl.getNum());
				}
%>
				<td onclick="modifyPlanDtl('<%=oSalePlanDtl.getSalePlanDtlId() %>')"><%=oSalePlanDtl.getNum() %></td>
<%
			}
%>
			</tr>
<%
		}
		if(!sumpdnum.isEmpty()){
%>
			<tr class="warning">
				<td>出库合计</td>
<%
			for(Object pkey : productMap.keySet()){
				Product oProduct = (Product)productMap.get(pkey);
%>
				<td><%=sumpdnum.get(oProduct.getProductId()) %></td>
<%
			}
%>
			</tr>
<%
		}
	}
	if(invertoryMap!=null && !invertoryMap.isEmpty()){
%>
			<tr class="danger">
				<td>总库存</td>
<%
		for(Object pkey : productMap.keySet()){
			Product oProduct = (Product)productMap.get(pkey);
%>
				<td><%=invertoryMap.get(oProduct.getProductId().toString()) %></td>
<%
		}
%>
			</tr>
<%
	}
%>
		</tbody>
	</table>
<%
}
%>
