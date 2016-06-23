<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.List" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="menu.partymgn"/></title>
    <meta name="menu" content="PartyMgnMenu"/>
</head>
	<div class="col-sm-12">
		<div class="panel panel-default">
		  <div class="panel-heading">党委支部党费信息<span class="text-primary"><code id="zhibuname">请先选中支部</code></span>
		  	
		  </div>
		  <form method="post" action="${ctx}/cpCharges" id="cpChargeSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#cpChargeSearchFormDiv'));">
			    <input type="hidden" name="page.pageSize"/>
		    	<input type="hidden" name="page.pageIndex"/>
			    <div id="search" class="text-right" style="margin-top:-35px;">
			        <span class="col-sm-5">
			            <input type="text" size="20" name="q" id="query" value="${param.q}"
			                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
			        </span>
			        <div id="actions" class="btn-group">
				        <button id="button.search" class="btn btn-default btn-sm" type="submit">
				            <i class="icon-search"></i> <fmt:message key="button.search"/>
				        </button>
				        <a href="#" class="btn btn-primary btn-sm" onclick="addCpChargeOper()">新增党费操作</a>
			        </div>
			    </div>
		    </form>
			<script type="text/javascript">
				if(typeof(afterSelectCpCharge) == "undefined"){
					afterSelectCpCharge = function(data){return true;};
				}
				if(typeof(beforeCpChargeFormOpen) == "undefined"){
					beforeCpChargeFormOpen = function(data){return true;};
				}
				if(typeof(afterCpChargeFormOpen) == "undefined"){
					afterCpChargeFormOpen = function(data){return true;};
				}
			</script>
		  <div class="panel-body">
		    <table class="table table-condensed table-striped table-hover table-bordered">
		    	<tr>
		    		<th>支部名称</th>
		    		<th>账户类型</th>
		    		<th>收入</th>
		    		<th>支出</th>
		    		<th>余额</th>
		    	</tr>
<%
List chargeSumList = (List)request.getAttribute("chargeSumList");
if(chargeSumList!=null && chargeSumList.size()>0){
	for(int i=0;i<chargeSumList.size();i++){
		Object[] chargeSum = (Object[])chargeSumList.get(i);
%>
				<tr>
					<td><%=chargeSum[0].toString() %></td>
					<td><%=chargeSum[2].toString() %></td>
					<td><%=chargeSum[3].toString() %></td>
					<td><%=chargeSum[4].toString() %></td>
					<td><%=chargeSum[5].toString() %></td>
				</tr>
<%
	}
}
%>
		    </table>
		    <div id="dtlinfo">
		    	<jsp:include page="/WEB-INF/pages/cpChargeList.jsp" flush="true"></jsp:include>
		    </div>
		  </div>
		</div>
	</div>
	<script type="text/javascript">
	function addCpChargeOper(){
		ajaxLoadDaialog({url:'<c:url value='/editCpCharge'/>',title:'党费操作信息',width:900,height:500,beforeDialogOpen:beforeCpChargeFormOpen,afterDialogOpen:afterCpChargeFormOpen,data:{method:'Add',from:'list'}})
	}
	</script>
