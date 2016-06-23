<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<div class="col-sm-12">
    <s:form action="/savePartyRelationship" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveCustom);">
        <s:hidden key="vendorId"/>
        
        <select name="customerlist" id="customerlist">
        	<%=request.getAttribute("partyGroupOptions").toString() %>
        </select>
        <hr>
        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <a href="#" class="btn btn-default" onclick="afterSaveCustom('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveCustom(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	$("#customersearch").submit();
	//formPage($("#enumerationSearchForm"),$("#enumerationPageNav").find("li[class='active']").find("a").html());
}
</script>
