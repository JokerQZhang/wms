<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th width="80%">类型</th>
				<th width="20%">标准</th>
			</tr>
			<c:forEach items="${peopleYFTypeList}" var="peopleYFType">
				<tr>
					<td><span style="color:blue;"><a href="#" style="color:red;" onclick="deletePeopleYFType('${peopleYFType[1].careId}')"><i class="glyphicon glyphicon-remove"></i></a>&nbsp; ${peopleYFType[3].description}/${peopleYFType[2].description}</span></td>
					<td>${peopleYFType[2].enumCode}</td>
				</tr>
			</c:forEach>
		</thead>
	</table>
<script type="text/javascript">

</script>
