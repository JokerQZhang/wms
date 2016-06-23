<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="tzFwqzDetail.title"/></title>
    <meta name="menu" content="TzFwqzMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="tzFwqzForm" action="saveTzFwqz" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveTzFwqz);">
        <s:hidden key="tzFwqz.fwqzId"/>
        <s:hidden key="tzFwqz.groupPartyId"/>
        <div class="form-group col-sm-12" style="display:none;">
        	<label><fmt:message key="tzFwqz.tzDate"/></label>
        	<input class="form-control" type="text" name="tzFwqz.tzDate" value="${tzFwqz.tzDate}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">解决群众实际困难情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzFwqz.jjsjknNum"/></label>
        	<input class="form-control" type="text" name="tzFwqz.jjsjknNum" value="${tzFwqz.jjsjknNum}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzFwqz.jjsjknProblem"/></label>
        	<input class="form-control" type="text" name="tzFwqz.jjsjknProblem" value="${tzFwqz.jjsjknProblem}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">建设基础设施情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzFwqz.jsjcssNum"/></label>
        	<input class="form-control" type="text" name="tzFwqz.jsjcssNum" value="${tzFwqz.jsjcssNum}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzFwqz.jsjcssDtl"/></label>
        	<input class="form-control" type="text" name="tzFwqz.jsjcssDtl" value="${tzFwqz.jsjcssDtl}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:2rem;">便民服务信息公示情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="tzFwqz.bmfuxxIsShow"/></label>
        	<input class="form-control" type="text" name="tzFwqz.bmfuxxIsShow" value="${tzFwqz.bmfuxxIsShow}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label><fmt:message key="tzFwqz.bmfuxxShowType"/></label>
        	<input class="form-control" type="text" name="tzFwqz.bmfuxxShowType" value="${tzFwqz.bmfuxxShowType}"/>
        </div>
        

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty tzFwqz.fwqzId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#tzFwqzForm').attr('action','/saveTzFwqz?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveTzFwqz(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#tzFwqzSearchForm"),$("#tzFwqzPageNav").find("li[class='active']").find("a").html());
}
</script>
