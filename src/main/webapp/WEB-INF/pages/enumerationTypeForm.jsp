<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="enumerationTypeDetail.title"/></title>
    <meta name="menu" content="EnumerationTypeMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="enumerationTypeForm" action="saveEnumerationType" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveEnumerationType);">
        <s:hidden key="enumerationType.enumTypeId"/>
        <s:textfield cssClass="form-control" key="enumerationType.description"/>
        <s:hidden cssClass="form-control" key="enumerationType.hasTable"/>
        <s:textfield cssClass="form-control" key="enumerationType.parentTypeId"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty enumerationType.enumTypeId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#enumerationTypeForm').attr('action','/saveEnumerationType?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveEnumerationType('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveEnumerationType(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#enumerationTypeSearchForm"),$("#enumerationTypePageNav").find("li[class='active']").find("a").html());
}
</script>
