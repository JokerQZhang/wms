<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="tzGfmzDetail.title"/></title>
    <meta name="menu" content="TzGfmzMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="tzGfmzForm" action="saveTzGfmz" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveTzGfmz);">
        <s:hidden key="tzGfmz.gfmzId"/>
        <s:hidden key="tzGfmz.groupPartyId"/>
        <div class="form-group col-sm-12" style="display:none;">
        	<label><fmt:message key="tzGfmz.tzDate"/></label>
        	<input class="form-control" type="text" name="tzGfmz.tzDate" value="${tzGfmz.tzDate}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">四议两公开运用情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzGfmz.sylhgkTimes"/></label>
        	<input class="form-control" type="text" name="tzGfmz.sylhgkTimes" value="${tzGfmz.sylhgkTimes}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzGfmz.sylhgkDtl"/></label>
        	<input class="form-control" type="text" name="tzGfmz.sylhgkDtl" value="${tzGfmz.sylhgkDtl}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">党群综合服务站运行情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzGfmz.dyzhfwzTimes"/></label>
        	<input class="form-control" type="text" name="tzGfmz.dyzhfwzTimes" value="${tzGfmz.dyzhfwzTimes}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzGfmz.dyzhfwzDtl"/></label>
        	<input class="form-control" type="text" name="tzGfmz.dyzhfwzDtl" value="${tzGfmz.dyzhfwzDtl}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">三资管理公示情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzGfmz.szgsNum"/></label>
        	<input class="form-control" type="text" name="tzGfmz.szgsNum" value="${tzGfmz.szgsNum}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzGfmz.szgsTime"/></label>
        	<input class="form-control" type="text" name="tzGfmz.szgsTime" value="${tzGfmz.szgsTime}"/>
        </div>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty tzGfmz.gfmzId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#tzGfmzForm').attr('action','/saveTzGfmz?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveTzGfmz(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#tzGfmzSearchForm"),$("#tzGfmzPageNav").find("li[class='active']").find("a").html());
}
</script>
