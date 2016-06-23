<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="geoDetail.title"/></title>
    <meta name="menu" content="GeoMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="geoForm" action="saveGeo" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveGeo);">
        <s:hidden key="geo.geoId"/>
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="geo.geoName"/><s:fielderror fieldName="geo.geoName"/></label>
				        	  <input class="form-control" type="text" name="geo.geoName" value="${geo.geoName}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="geo.geoName"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="geo.geoNamePinyin"/><s:fielderror fieldName="geo.geoNamePinyin"/></label>
				        	  <input class="form-control" type="text" name="geo.geoNamePinyin" value="${geo.geoNamePinyin}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="geo.geoNamePinyin"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="geo.geoPoint"/><s:fielderror fieldName="geo.geoPoint"/></label>
				        	  <input class="form-control" type="text" name="geo.geoPoint" value="${geo.geoPoint}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="geo.geoPoint"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="geo.geoType"/><s:fielderror fieldName="geo.geoType"/></label>
				        	  <input class="form-control" type="text" name="geo.geoType" value="${geo.geoType}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="geo.geoType"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="geo.parentGeoId"/><s:fielderror fieldName="geo.parentGeoId"/></label>
				        	  <input class="form-control" type="text" name="geo.parentGeoId" value="${geo.parentGeoId}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="geo.parentGeoId"/> -->

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty geo.geoId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#geoForm').attr('action','/saveGeo?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveGeo('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveGeo(data){
	if(data=="SaveSuccess"){
		$("#jokerdialogframexixi").dialog("close");
		formPage($("#geoSearchForm"),$("#geoPageNav").find("li[class='active']").find("a").html());
	}else{
		$("#jokerdialogframexixi").html(data);
	}
	
}
</script>
