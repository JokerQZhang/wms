<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="statusValidChangeDetail.title"/></title>
    <meta name="menu" content="StatusValidChangeMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="statusValidChangeForm" action="saveStatusValidChange" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveStatusValidChange);">
        <s:hidden key="statusValidChange.svcId"/>
        <s:textfield cssClass="form-control" key="statusValidChange.conditionExpression"/>
        <s:textfield cssClass="form-control" key="statusValidChange.statusIdFrom"/>
        <s:textfield cssClass="form-control" key="statusValidChange.statusIdTo"/>
        <s:textfield cssClass="form-control" key="statusValidChange.transitionName"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty statusValidChange.svcId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#statusValidChangeForm').attr('action','/saveStatusValidChange?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveStatusValidChange('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveStatusValidChange(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#statusValidChangeSearchForm"),$("#statusValidChangePageNav").find("li[class='active']").find("a").html());
}
</script>
