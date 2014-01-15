<%@page import="com.sklay.core.enums.SwitchStatus"%>
<%@page import="com.sklay.core.enums.Sex"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="${ctx}/static/thirdparty/datepicker/WdatePicker.js"></script>
<%@ include file="../../include.jsp"%>

<div class="widget-box">	
	<div class="widget-content tab-content" id="createForm">
		<form class="form-horizontal" action="${ctx }/admin/festival/create" method="post">
	      <div class="control-group">
	      	<label class="control-label" for="inputName"><span style="color: red;">*</span> 节日名称</label>
	        <div class="controls">
	          <input class="span3" type="text" name="name" id="inputName" placeholder="节日名称">
	        </div>
	      </div>
	      
	      <div class="control-group">
	      	<label class="control-label" for="inputJobTime"><span style="color: red;">*</span> 节日时间</label>
	        <div class="controls">
	          <input class="span3 Wdate" type="text" required="required" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="inputJobTime" name="jobTime" placeholder="节日日期">
	        </div>
	      </div>
	      
	      <div class="control-group">
	        <label class="control-label">状态</label>
	        <div class="controls">
	        	<label class="radio inline span1" for="inputSwitchStatus1">
				  <input type="radio" name="switchStatus" id="inputSwitchStatus1" value="<%=SwitchStatus.CLOSE %>" <c:if test="${checked.value eq 0}">checked</c:if>><%=SwitchStatus.CLOSE.getLable() %>
				</label>
	          	<label class="radio inline span1" for="inputSwitchStatus2">
				  <input type="radio" name="switchStatus" id="inputSwitchStatus2" value="<%=SwitchStatus.OPEN %>" <c:if test="${checked.value eq 1}">checked</c:if>><%=SwitchStatus.OPEN.getLable() %>
				</label>
	        </div>
	      </div>
	      
	      <div class="control-group">
	        <div class="controls">
	          <button type="button" class="btn btn-primary"  title="" data-delay="5" data-html="true" data-href="${ctx}/admin/festival/list" data-content="添加成功." data-original-title="消息...">提交</button>
	        </div>
	      </div>
	    </form>
   	</div>
</div>