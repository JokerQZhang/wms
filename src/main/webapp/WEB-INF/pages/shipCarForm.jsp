<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="shipCarDetail.title"/></title>
    <meta name="menu" content="ShipCarMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="shipCarForm" action="saveShipCar" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveShipCar);">
        <s:hidden key="shipCar.shipCarId"/>
        <s:textfield cssClass="form-control" key="shipCar.carCardId"/>
        <s:textfield cssClass="form-control" key="shipCar.conName"/>
        <s:textfield cssClass="form-control" key="shipCar.conPhone"/>
        <s:textfield cssClass="form-control" key="shipCar.loadWeight"/>
        <s:textfield cssClass="form-control" key="shipCar.typeName"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty shipCar.shipCarId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#shipCarForm').attr('action','/saveShipCar?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveShipCar('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveShipCar(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#shipCarSearchForm"),$("#shipCarPageNav").find("li[class='active']").find("a").html());
}
</script>
