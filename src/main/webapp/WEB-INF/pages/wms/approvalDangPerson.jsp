<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<dl class="dl-horizontal">
	<dt>姓名</dt>
	<dd>${person.name}</dd>
	<dt>性别</dt>
	<dd>${person.gender}</dd>
	<dt>身份证号</dt>
	<dd>${person.cardId}</dd>
	<dt>状态改变</dt>
	<dd>
		<c:if test="${cpDtl.statusId=='4'}">入党积极分子--><code>发展对象</code></c:if>
		<c:if test="${cpDtl.statusId=='3'}">发展对象--><code>预备党员</code></c:if>
		<c:if test="${cpDtl.statusId=='2'}">预备党员--><code>正式党员</code></c:if>
	</dd>
</dl>
<div class="col-sm-12">
	<input name="apartyId" type="hidden" value="${person.partyId}">
	<input name="aresultStatus" type="hidden" value="${cpDtl.statusId}">
	<div class="form-group col-sm-6">
		<label>总票数</label>
		<input class="form-control" name="totalNum" type="text">
	</div>
	<div class="form-group col-sm-6">
		<label>赞成票数</label>
		<input class="form-control" name="approvalNum" type="text">
	</div>
	<div class="form-group col-sm-11">
		<label>投票结果</label>
		通过<input name="approvalResult" type="radio" value="1">未通过<input name="approvalResult" type="radio" value="0">
	</div>
	<div class="form-group col-sm-11">
		<button class="btn btn-primary btn-sm" onclick="submitApproval()">保存</button>
	</div>
</div>
<script type="text/javascript">
function submitApproval(){
	var partyId = $("input[name='apartyId']").val();
	var resultStatus = $("input[name='aresultStatus']").val();
	var approvalNum = $("input[name='approvalNum']").val();
	var totalNum = $("input[name='totalNum']").val();
	var approvalResult = $("input[name='approvalResult']:checked").val();
	$.ajax({
		url:"<c:url value='/wmsd/approvalDangPersonSave'/>",
		type:"post",
		data:{partyId:partyId,resultStatus:resultStatus,approvalNum:approvalNum,totalNum:totalNum,approvalResult:approvalResult},
		success:function(data){
			alert(data);
			$("#jokerdialogframexixi").dialog("destroy").remove();
		} 
	});
}
</script>
