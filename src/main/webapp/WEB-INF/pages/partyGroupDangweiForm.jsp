<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.List,com.joker.wms.model.*" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="partyGroupDetail.title"/></title>
    <meta name="menu" content="PartyGroupMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="partyGroupForm" action="savePartyGroupDangwei" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSavePartyGroup);">
        <s:hidden key="partyGroup.pgId"/>
        <input type="hidden" name="parentId"/>
        <s:textfield cssClass="form-control" key="partyGroup.groupName"/>
        <s:textfield cssClass="form-control" key="partyGroup.address"/>
        <s:textfield cssClass="form-control" key="partyGroup.phone"/>
        <s:hidden cssClass="form-control" key="partyGroup.numEmployees"/>
        <s:hidden cssClass="form-control" key="partyGroup.partyId"/>
		<div class="form-group"><label>对应行政机构</label>
		<select class="form-control" name="belongXingZhengPartyId">
<%
List xzpgList = (List)request.getAttribute("xzpgList");
String belongXingZhengPartyId = (String)request.getAttribute("belongXingZhengPartyId");
if(xzpgList!=null && xzpgList.size()>0){
	for(int i=0; i<xzpgList.size(); i++){
		PartyGroup xzpg = (PartyGroup)xzpgList.get(i);
%>
			<option value="<%=xzpg.getPartyId() %>" <%=xzpg.getPartyId().toString().equals(belongXingZhengPartyId)?"selected='selected'":"" %>><%=xzpg.getGroupName() %></option>
<%
	}
}
%>
		</select>
		</div>
		<script type="text/javascript">
		  $(document).ready(function(){
		  	$("select[name='belongXingZhengPartyId']").combobox();
		  });
		</script>
        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty partyGroup.pgId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#partyGroupForm').attr('action','/wmsd/savePartyGroupCun?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSavePartyGroup('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSavePartyGroup(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#partyGroupSearchForm"),$("#partyGroupPageNav").find("li[class='active']").find("a").html());
}
</script>
