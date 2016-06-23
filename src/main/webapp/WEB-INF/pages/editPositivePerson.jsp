<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="personDetail.title"/></title>
    <meta name="menu" content="PersonMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="personForm" action="savePositivePerson" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSavePerson);">
        <s:hidden key="person.personId"/>
        <input type="hidden" name="belongGroupId" value="${belongGroupId}">
        <s:hidden key="person.age"/>
        <s:hidden key="person.partyId"/>
        <s:hidden key="person.personalTitle"/>
        <s:hidden key="cpDtl.cpDtlId"/>
        <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">基本信息</legend>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="person.name"/></label>
        	<input class="form-control" type="text" name="person.name" value="${person.name}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="person.gender"/></label>
        	<select class="form-control" name="person.gender">
        		<option value="男" ${person.gender eq "男"?"selected":"" }>男</option>
        		<option value="女" ${person.gender eq "女"?"selected":"" }>女</option>
        	</select>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="person.birthday"/></label>
        	<input class="form-control" type="text" name="person.birthday" value="${person.birthday}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="person.nation"/></label>
        	<input class="form-control" type="text" name="person.nation" value="${person.nation}"/>
        </div>
        <div class="form-group col-sm-4">
        	<label><fmt:message key="person.household"/></label>
        	<input class="form-control" type="text" name="person.household" value="${person.household}"/>
        </div>
        
        <div class="form-group col-sm-4">
        	<label><fmt:message key="person.marriage"/></label>
        	<input class="form-control" type="text" name="person.marriage" value="${person.marriage}"/>
        </div>
        <div class="form-group col-sm-4">
        	<label><fmt:message key="person.workDate"/></label>
        	<input class="form-control" type="text" name="person.workDate" value="${person.workDate}"/>
        </div>
        <div class="form-group col-sm-4">
        	<label><fmt:message key="person.cardId"/></label>
        	<input class="form-control" type="text" name="person.cardId" value="${person.cardId}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">党籍信息</legend>
        <div class="form-group col-sm-4">
        	<label><fmt:message key="cpPositive.firstApplyTime"/></label>
        	<input class="form-control" type="text" name="cpPositive.firstApplyTime" value="${cpPositive.firstApplyTime}"/>
        </div>
        <div class="form-group col-sm-4">
        	<label><fmt:message key="cpPositive.bePositiveTime"/></label>
        	<input class="form-control" type="text" name="cpPositive.bePositiveTime" value="${cpPositive.bePositiveTime}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="cpPositive.conPeople1"/></label>
        	<input class="form-control" type="text" name="cpPositive.conPeople1" value="${cpPositive.conPeople1}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="cpPositive.conPeople2"/></label>
        	<input class="form-control" type="text" name="cpPositive.conPeople2" value="${cpPositive.conPeople2}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">学历信息</legend>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="person.education"/></label>
        	<input class="form-control" type="text" name="person.education" value="${person.education}"/>
        </div>
        <div class="form-group col-sm-5">
        	<label><fmt:message key="person.educationSchoole"/></label>
        	<input class="form-control" type="text" name="person.educationSchoole" value="${person.educationSchoole}"/>
        </div>
        <div class="form-group col-sm-5">
        	<label><fmt:message key="person.educationSpeciality"/></label>
        	<input class="form-control" type="text" name="person.educationSpeciality" value="${person.educationSpeciality}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">职业信息</legend>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="cpDtl.occupation"/></label>
        	<input class="form-control" type="text" name="cpDtl.occupation" value="${cpDtl.occupation}"/>
        </div>
        <div class="form-group col-sm-5">
        	<label><fmt:message key="cpDtl.workGroup"/></label>
        	<input class="form-control" type="text" name="cpDtl.workGroup" value="${cpDtl.workGroup}"/>
        </div>
        <div class="form-group col-sm-5">
        	<label><fmt:message key="cpDtl.workStatus"/></label>
        	<input class="form-control" type="text" name="cpDtl.workStatus" value="${cpDtl.workStatus}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">联系方式</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.householdAddress"/></label>
        	<input class="form-control" type="text" name="cpDtl.householdAddress" value="${cpDtl.householdAddress}"/>
        </div>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="person.familyAddress"/></label>
        	<input class="form-control" type="text" name="person.familyAddress" value="${person.familyAddress}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="person.phone"/></label>
        	<input class="form-control" type="text" name="person.phone" value="${person.phone}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="person.qq"/></label>
        	<input class="form-control" type="text" name="person.qq" value="${person.qq}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="person.weixin"/></label>
        	<input class="form-control" type="text" name="person.weixin" value="${person.weixin}"/>
        </div>
        
        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty person.personId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#personForm').attr('action','/saveCunPerson?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSavePerson('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSavePerson(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#personSearchForm"),$("#personPageNav").find("li[class='active']").find("a").html());
}
function changePersonType(pselect){
	var sv = $(pselect).val();
	if(sv==5){
		$("#statusAndUnitDiv").show();
	}else{
		$("#statusAndUnitDiv").hide();
	}
}
$(function(){
	getDatePicker($("input[name='person.birthday']"));
	getDatePicker($("input[name='person.workDate']"));
	getDatePicker($("input[name='cpPositive.firstApplyTime']"));
	getDatePicker($("input[name='cpPositive.bePositiveTime']"));
})
</script>
