<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="enumerationDetail.title"/></title>
    <meta name="menu" content="EnumerationMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="enumerationForm" action="saveEnumeration" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveEnumeration);">
        <s:hidden key="enumeration.enumId"/>
        <s:textfield cssClass="form-control" key="enumeration.description"/>
        <s:textfield cssClass="form-control" key="enumeration.enumCode"/>
        <s:hidden cssClass="form-control" key="enumTypeId"/>
        <!-- todo: change this to read the identifier field from the other pojo -->
        <s:textfield cssClass="form-control" key="enumeration.sequenceId"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty enumeration.enumId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#enumerationForm').attr('action','/saveEnumeration?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveEnumeration('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveEnumeration(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#enumerationSearchForm"),$("#enumerationPageNav").find("li[class='active']").find("a").html());
}
</script>
