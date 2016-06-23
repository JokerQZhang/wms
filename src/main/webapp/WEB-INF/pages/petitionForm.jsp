<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="petitionDetail.title"/></title>
    <meta name="menu" content="PetitionMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="petitionForm" action="savePetition" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSavePetition);">
        <s:hidden key="petition.petitionId"/>
        <s:hidden key="petition.createdByUser"/>
        <s:hidden key="petition.createdTime"/>
        <s:hidden key="petition.lastUpdatedByUser"/>
        <s:hidden key="petition.lastUpdatedTime"/>
        <s:hidden key="petition.statusId"/>
        <s:hidden key="petition.leaderContent"/>
        <s:hidden key="petition.realEndTime"/>
        <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">被举报人信息</legend>
        <div class="form-group col-sm-3">
        	  <label><fmt:message key="petition.reportedPeople"/></label>
        	  <input class="form-control" type="text" name="petition.reportedPeople" value="${petition.reportedPeople}"/>
          </div>
        <div class="form-group col-sm-3">
       	  <label><fmt:message key="petition.reportedDep"/></label>
       	  <input class="form-control" type="text" name="petition.reportedDep" value="${petition.reportedDep}"/>
         </div>
        <div class="form-group col-sm-3">
       	  <label><fmt:message key="petition.reportedStatus"/></label>
       	  <input class="form-control" type="text" name="petition.reportedStatus" value="${petition.reportedStatus}"/>
         </div>
        <div class="form-group col-sm-3">
       	  <label><fmt:message key="petition.reportedMemo"/></label>
       	  <input class="form-control" type="text" name="petition.reportedMemo" value="${petition.reportedMemo}"/>
         </div>
         <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">举报人信息</legend>
        <div class="form-group col-sm-2">
        	  <label><fmt:message key="petition.reportPeople"/></label>
        	  <input class="form-control" type="text" name="petition.reportPeople" value="${petition.reportPeople}"/>
          </div>
        <div class="form-group col-sm-3">
       	  <label><fmt:message key="petition.reportDep"/></label>
       	  <input class="form-control" type="text" name="petition.reportDep" value="${petition.reportDep}"/>
         </div>
         <div class="form-group col-sm-2">
        	  <label><fmt:message key="petition.reportStatus"/></label>
        	  <input class="form-control" type="text" name="petition.reportStatus" value="${petition.reportStatus}"/>
          </div>
          <div class="form-group col-sm-3">
        	  <label><fmt:message key="petition.reportPConnect"/></label>
        	  <input class="form-control" type="text" name="petition.reportPConnect" value="${petition.reportPConnect}"/>
          </div>
          <div class="form-group col-sm-2">
        	  <label><fmt:message key="petition.reportPNum"/></label>
        	  <input class="form-control" type="text" name="petition.reportPNum" value="${petition.reportPNum}"/>
          </div>
       <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">举报信息</legend>
        <div class="form-group col-sm-3">
       	  <label><fmt:message key="petition.reportType"/></label>
       	  <select class="form-control" name="petition.reportType">
       	  	<%=request.getAttribute("reportTypeOptions") %>
       	  </select>
         </div>
        <div class="form-group col-sm-3">
        	  <label><fmt:message key="petition.reportMethod"/></label>
        	  <select class="form-control" name="petition.reportMethod">
	       	  	<%=request.getAttribute("reportMethodOptions") %>
	       	  </select>
          </div>
         <div class="form-group col-sm-6">
        	  <label><fmt:message key="petition.reportMemo"/></label>
        	  <input class="form-control" type="text" name="petition.reportMemo" value="${petition.reportMemo}"/>
          </div>
        <legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">受理信息</legend>
        <div class="form-group col-sm-3">
        	  <label><fmt:message key="petition.acceptName"/></label>
        	  <input class="form-control" type="text" name="petition.acceptName" value="${petition.acceptName eq null?currentPerson.name:petition.acceptName}"/>
          </div>
        <div class="form-group col-sm-3">
       	  <label><fmt:message key="petition.acceptTime"/></label>
<%String nowDate = com.joker.wms.util.MyDateUtil.getCurrDate("yyyy-MM-dd");request.setAttribute("nowDate", nowDate);%>
       	  <input class="form-control" type="text" name="petition.acceptTime" value="${petition.acceptTime eq null?nowDate:petition.acceptTime}"/>
         </div>
        <div class="form-group col-sm-3">
       	  <label><fmt:message key="petition.expectEndTime"/></label>
       	  <input class="form-control" type="text" name="petition.expectEndTime" value="${petition.expectEndTime}"/>
        </div>
        <div class="form-group col-sm-3">
       	  <label><fmt:message key="petition.processPartyId"/></label>
       	  <select class="form-control" name="petition.processPartyId" value="${petition.expectEndTime}">
       	  	<%=request.getAttribute("zhibuOptions") %>
       	  </select>
         </div>
        <div class="form-group col-sm-12">
        	  <label><fmt:message key="petition.acceptContent"/></label>
        	  <input class="form-control" type="text" name="petition.acceptContent" value="${petition.acceptContent}"/>
          </div>
        
        <div class="form-group col-sm-12">
        	  <label><fmt:message key="petition.reportContent"/></label>
        	  <textarea class="form-control" name="petition.reportContent" rows="5" cols="">${petition.reportContent}</textarea>
          </div>
         
        
        

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty petition.petitionId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#petitionForm').attr('action','/savePetition?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSavePetition('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSavePetition(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#petitionSearchForm"),$("#petitionPageNav").find("li[class='active']").find("a").html());
}
$(function(){
	getDatePicker($("input[name='petition.acceptTime']"));
	getDatePicker($("input[name='petition.expectEndTime']"));
	$("select[name='petition.processPartyId']").combobox();
})
</script>
