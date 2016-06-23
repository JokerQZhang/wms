<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.joker.wms.model.Product" %>
<%@ page import="com.joker.wms.model.Price" %>
<%@ include file="/common/taglibs.jsp" %>

<%
List productPriceList = (List)request.getAttribute("productPriceList");
List dateList = (List)request.getAttribute("dateList");
String showData = (String)request.getAttribute("showData");
if(showData==null || showData.equals("")){
%>
<head>
    <title><fmt:message key="activeUsers.title"/></title>
    <meta name="menu" content="FacilityMgnMenu"/>
</head>
	<h2>价格列表</h2>
	<form method="post" action="${ctx}/pricesset" id="priceSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#pricelist'));">
		<div id="search" class="text-right">
	        <span class="col-sm-12" style="font-size:62.5%">
	        	<input type="text" size="14" name="lastdate" id="lastdate" value="${lastdate}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        	<select name="groupId">
		        	<%=request.getAttribute("pgoptions") %>
		        </select>
	            
	            <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="icon-search"></i> <fmt:message key="button.search"/>
		        </button>
	        </span>
	        
	        
	    </div>
	</form>
	<div id="pricelist">
<%
}
%>
		<table class="table table-condensed table-striped table-hover table-bordered">
			<thead>
			<tr>
				<th>产品</th>
				<th>重量</th>
<%
if(dateList!=null && dateList.size()>0){
	for(int i=dateList.size()-1; i>=0; i--){
%>
				<th><%=(String)dateList.get(i) %></th>
<%
	}
}
%>
			</tr>
			</thead>
<%
if(productPriceList!=null && productPriceList.size()>0){
	for(int i=0; i<productPriceList.size(); i++){
%>
			<tr>
<%
		Map p2p = (Map)productPriceList.get(i);
		Product proset = (Product)(p2p.keySet().toArray()[0]);
		List priceDayList = (List)p2p.get(proset);
%>
				<td><%=proset.getProductName() %></td>
				<td><%=proset.getWeight() %></td>
<%
		for(int j=0; j<priceDayList.size(); j++){
			Price price = (Price)priceDayList.get(j);
			String backdate = (String)dateList.get(6-j);
%>
				<td onclick="modifyPrice('<%=price.getPriceId()%>','<%=proset.getProductName() %>','<%=backdate%>')"><%=price.getPrice() %></td>
<%
		}
	}
%>
			</tr>
<%
}
%>
		</table>
<%
if(showData==null || showData.equals("")){
%>
	</div>
	<script type="text/javascript">
	$(function(){
		$("select[name='groupId']").combobox();
	});
	function modifyPrice(priceId,productName,priceDate){
		var groupId = $("select[name='groupId']").val();
		ajaxLoadDaialog({url:"<c:url value='/editPrice'/>",title:'价格修改',width:500,height:270,beforeDialogOpen:undefined,afterDialogOpen:undefined,data:{priceId:priceId,productName:productName,priceDate:priceDate,groupId:groupId}});
	}
	</script>
<%
}
%>