<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<h4>基本情况
<span style="float:right;" class="text-primary"><code id="zhibuname">${partyGroup.groupName }</code></span>
</h4>
<div style="font-size:15px;">
	<dl class="dl-horizontal">
	  <dt>类型</dt>
	  <dd>${villageInfo.villageType}</dd>
	  <dt>村民数</dt>
	  <dd>${villageInfo.peopleNum}</dd>
	  <dt>党员数</dt>
	  <dd>${villageInfo.partyNum}</dd>
	  <dt>领导班子人数</dt>
	  <dd>${villageInfo.leaderNum}</dd>
	  <dt>人均年收入</dt>
	  <dd>${villageInfo.personIncome}</dd>
	  <dt>集体年收入</dt>
	  <dd>${villageInfo.groupIncome}</dd>
	</dl>
	<hr>
	<ul style="font-size:12px;">
		<li>
			<strong>村支书:</strong>
			<em>【姓名】</em><a href="#" onclick="ajaxLoadDaialog({url:'/editPerson',title:'人员信息',width:600,height:500,beforeDialogOpen:undefined,afterDialogOpen:undefined,data:{personId:'${person3.personId}',from:'list'}})">${person3.name }</a> 
			|<em>【性别】</em>${person3.gender } | <em>【年龄】</em>${person3.age } | <em>【学历】</em>${person3.education }
			
		</li>
		<li>
			<strong>村委主任:</strong>
			<em>【姓名】</em><a href="#" onclick="ajaxLoadDaialog({url:'/editPerson',title:'人员信息',width:600,height:500,beforeDialogOpen:undefined,afterDialogOpen:undefined,data:{personId:'${person4.personId}',from:'list'}})">${person4.name }</a>
			 |<em>【性别】</em>${person4.gender } | <em>【年龄】</em>${person4.age } | <em>【学历】</em>${person4.education }
		</li>
		<li>
			<strong>第一书记:</strong>
			<em>【姓名】</em><a href="#" onclick="ajaxLoadDaialog({url:'/editPerson',title:'人员信息',width:600,height:500,beforeDialogOpen:undefined,afterDialogOpen:undefined,data:{personId:'${person5.personId}',from:'list'}})">${person5.name } </a>
			|<em>【性别】</em>${person5.gender } | <em>【年龄】</em>${person5.age } | <em>【学历】</em>${person5.education } | <em>【派驻单位及职务】</em>${partyRole5.roleAttached1 }
		</li>
	</ul>

</div>
<hr>
<h4>人员信息</h4>
<jsp:include page="/WEB-INF/pages/wms/cunpersonList.jsp" flush="true"></jsp:include>