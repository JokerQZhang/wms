<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<form method="post" action="${ctx}/wmsd/dangpersons" id="personSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#personSearchFormDiv'));">
	<input type="hidden" name="page.pageSize"/>
	<input type="hidden" name="page.pageIndex"/>
	<input type="hidden" name="belongGroupId" value="${belongGroupId}"/>
	<input type="hidden" name="q"/>
	<input type="hidden" name="dang" value="dang"/>
	<input type="hidden" name="isNowDangwei" value="${isNowDangwei}"/>
</form>
<script type="text/javascript">
	if(typeof(afterSelectPerson) == "undefined"){
		afterSelectPerson = function(data){return true;};
	}
	if(typeof(beforePersonFormOpen) == "undefined"){
		beforePersonFormOpen = function(data){
			var selectedGroupId = $("input[name='selectedGroupId']").val();
			if(selectedGroupId==null||selectedGroupId==""){
				alert("组织结构是按照关系来的，请先选择一个部门，然后再添加其人员。");
				return false;
			}
			return true;
		};
	}
	if(typeof(afterPersonFormOpen) == "undefined"){
		afterPersonFormOpen = function(data){
			$("input[name='belongGroupId']").val($("input[name='selectedGroupId']").val());
			return true;
		};
	}
	$(function(){
		$("#personSearchForm").submit();
	})
</script>
<div id="personSearchFormDiv"></div>
