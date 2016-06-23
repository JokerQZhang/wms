<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="shipmentDetail.title"/></title>
    <meta name="menu" content="ShipmentMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="shipmentForm" action="saveShipment" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveShipment);">
        <s:hidden key="shipment.shipmentId"/>
        <s:hidden cssClass="form-control" key="shipment.facilityIdFrom"/>
        <s:hidden cssClass="form-control" key="shipment.facilityIdTo"/>
        <s:textfield cssClass="form-control" key="shipment.num"/>
        <s:hidden cssClass="form-control" key="shipment.productId"/>
        <s:hidden cssClass="form-control" key="shipment.salePlanId"/>
        <div class="form-group">
        	<label><fmt:message key="shipment.shipCarId"/></label>
        	<select name="shipment.shipCarId" class="form-control">
        		<%=request.getAttribute("shipCarOptions") %>
        	</select>
        </div>
        <s:hidden cssClass="form-control date" key="shipment.shipDate" size="11" title="date" datepicker="true"/>
        <s:hidden cssClass="form-control" key="shipment.uomId"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <!-- 
            <c:if test="${not empty shipment.shipmentId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#shipmentForm').attr('action','/saveShipment?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
             -->
            <a href="#" class="btn btn-default" onclick="afterSaveShipment('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveShipment(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#shipmentSearchForm"),$("#shipmentPageNav").find("li[class='active']").find("a").html());
}
</script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/bootstrap-datepicker/bootstrap-datepicker.min.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/bootstrap-datepicker/bootstrap-datepicker.min.js'/>"></script>
<c:if test="${pageContext.request.locale.language != 'en'}">
<script type="text/javascript" src="<c:url value='/scripts/bootstrap-datepicker/bootstrap-datepicker.zh-CN.min.js'/>"></script>
</c:if>
<script type="text/javascript">
    $(document).ready(function() {
        $('.date').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: '${pageContext.request.locale.language}'});
    });
</script>
