<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="productDetail.title"/></title>
    <meta name="menu" content="ProductMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="productForm" action="saveProduct" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveProduct);">
        <s:hidden key="product.productId"/>
        <s:textfield cssClass="form-control" key="product.productName"/>
        <s:textfield cssClass="form-control" key="product.weight"/>
        <div class="form-group">
        	<label class="control-label" for="productForm_product_weight">Weight:</label>
        	<select name="product.standUomId" class="form-control">
				<%=request.getAttribute("uomselector") %>
			</select>
        </div>
		<s:textfield cssClass="form-control" key="price" label="价格" />
        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty product.productId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#productForm').attr('action','/saveProduct?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveProduct('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveProduct(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#productSearchForm"),$("#productPageNav").find("li[class='active']").find("a").html());
}
</script>
