<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="tzZtjjDetail.title"/></title>
    <meta name="menu" content="TzZtjjMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="tzZtjjForm" action="saveTzZtjj" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveTzZtjj);">
        <s:hidden key="tzZtjj.ztjjId"/>
        <s:hidden key="tzZtjj.groupPartyId"/>
        <div class="form-group col-sm-12" style="display:none;">
        	<label><fmt:message key="tzZtjj.tzDate"/></label>
        	<input class="form-control" type="text" name="tzZtjj.tzDate" value="${tzZtjj.tzDate}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">制定村级发展规划情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzZtjj.zdcjfzghName"/></label>
        	<input class="form-control" type="text" name="tzZtjj.zdcjfzghName" value="${tzDhbz.tzDate}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzZtjj.zdcjfzghStatus"/></label>
        	<input class="form-control" type="text" name="tzZtjj.zdcjfzghStatus" value="${tzZtjj.zdcjfzghStatus}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">协调资金、项目、信息情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzZtjj.xtzjxmType"/></label>
        	<input class="form-control" type="text" name="tzZtjj.xtzjxmType" value="${tzZtjj.xtzjxmType}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzZtjj.xtzjxmPurpose"/></label>
        	<input class="form-control" type="text" name="tzZtjj.xtzjxmPurpose" value="${tzZtjj.xtzjxmPurpose}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">培养致富能手情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzZtjj.pyzfnsName"/></label>
        	<input class="form-control" type="text" name="tzZtjj.pyzfnsName" value="${tzZtjj.pyzfnsName}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzZtjj.pyzfnsSkill"/></label>
        	<input class="form-control" type="text" name="tzZtjj.pyzfnsSkill" value="${tzZtjj.pyzfnsSkill}"/>
        </div>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty tzZtjj.ztjjId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#tzZtjjForm').attr('action','/saveTzZtjj?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveTzZtjj(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#tzZtjjSearchForm"),$("#tzZtjjPageNav").find("li[class='active']").find("a").html());
}
</script>
