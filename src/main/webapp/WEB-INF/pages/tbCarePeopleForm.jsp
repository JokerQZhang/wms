<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="tbCarePeopleDetail.title"/></title>
    <meta name="menu" content="TbCarePeopleMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="tbCarePeopleForm" action="saveTbCarePeople" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveTbCarePeople);">
        <s:hidden key="tbCarePeople.peopleId"/>
        <s:textfield cssClass="form-control" key="tbCarePeople.peopleName"/>
        <div class="form-group">
        	<label><fmt:message key="tbCarePeople.gender"/></label>
	        <select class="form-control" name="tbCarePeople.gender">
	        	<option value="男" ${tbCarePeople.gender=="男"?"selected='selected'":"" }>男</option>
	        	<option value="女" ${tbCarePeople.gender=="女"?"selected='selected'":"" }>女</option>
	        </select>
        </div>
        <div class="form-group">
        	<label><fmt:message key="tbCarePeople.nation"/></label>
	        <select class="form-control" name="tbCarePeople.nation">
	        	<option value="汉" ${tbCarePeople.nation=="汉"?"selected='selected'":"" }>汉</option>
	        	<option value="回" ${tbCarePeople.nation=="回"?"selected='selected'":"" }>回</option>
	        </select>
        </div>
        <s:textfield cssClass="form-control" key="tbCarePeople.birthday"/>
        <div class="form-group">
        	<label><fmt:message key="tbCarePeople.departmentId"/></label>
	        <select class="form-control" name="tbCarePeople.departmentId">
	        	<option value="1" ${partyGroup.partyId==1?"selected='selected'":""}>尉氏县</option>
	        	<c:forEach items="${pgList}" var="partyGroup">
	        		<option value="${partyGroup.partyId}" ${partyGroup.partyId==tbCarePeople.departmentId?"selected='selected'":"" }>${partyGroup.groupName}</option>
	        	</c:forEach>
	        </select>
        </div>
        <script type="text/javascript">
		  $(document).ready(function(){
		  	$("select[name='tbCarePeople.departmentId']").combobox();
		  });
		</script>
        <s:textfield cssClass="form-control" key="tbCarePeople.address"/>
        <s:textfield cssClass="form-control" key="tbCarePeople.idCard"/>
        <s:textfield cssClass="form-control" key="tbCarePeople.job"/>
        <div class="form-group">
        	<label><fmt:message key="tbCarePeople.partyType"/></label>
	        <select class="form-control" name="tbCarePeople.partyType">
	        	<option></option>
	        	<option value="党员" ${tbCarePeople.partyType=="党员"?"selected='selected'":"" }>党员</option>
	        </select>
        </div>
        <div class="form-group">
        	<label><fmt:message key="tbCarePeople.partyStatus"/></label>
	        <select class="form-control" name="tbCarePeople.partyStatus">
	        	<option value="正常" ${tbCarePeople.partyStatus=="正常"?"selected='selected'":"" }>正常</option>
	        	<option value="流动" ${tbCarePeople.partyStatus=="流动"?"selected='selected'":"" }>流动</option>
	        </select>
        </div>
        <div class="form-group">
        	<label><fmt:message key="tbCarePeople.pensionInsurance"/></label>
	        <select class="form-control" name="tbCarePeople.pensionInsurance">
	        	<option value="已参保" ${tbCarePeople.pensionInsurance=="已参保"?"selected='selected'":"" }>已参保</option>
	        	<option value="未参保" ${tbCarePeople.pensionInsurance=="未参保"?"selected='selected'":"" }>未参保</option>
	        	<option value="已领取" ${tbCarePeople.pensionInsurance=="已领取"?"selected='selected'":"" }>已领取</option>
	        </select>
        </div>
        

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty tbCarePeople.peopleId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#tbCarePeopleForm').attr('action','/saveTbCarePeople?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveTbCarePeople('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveTbCarePeople(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#tbCarePeopleSearchForm"),$("#tbCarePeoplePageNav").find("li[class='active']").find("a").html());
}
</script>
