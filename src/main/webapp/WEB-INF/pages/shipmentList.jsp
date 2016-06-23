<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="com.joker.wms.model.*" %>
<%@ page import="java.math.BigDecimal" %>

<head>
    <title><fmt:message key="shipmentList.title"/></title>
    <meta name="menu" content="ShipmentMenu"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>
    <h2><fmt:message key="shipmentList.heading"/></h2>

    <form method="post" action="${ctx}/shipments" id="shipmentSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#shipmentSearchFormDiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
    	<input type="hidden" name="salePlanId">
	    <div id="search" class="text-right">
	    	<a class="btn btn-default btn-sm" onclick="shipit()">发货</a>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectShipment) == "undefined"){
			afterSelectShipment = function(data){return true;};
		}
		if(typeof(beforeShipmentFormOpen) == "undefined"){
			beforeShipmentFormOpen = function(data){return true;};
		}
		if(typeof(afterShipmentFormOpen) == "undefined"){
			afterShipmentFormOpen = function(data){return true;};
		}
		function modifyShipment(shipmentId){
			ajaxLoadDaialog({url:'<c:url value='/editShipment'/>',title:'<fmt:message key="shipmentDetail.heading"/>'
				,width:600,height:315,beforeDialogOpen:beforeShipmentFormOpen,afterDialogOpen:afterShipmentFormOpen
				,data:{shipmentId:shipmentId,from:'list'}})
		}
		function shipit(){
			var salePlanId = $("input[name='salePlanId']").val();
			if(salePlanId==null || salePlanId==""){
				alert("请先选择需要发货的销售计划！");
				return false;
			}
			if(!confirm("确认发货以后所有货运信息和计划信息将不再允许修改，您确认进行发货操作？")){
				return false;
			}
			$.ajax({
				url:'<c:url value='/dialog/shipSalePlan'/>'
				,type:'post'
				,data:{"salePlan.salePlanId":salePlanId}
				,success:function(data){
					alert(data);
				}
			});
		}
	</script>
    <p><fmt:message key="shipmentList.message"/></p>
    <div id="shipmentSearchFormDiv"></div>
<%
}else{
	Map facilityMap = (Map)request.getAttribute("facilityMap");
    Map productMap = (Map)request.getAttribute("productMap");
    Map shipmentMap = (Map)request.getAttribute("shipmentMap");
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
				Shipment oShipment = (Shipment)shipmentMap.get(keyFPPlan);
				if(sumpdnum.containsKey(oProduct.getProductId())){
					sumpdnum.put(oProduct.getProductId(), oShipment.getNum().add(sumpdnum.get(oProduct.getProductId())));
				}else{
					sumpdnum.put(oProduct.getProductId(), oShipment.getNum());
				}
%>
				<td onclick="modifyShipment('<%=oShipment.getShipmentId() %>')"><%=oShipment.getNum() %></td>
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
