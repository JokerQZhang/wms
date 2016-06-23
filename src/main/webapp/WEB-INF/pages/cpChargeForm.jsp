<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="cpChargeDetail.title"/></title>
    <meta name="menu" content="CpChargeMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="cpChargeForm" action="saveCpCharge" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveCpCharge);">
        <s:hidden key="cpCharge.cpChargeId"/>
        <s:hidden key="cpCharge.createdByUser"/>
        <s:hidden key="cpCharge.createdTime"/>
        <s:hidden key="cpCharge.lastUpdatedByUser"/>
        <s:hidden key="cpCharge.lastUpdatedTime"/>
        <s:hidden key="cpCharge.ioType"/>
        <s:hidden key="cpCharge.partyId"/>
        <s:hidden key="cpCharge.relateAccountType"/>
        <div class="form-group col-sm-6">
       	  <label><fmt:message key="cpCharge.cpTitle"/></label>
       	  <input class="form-control" type="text" name="cpCharge.cpTitle" value="${cpCharge.cpTitle}"/>
        </div>
        <div class="form-group col-sm-6">
       	  <label><fmt:message key="cpCharge.operPeople"/></label>
       	  <input class="form-control" type="text" name="cpCharge.operPeople" value="${cpCharge.operPeople eq ''?'':currentPerson.name}"/>
        </div>
        <div class="form-group col-sm-3">
       	  <label><fmt:message key="cpCharge.operType"/></label>
       	  <select class="form-control" name="cpCharge.operType" onchange="changeOperType(this)">
       	  <%=request.getAttribute("operTypeOptions") %>
       	  </select>
        </div>
        <div class="form-group col-sm-3">
       	  <label><fmt:message key="cpCharge.accountType"/></label>
       	  <input type="hidden" name="cpCharge.accountType" value="${cpCharge.accountType eq null?"26":cpCharge.accountType}"/>
       	  <select class="form-control" name="accountType" disabled="disabled" onchange="changeAccountType(this)" on>
       	  <%=request.getAttribute("accountTypeOptions") %>
       	  </select>
        </div>
        <div class="form-group col-sm-3">
       	  <label><fmt:message key="cpCharge.relatePartyId"/></label>
       	  <select class="form-control" name="cpCharge.relatePartyId">
       	  <%=request.getAttribute("childrenOptions") %>
       	  </select>
        </div>
        <div class="form-group col-sm-3">
       	  <label><fmt:message key="cpCharge.balance"/></label>
       	  <input class="form-control" type="text" name="cpCharge.balance" value="${cpCharge.balance}"/>
        </div>
        
        
        
        <div class="form-group col-sm-12">
       	  <label><fmt:message key="cpCharge.memo"/></label>
       	  <textarea rows="5" cols="" class="form-control" name="cpCharge.memo">${cpCharge.memo}</textarea>
        </div>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty cpCharge.cpChargeId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#cpChargeForm').attr('action','/saveCpCharge?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveCpCharge('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveCpCharge(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#cpChargeSearchForm"),$("#cpChargePageNav").find("li[class='active']").find("a").html());
}
function changeOperType(item){
	var nowVal = $(item).val();
	var parentOptions = "<%=request.getAttribute("parentOptions") %>";
	var childrenOptions = "<%=request.getAttribute("childrenOptions") %>";
	if(nowVal=="22"||nowVal=="25"){
		$("select[name='cpCharge.relatePartyId']").html($(childrenOptions));
	}else if(nowVal=="23"||nowVal=="24"){
		$("select[name='cpCharge.relatePartyId']").html($(parentOptions));
	}
	if(nowVal=="22"||nowVal=="23"){
		$("select[name='accountType']").val("26");
		$("input[name='cpCharge.accountType']").val("26");
	}else if(nowVal=="24"||nowVal=="25"){
		$("select[name='accountType']").val("27");
		$("input[name='cpCharge.accountType']").val("27");
	}
	if(nowVal=="25"){
		$("select[name='accountType']").removeAttr("disabled");
	}else{
		$("select[name='accountType']").attr("disabled","disabled");
	}
}
function changeAccountType(item){
	$("input[name='cpCharge.accountType']").val($(item).val());
}
</script>
