<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="priceDetail.title"/></title>
    <meta name="menu" content="PriceMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="priceForm" action="savePrice" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSavePrice);">
        <s:hidden key="price.priceId"/>
        <s:hidden key="groupId"/>
        <s:hidden key="priceDate"/>
        <input type="hidden" name="isdaypriceedit" value="${isdaypriceedit}"/>
        <s:hidden cssClass="form-control" key="price.fromDate"/>
        <s:hidden cssClass="form-control" key="price.priceType"/>
        <s:hidden cssClass="form-control" key="price.priceUomId"/>
        <s:hidden cssClass="form-control" key="price.productId"/>
        <s:hidden cssClass="form-control" key="price.thruDate"/>
        <s:hidden cssClass="form-control" key="price.partyId"/>
		<label class="control-label">产品名称：${productName }</label>
		<label class="control-label">价格日期：${priceDate }</label>
		<s:textfield cssClass="form-control" key="price.price"/>
        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty price.priceId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#priceForm').attr('action','/savePrice?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSavePrice('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSavePrice(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#priceSearchForm"),$("#pricePageNav").find("li[class='active']").find("a").html());
}
</script>
