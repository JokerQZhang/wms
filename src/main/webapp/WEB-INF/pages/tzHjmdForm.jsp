<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="tzHjmdDetail.title"/></title>
    <meta name="menu" content="TzHjmdMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="tzHjmdForm" action="saveTzHjmd" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveTzHjmd);">
        <s:hidden key="tzHjmd.hjmdId"/>
        <s:hidden key="tzHjmd.groupPartyId"/>
        <div class="form-group col-sm-12" style="display:none;">
        	<label><fmt:message key="tzHjmd.tzDate"/></label>
        	<input class="form-control" type="text" name="tzHjmd.tzDate" value="${tzHjmd.tzDate}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">走访党员群众情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzHjmd.zfqzTimes"/></label>
        	<input class="form-control" type="text" name="tzHjmd.zfqzTimes" value="${tzHjmd.zfqzTimes}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzHjmd.zfqzPersonNum"/></label>
        	<input class="form-control" type="text" name="tzHjmd.zfqzPersonNum" value="${tzHjmd.zfqzPersonNum}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">化解矛盾纠纷情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzHjmd.hjmdjfNum"/></label>
        	<input class="form-control" type="text" name="tzHjmd.hjmdjfNum" value="${tzHjmd.hjmdjfNum}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzHjmd.hjmdjfDtl"/></label>
        	<input class="form-control" type="text" name="tzHjmd.hjmdjfDtl" value="${tzHjmd.hjmdjfDtl}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">解决历史遗留问题情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzHjmd.jjlsylwtNum"/></label>
        	<input class="form-control" type="text" name="tzHjmd.jjlsylwtNum" value="${tzHjmd.jjlsylwtNum}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzHjmd.jjlsylwtDtl"/></label>
        	<input class="form-control" type="text" name="tzHjmd.jjlsylwtDtl" value="${tzHjmd.jjlsylwtDtl}"/>
        </div>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty tzHjmd.hjmdId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#tzHjmdForm').attr('action','/saveTzHjmd?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveTzHjmd(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#tzHjmdSearchForm"),$("#tzHjmdPageNav").find("li[class='active']").find("a").html());
}
</script>
