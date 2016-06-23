<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="statusItemDetail.title"/></title>
    <meta name="menu" content="StatusItemMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="statusItemForm" action="saveStatusItem" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveStatusItem);">
        <s:hidden key="statusItem.statusId"/>
        <s:textfield cssClass="form-control" key="statusItem.description"/>
        <s:textfield cssClass="form-control" key="statusItem.sequenceId"/>
        <s:textfield cssClass="form-control" key="statusItem.statusCode"/>
        <s:hidden cssClass="form-control" key="statusItem.statusTypeId"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty statusItem.statusId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#statusItemForm').attr('action','/saveStatusItem?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveStatusItem('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveStatusItem(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#statusItemSearchForm"),$("#statusItemPageNav").find("li[class='active']").find("a").html());
}
</script>
