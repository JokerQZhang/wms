<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="uomConversionDetail.title"/></title>
    <meta name="menu" content="UomConversionMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="uomConversionForm" action="saveUomConversion" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveUomConversion);">
        <s:hidden key="uomConversion.uomConversionId"/>
        <s:textfield cssClass="form-control" key="uomConversion.uomIdFrom"/>
        <s:textfield cssClass="form-control" key="uomConversion.conversionFactor"/>
        <s:textfield cssClass="form-control" key="uomConversion.uomIdTo"/>
        <s:textfield cssClass="form-control" key="uomConversion.roundingMode"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty uomConversion.uomConversionId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#uomConversionForm').attr('action','/saveUomConversion?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveUomConversion('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveUomConversion(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#uomConversionSearchForm"),$("#uomConversionPageNav").find("li[class='active']").find("a").html());
}
</script>
