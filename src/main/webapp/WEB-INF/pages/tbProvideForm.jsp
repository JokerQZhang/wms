<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="tbProvideDetail.title"/></title>
    <meta name="menu" content="TbProvideMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="tbProvideForm" action="saveTbProvide" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveTbProvide);">
        <s:hidden key="tbProvide.provideId"/>
        <s:hidden cssClass="form-control" key="tbProvide.departmentId"/>
        <div class="form-group">
	   	  <label>民政优抚类型</label>
	      <select class="form-control" name="yfTypeId" onchange="changeProvideName(this)">
	      	<c:forEach items="${yftypes}" var="yftype">
	      		<option value="${yftype[1].enumId}">
	      			${yftype[0].description}/${yftype[1].description}/${yftype[1].enumCode}
	      		</option>
	      	</c:forEach>
	      </select>
	    </div>
        <div class="form-group">
        	<label><fmt:message key="tbProvide.provideDate"/></label>
        	<input class="form-control" type="text" name="tbProvide.provideDate" value="${nowDate}"/>
        </div>
        <s:textfield cssClass="form-control" key="tbProvide.provideName" readonly="true"/>
        <s:hidden cssClass="form-control" key="tbProvide.provideSum"/>
        <s:hidden cssClass="form-control" key="tbProvide.validFlag"/>
		<input type="hidden" name="tempprovideName" value="${tempprovideName}">
        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty tbProvide.provideId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#tbProvideForm').attr('action','/saveTbProvide?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveTbProvide('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
$(function(){
	var provideName = $("input[name='tempprovideName']").val();
	var nowPType = $("select[name='yfTypeId']").find("option:first").text().trim();
	$("input[name='tbProvide.provideName']").val(provideName + nowPType);
});
function afterSaveTbProvide(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#tbProvideSearchForm"),$("#tbProvidePageNav").find("li[class='active']").find("a").html());
}
function changeProvideName(select){
	var nowPType = $(select).find("option:selected").text().trim();
	var provideName = $("input[name='tempprovideName']").val();
	$("input[name='tbProvide.provideName']").val(provideName + nowPType);
}
</script>
