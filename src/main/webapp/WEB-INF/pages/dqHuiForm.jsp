<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="wmsHuiDetail.title"/></title>
    <meta name="menu" content="wmsHuiMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="wmsHuiForm" action="savewmsHui" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSavewmsHui);">
        <s:hidden key="wmsHui.huiId"/>
        <div class="form-group col-sm-12">
        	<label><fmt:message key="wmsHui.title"/></label>
        	<input class="form-control" type="text" name="wmsHui.title" value="${wmsHui.title}"/>
        </div>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="wmsHui.huiType"/></label>
        	<select class="form-control" name="wmsHui.huiType" value="${wmsHui.huiType}">
        	<%=request.getAttribute("huiTypeStr") %>
        	</select>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="wmsHui.huiTime"/></label>
        	<input class="form-control" type="text" name="wmsHui.huiTime" value="${wmsHui.huiTime}"/>
        </div>
        <script type="text/javascript">
        $(document).ready(function() {
        	getDatePicker($("input[name='wmsHui.huiTime']"));
	    });
        </script>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="wmsHui.huiMaster"/></label>
        	<input class="form-control" type="text" name="wmsHui.huiMaster" value="${wmsHui.huiMaster}"/>
        </div>
        <div class="form-group col-sm-5">
        	<label><fmt:message key="wmsHui.huiAddress"/></label>
        	<input class="form-control" type="text" name="wmsHui.huiAddress" value="${wmsHui.huiAddress}"/>
        </div>
        
        <div class="form-group col-sm-2">
        	<label><fmt:message key="wmsHui.huiRecorder"/></label>
        	<input class="form-control" type="text" name="wmsHui.huiRecorder" value="${wmsHui.huiRecorder}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="wmsHui.numAbsent"/></label>
        	<input class="form-control" type="text" name="wmsHui.numAbsent" value="${wmsHui.numAbsent}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="wmsHui.numAbsentParty"/></label>
        	<input class="form-control" type="text" name="wmsHui.numAbsentParty" value="${wmsHui.numAbsentParty}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="wmsHui.numParty"/></label>
        	<input class="form-control" type="text" name="wmsHui.numParty" value="${wmsHui.numParty}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="wmsHui.numReal"/></label>
        	<input class="form-control" type="text" name="wmsHui.numReal" value="${wmsHui.numReal}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="wmsHui.numShould"/></label>
        	<input class="form-control" type="text" name="wmsHui.numShould" value="${wmsHui.numShould}"/>
        </div>
        
        <div class="form-group col-sm-12">
        	<label><fmt:message key="wmsHui.nameAbsent"/></label>
        	<input class="form-control" type="text" name="wmsHui.nameAbsent" value="${wmsHui.nameAbsent}"/>
        </div>
        <div class="form-group col-sm-12">
        	<label><fmt:message key="wmsHui.nameComeIn"/></label>
        	<input class="form-control" type="text" name="wmsHui.nameComeIn" value="${wmsHui.nameComeIn}"/>
        </div>
        <div class="form-group col-sm-12">
        	<label><fmt:message key="wmsHui.nameSiteIn"/></label>
        	<input class="form-control" type="text" name="wmsHui.nameSiteIn" value="${wmsHui.nameSiteIn}"/>
        </div>
        
        <div class="form-group col-sm-12">
        	<label><fmt:message key="wmsHui.huiContent"/></label>
        	<textarea class="form-control" name="wmsHui.huiContent" style="height:200px;" placeholder="会议内容，1-2000个字符" minlength="1" maxlength="2000">${wmsHui.huiContent}</textarea>
        </div>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty wmsHui.huiId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#wmsHuiForm').attr('action','/savewmsHui?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSavewmsHui('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSavewmsHui(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#wmsHuiSearchForm"),$("#wmsHuiPageNav").find("li[class='active']").find("a").html());
}
</script>
