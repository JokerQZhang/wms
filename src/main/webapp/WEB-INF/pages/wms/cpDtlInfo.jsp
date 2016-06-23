<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="personDetail.title"/></title>
    <meta name="menu" content="PersonMenu"/>
    <link rel="stylesheet" type="text/css" href="${cxt}/scripts/bootstrap/css/bootstrap.min.css" />
    <style type="text/css">
    th{font-size:13px;border:1px solid #ddd;color:#8C0D0D;text-align:center;height: 30px;line-height: 30px;}
    td{font-size:13px;text-align:center;height:30px;line-height: 30px;}
    </style>
</head>

<div class="col-sm-12">
    <s:form id="personForm" action="saveDangPerson" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSavePerson);">
        <s:hidden key="person.personId"/>
        <input type="hidden" name="belongGroupId" value="${belongGroupId}">
        <s:hidden key="person.age"/>
        <s:hidden key="person.partyId"/>
        <s:hidden key="person.personalTitle"/>
        <s:hidden key="cpDtl.cpDtlId"/>
<table class="table table-condensed table-bordered">
  <tbody>
  <tr>
      <th rowspan="4">党员基本<br/>信息</th>
  </tr>
  <tr>
      <th width="8%">姓名</th>
      <td width="15%">${person.name}</td>
      <th width="8%">性别</th>
      <td width="15%">${person.gender}</td>
      <th width="8%">出生年月</th>
      <td width="15%">${person.birthday}</td>
      <th width="10%">民族</th>
      <td width="15%">${person.nation}</td>
  </tr>
  <tr>
      <th>婚姻状况</th>
      <td>${person.marriage}</td>
      <th>入党时间</th>
      <td>${cpDtl.bePartyDate}</td>
      <th>转正日期</th>
      <td>${cpDtl.positiveDate}</td>
      <th>参加工作时间</th>
      <td>${person.workDate}</td>
  </tr>
  <tr>
      <th>身份证号码</th>
      <td>${person.cardId}</td>
      <th>籍贯</th>
      <td colspan="5">${person.household}</td>
  </tr>
  <tr>
      <th  rowspan="2">党籍信息</th>
  </tr>
  <tr>
      <th>入党时所在<br/>支部</th>
      <td>${cpDtl.bePartyZhibu}</td>
      <th>转入当前<br/>支部日期</th>
      <td>${cpDtl.beHereDate}</td>
      <th>转出党支部<br/>名称</th>
      <td>${cpDtl.outOfZhibu}</td>
      <th>现任党内职务</th>
      <td>${cpDtl.partyStatus}</td>
  </tr>
  <tr>
      <th  rowspan="2">学历信息</th>
  </tr>
  <tr>
      <th>学历学位</th>
      <td>${person.education}</td>
      <th>毕业院校</th>
      <td colspan="2">${person.educationSchoole}</td>
      <th>专业</th>
      <td colspan="2">${person.educationSpeciality}</td>
  </tr>
  <tr>
      <th  rowspan="2">职业信息</th>
  </tr>
  <tr>
      <th>职业类型</th>
      <td>${cpDtl.occupation}</td>
      <th>现任工作单位</th>
      <td colspan="2">${cpDtl.workGroup}</td>
      <th>职务</th>
      <td colspan="2">${cpDtl.workStatus}</td>
  </tr>
  
  <tr>
      <th  rowspan="3">联系方式</th>
  </tr>
  <tr>
      <th>户籍所在地</th>
      <td>${cpDtl.householdAddress}</td>
      <th>手机号码</th>
      <td>${person.phone}</td>
      <th>QQ号</th>
      <td>${person.qq}</td>
      <th>微信号</th>
      <td>${person.weixin}</td>
  </tr>
  <tr>
      <th>家庭住址</th>
      <td colspan="7">${person.familyAddress}</td>
  </tr>
  <tr>
      <th  rowspan="4">党员流动<br/>信息</th>
  </tr>
  <tr>
      <th>流出日期</th>
      <td>${cpDtl.flowOutDate}</td>
      <th>外出流向</th>
      <td>${cpDtl.flowOutInfo}</td>
      <th>是否持有流动<br/>党员活动证</th>
      <td>${cpDtl.isHaveFlowCard}</td>
      <th>流动党员<br/>活动证编号</th>
      <td>${cpDtl.flowCardNum}</td>
  </tr>
  <tr>
      <th>流入单位</th>
      <td>${cpDtl.flowInGroup}</td>
      <th>流入单位<br/>党组织联系人</th>
      <td>${cpDtl.flowInGroupPerson}</td>
      <th>流入单位党组<br/>织联系方式</th>
      <td>${cpDtl.flowInGroupPhone}</td>
      <th>党组织类型</th>
      <td>${cpDtl.partyGroupType}</td>
  </tr>
  <tr>
      <th>外出原因</th>
      <td colspan="7"></td>
  </tr>
  <tr>
      <th  rowspan="3">出国境情况</th>
  </tr>
  <tr>
      <th>出国日期</th>
      <td>${cpDtl.outCountryDate}</td>
      <th>出国原因</th>
      <td colspan="3">${cpDtl.outCountryReason}</td>
      <th>出国后与组织<br/>联系情况</th>
      <td>${cpDtl.outCountryConnect}</td>
  </tr>
  <tr>
      <th>党籍处理方式</th>
      <td>${cpDtl.outCountryDangji}</td>
      <th>回国日期</th>
      <td>${cpDtl.outCountryBackdate}</td>
      <th>恢复组织<br/>生活情况</th>
      <td colspan="3">${cpDtl.outCountryBacklife}</td>
  </tr>
  <tr>
      <th  rowspan="8">家庭主要成员及重要社会关系情况</th>
  </tr>
  <tr>
      <th>称谓</th>
      <th>姓名</th>
      <th>年龄</th>
      <th>政治面貌</th>
      <th colspan="2">工作单位</th>
      <th colspan="2">工作职务</th>
  </tr>
  <tr>
      <td>${cpDtl.RTitle1}</td>
      <td>${cpDtl.RName1}</td>
      <td>${cpDtl.RAge1}</td>
      <td>${cpDtl.RSocial1}</td>
      <td colspan="2">${cpDtl.RWorkeCompany1}</td>
      <td colspan="2">${cpDtl.RWorkeSatus1}</td>
  </tr>
  <tr>
      <td>${cpDtl.RTitle2}</td>
      <td>${cpDtl.RName2}</td>
      <td>${cpDtl.RAge2}</td>
      <td>${cpDtl.RSocial2}</td>
      <td colspan="2">${cpDtl.RWorkeCompany2}</td>
      <td colspan="2">${cpDtl.RWorkeSatus2}</td>
  </tr>
  <tr>
      <td>${cpDtl.RTitle3}</td>
      <td>${cpDtl.RName3}</td>
      <td>${cpDtl.RAge3}</td>
      <td>${cpDtl.RSocial3}</td>
      <td colspan="2">${cpDtl.RWorkeCompany3}</td>
      <td colspan="2">${cpDtl.RWorkeSatus3}</td>
  </tr>
  <tr>
      <td>${cpDtl.RTitle4}</td>
      <td>${cpDtl.RName4}</td>
      <td>${cpDtl.RAge4}</td>
      <td>${cpDtl.RSocial4}</td>
      <td colspan="2">${cpDtl.RWorkeCompany4}</td>
      <td colspan="2">${cpDtl.RWorkeSatus4}</td>
  </tr>
  <tr>
      <td>${cpDtl.RTitle5}</td>
      <td>${cpDtl.RName5}</td>
      <td>${cpDtl.RAge5}</td>
      <td>${cpDtl.RSocial5}</td>
      <td colspan="2">${cpDtl.RWorkeCompany5}</td>
      <td colspan="2">${cpDtl.RWorkeSatus5}</td>
  </tr>
  <tr>
      <td>${cpDtl.RTitle6}</td>
      <td>${cpDtl.RName6}</td>
      <td>${cpDtl.RAge6}</td>
      <td>${cpDtl.RSocial6}</td>
      <td colspan="2">${cpDtl.RWorkeCompany6}</td>
      <td colspan="2">${cpDtl.RWorkeSatus6}</td>
  </tr>
  <tr>
      <th rowspan="2">党员档案管理情况</th>
  </tr>
  <tr>
  	  <th>保管单位</th>
      <td colspan="2">${cpDtl.keepUnit}</td>
      <th>保管资料</th>
      <td colspan="4">
      	${(cpDtl.rdzys eq "1")?"入党志愿书":""} &nbsp;
      	${(cpDtl.rdsqs eq "1")?"入党申请书":""} &nbsp;
      	${(cpDtl.zzsccl eq "1")?"政治审查材料":""} &nbsp;
      	${(cpDtl.zzsqs eq "1")?"转正申请书":""} &nbsp;
      	${(cpDtl.pykccl eq "1")?"培养考察材料":""} &nbsp;
      	${cpDtl.otherCl} &nbsp;
      </td>
  </tr>
</tbody></table>
        
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
</script>
