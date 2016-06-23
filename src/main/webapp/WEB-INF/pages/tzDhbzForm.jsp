<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="tzDhbzDetail.title"/></title>
    <meta name="menu" content="TzDhbzMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="tzDhbzForm" action="saveTzDhbz" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveTzDhbz);">
        <s:hidden key="tzDhbz.dhbzId"/>
        <s:hidden key="tzDhbz.groupPartyId"/>
        <div class="form-group col-sm-12" style="display:none;">
        	<label><fmt:message key="tzDhbz.tzDate"/></label>
        	<input class="form-control" type="text" name="tzDhbz.tzDate" value="${tzDhbz.tzDate}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">指导参与组织生活情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzDhbz.zdzzshTime"/></label>
        	<input class="form-control" type="text" name="tzDhbz.zdzzshTime" value="${tzDhbz.zdzzshTime}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzDhbz.zdzzhyName"/></label>
        	<input class="form-control" type="text" name="tzDhbz.zdzzhyName" value="${tzDhbz.zdzzhyName}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">后备干部帮带情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzDhbz.hbgbNum"/></label>
        	<input class="form-control" type="text" name="tzDhbz.hbgbNum" value="${tzDhbz.hbgbNum}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzDhbz.bdfs"/></label>
        	<input class="form-control" type="text" name="tzDhbz.bdfs" value="${tzDhbz.bdfs}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">培养积极分子情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzDhbz.pyjjfzNum"/></label>
        	<input class="form-control" type="text" name="tzDhbz.pyjjfzNum" value="${tzDhbz.pyjjfzNum}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzDhbz.pyjjfzName"/></label>
        	<input class="form-control" type="text" name="tzDhbz.pyjjfzName" value="${tzDhbz.pyjjfzName}"/>
        </div>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty tzDhbz.dhbzId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#tzDhbzForm').attr('action','/saveTzDhbz?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveTzDhbz(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#tzDhbzSearchForm"),$("#tzDhbzPageNav").find("li[class='active']").find("a").html());
}
</script>
