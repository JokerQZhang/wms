<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="tzDyzthDetail.title"/></title>
    <meta name="menu" content="TzDyzthMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="tzDyzthForm" action="saveTzDyzth" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveTzDyzth);">
        <s:hidden key="tzDyzth.dyzthId"/>
        <s:hidden key="tzDyzth.groupPartyId"/>
        <div class="form-group col-sm-12" style="display:none;">
        	<label><fmt:message key="tzDyzth.tzDate"/></label>
        	<input class="form-control" type="text" name="tzDyzth.tzDate" value="${tzDyzth.tzDate}"/>
        </div>
        <div class="form-group col-sm-12">
        	<label><fmt:message key="tzDyzth.address"/></label>
        	<input class="form-control" type="text" name="tzDyzth.address" value="${tzDyzth.address}"/>
        </div>
        <div class="form-group col-sm-12">
        	<label><fmt:message key="tzDyzth.content"/></label>
        	<textarea name="tzDyzth.content" class="form-control" rows="5" cols="">${tzDyzth.content}</textarea>
        </div>
        

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty tzDyzth.dyzthId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#tzDyzthForm').attr('action','/saveTzDyzth?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveTzDyzth(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#tzDyzthSearchForm"),$("#tzDyzthPageNav").find("li[class='active']").find("a").html());
}
</script>
