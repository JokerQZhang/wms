<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="uomDetail.title"/></title>
    <meta name="menu" content="UomMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="uomForm" action="saveUom" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveUom);">
        <s:hidden key="uom.uomId"/>
        <s:textfield cssClass="form-control" key="uom.abbreviation"/>
        <s:textfield cssClass="form-control" key="uom.description"/>
        <s:textfield cssClass="form-control" key="uom.sequenceId"/>
        <s:hidden cssClass="form-control" key="uom.uomTypeId"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty uom.uomId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#uomForm').attr('action','/saveUom?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveUom('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveUom(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#uomSearchForm"),$("#uomPageNav").find("li[class='active']").find("a").html());
}
</script>
