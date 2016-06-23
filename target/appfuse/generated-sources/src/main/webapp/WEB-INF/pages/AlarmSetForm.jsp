<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="alarmSetDetail.title"/></title>
    <meta name="menu" content="AlarmSetMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="alarmSetForm" action="saveAlarmSet" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveAlarmSet);">
        <s:hidden key="alarmSet.alarmSetId"/>
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="alarmSet.alarmLevel"/></label>
				        	  <input class="form-control" type="text" name="alarmSet.alarmLevel" value="${alarmSet.alarmLevel}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="alarmSet.alarmLevel"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="alarmSet.kpiId"/></label>
				        	  <input class="form-control" type="text" name="alarmSet.kpiId" value="${alarmSet.kpiId}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="alarmSet.kpiId"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="alarmSet.kpiName"/></label>
				        	  <input class="form-control" type="text" name="alarmSet.kpiName" value="${alarmSet.kpiName}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="alarmSet.kpiName"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="alarmSet.maxValue"/></label>
				        	  <input class="form-control" type="text" name="alarmSet.maxValue" value="${alarmSet.maxValue}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="alarmSet.maxValue"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="alarmSet.memo"/></label>
				        	  <input class="form-control" type="text" name="alarmSet.memo" value="${alarmSet.memo}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="alarmSet.memo"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="alarmSet.minValue"/></label>
				        	  <input class="form-control" type="text" name="alarmSet.minValue" value="${alarmSet.minValue}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="alarmSet.minValue"/> -->

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty alarmSet.alarmSetId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#alarmSetForm').attr('action','/saveAlarmSet?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveAlarmSet('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveAlarmSet(data){
	alert(data=="保存成功");
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#alarmSetSearchForm"),$("#alarmSetPageNav").find("li[class='active']").find("a").html());
}
</script>
