<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="activeUsers.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>
	<div class="col-sm-5">
		<div class="panel panel-default">
		  <div class="panel-heading">Panel heading without title</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/partyRelationshipTypeList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<div class="col-sm-7">
		<div class="panel panel-default">
		  <div class="panel-heading">Panel heading without title</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/partyRelationshipList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		
	})
	</script>
