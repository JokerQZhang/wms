<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="uomTypeDetail.title"/></title>
    <meta name="menu" content="UomTypeMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="uomTypeForm" action="saveUomType" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveUomType);">
        <s:hidden key="uomType.uomTypeId"/>
        <s:textfield cssClass="form-control" key="uomType.description"/>
        <s:textfield cssClass="form-control" key="uomType.hasTable"/>
        <s:textfield cssClass="form-control" key="uomType.parentId"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty uomType.uomTypeId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#uomTypeForm').attr('action','/saveUomType?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveUomType('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveUomType(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#uomTypeSearchForm"),$("#uomTypePageNav").find("li[class='active']").find("a").html());
}
</script>
