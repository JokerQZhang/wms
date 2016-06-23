<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="salePlanDtlDetail.title"/></title>
    <meta name="menu" content="SalePlanDtlMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="salePlanDtlForm" action="saveSalePlanDtl" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveSalePlanDtl);">
        <s:hidden key="salePlanDtl.salePlanDtlId"/>
        <s:hidden cssClass="form-control" key="salePlanDtl.facilityIdFrom"/>
        <s:hidden cssClass="form-control" key="salePlanDtl.facilityIdTo"/>
        <s:textfield cssClass="form-control" key="salePlanDtl.num"/>
        <s:hidden cssClass="form-control" key="salePlanDtl.productId"/>
        <s:hidden cssClass="form-control" key="salePlanDtl.salePlanId"/>
        <s:textfield cssClass="form-control" key="salePlanDtl.toSequenceId"/>
        <s:hidden cssClass="form-control" key="salePlanDtl.uomId"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <!-- 
            <c:if test="${not empty salePlanDtl.salePlanDtlId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#salePlanDtlForm').attr('action','/saveSalePlanDtl?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            -->
            <a href="#" class="btn btn-default" onclick="afterSaveSalePlanDtl('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveSalePlanDtl(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#salePlanDtlSearchForm"),$("#salePlanDtlPageNav").find("li[class='active']").find("a").html());
}
</script>
