<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="personDetail.title"/></title>
    <meta name="menu" content="PersonMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="personForm" action="saveDangPerson" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSavePerson);">
        <s:hidden key="person.personId"/>
        <input type="hidden" name="belongGroupId" value="${belongGroupId}">
        <s:hidden key="person.age"/>
        <s:hidden key="person.partyId"/>
        <s:hidden key="person.personalTitle"/>
        <s:hidden key="cpDtl.cpDtlId"/>
        <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">党员基本信息</legend>
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
        
        <div class="form-group col-sm-2">
        	<label><fmt:message key="person.marriage"/></label>
        	<input class="form-control" type="text" name="person.marriage" value="${person.marriage}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="cpDtl.bePartyDate"/></label>
        	<input class="form-control" type="text" name="cpDtl.bePartyDate" value="${cpDtl.bePartyDate}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="cpDtl.positiveDate"/></label>
        	<input class="form-control" type="text" name="cpDtl.positiveDate" value="${cpDtl.positiveDate}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="person.workDate"/></label>
        	<input class="form-control" type="text" name="person.workDate" value="${person.workDate}"/>
        </div>
        <div class="form-group col-sm-4">
        	<label><fmt:message key="person.cardId"/></label>
        	<input class="form-control" type="text" name="person.cardId" value="${person.cardId}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">党籍信息</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.bePartyZhibu"/></label>
        	<input class="form-control" type="text" name="cpDtl.bePartyZhibu" value="${cpDtl.bePartyZhibu}"/>
        </div>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.beHereDate"/></label>
        	<input class="form-control" type="text" name="cpDtl.beHereDate" value="${cpDtl.beHereDate}"/>
        </div>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.outOfZhibu"/></label>
        	<input class="form-control" type="text" name="cpDtl.outOfZhibu" value="${cpDtl.outOfZhibu}"/>
        </div>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.partyStatus"/></label>
        	<input class="form-control" type="text" name="cpDtl.partyStatus" value="${cpDtl.partyStatus}"/>
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
        <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">党员流动信息</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.flowOutDate"/></label>
        	<input class="form-control" type="text" name="cpDtl.flowOutDate" value="${cpDtl.flowOutDate}"/>
        </div>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.flowOutInfo"/></label>
        	<input class="form-control" type="text" name="cpDtl.flowOutInfo" value="${cpDtl.flowOutInfo}"/>
        </div>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.isHaveFlowCard"/></label>
        	<input class="form-control" type="text" name="cpDtl.isHaveFlowCard" value="${cpDtl.isHaveFlowCard}"/>
        </div>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.flowCardNum"/></label>
        	<input class="form-control" type="text" name="cpDtl.flowCardNum" value="${cpDtl.flowCardNum}"/>
        </div>
        
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.flowInGroup"/></label>
        	<input class="form-control" type="text" name="cpDtl.flowInGroup" value="${cpDtl.flowInGroup}"/>
        </div>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.flowInGroupPerson"/></label>
        	<input class="form-control" type="text" name="cpDtl.flowInGroupPerson" value="${cpDtl.flowInGroupPerson}"/>
        </div>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.flowInGroupPhone"/></label>
        	<input class="form-control" type="text" name="cpDtl.flowInGroupPhone" value="${cpDtl.flowInGroupPhone}"/>
        </div>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.partyGroupType"/></label>
        	<input class="form-control" type="text" name="cpDtl.partyGroupType" value="${cpDtl.partyGroupType}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">出国（境）情况</legend>
        <div class="form-group col-sm-4">
        	<label><fmt:message key="cpDtl.outCountryDate"/></label>
        	<input class="form-control" type="text" name="cpDtl.outCountryDate" value="${cpDtl.outCountryDate}"/>
        </div>
        <div class="form-group col-sm-4">
        	<label><fmt:message key="cpDtl.outCountryReason"/></label>
        	<input class="form-control" type="text" name="cpDtl.outCountryReason" value="${cpDtl.outCountryReason}"/>
        </div>
        <div class="form-group col-sm-4">
        	<label><fmt:message key="cpDtl.outCountryConnect"/></label>
        	<input class="form-control" type="text" name="cpDtl.outCountryConnect" value="${cpDtl.outCountryConnect}"/>
        </div>
        
        <div class="form-group col-sm-4">
        	<label><fmt:message key="cpDtl.outCountryDangji"/></label>
        	<input class="form-control" type="text" name="cpDtl.outCountryDangji" value="${cpDtl.outCountryDangji}"/>
        </div>
        <div class="form-group col-sm-4">
        	<label><fmt:message key="cpDtl.outCountryBackdate"/></label>
        	<input class="form-control" type="text" name="cpDtl.outCountryBackdate" value="${cpDtl.outCountryBackdate}"/>
        </div>
        <div class="form-group col-sm-4">
        	<label><fmt:message key="cpDtl.outCountryBacklife"/></label>
        	<input class="form-control" type="text" name="cpDtl.outCountryBacklife" value="${cpDtl.outCountryBacklife}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">家庭主要成员及重要社会关系情况</legend>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="cpDtl.RTitle"/></label>
        	<input class="form-control" type="text" name="cpDtl.RTitle1" value="${cpDtl.RTitle1}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="cpDtl.RName"/></label>
        	<input class="form-control" type="text" name="cpDtl.RName1" value="${cpDtl.RName1}"/>
        </div>
        <div class="form-group col-sm-1">
        	<label><fmt:message key="cpDtl.RAge"/></label>
        	<input class="form-control" type="text" name="cpDtl.RAge1" value="${cpDtl.RAge1}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="cpDtl.RSocial"/></label>
        	<input class="form-control" type="text" name="cpDtl.RSocial1" value="${cpDtl.RSocial1}"/>
        </div>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.RWorkeCompany"/></label>
        	<input class="form-control" type="text" name="cpDtl.RWorkeCompany1" value="${cpDtl.RWorkeCompany1}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="cpDtl.RWorkeSatus"/></label>
        	<input class="form-control" type="text" name="cpDtl.RWorkeSatus1" value="${cpDtl.RWorkeSatus1}"/>
        </div>
        
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RTitle2" value="${cpDtl.RTitle2}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RName2" value="${cpDtl.RName2}"/>
        </div>
        <div class="form-group col-sm-1">
        	<input class="form-control" type="text" name="cpDtl.RAge2" value="${cpDtl.RAge2}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RSocial2" value="${cpDtl.RSocial2}"/>
        </div>
        <div class="form-group col-sm-3">
        	<input class="form-control" type="text" name="cpDtl.RWorkeCompany2" value="${cpDtl.RWorkeCompany2}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RWorkeSatus2" value="${cpDtl.RWorkeSatus2}"/>
        </div>
        
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RTitle3" value="${cpDtl.RTitle3}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RName3" value="${cpDtl.RName3}"/>
        </div>
        <div class="form-group col-sm-1">
        	<input class="form-control" type="text" name="cpDtl.RAge3" value="${cpDtl.RAge3}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RSocial3" value="${cpDtl.RSocial3}"/>
        </div>
        <div class="form-group col-sm-3">
        	<input class="form-control" type="text" name="cpDtl.RWorkeCompany3" value="${cpDtl.RWorkeCompany3}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RWorkeSatus3" value="${cpDtl.RWorkeSatus3}"/>
        </div>
        
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RTitle4" value="${cpDtl.RTitle4}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RName4" value="${cpDtl.RName4}"/>
        </div>
        <div class="form-group col-sm-1">
        	<input class="form-control" type="text" name="cpDtl.RAge4" value="${cpDtl.RAge4}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RSocial4" value="${cpDtl.RSocial4}"/>
        </div>
        <div class="form-group col-sm-3">
        	<input class="form-control" type="text" name="cpDtl.RWorkeCompany4" value="${cpDtl.RWorkeCompany4}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RWorkeSatus4" value="${cpDtl.RWorkeSatus4}"/>
        </div>
        
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RTitle5" value="${cpDtl.RTitle5}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RName5" value="${cpDtl.RName5}"/>
        </div>
        <div class="form-group col-sm-1">
        	<input class="form-control" type="text" name="cpDtl.RAge5" value="${cpDtl.RAge5}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RSocial5" value="${cpDtl.RSocial5}"/>
        </div>
        <div class="form-group col-sm-3">
        	<input class="form-control" type="text" name="cpDtl.RWorkeCompany5" value="${cpDtl.RWorkeCompany5}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RWorkeSatus5" value="${cpDtl.RWorkeSatus5}"/>
        </div>
        
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RTitle6" value="${cpDtl.RTitle6}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RName6" value="${cpDtl.RName6}"/>
        </div>
        <div class="form-group col-sm-1">
        	<input class="form-control" type="text" name="cpDtl.RAge6" value="${cpDtl.RAge6}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RSocial6" value="${cpDtl.RSocial6}"/>
        </div>
        <div class="form-group col-sm-3">
        	<input class="form-control" type="text" name="cpDtl.RWorkeCompany6" value="${cpDtl.RWorkeCompany6}"/>
        </div>
        <div class="form-group col-sm-2">
        	<input class="form-control" type="text" name="cpDtl.RWorkeSatus6" value="${cpDtl.RWorkeSatus6}"/>
        </div>
        <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">党员档案管理情况</legend>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="cpDtl.keepUnit"/></label>
        	<input class="form-control" type="text" name="cpDtl.keepUnit" value="${cpDtl.keepUnit}"/>
        </div>
        <div class="form-group col-sm-9">
        	<label>保管材料</label>
        	<fmt:message key="cpDtl.rdzys"/><input type="checkbox" name="cpDtl.rdzys" value="1">
        	<fmt:message key="cpDtl.rdsqs"/><input type="checkbox" name="cpDtl.rdsqs" value="1">
        	<fmt:message key="cpDtl.zzsccl"/><input type="checkbox" name="cpDtl.zzsccl" value="1">
        	<fmt:message key="cpDtl.zzsqs"/><input type="checkbox" name="cpDtl.zzsqs" value="1">
        	<fmt:message key="cpDtl.pykccl"/><input type="checkbox" name="cpDtl.pykccl" value="1">
        	<fmt:message key="cpDtl.otherCl"/><input type="checkbox" name="cpDtl.otherCl" value="1">
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
	getDatePicker($("input[name='cpDtl.positiveDate']"));
	getDatePicker($("input[name='cpDtl.bePartyDate']"));
	getDatePicker($("input[name='cpDtl.beHereDate']"));
	getDatePicker($("input[name='cpDtl.flowOutDate']"));
	getDatePicker($("input[name='cpDtl.outCountryDate']"));
	getDatePicker($("input[name='cpDtl.outCountryBackdate']"));
})
</script>
