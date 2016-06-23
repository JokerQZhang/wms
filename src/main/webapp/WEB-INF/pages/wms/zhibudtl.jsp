<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<h4>基本情况
<span style="float:right;" class="text-primary"><code id="zhibuname">${partyGroup.groupName }</code></span>
</h4>
<div style="font-size:15px;">
	<dl class="dl-horizontal">
	  <dt>支部数</dt>
	  <dd>${villageInfo.villageType}</dd>
	  <dt>党员数</dt>
	  <dd>${villageInfo.peopleNum}</dd>
	  <dt>预备党员数</dt>
	  <dd>${villageInfo.partyNum}</dd>
	  <dt>流动党员数</dt>
	  <dd>${villageInfo.leaderNum}</dd>
	  <dt>对应行政机构</dt>
	  <dd>${villageInfo.personIncome}</dd>
	</dl>

</div>
<hr>
<h4>党员信息</h4>
<jsp:include page="/WEB-INF/pages/wms/dangpersonList.jsp" flush="true"></jsp:include>
<h4>发展党员信息</h4>
<form method="post" action="<c:url value="/wmsd/positivepersons"/>" id="positivepersonSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#positivepersonSearchFormDiv'));">
	<input type="hidden" name="page.pageSize"/>
	<input type="hidden" name="page.pageIndex"/>
	<input type="hidden" name="belongGroupId" value="${belongGroupId}"/>
	<input type="hidden" name="q"/>
	<input type="hidden" name="dang" value="dang"/>
	<input type="hidden" name="isNowDangwei" value="${isNowDangwei}"/>
</form>
<div id="positivepersonSearchFormDiv"></div>
<script type="text/javascript">
$(function(){
	$("#positivepersonSearchForm").submit();
})
</script>