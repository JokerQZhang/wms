<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="moniteSiteDetail.title"/></title>
    <meta name="menu" content="MoniteSiteMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="moniteSiteForm" action="saveMoniteSite" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveMoniteSite);">
        <s:hidden key="moniteSite.siteId"/>
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="moniteSite.conPeople"/><s:fielderror fieldName="moniteSite.conPeople"/></label>
				        	  <input class="form-control" type="text" name="moniteSite.conPeople" value="${moniteSite.conPeople}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="moniteSite.conPeople"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="moniteSite.email"/><s:fielderror fieldName="moniteSite.email"/></label>
				        	  <input class="form-control" type="text" name="moniteSite.email" value="${moniteSite.email}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="moniteSite.email"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="moniteSite.geopoint"/><s:fielderror fieldName="moniteSite.geopoint"/></label>
				        	  <input class="form-control" type="text" name="moniteSite.geopoint" value="${moniteSite.geopoint}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="moniteSite.geopoint"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="moniteSite.partyId"/><s:fielderror fieldName="moniteSite.partyId"/></label>
				        	  <input class="form-control" type="text" name="moniteSite.partyId" value="${moniteSite.partyId}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="moniteSite.partyId"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="moniteSite.phone"/><s:fielderror fieldName="moniteSite.phone"/></label>
				        	  <input class="form-control" type="text" name="moniteSite.phone" value="${moniteSite.phone}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="moniteSite.phone"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="moniteSite.sitName"/><s:fielderror fieldName="moniteSite.sitName"/></label>
				        	  <input class="form-control" type="text" name="moniteSite.sitName" value="${moniteSite.sitName}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="moniteSite.sitName"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="moniteSite.telphone"/><s:fielderror fieldName="moniteSite.telphone"/></label>
				        	  <input class="form-control" type="text" name="moniteSite.telphone" value="${moniteSite.telphone}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="moniteSite.telphone"/> -->

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty moniteSite.siteId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#moniteSiteForm').attr('action','/saveMoniteSite?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveMoniteSite('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveMoniteSite(data){
	if(data=="SaveSuccess"){
		$("#jokerdialogframexixi").dialog("close");
		formPage($("#moniteSiteSearchForm"),$("#moniteSitePageNav").find("li[class='active']").find("a").html());
	}else{
		$("#jokerdialogframexixi").html(data);
	}
	
}
</script>
