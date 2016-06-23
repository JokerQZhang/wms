<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="tbProvideDtlDetail.title"/></title>
    <meta name="menu" content="TbProvideDtlMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="tbProvideDtlForm" action="saveTbProvideDtl" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveTbProvideDtl);">
        <s:hidden key="tbProvideDtl.provideDtlId"/>
        <s:textfield cssClass="form-control" key="tbProvideDtl.createdByUser"/>
        <s:textfield cssClass="form-control" key="tbProvideDtl.createdTime"/>
        <s:textfield cssClass="form-control" key="tbProvideDtl.enumId"/>
        <s:textfield cssClass="form-control" key="tbProvideDtl.lastUpdatedByUser"/>
        <s:textfield cssClass="form-control" key="tbProvideDtl.lastUpdatedTime"/>
        <s:textfield cssClass="form-control" key="tbProvideDtl.peopleId"/>
        <s:textfield cssClass="form-control" key="tbProvideDtl.provideId"/>
        <s:textfield cssClass="form-control" key="tbProvideDtl.provideMoney"/>
        <s:textfield cssClass="form-control" key="tbProvideDtl.validFlag"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty tbProvideDtl.provideDtlId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#tbProvideDtlForm').attr('action','/saveTbProvideDtl?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveTbProvideDtl('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveTbProvideDtl(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#tbProvideDtlSearchForm"),$("#tbProvideDtlPageNav").find("li[class='active']").find("a").html());
}
</script>
