<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigInteger" %>
<h4>${partyGroup.groupName }党费信息
<span style="float:right;" class="text-primary"><code id="zhibuname">${partyGroup.groupName }</code></span>
</h4>
<%
List chargeSumList = (List)request.getAttribute("chargeSumList");
Object[] dangfei = {0,0,0,0,0,0};
Object[] bokuan = {0,0,0,0,0,0};
if(chargeSumList!=null && chargeSumList.size()>0){
	for(int i=0;i<chargeSumList.size();i++){
		Object[] chargeSum = (Object[])chargeSumList.get(i);
		BigInteger accountType = (BigInteger)chargeSum[1];
		if(accountType!=null && accountType.toString().equals("26")){
			dangfei = chargeSum;
		}
		if(accountType!=null && accountType.toString().equals("27")){
			bokuan = chargeSum;
		}
	}
}
%>
<div style="font-size:15px;">
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th colspan="2">收入</th>
				<th colspan="2">支出</th>
				<th colspan="2">余额</th>
			</tr>
			<tr>
				<th>党费收入</th>
				<th>上级拨入</th>
				<th>上缴党费</th>
				<th>下拨党费</th>
				<th>党费账户</th>
				<th>拨入账户</th>
			</tr>
			<tr>
				<td><%=String.valueOf(dangfei[3]) %></td>
				<td><%=String.valueOf(bokuan[3]) %></td>
				<td><%=String.valueOf(dangfei[4]) %></td>
				<td><%=String.valueOf(bokuan[4]) %></td>
				<td><%=String.valueOf(dangfei[5]) %></td>
				<td><%=String.valueOf(bokuan[5]) %></td>
			</tr>
		</thead>
	</table>
</div>
<hr>
<h4>党费操作明细信息</h4>
<jsp:include page="/WEB-INF/pages/cpChargeList.jsp" flush="true"></jsp:include>
