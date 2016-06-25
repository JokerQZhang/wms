<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="monitorDataDetail.title"/></title>
    <meta name="menu" content="MonitorDataMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="monitorDataForm" action="saveMonitorData" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveMonitorData);">
        <s:hidden key="monitorData.monitorId"/>
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k1"/><s:fielderror fieldName="monitorData.k1"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k1" value="${monitorData.k1}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k1"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k10"/><s:fielderror fieldName="monitorData.k10"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k10" value="${monitorData.k10}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k10"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k11"/><s:fielderror fieldName="monitorData.k11"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k11" value="${monitorData.k11}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k11"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k12"/><s:fielderror fieldName="monitorData.k12"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k12" value="${monitorData.k12}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k12"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k13"/><s:fielderror fieldName="monitorData.k13"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k13" value="${monitorData.k13}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k13"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k14"/><s:fielderror fieldName="monitorData.k14"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k14" value="${monitorData.k14}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k14"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k15"/><s:fielderror fieldName="monitorData.k15"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k15" value="${monitorData.k15}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k15"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k16"/><s:fielderror fieldName="monitorData.k16"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k16" value="${monitorData.k16}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k16"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k17"/><s:fielderror fieldName="monitorData.k17"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k17" value="${monitorData.k17}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k17"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k18"/><s:fielderror fieldName="monitorData.k18"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k18" value="${monitorData.k18}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k18"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k19"/><s:fielderror fieldName="monitorData.k19"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k19" value="${monitorData.k19}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k19"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k2"/><s:fielderror fieldName="monitorData.k2"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k2" value="${monitorData.k2}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k2"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k20"/><s:fielderror fieldName="monitorData.k20"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k20" value="${monitorData.k20}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k20"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k3"/><s:fielderror fieldName="monitorData.k3"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k3" value="${monitorData.k3}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k3"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k4"/><s:fielderror fieldName="monitorData.k4"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k4" value="${monitorData.k4}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k4"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k5"/><s:fielderror fieldName="monitorData.k5"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k5" value="${monitorData.k5}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k5"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k6"/><s:fielderror fieldName="monitorData.k6"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k6" value="${monitorData.k6}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k6"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k7"/><s:fielderror fieldName="monitorData.k7"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k7" value="${monitorData.k7}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k7"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k8"/><s:fielderror fieldName="monitorData.k8"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k8" value="${monitorData.k8}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k8"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.k9"/><s:fielderror fieldName="monitorData.k9"/></label>
				        	  <input class="form-control" type="text" name="monitorData.k9" value="${monitorData.k9}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.k9"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.siteId"/><s:fielderror fieldName="monitorData.siteId"/></label>
				        	  <input class="form-control" type="text" name="monitorData.siteId" value="${monitorData.siteId}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.siteId"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="monitorData.monitorTime"/><s:fielderror fieldName="monitorData.monitorTime"/></label>
				        	  <input class="form-control" type="text" name="monitorData.monitorTime" value="${monitorData.monitorTime}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="monitorData.monitorTime"/> -->

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty monitorData.monitorId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#monitorDataForm').attr('action','/saveMonitorData?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveMonitorData('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveMonitorData(data){
	if(data=="SaveSuccess"){
		$("#jokerdialogframexixi").dialog("close");
		formPage($("#monitorDataSearchForm"),$("#monitorDataPageNav").find("li[class='active']").find("a").html());
	}else{
		$("#jokerdialogframexixi").html(data);
	}
	
}
</script>
