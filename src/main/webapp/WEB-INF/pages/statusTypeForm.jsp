<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="statusTypeDetail.title"/></title>
    <meta name="menu" content="StatusTypeMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="statusTypeForm" action="saveStatusType" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveStatusType);">
        <s:hidden key="statusType.statusTypeId"/>
        <s:textfield cssClass="form-control" key="statusType.description"/>
        <s:textfield cssClass="form-control" key="statusType.hasTable"/>
        <s:textfield cssClass="form-control" key="statusType.parentId"/>
        <s:textfield cssClass="form-control" key="statusType.sequenceId"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty statusType.statusTypeId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#statusTypeForm').attr('action','/saveStatusType?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveStatusType('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveStatusType(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#statusTypeSearchForm"),$("#statusTypePageNav").find("li[class='active']").find("a").html());
}
</script>
