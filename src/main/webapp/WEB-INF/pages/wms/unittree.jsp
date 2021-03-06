<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
<head>
    <title><fmt:message key="partyGroupList.title"/></title>
    <meta name="menu" content="PartyGroupMenu"/>
</head>
	<input type="hidden" name="selectedGroupId"/>
    <form method="post" action="${ctx}/wmsd/unitTree" id="partyGroupSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#partyGroupSearchFormDiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
    	<input type="hidden" name="parentGroupId" value="1">
	    <div id="search" class="text-right">
	        <span class="col-sm-9">
	            <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        </span>
	        <div id="actions" class="btn-group">
		        <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="icon-search"></i> <fmt:message key="button.search"/>
		        </button>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		var selectedGroupId = "";
		var isNowXiang = "";
		if(typeof(beforePartyGroupFormOpen) == "undefined"){
			beforePartyGroupFormOpen = function(data){
				if(selectedGroupId==null||selectedGroupId==""){
					alert("组织结构是按照关系来的，请先选择一个部门，然后再添加其子部门。");
					return false;
				}
				return true;
			};
		}
		if(typeof(afterPartyGroupFormOpen) == "undefined"){
			afterPartyGroupFormOpen = function(data){
				$("input[name='parentId']").val(selectedGroupId);
				return true;
			};
		}
		function barLeafClick(spanItem, parentId, isXiang){
			//开合子元素
/* 	    	var children = $(spanItem).parent('li.parent_li').find(' > ul > li');
	        if (children.is(":visible")) {
	            children.hide('fast');
	            $(spanItem).attr('title', 'Expand this branch').find(' > i').addClass('glyphicon-plus-sign').removeClass('glyphicon-minus-sign');
	        } else {
	            children.show('fast');
	            $(spanItem).attr('title', 'Collapse this branch').find(' > i').addClass('glyphicon-minus-sign').removeClass('glyphicon-plus-sign');
	          	//是否已经查询出子元素如果已存在则展开或者闭合，如果没有则查询
	          	var nextItem = $(spanItem).next();
	          	var nodeName = $(nextItem).prop("nodeName");
	          	if(nodeName!="UL"){
	          		//动态加载子元素
	          		$.ajax({
	          			url:"${ctx}/wmsd/unitTree",
	          			data:{parentGroupId:parentId},
	          			type:"post",
	          			success:function(data){
	          				$(data).insertAfter($(spanItem));
	          			}
	          		});
	          	}
	        } */
	        //选中效果
	        var nowClass = $(spanItem).attr("class");
	        if(nowClass=="btn-success"){
	        }else{
	        	$(".btn-success").removeClass("btn-success");
	        	$(spanItem).addClass("btn-success");
	        }
	        //选中乡的时候允许新增村信息
	        var pStr = $(spanItem).parent().parent().parent().find("span:first").text();
	        var sStr = $(spanItem).text();
	        $("#zhibuname").html(pStr + " >>" + sStr);
	        if(parentId!=null && isXiang=="xiang"){
	        	selectedGroupId = parentId;
	        	isNowXiang=isXiang;
	        }else{
	        	isNowXiang="";
	        	selectedGroupId = parentId;
	        }
	      	//选中触发
	      	villageTreeSelect(parentId, isXiang);
	    }
		function selectUnitRoot(spanItem, parentId, isXiang){
			//选中效果
	        var nowClass = $(spanItem).attr("class");
	        if(nowClass=="btn-success"){
	        }else{
	        	$(".btn-success").removeClass("btn-success");
	        	$(spanItem).addClass("btn-success");
	        }
	        selectedGroupId=parentId;
	        isNowXiang="";
		}
	</script>
    <p><fmt:message key="partyGroupList.message"/></p>
    <div id="partyGroupSearchFormDiv" class="tree"></div>
<%
}else{
	String isRoot = (String)request.getAttribute("isRoot");
%>
<%
	if(isRoot!=null && "isRoot".equals(isRoot)){
%>
	<ul>
		<li class="parent_li">
			<span onclick="selectUnitRoot(this,'1')"><i class="glyphicon glyphicon-th-list"></i> 尉氏县</span>
			<ul>
				<c:forEach items="${partyGroups}" var="partyGroup">
				<li class="parent_li">
					<span onclick="barLeafClick(this,'${partyGroup.partyId}','xiang')"><i class="glyphicon glyphicon-leaf"></i> ${partyGroup.groupName}
				</li>
				</c:forEach>
			</ul>
		</li>
	</ul>
<%
	}else{
%>
	<ul>
		<c:forEach items="${partyGroups}" var="partyGroup">
		<li class="parent_li">
			<span onclick="barLeafClick(this,'${partyGroup.partyId}')"><i class="glyphicon glyphicon-leaf"></i> ${partyGroup.groupName}</span>
		</li>
		</c:forEach>
	</ul>
<%
	}
}
%>
