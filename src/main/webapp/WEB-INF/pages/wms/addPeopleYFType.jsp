<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<div id="addYFTypeDiv">
	<dl class="dl-horizontal">
		<dt>人员</dt>
		<dd><code id="yfpeoplename">${selectedPeopleName }</code></dd>
	</dl>
	<input type="hidden" name="selectedPeopleId" value="${selectedPeopleId}">
	<div class="form-group">
     	<label>民政优抚类型</label>
      <select class="form-control" name="yfTypeId">
      	<c:forEach items="${yftypes}" var="yftype">
      		<option value="${yftype[1].enumId}">
      			${yftype[0].description}/
      			${yftype[1].description}/
      			${yftype[1].enumCode}
      		</option>
      	</c:forEach>
      </select>
     </div>
     <a class="btn btn-primary btn-sm" href="#" onclick="savePeopleYFType()">新增</a>
</div>
<script type="text/javascript">

</script>
